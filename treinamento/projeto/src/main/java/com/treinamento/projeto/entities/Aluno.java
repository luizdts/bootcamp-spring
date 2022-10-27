package com.treinamento.projeto.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_aluno")
public class Aluno implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Pessoa pessoa;
	
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="Matricula")
	private String matricula;
	
	@Column(name="ano_de_entrada")
	private Date anoDeEntrada;
	
	@ManyToOne
	private Pessoa id_pessoa;

	public Aluno(Long id, String matricula, Date anoDeEntrada) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.anoDeEntrada = anoDeEntrada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getAnoDeEntrada() {
		return anoDeEntrada;
	}

	public void setAnoDeEntrada(Date anoDeEntrada) {
		this.anoDeEntrada = anoDeEntrada;
	}
	
	
}
