package br.com.proconweb.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.proconweb.models.Feriado;
import br.com.proconweb.services.FeriadoService;

/**
 * 
 * @author Marlon F. Garcia
 *
 */
@RestController
@RequestMapping("/feriados")
public class FeriadoController {

	@Autowired
	private FeriadoService feriadoService;

	@PostMapping
	public ResponseEntity<Feriado> salvar(@RequestBody Feriado feriado) {
		return ResponseEntity.ok(this.feriadoService.salvar(feriado));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Feriado> atualizar(@PathVariable Integer id,
			@RequestBody Feriado feriado) {
		return ResponseEntity.ok(this.feriadoService.atualizar(id, feriado));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Feriado> buscar(@PathVariable Integer id) {
		return ResponseEntity.ok(this.feriadoService.buscar(id));
	}

	@GetMapping("/listar/{pagina}/{quant}/{de}")
	public ResponseEntity<Page<Feriado>> listar(
			@PathVariable @DateTimeFormat(iso = ISO.DATE) LocalDate de, @PathVariable int pagina,
			@PathVariable int quant) {
		return ResponseEntity.ok(this.feriadoService.listar(de, pagina, quant));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Integer id) {
		this.feriadoService.excluir(id);
		return ResponseEntity.ok().build();
	}

}
