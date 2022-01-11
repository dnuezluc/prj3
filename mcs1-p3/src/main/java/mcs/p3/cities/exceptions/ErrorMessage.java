package mcs.p3.cities.exceptions;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
	private String message;
	private HttpStatus status;
	
	public ErrorMessage(int code) {
		switch(code) {
		case 1:
			message = "Element not found in data base with this Id";
			status = HttpStatus.NOT_FOUND;
			break;
		case 2:
			message = "Element not found in data base with this Name";
			status = HttpStatus.NOT_FOUND;
			break;
		case 3:
			message = "Error to rewrite object in model JSON";
			status = HttpStatus.BAD_REQUEST;
			break;
		case 4:
			message = "This list it´s emtpy";
			status = HttpStatus.NOT_FOUND;
			break;
		}
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	
}
