package com.projetopep.api.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetopep.api.modelo.Formulario;

@Repository
public interface FormularioRepository extends JpaRepository<Formulario, Long> {

	Formulario findByDateCreated(Date dateCreated);

	List<Formulario> findAllByUsuarioId(Long id);

	Formulario findByNum(Integer num);

	List<Formulario> findAllByNumAndDateCreated(Integer num, Date dateCreated);

	List<Formulario> findAllByUsuarioIdAndDateCreateds(Long id, Date dateCreated);

}
