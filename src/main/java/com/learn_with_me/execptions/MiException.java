package com.learn_with_me.execptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class MiException extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;
    private HttpStatus status;

    public MiException(String mensaje, HttpStatus status) {
        super(mensaje);
        this.status = status;
    }

    
}
