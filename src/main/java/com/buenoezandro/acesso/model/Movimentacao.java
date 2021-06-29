package com.buenoezandro.acesso.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Movimentacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode
	@Embeddable
	public static class MovimentacaoId implements Serializable {

		private static final long serialVersionUID = 1L;

		private Long idMovimento;
		private Long idUsuario;

	}

	@EmbeddedId
	private MovimentacaoId id;

	private LocalDateTime dataEntrada;
	private LocalDateTime dataSaida;
	private BigDecimal periodo;
	private Ocorrencia ocorrencia;
	private Calendario calendario;

}
