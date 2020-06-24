package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Jogador {
	
	private Long id;
	private Long idTime;
	private String nome;
	private LocalDate dataNascimento;
	private Integer nivelHabilidade;
	private BigDecimal salario;
	
	public Jogador() {
	}

	public Jogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade,
			BigDecimal salario) {
		setId(id);
		setIdTime(idTime);
		setNome(nome);
		setDataNascimento(dataNascimento);
		setNivelHabilidade(nivelHabilidade);
		setSalario(salario);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id != null) {
			this.id = id;
		}else {
			throw new NullPointerException();
		}
	}

	public Long getIdTime() {
		return idTime;
	}

	public void setIdTime(Long idTime){
		if (idTime != null) {
			this.idTime = idTime;
		}else {
			throw new NullPointerException();
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (!nome.isEmpty()) {
			this.nome = nome;
		}else {
			throw new NullPointerException();
		}
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		if (dataNascimento != null) {
			this.dataNascimento = dataNascimento;
		}else {
			throw new NullPointerException();
		}
	}

	public Integer getNivelHabilidade() {
		return nivelHabilidade;
	}

	public void setNivelHabilidade(Integer nivelHabilidade) {
		if (nivelHabilidade > -1 || nivelHabilidade < 101 ) {	
			this.nivelHabilidade = nivelHabilidade;
		}else{
			throw new RuntimeException();
		}
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		if (salario != null) {
			this.salario = salario;
		}else {
			throw new NullPointerException();
		}
	}
	
	@Override
	public String toString() {
		return "-> id.: "+ id  + " -  Time.: " + idTime + " -  Nome.: " + nome + " -  Data Nasc.: " + 
		dataNascimento + " -  Nivel Habilidade.: " + nivelHabilidade + " -  Salario.: " + salario + " .";
		
	}

}
