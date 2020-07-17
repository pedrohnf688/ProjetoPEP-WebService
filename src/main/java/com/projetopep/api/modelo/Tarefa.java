package com.projetopep.api.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.projetopep.api.modelo.enums.EnumStatusTarefa;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "date_created", nullable = false)
	private Date dateCreated;

	private String nome;
	
	private EnumStatusTarefa  status;
	
	private String urlVideoAula;
	
	private Questionario questionario;
}
