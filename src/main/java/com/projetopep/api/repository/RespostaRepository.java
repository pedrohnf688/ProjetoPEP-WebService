package com.projetopep.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetopep.api.modelo.Resposta;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {

	List<Resposta> findAllByDateCreated(Date dateCreated);

	List<Resposta> findAllByChave(Integer chave);

	List<Resposta> findAllByChaveAndFormularioId(Integer chave, Long id);

	List<Resposta> findAllByFormularioId(Long id);

	List<Resposta> findAllByFormularioIdAndDateCreated(Long id, Date dateCreated);

}
