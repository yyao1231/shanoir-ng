import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { preventInitialChildAnimations, slideDown } from '../shared/animations/animations';
import { MsgBoxService } from '../shared/msg-box/msg-box.service';
import { ImagesUrlUtil } from '../shared/utils/images-url.util';
import { Subject } from '../subjects/shared/subject.model';
import { ContextData } from './clinical-context/clinical-context.component';
import { ImportJob, PatientDicom } from './dicom-data.model';
import { ImportService } from './import.service';
import { SubjectService } from '../subjects/shared/subject.service';

type State = 'dicom' | 'series' | 'context' | 'final' | 'none';

@Component({
    selector: 'import-modality',
    templateUrl: 'import.component.html',
    styleUrls: ['import.component.css', 'import.step.css'],
    animations: [slideDown, preventInitialChildAnimations]
})
export class ImportComponent  {

    private extracted: any;
    private importJob: ImportJob;
    private selectedPatients: PatientDicom[];
    private context: ContextData;
    private opened: State = 'dicom';
    private importing: boolean = false;

    private dicomValid: boolean = false;
    private seriesValid: boolean = false;
    private contextValid: boolean = false;

    private ImagesUrlUtil = ImagesUrlUtil;
    
    constructor(
        private importService: ImportService,
        private subjectService: SubjectService,
        private msgService: MsgBoxService,
        private router: Router,
    ) {}
    
    private onFilesExtracted(extracted) {
        this.extracted = extracted;
    }
    
    private onArchiveUploaded(importJob: ImportJob) {
        this.importJob = importJob;
    }

    private onPatientsChange(patients: PatientDicom[]) {
        this.selectedPatients = patients;
    }
    
    private onContextChange(context: ContextData) {
        this.context = context;
    }

    private get patient(): PatientDicom {
        if (!this.selectedPatients || this.selectedPatients.length <= 0) return null;
        return this.selectedPatients[0];
    }
    
    private startImportJob(): void {
        this.subjectService
            .updateSubjectStudyValues(this.context.subject.subjectStudy)
            .then(() => {
                let that = this;
                this.importing = true;
                this.importData()
                    .then(() => {
                        this.importing = false;
                        setTimeout(function () {
                            that.msgService.log('info', 'The data has been successfully imported')
                        }, 0);
                        this.router.navigate(['/dataset-list']);
                    }).catch(error => {
                        this.importing = false;
                        throw error;
                    });
            }).catch(error => {
                throw new Error('Could not save the subjectStudy object, the import job has been stopped. Cause : ' + error);
            });
    }

    private importData (): Promise<any> {
        if (true) {
            let importJob = new ImportJob();
            importJob.patients = new Array<PatientDicom>();
            // this.patient.subject = new IdNameObject(this.context.subject.id, this.context.subject.name);
            this.patient.subject = Subject.makeSubject(
                    this.context.subject.id, 
                    this.context.subject.name, 
                    this.context.subject.identifier, 
                    this.context.subject.subjectStudy);
            importJob.patients.push(this.patient);
            importJob.workFolder = this.importJob.workFolder;
            importJob.fromDicomZip = true;
            importJob.examinationId = this.context.examination.id;
            importJob.frontStudyId = this.context.study.id;
            importJob.frontStudyCardId = this.context.studycard.id;
            importJob.frontConverterId = this.context.studycard.niftiConverter.id;
            return this.importService.startImportJob(importJob);
        }
    }

    private isValid(): boolean {
        return this.dicomValid && this.seriesValid && this.contextValid;
    }

    private get contextEnabled(): boolean {
        return this.dicomValid && this.seriesValid;
    }

    private get seriesEnabled(): boolean {
        return this.dicomValid;
    }

    private get lastEnabled(): State {
        if (this.isValid()) return 'final';
        else if (this.contextEnabled) return 'context';
        else if (this.seriesEnabled) return 'series';
        else return 'dicom';
    }

    private toggle(state: State) {
        if (this.opened == state) this.opened = 'none';
        else this.opened = state;
    }
}