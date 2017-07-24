package br.com.muxi.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.com.muxi.dao.TituloDao;
import br.com.muxi.model.Titulo;

@Service
@Validated
public class TituloService {

	@Autowired
	private TituloDao dao;
	
	@Transactional(readOnly=true)
	public List<Titulo> getAll() {
		return dao.findAll();
	}
	
	@Transactional(readOnly=true)
	public Titulo get(Integer logic) {
		return dao.findOne(logic);
	}
	
	public void save(@Valid Titulo titulo) {
		dao.save(titulo);
	}
}
