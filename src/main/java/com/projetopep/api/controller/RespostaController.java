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
import com.projetopep.api.modelo.RespostaAntigo;
import com.projetopep.api.repository.RespostaRepository;

@RestController
@RequestMapping("resposta")
public class RespostaController {

	@Autowired
	private RespostaRepository rr;

	@GetMapping
	public ResponseEntity<Response<List<RespostaAntigo>>> listAllRespotas() {

		Response<List<RespostaAntigo>> response = new Response<List<RespostaAntigo>>();
		List<RespostaAntigo> listaRespostas = rr.findAll();

		if (listaRespostas.isEmpty()) {
			response.getErros().add("A lista de respostas está vazia.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(listaRespostas);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<Response<RespostaAntigo>> listById(@PathVariable("id") Long id) {

		Response<RespostaAntigo> response = new Response<RespostaAntigo>();
		Optional<RespostaAntigo> r = rr.findById(id);

		if (!r.isPresent()) {
			response.getErros().add("Resposta não existente.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(r.get());
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "dateCreated")
	public ResponseEntity<Response<List<RespostaAntigo>>> listAllByDateCreated(
			@RequestParam("dateCreated") @DateTimeFormat(pattern = "dd.MM.yyyy") Date dateCreated) {

		Response<List<RespostaAntigo>> response = new Response<List<RespostaAntigo>>();
		List<RespostaAntigo> listaRespostas = rr.findAllByDateCreated(dateCreated);

		if (listaRespostas.isEmpty()) {
			response.getErros().add("A lista de respostas está vazia.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(listaRespostas);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "chave")
	public ResponseEntity<Response<List<RespostaAntigo>>> listAllByChave(@RequestParam("chave") Integer chave) {

		Response<List<RespostaAntigo>> response = new Response<List<RespostaAntigo>>();
		List<RespostaAntigo> listaRespostas = rr.findAllByChave(chave);

		if (listaRespostas.isEmpty()) {
			response.getErros().add("A lista de respostas está vazia.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(listaRespostas);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "chaveAndFormId")
	public ResponseEntity<Response<List<RespostaAntigo>>> listAllByChaveAndFormularioId(@RequestParam("chave") Integer chave,
			@RequestParam("id") Long id) {

		Response<List<RespostaAntigo>> response = new Response<List<RespostaAntigo>>();
		List<RespostaAntigo> listaRespostas = rr.findAllByChaveAndFormularioId(chave, id);

		if (listaRespostas.isEmpty()) {
			response.getErros().add("A lista de respostas está vazia.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(listaRespostas);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "formId")
	public ResponseEntity<Response<List<RespostaAntigo>>> listAllByFormularioId(@RequestParam("id") Long id) {

		Response<List<RespostaAntigo>> response = new Response<List<RespostaAntigo>>();
		List<RespostaAntigo> listaRespostas = rr.findAllByFormularioId(id);

		if (listaRespostas.isEmpty()) {
			response.getErros().add("A lista de respostas está vazia.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(listaRespostas);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "formIdAndDateCreated")
	public ResponseEntity<Response<List<RespostaAntigo>>> listAllByFormularioIdAndDateCreated(@RequestParam("id") Long id,
			@RequestParam("dateCreated") @DateTimeFormat(pattern = "dd.MM.yyyy") Date dateCreated) {

		Response<List<RespostaAntigo>> response = new Response<List<RespostaAntigo>>();
		List<RespostaAntigo> listaRespostas = rr.findAllByFormularioIdAndDateCreated(id, dateCreated);

		if (listaRespostas.isEmpty()) {
			response.getErros().add("A lista de respostas está vazia.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(listaRespostas);
		return ResponseEntity.ok(response);
	}

}
