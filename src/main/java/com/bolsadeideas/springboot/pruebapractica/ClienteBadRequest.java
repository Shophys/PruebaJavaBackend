package com.bolsadeideas.springboot.pruebapractica;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
	public class ClienteBadRequest extends RuntimeException {

		  public ClienteBadRequest(String exception) {
		    super(exception);
		  }

		}
