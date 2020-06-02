package com.projetopep.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetopep.api.modelo.Resposta;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {

	Resposta findByDateCreated(Date dateCreated);
	
	Resposta findByChave(Integer chave);
	
	List<Resposta> findAllByChave(Integer chave);
	
	List<Resposta> findAllByFormularioId(Long id);
	
	List<Resposta> findAllsByFormularioIdAndDateCreated(Long id, Date dateCreated);
	
}
