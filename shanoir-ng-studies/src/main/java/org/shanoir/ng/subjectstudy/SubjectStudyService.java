package org.shanoir.ng.subjectstudy;

import org.shanoir.ng.shared.exception.ShanoirStudiesException;
import org.shanoir.ng.shared.validation.UniqueCheckableService;

/**
 * Subject study service.
 *
 */
public interface SubjectStudyService extends UniqueCheckableService<SubjectStudy> {
	
	/**
	 * Find subject study by its id.
	 *
	 * @param id
	 *            subject study id.
	 * @return a subject study or null.
	 */
	SubjectStudy findById(Long id);
	
	/**
	 * Update subject study.
	 *
	 * @param subject study
	 *            subject study to update.
	 * @return updated subject study.
	 * @throws ShanoirStudiesException
	 */
	SubjectStudy update(SubjectStudy subjectStudy) throws ShanoirStudiesException;

}
