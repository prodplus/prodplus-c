package br.com.proconweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.proconweb.models.Configuracao;
import br.com.proconweb.models.auxiliares.Turno;
import br.com.proconweb.services.ConfiguracaoService;

/**
 * 
 * @author Marlon F. Garcia
 *
 */
@RestController
@RequestMapping("/configs")
public class ConfiguracaoController {

	@Autowired
	private ConfiguracaoService configService;

	@PostMapping
	public ResponseEntity<Configuracao> salvar(@RequestBody Configuracao config) {
		return ResponseEntity.ok(this.configService.salvar(config));
	}

	@GetMapping
	public ResponseEntity<Configuracao> buscar() {
		return ResponseEntity.ok(this.configService.buscar());
	}

	@PutMapping("/{periodo}")
	public ResponseEntity<Configuracao> inserirTurno(@PathVariable String periodo,
			@RequestBody Turno turno) {
		return ResponseEntity.ok(this.configService.inserirTurno(periodo, turno));
	}

}
