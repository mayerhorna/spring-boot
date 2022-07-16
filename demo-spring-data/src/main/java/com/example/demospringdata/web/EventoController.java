package com.example.demospringdata.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demospringdata.dao.EventoRepository;
import com.example.demospringdata.model.Evento;

@RestController
public class EventoController {
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@GetMapping("/evento")
	public List<Evento> list(){
		return eventoRepository.findAll();
	}
	
	@GetMapping("/eventoList")
	public List<Evento> eventoList(){
		return eventoRepository.findAll();
	}
	
	@GetMapping("/eventoListFilter/{filtro}")
	public List<Evento> eventoListFilter(@PathVariable String filtro){
		return eventoRepository.findByTituloContaining(filtro);
	}
}
