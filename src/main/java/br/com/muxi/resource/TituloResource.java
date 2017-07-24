package br.com.muxi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	private static final String MEDIA_TYPE_TEXT_PLAIN = "text/plain";
	private static final String MEDIA_TYPE_JSON = "application/json";
	
	@Autowired
	private TituloService service;
	
	private TituloConverter converter = new TituloConverter();
	
	@GetMapping
	public List<Titulo> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{logic}")
	public Titulo getOne(@PathVariable Integer logic) {
		return service.get(logic);
	}
	
	@PostMapping(consumes=MEDIA_TYPE_TEXT_PLAIN)
	public Titulo save(@RequestBody String textoTitulo) {
		Titulo titulo = converter.toObject(textoTitulo);
		service.save(titulo);
		return titulo;
	}
	
	@PutMapping(path="/{logic}", consumes=MEDIA_TYPE_JSON)
	public Titulo update(@PathVariable Integer logic, @RequestBody Titulo titulo) {
		service.save(titulo);
		return titulo;
	}
}
