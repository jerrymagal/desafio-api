package br.com.muxi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.muxi.model.Titulo;

public interface TituloDao extends JpaRepository<Titulo, Integer>{

}
