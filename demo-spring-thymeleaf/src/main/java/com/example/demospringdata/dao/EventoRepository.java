package com.example.demospringdata.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demospringdata.model.Evento;

public interface EventoRepository extends JpaRepository<Evento,Long>{
	
	public List<Evento> findByTitulo(String titulo);
	
	public List<Evento> findByTituloContaining(String titulo);
}	
