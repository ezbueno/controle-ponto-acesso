package com.buenoezandro.acesso.controller.exception;

import java.io.Serializable;
import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private ZonedDateTime timestamp;
	private Integer status;
	private String error;
	
}
