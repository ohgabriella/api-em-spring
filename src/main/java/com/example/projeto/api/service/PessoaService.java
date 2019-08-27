package com.example.projeto.api.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.projeto.api.model.Pessoa;
import com.example.projeto.api.repository.PessoaRepository;

@Service
public class PessoaService {
	@Autowired
	@Qualifier("pessoaRepository")
	private PessoaRepository pessoaRepository;
	
	public Pessoa atualizar(Pessoa pessoa, Long codigo) {
		Pessoa pessoaSalva = pessoaRepository.getOne(codigo);
		if(pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
		pessoaRepository.save(pessoaSalva);
		
		return pessoaSalva;
	}
	
}
