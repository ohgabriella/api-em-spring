package com.example.projeto.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projeto.api.model.Pessoa;
import com.example.projeto.api.repository.PessoaRepository;

@Service
public class PessoaService {
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa atualizar(Pessoa pessoa) {
		//Pessoa pessoaSalva = pessoaRepository.findOne(codigo);
	}
	
}
