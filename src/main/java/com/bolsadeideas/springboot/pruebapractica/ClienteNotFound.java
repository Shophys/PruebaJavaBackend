package com.bolsadeideas.springboot.pruebapractica;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
	public class ClienteNotFound extends RuntimeException {

		  public ClienteNotFound(String exception) {
		    super(exception);
		  }

		}
