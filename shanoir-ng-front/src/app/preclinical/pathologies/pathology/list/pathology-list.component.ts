import {Component,ViewChild, ViewContainerRef} from '@angular/core'
import { Router } from '@angular/router'; 

import { ConfirmDialogService } from "../../../../shared/components/confirm-dialog/confirm-dialog.service";
import { KeycloakService } from "../../../../shared/keycloak/keycloak.service";

import { Pathology } from '../shared/pathology.model';
import { PathologyService } from '../shared/pathology.service';

import { ImagesUrlUtil } from '../../../../shared/utils/images-url.util';
import { FilterablePageable, Page } from '../../../../shared/components/table/pageable.model';
import { BrowserPaging } from '../../../../shared/components/table/browser-paging.model';
import { TableComponent } from '../../../../shared/components/table/table.component';

@Component({
  selector: 'pathology-list',
  templateUrl:'pathology-list.component.html',
  styleUrls: ['pathology-list.component.css'], 
  providers: [PathologyService]
})
export class PathologiesListComponent {
  public pathologies: Pathology[];
  private pathologiesPromise: Promise<void> = this.getPathologies();
  private browserPaging: BrowserPaging<Pathology>;
  public rowClickAction: Object;
  public columnDefs: any[];
  public customActionDefs: any[];
  @ViewChild('pathologiesTableTable') table: TableComponent;
    
    constructor(
        public pathologyService: PathologyService,
        public router: Router,
        private keycloakService: KeycloakService,
        public confirmDialogService: ConfirmDialogService, private viewContainerRef: ViewContainerRef) {
            this.createColumnDefs();
     }   
     
    getPage(pageable: FilterablePageable): Promise<Page<Pathology>> {
        return new Promise((resolve) => {
            this.pathologiesPromise.then(() => {
                resolve(this.browserPaging.getPage(pageable));
            });
        });
    }
    
    
    
    getPathologies():  Promise<void> {
    	this.pathologies = []; 
    	this.browserPaging = new BrowserPaging(this.pathologies, this.columnDefs);
        return this.pathologyService.getPathologies().then(pathologies => {
            this.pathologies = pathologies;
            
            this.browserPaging.setItems(this.pathologies);
            this.table.refresh();
        })              
    }
    
    
    delete(pathology: Pathology): void {      
      this.pathologyService.delete(pathology.id).then((res) => this.getPathologies());
    }
    
    
    // Grid columns definition
    private createColumnDefs() {
        function castToString(id: number) {
            return String(id);
        };
        this.columnDefs = [
            {headerName: "ID", field: "id", type: "id", cellRenderer: function (params: any) {
                return castToString(params.data.id);
            }},
            {headerName: "Name", field: "name"}
            //{headerName: "Edit", type: "button", img: ImagesUrlUtil.EDIT_ICON_PATH, action: this.editPathology,component:this},
            //{headerName: "Delete", type: "button", img: ImagesUrlUtil.GARBAGE_ICON_PATH, action: this.openDeletePathologyConfirmDialog, component:this}
        ];
        if (this.keycloakService.isUserAdmin() || this.keycloakService.isUserExpert()) {
            this.columnDefs.push({headerName: "", type: "button", img: ImagesUrlUtil.GARBAGE_ICON_PATH, action: this.openDeletePathologyConfirmDialog},
            {headerName: "", type: "button", img: ImagesUrlUtil.EDIT_ICON_PATH, target : "/preclinical-pathology", getParams: function(item: any): Object {
                return {id: item.id, mode: "edit"};
            }});
        }
        if (!this.keycloakService.isUserGuest()) {
            this.columnDefs.push({headerName: "", type: "button", img: ImagesUrlUtil.VIEW_ICON_PATH, target : "/preclinical-pathology", getParams: function(item: any): Object {
                return {id: item.id, mode: "view"};
            }});
        }
        this.customActionDefs = [];
        if (this.keycloakService.isUserAdmin() || this.keycloakService.isUserExpert()) {
        this.customActionDefs.push({title: "new pathology", img: ImagesUrlUtil.ADD_ICON_PATH, target: "/preclinical-pathology", getParams: function(item: any): Object {
                return {mode: "create"};
        }});
        this.customActionDefs.push({title: "delete selected", img: ImagesUrlUtil.GARBAGE_ICON_PATH, action: this.deleteAll });
        }
        if (!this.keycloakService.isUserGuest()) {
            this.rowClickAction = {target : "/preclinical-pathology", getParams: function(item: any): Object {
                    return {id: item.id, mode: "view"};
            }};
        }
    }
    
    openDeletePathologyConfirmDialog = (item: Pathology) => {
         this.confirmDialogService
                .confirm('Delete pathology', 'Are you sure you want to delete pathology ' + item.name + '?', 
                    this.viewContainerRef)
                .subscribe(res => {
                    if (res) {
                        this.delete(item);
                    }
                });
    }
    
    deleteAll = () => {
        let ids: number[] = [];
        for (let pathology of this.pathologies) {
            if (pathology["isSelectedInTable"]) ids.push(pathology.id);
        }
        if (ids.length > 0) {
            console.log("TODO : delete those ids : " + ids);
        }
    }
}