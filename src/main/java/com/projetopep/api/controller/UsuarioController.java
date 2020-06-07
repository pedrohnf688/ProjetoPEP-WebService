package com.projetopep.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetopep.api.config.Response;
import com.projetopep.api.modelo.Usuario;
import com.projetopep.api.repository.UsuarioRepository;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepository ur;

	@GetMapping
	public ResponseEntity<Response<List<Usuario>>> listAllUsuarios() {

		Response<List<Usuario>> response = new Response<List<Usuario>>();
		List<Usuario> listaUsuarios = ur.findAll();

		if (listaUsuarios.isEmpty()) {
			response.getErros().add("A lista de usuarios está vazia.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(listaUsuarios);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Response<Usuario>> listById(@PathVariable("id") Long id) {

		Response<Usuario> response = new Response<Usuario>();
		Optional<Usuario> u = ur.findById(id);

		if (!u.isPresent()) {
			response.getErros().add("Usuário não existente.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(u.get());
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "username")
	public ResponseEntity<Response<Usuario>> listByUsername(@RequestParam("username") String username) {

		Response<Usuario> response = new Response<Usuario>();
		Optional<Usuario> u = ur.findByUsername(username);

		if (!u.isPresent()) {
			response.getErros().add("Username não existente.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(u.get());
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "email")
	public ResponseEntity<Response<Usuario>> listByEmail(@RequestParam("email") String email) {

		Response<Usuario> response = new Response<Usuario>();
		Optional<Usuario> u = ur.findByEmail(email);

		if (!u.isPresent()) {
			response.getErros().add("Email não existente.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(u.get());
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "identificador")
	public ResponseEntity<Response<Usuario>> listByIdentificador(@RequestParam("identificador") String identificador) {

		Response<Usuario> response = new Response<Usuario>();
		Optional<Usuario> u = ur.findByIdentificador(identificador);

		if (!u.isPresent()) {
			response.getErros().add("Identificador não existente.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(u.get());
		return ResponseEntity.ok(response);
	}

}
