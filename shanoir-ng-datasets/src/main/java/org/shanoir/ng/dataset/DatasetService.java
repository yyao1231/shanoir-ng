package org.shanoir.ng.dataset;

import java.util.List;

import org.shanoir.ng.shared.exception.ShanoirException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Dataset service.
 *
 * @author msimon
 *
 */
public interface DatasetService<T extends Dataset> {

	/**
	 * Delete a dataset.
	 * 
	 * @param id
	 *            dataset id.
	 * @throws ShanoirException
	 */
	void deleteById(Long id) throws ShanoirException;

	/**
	 * Find dataset by its id.
	 *
	 * @param id
	 *            dataset id.
	 * @return a dataset or null.
	 */
	T findById(Long id);

	/**
	 * Save a dataset.
	 *
	 * @param dataset
	 *            dataset to create.
	 * @return created dataset.
	 * @throws ShanoirException
	 */
	T save(T dataset) throws ShanoirException;

	/**
	 * Update a dataset.
	 *
	 * @param dataset
	 *            dataset to update.
	 * @return updated dataset.
	 * @throws ShanoirException
	 */
	T update(T dataset) throws ShanoirException;

	/**
	 * Update a dataset from the old Shanoir
	 * 
	 * @param dataset
	 *            dataset.
	 * @throws ShanoirException
	 */
	void updateFromShanoirOld(T dataset) throws ShanoirException;
	
	/**
	 * Find every dataset
	 * 
	 * @return datasets
	 * @throws ShanoirException
	 */
	List<T> findAll() throws ShanoirException;

	/**
	 * Fetch the asked page
	 * 
	 * @return datasets
	 * @throws ShanoirException
	 */
	public Page<Dataset> findPage(final Pageable pageable) throws ShanoirException;

}
