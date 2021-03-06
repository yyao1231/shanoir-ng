package org.shanoir.ng.studycard;

import java.util.List;

import org.shanoir.ng.shared.model.ItemRepositoryCustom;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for study cards.
 *
 * @author msimon
 */
public interface StudyCardRepository extends CrudRepository<StudyCard, Long>, ItemRepositoryCustom<StudyCard> {

	/**
	 * Find list of study card by their study id.
	 * 
	 * @param studyIdList
	 *            list of study ids.
	 * @return list of study cards.
	 */
	List<StudyCard> findByStudyIdIn(List<Long> studyIdList);

}
