package com.bolsadeideas.springboot.pruebapractica;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public class ClienteInternalError extends RuntimeException {

		  public ClienteInternalError(String exception) {
		    super(exception);
		  }

		}
