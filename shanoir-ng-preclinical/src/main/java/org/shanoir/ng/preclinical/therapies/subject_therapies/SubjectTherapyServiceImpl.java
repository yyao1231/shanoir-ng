package org.shanoir.ng.preclinical.therapies.subject_therapies;

import java.util.List;

import org.shanoir.ng.preclinical.subjects.AnimalSubject;
import org.shanoir.ng.preclinical.therapies.Therapy;
import org.shanoir.ng.shared.exception.ShanoirPreclinicalException;
import org.shanoir.ng.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 * Subject therapy service implementation.
 * 
 * @author sloury
 *
 */
@Service
public class SubjectTherapyServiceImpl implements SubjectTherapyService {

	/**
	 * Logger
	 */
	private static final Logger LOG = LoggerFactory.getLogger(SubjectTherapyServiceImpl.class);

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private SubjectTherapyRepository subtherapiesRepository;

	@Override
	public void deleteById(final Long id) throws ShanoirPreclinicalException {
		subtherapiesRepository.delete(id);
	}

	@Override
	public void deleteByAnimalSubject(AnimalSubject animalSubject) throws ShanoirPreclinicalException {
		List<SubjectTherapy> therapies = findAllByAnimalSubject(animalSubject);
		for (SubjectTherapy subjectTherapy : therapies) {
			deleteById(subjectTherapy.getId());
		}
	}

	@Override
	public List<SubjectTherapy> findAll() {
		return Utils.toList(subtherapiesRepository.findAll());
	}

	@Override
	public List<SubjectTherapy> findAllByAnimalSubject(AnimalSubject animalSubject) {
		return Utils.toList(subtherapiesRepository.findByAnimalSubject(animalSubject));
	}

	@Override
	public List<SubjectTherapy> findAllByTherapy(Therapy therapy) {
		return Utils.toList(subtherapiesRepository.findByTherapy(therapy));
	}

	@Override
	public List<SubjectTherapy> findBy(final String fieldName, final Object value) {
		return subtherapiesRepository.findBy(fieldName, value);
	}

	@Override
	public SubjectTherapy findById(final Long id) {
		return subtherapiesRepository.findOne(id);
	}

	@Override
	public SubjectTherapy save(final SubjectTherapy subtherapy) throws ShanoirPreclinicalException {
		SubjectTherapy savedTherapy = null;
		try {
			savedTherapy = subtherapiesRepository.save(subtherapy);
		} catch (DataIntegrityViolationException dive) {
			ShanoirPreclinicalException.logAndThrow(LOG, "Error while creating subject therapy: " + dive.getMessage());
		}
		return savedTherapy;
	}

	@Override
	public SubjectTherapy update(final SubjectTherapy subtherapy) throws ShanoirPreclinicalException {
		final SubjectTherapy subtherapyDb = subtherapiesRepository.findOne(subtherapy.getId());
		updateModelValues(subtherapyDb, subtherapy);
		try {
			subtherapiesRepository.save(subtherapyDb);
		} catch (Exception e) {
			ShanoirPreclinicalException.logAndThrow(LOG, "Error while updating a subject therapy: " + e.getMessage());
		}
		return subtherapyDb;
	}

	private SubjectTherapy updateModelValues(final SubjectTherapy subtherapyDb, final SubjectTherapy subtherapy) {
		subtherapyDb.setTherapy(subtherapy.getTherapy());
		subtherapyDb.setDose(subtherapy.getDose());
		subtherapyDb.setDoseUnit(subtherapy.getDoseUnit());
		subtherapyDb.setFrequency(subtherapy.getFrequency());
		subtherapyDb.setStartDate(subtherapy.getStartDate());
		subtherapyDb.setEndDate(subtherapy.getEndDate());
		return subtherapyDb;
	}

}