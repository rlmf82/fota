package man.fota.handler;

import java.io.Serializable;

import man.fota.exception.BusinessException;

public class ResponseError implements Serializable{

	private static final long serialVersionUID = 1L;
	private String message;
	
	public static ResponseError createResponseError(BusinessException businessException) {
		ResponseError response = new ResponseError();
		response.setMessage(businessException.getMessage());
		return response;
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}