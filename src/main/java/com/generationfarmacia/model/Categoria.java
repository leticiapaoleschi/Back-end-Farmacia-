package com.generationfarmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank(message="Tarja é obrigatório!")
private String tarja;

@NotNull
private String uso;

@NotBlank(message="Sessão da farmacia")
private String sessao;

@OneToMany(mappedBy ="categoria", cascade = CascadeType.ALL)
@JsonIgnoreProperties("categoria")
private List<Produto>produto;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTarja() {
	return tarja;
}

public void setTarja(String tarja) {
	this.tarja = tarja;
}

public String getUso() {
	return uso;
}

public void setUso(String uso) {
	this.uso = uso;
}

public String getSessao() {
	return sessao;
}

public void setSessao(String sessao) {
	this.sessao = sessao;
}

public List<Produto> getProduto() {
	return produto;
}

public void setProduto(List<Produto> produto) {
	this.produto = produto;
}

}
