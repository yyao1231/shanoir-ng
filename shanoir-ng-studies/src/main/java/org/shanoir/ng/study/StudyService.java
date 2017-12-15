package org.shanoir.ng.study;

import java.util.List;

import org.shanoir.ng.shared.dto.IdNameDTO;
import org.shanoir.ng.shared.exception.ShanoirStudiesException;
import org.shanoir.ng.shared.validation.UniqueCheckableService;
import org.shanoir.ng.study.dto.SimpleStudyDTO;
import org.shanoir.ng.study.dto.StudyStudyCardDTO;

/**
 * Study service.
 * 
 * @author msimon
 *
 */
public interface StudyService extends UniqueCheckableService<Study> {

	/**
	 * Check if an user can update a study.
	 * 
	 * @param studyId
	 *            study id.
	 * @param userId
	 *            user id.
	 * @return true or false.
	 */
	boolean canUserUpdateStudy(Long studyId, Long userId);

	/**
	 * Delete a study. Check if current user can delete study.
	 *
	 * @param id
	 *            study id.
	 * @param userId
	 *            user id.
	 * @throws ShanoirStudiesException
	 */
	void deleteById(Long id, Long userId) throws ShanoirStudiesException;

	/**
	 * Delete a Study from the old Shanoir.
	 *
	 * @param Study
	 *            Study.
	 * @throws ShanoirStudiesException
	 */
	void deleteFromShanoirOld(Study study) throws ShanoirStudiesException;

	/**
	 * Get all the studies
	 * 
	 * @return a list of studies
	 */
	List<Study> findAll();

	/**
	 * Find study by its id.
	 *
	 * @param id
	 *            study id.
	 * @return a study or null.
	 */
	Study findById(Long id);

	/**
	 * Find study by its id. Check if current user can see study.
	 *
	 * @param id
	 *            study id.
	 * @param userId
	 *            user id.
	 * @return a study or null.
	 * @throws ShanoirStudiesException
	 */
	Study findById(Long id, Long userId) throws ShanoirStudiesException;

	/**
	 * Find id and name for all studies.
	 * 
	 * @return list of studies.
	 */
	List<IdNameDTO> findIdsAndNames();

	/**
	 * Find all studies for a user.
	 * 
	 * @param userId
	 *            user id.
	 * @return a list of studies.
	 */
	List<Study> findStudiesByUserId(Long userId);

	/**
	 * Find all studies with theirs study cards for a user.
	 * 
	 * @param userId
	 *            user id.
	 * @return a list of simple studies.
	 * @throws ShanoirStudiesException
	 */
	List<SimpleStudyDTO> findStudiesWithStudyCardsByUserId(Long userId) throws ShanoirStudiesException;

	/**
	 * add new study
	 * 
	 * @param study
	 * @return created Study
	 * @throws ShanoirStudiesException
	 */
	Study save(Study study) throws ShanoirStudiesException;

	/**
	 * Update a study
	 * 
	 * @param study
	 * @return updated study
	 * @throws ShanoirStudiesException
	 */
	Study update(Study study) throws ShanoirStudiesException;

	/**
	 * Manage link between a study and a study card (CUD)
	 *
	 * @param studyStudyCardDTO
	 *            DTO with link between study and study card.
	 * @throws ShanoirStudiesException
	 */
	void updateFromMsStudyCard(StudyStudyCardDTO studyStudyCardDTO) throws ShanoirStudiesException;

	/**
	 * Update a Study from the old Shanoir
	 *
	 * @param Study
	 *            Study.
	 * @throws ShanoirStudiesException
	 */
	void updateFromShanoirOld(Study study) throws ShanoirStudiesException;

}
