package com.projetopep.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetopep.api.modelo.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByUsername(String username);

	Optional<Usuario> findByEmail(String email);

	Optional<Usuario> findByIdentificador(String identificador);
}
