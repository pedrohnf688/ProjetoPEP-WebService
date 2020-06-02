package com.projetopep.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetopep.api.config.Response;
import com.projetopep.api.modelo.Formulario;
import com.projetopep.api.repository.FormularioRepository;

@RestController
@RequestMapping("form")
public class FormularioController {

	@Autowired
	private FormularioRepository fr;

	@GetMapping
	public ResponseEntity<Response<List<Formulario>>> listAllRFormularios() {

		Response<List<Formulario>> response = new Response<List<Formulario>>();
		List<Formulario> listaFormularios = fr.findAll();

		if (listaFormularios.isEmpty()) {
			response.getErros().add("A lista de formularios está vazia.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(listaFormularios);
		return ResponseEntity.ok(response);
	}

}
