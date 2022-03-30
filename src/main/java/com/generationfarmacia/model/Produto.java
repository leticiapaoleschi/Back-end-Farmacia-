package com.generationfarmacia.model;

import java.math.BigDecimal;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name= "tb_produtos")
public class Produto {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private long id;

@NotNull(message="Nome do produto!")
private String nome;

@NotBlank
private String descricao;
@NotNull
private String foto; 

@JsonFormat(shape = JsonFormat.Shape.STRING) // * A anotação @JsonFormat(shape = JsonFormat.Shape.STRING) é utilizada para formatar o valor do preço do produto como uma String
@NotNull(message="Preço é obrigatório!")
@Positive(message = "Digite um valor maior do que zero")
private BigDecimal preco;

@ManyToOne
@JsonIgnoreProperties("produto")
private Categoria categoria;

public long getId() {
	return id;
}


public void setId(long id) {
	this.id = id;
}


public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}


public String getDescricao() {
	return descricao;
}


public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public BigDecimal getPreco() {
	return preco;
}


public void setPreco(BigDecimal preco) {
	this.preco = preco;
}
public String getFoto() {
	return foto;
}


public void setFoto(String foto) {
	this.foto = foto;
}
public Categoria getCategoria() {
	return categoria;
}


public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
}
}
