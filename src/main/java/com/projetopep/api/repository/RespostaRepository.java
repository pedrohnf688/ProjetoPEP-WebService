package com.projetopep.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetopep.api.modelo.RespostaAntigo;

@Repository
public interface RespostaRepository extends JpaRepository<RespostaAntigo, Long> {

	List<RespostaAntigo> findAllByDateCreated(Date dateCreated);

	List<RespostaAntigo> findAllByChave(Integer chave);

	List<RespostaAntigo> findAllByChaveAndFormularioId(Integer chave, Long id);

	List<RespostaAntigo> findAllByFormularioId(Long id);

	List<RespostaAntigo> findAllByFormularioIdAndDateCreated(Long id, Date dateCreated);

}
