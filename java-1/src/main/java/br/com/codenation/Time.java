package br.com.codenation;

import java.time.LocalDate;

public class Time {
	private Long id;
	private String nome;
	private LocalDate dataCriacao;
	private String corUniformePrincipal;
	private String corUniformeSecundario;
	private Long capitao;
	
	public Time() {
	}

	public Time(Long idTime, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		setId(idTime);
		setNome(nome);
		setDataCriacao(dataCriacao);
		setCorUniformePrincipal(corUniformePrincipal);
		setCorUniformeSecundario(corUniformeSecundario);
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

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		if (dataCriacao != null) {
			this.dataCriacao = dataCriacao;
		}else {
			throw new NullPointerException();
		}
	}

	public String getCorUniformePrincipal() {
		return corUniformePrincipal;
	}

	public void setCorUniformePrincipal(String corUniformePrincipal) {
		if (!corUniformePrincipal.isEmpty()) {
			this.corUniformePrincipal = corUniformePrincipal;
		}else {
			throw new NullPointerException();
		}
	}

	public String getCorUniformeSecundario() {
		return corUniformeSecundario;
	}

	public void setCorUniformeSecundario(String corUniformeSecundario) {
		if (!corUniformeSecundario.isEmpty()) {
			this.corUniformeSecundario = corUniformeSecundario;
		}else {
			throw new NullPointerException();
		}
	}

	public Long getCapitao() {
		return capitao;
	}

	public void setCapitao(Long capitao)  {
			this.capitao = capitao;
	}
	
	@Override
	public String toString() {
		return "-> id.: " + id + " - Time.: "+ nome + " -  Data Criacao.: " + dataCriacao + 
		" -  Uniforme Principal.: " + corUniformePrincipal + " -  Segungo Uniforme.: " + corUniformeSecundario +
		" -  Capitao.: " + capitao + " .";
	}
	
	
}
