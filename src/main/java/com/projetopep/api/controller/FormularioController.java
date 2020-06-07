package com.projetopep.api.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<Response<List<Formulario>>> listAllFormularios() {

		Response<List<Formulario>> response = new Response<List<Formulario>>();
		List<Formulario> listaFormularios = fr.findAll();

		if (listaFormularios.isEmpty()) {
			response.getErros().add("A lista de formularios está vazia.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(listaFormularios);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Response<Formulario>> listById(@PathVariable("id") Long id) {

		Response<Formulario> response = new Response<Formulario>();
		Optional<Formulario> f = fr.findById(id);

		if (!f.isPresent()) {
			response.getErros().add("Formulário não existente.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(f.get());
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "dateCreated")
	public ResponseEntity<Response<List<Formulario>>> listAllByDateCreated(
			@RequestParam("dateCreated") @DateTimeFormat(pattern = "dd.MM.yyyy") Date dateCreated) {

		Response<List<Formulario>> response = new Response<List<Formulario>>();
		List<Formulario> listaFormularios = fr.findAllByDateCreated(dateCreated);

		if (listaFormularios.isEmpty()) {
			response.getErros().add("A lista de formularios está vazia.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(listaFormularios);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "usuario")
	public ResponseEntity<Response<List<Formulario>>> listAllByUsuarioId(@RequestParam("id") Long id) {

		Response<List<Formulario>> response = new Response<List<Formulario>>();
		List<Formulario> listaFormularios = fr.findAllByUsuarioId(id);

		if (listaFormularios.isEmpty()) {
			response.getErros().add("A lista de formularios está vazia.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(listaFormularios);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "numAndUserId")
	public ResponseEntity<Response<List<Formulario>>> listAllByNumAndUsuarioId(@RequestParam("num") Integer num,
			@RequestParam("id") Long id) {

		Response<List<Formulario>> response = new Response<List<Formulario>>();
		List<Formulario> listaFormularios = fr.findAllByNumAndUsuarioId(num, id);

		if (listaFormularios.isEmpty()) {
			response.getErros().add("A lista de formularios está vazia.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(listaFormularios);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "numAndDateCreated")
	public ResponseEntity<Response<List<Formulario>>> listAllByNumAndDateCreated(@RequestParam("num") Integer num,
			@RequestParam("dateCreated") @DateTimeFormat(pattern = "dd.MM.yyyy") Date dateCreated) {

		Response<List<Formulario>> response = new Response<List<Formulario>>();
		List<Formulario> listaFormularios = fr.findAllByNumAndDateCreated(num, dateCreated);

		if (listaFormularios.isEmpty()) {
			response.getErros().add("A lista de formularios está vazia.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(listaFormularios);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "userIdAndDateCreated")
	public ResponseEntity<Response<List<Formulario>>> listAllByUsuarioIdAndDateCreated(@RequestParam("id") Long id,
			@RequestParam("dateCreated") @DateTimeFormat(pattern = "dd.MM.yyyy") Date dateCreated) {

		Response<List<Formulario>> response = new Response<List<Formulario>>();
		List<Formulario> listaFormularios = fr.findAllByUsuarioIdAndDateCreated(id, dateCreated);

		if (listaFormularios.isEmpty()) {
			response.getErros().add("A lista de formularios está vazia.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(listaFormularios);
		return ResponseEntity.ok(response);
	}

}
