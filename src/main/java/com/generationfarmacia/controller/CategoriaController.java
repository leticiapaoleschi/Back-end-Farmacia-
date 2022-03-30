package com.generationfarmacia.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.generationfarmacia.model.Categoria;

import com.generationfarmacia.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin  (origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository CategoriaRepository;
	
	@GetMapping
	public ResponseEntity<List <Categoria>> getAll(){
		return ResponseEntity.ok(CategoriaRepository.findAll());
	}
	@GetMapping("/{id}") 
	public ResponseEntity<Categoria> GetById(@PathVariable long id){
		return CategoriaRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
}
	@GetMapping("/tarja/{tarja}")
	public ResponseEntity<List<Categoria>> getByCategoria(@PathVariable String tarja){
		return ResponseEntity.ok(CategoriaRepository.findAllByTarjaContainingIgnoreCase(tarja));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> postCategoria(@Valid @RequestBody Categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(CategoriaRepository.save(categoria));
}
	public ResponseEntity<Categoria> putCategoria(@Valid @RequestBody Categoria categoria) {
		
		return CategoriaRepository.findById(categoria.getId()).map(resposta -> ResponseEntity.ok().body(CategoriaRepository.save(categoria))).orElse(ResponseEntity.notFound().build());

	}
	
	@DeleteMapping("/{id}") 
	public void delete(@PathVariable long id) {
		CategoriaRepository.deleteById(id);
	}
}
