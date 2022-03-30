package com.generationfarmacia.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generationfarmacia.model.Produto;
import com.generationfarmacia.repository.ProdutoRepository;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping("/produtos") 
public class ProdutoController {
	@Autowired 
	private ProdutoRepository ProdutoRepository;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){ 
		return ResponseEntity.ok(ProdutoRepository.findAll());
	
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Produto> GetById(@PathVariable long id){
		return ProdutoRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}	

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Produto>> getByNome(@PathVariable String nome){
	return ResponseEntity.ok(ProdutoRepository.findAllByNomeContainingIgnoreCase(nome));
}
    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<Produto>> getByDescricao(@PathVariable String descricao){
	return ResponseEntity.ok(ProdutoRepository.findAllByNomeContainingIgnoreCase(descricao));
    }
    @GetMapping("/preco_inicial/{inicio}/preco_final/{fim}")
	public ResponseEntity<List<Produto>> getByPrecoEntreNatve(@PathVariable BigDecimal inicio, @PathVariable BigDecimal fim){
		return ResponseEntity.ok(ProdutoRepository.buscarProdutosEntre(inicio, fim));
	}
 
   @PostMapping
   public ResponseEntity<Produto> post ( @RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(ProdutoRepository.save(produto));
   } 
 
   @PutMapping 
	public ResponseEntity<Produto> put (@RequestBody Produto produto){
		return ResponseEntity.status(HttpStatus.OK).body(ProdutoRepository.save(produto));
   }
	@DeleteMapping("/{id}") 
	public void delete(@PathVariable long id) {
		ProdutoRepository.deleteById(id);
   }
}
