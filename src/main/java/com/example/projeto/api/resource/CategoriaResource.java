package com.example.projeto.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto.api.model.Categoria;
import com.example.projeto.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping
	public List<Categoria> listarCategorias() {
		return categoriaRepository.findAll();
	}
}
