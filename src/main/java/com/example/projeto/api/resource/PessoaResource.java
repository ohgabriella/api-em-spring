package com.example.projeto.api.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto.api.event.RecursoCriadoEvent;
import com.example.projeto.api.model.Pessoa;
import com.example.projeto.api.repository.PessoaRepository;
import com.example.projeto.api.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	public List<Pessoa> listarPessoa() {
		return pessoaRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Pessoa> criarPessoa(@Valid @RequestBody Pessoa pessoas, HttpServletResponse response) {
		Pessoa pessoaSalva = pessoaRepository.save(pessoas);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}

	@GetMapping("/{codigo}")
	public Optional<Pessoa> listarPessoaPorCodigo(@PathVariable Long codigo) {
		return pessoaRepository.findById(codigo);
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		pessoaRepository.deleteById(codigo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long codigo, @Valid @RequestBody Pessoa pessoa) {
		Pessoa pessoaAtualizada = pessoaService.atualizar(pessoa, codigo);
		return ResponseEntity.ok(pessoaAtualizada);
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
																	}
	
	
}
