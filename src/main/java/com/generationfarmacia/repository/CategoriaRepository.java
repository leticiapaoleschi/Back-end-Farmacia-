package com.generationfarmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generationfarmacia.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	public List <Categoria> findAllBySessaoContainingIgnoreCase(String sessao);

	public List <Categoria> findAllByUsoContainingIgnoreCase(String uso);
	
	public List<Categoria> findAllByTarjaContainingIgnoreCase(String tarja);

	
}
