package org.shanoir.challengeScores.data.model.exception;

import io.swagger.model.ErrorModel;

public class RestServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	private int code;
	private String message;

	/**
	 * @param code
	 */
	public RestServiceException(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}


	public ErrorModel toErrorModel() {
		return new ErrorModel().code(code).message(message);
	}


	/**
	 * @param message the message to set
	 */
	protected void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return super.toString() + ". " + message;
	}


	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
}
