package com.buenoezandro.acesso.dto;

import java.io.Serializable;

import com.buenoezandro.acesso.model.JornadaTrabalho;

import lombok.Data;

@Data
public class JornadaTrabalhoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String descricao;
	
	public JornadaTrabalhoDTO() {
	}
	
	public JornadaTrabalhoDTO(JornadaTrabalho jornadaTrabalho) {
		this.id = jornadaTrabalho.getId();
		this.descricao = jornadaTrabalho.getDescricao();
	}

}
