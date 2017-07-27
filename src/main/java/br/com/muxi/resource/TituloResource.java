package br.com.muxi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.muxi.converter.impl.TituloConverter;
import br.com.muxi.model.Titulo;
import br.com.muxi.service.TituloService;

@RestController
@RequestMapping("/titulo")
public class TituloResource {

	private static final String MEDIA_TYPE_TEXT_HTML = "text/html";
	private static final String MEDIA_TYPE_JSON = "application/json";
	
	@Autowired
	private TituloService service;
	
	private TituloConverter converter = new TituloConverter();
	
	@GetMapping(path="/")
	public String index() {
		return "index";
	}
	
	@GetMapping
	public ResponseEntity<List<Titulo>> getAll() {
		
		List<Titulo> titulos = service.getAll();
		HttpStatus status = HttpStatus.OK;
		
		if(titulos.isEmpty()) {
			status = HttpStatus.NO_CONTENT;
		}
		
		return new ResponseEntity<>(titulos, status);
	}
	
	@GetMapping("/{logic}")
	public Titulo getOne(@PathVariable Integer logic) {
		return service.get(logic);
	}
	
	@PostMapping(consumes=MEDIA_TYPE_TEXT_HTML)
	public ResponseEntity<Titulo> save(@RequestBody String textoTitulo) {
		Titulo titulo = converter.toObject(textoTitulo);
		service.save(titulo);
		return new ResponseEntity<>(titulo, HttpStatus.CREATED);
	}
	
	@PutMapping(path="/{logic}", consumes=MEDIA_TYPE_JSON)
	public Titulo update(@PathVariable Integer logic, @RequestBody Titulo titulo) {
		service.save(titulo);
		return titulo;
	}
}
