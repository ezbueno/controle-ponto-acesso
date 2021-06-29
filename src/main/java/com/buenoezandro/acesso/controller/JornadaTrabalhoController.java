package com.buenoezandro.acesso.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.buenoezandro.acesso.dto.JornadaTrabalhoDTO;
import com.buenoezandro.acesso.model.JornadaTrabalho;
import com.buenoezandro.acesso.service.JornadaTrabalhoService;

@RestController
@RequestMapping(value = "/jornada")
public class JornadaTrabalhoController {

	private JornadaTrabalhoService jornadaTrabalhoService;

	@Autowired
	public JornadaTrabalhoController(JornadaTrabalhoService jornadaTrabalhoService) {
		this.jornadaTrabalhoService = jornadaTrabalhoService;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<JornadaTrabalhoDTO>> buscarTodos() {
		List<JornadaTrabalho> jornadas = this.jornadaTrabalhoService.buscarTodos();
		return ResponseEntity.ok().body(jornadas.stream().map(JornadaTrabalhoDTO::new).collect(Collectors.toList()));
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JornadaTrabalhoDTO> buscarPorId(@PathVariable Long id) {
		var jornadaTrabalho = this.jornadaTrabalhoService.buscarPorId(id);
		return ResponseEntity.ok().body(new JornadaTrabalhoDTO(jornadaTrabalho));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JornadaTrabalhoDTO> salvar(@RequestBody JornadaTrabalhoDTO jornadaTrabalhoDTO) {
		var jornadaTrabalho = this.jornadaTrabalhoService.salvar(jornadaTrabalhoDTO);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(jornadaTrabalho.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JornadaTrabalhoDTO> atualizar(@PathVariable Long id,
			@RequestBody JornadaTrabalhoDTO jornadaTrabalhoDTO) {
		var jornadaTrabalho = this.jornadaTrabalhoService.atualizar(id, jornadaTrabalhoDTO);
		return ResponseEntity.ok().body(new JornadaTrabalhoDTO(jornadaTrabalho));
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		this.jornadaTrabalhoService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
