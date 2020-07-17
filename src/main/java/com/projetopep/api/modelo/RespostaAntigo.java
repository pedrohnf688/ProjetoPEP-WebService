package com.projetopep.api.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class RespostaAntigo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "date_created", nullable = false)
	private Date dateCreated;

	@Column(name = "chave", nullable = false)
	private Integer chave;

	@Column(name = "valor", nullable = false)
	private String valor;

	@ManyToOne
	@JoinColumn(name = "formulario_id")
	private Formulario formulario;

}
