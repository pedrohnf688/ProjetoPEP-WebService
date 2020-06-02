package com.projetopep.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
