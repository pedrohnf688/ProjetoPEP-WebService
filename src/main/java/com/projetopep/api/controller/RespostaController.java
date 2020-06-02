package com.projetopep.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetopep.api.config.Response;
import com.projetopep.api.modelo.Resposta;
import com.projetopep.api.repository.RespostaRepository;

@RestController
@RequestMapping("resposta")
public class RespostaController {

	@Autowired
	private RespostaRepository rr;

	@GetMapping
	public ResponseEntity<Response<List<Resposta>>> listAllRespotas() {

		Response<List<Resposta>> response = new Response<List<Resposta>>();
		List<Resposta> listaRespostas = rr.findAll();

		if (listaRespostas.isEmpty()) {
			response.getErros().add("A lista de respostas está vazia.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(listaRespostas);
		return ResponseEntity.ok(response);
	}

}
