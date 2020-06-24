package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;


public class DesafioMeuTimeApplication implements MeuTimeInterface {
	private List<Time> times = new ArrayList<>();
	private List<Jogador> jogadores = new ArrayList<>();

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		if (id == null || nome == null || dataCriacao == null || corUniformePrincipal == null ||  corUniformeSecundario == null ) {
			throw new NullPointerException();
		}else {
			Boolean timeNew = verificarTime(id);
			if (timeNew.booleanValue() == false) {
				times.add( new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
			}else {
				throw new IdentificadorUtilizadoException("Time "+ id +" já existe.");
			}
		}
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		if (id == null || idTime == null || nome == null ||  dataNascimento == null || nivelHabilidade == null || salario == null) {
			throw new NullPointerException();
		}else {
			Time time = buscarTime(idTime);
			Boolean jogadorNew = verificarJogador(id);
			if (jogadorNew.booleanValue() == false ) {
				jogadores.add(new Jogador(id, time.getId(), nome, dataNascimento, nivelHabilidade, salario));
			}else {
				throw new IdentificadorUtilizadoException("jogador "+ id +" já existe.");
			}
		}
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		Jogador jogador = buscarJogador(idJogador);
		Time time = buscarTime(jogador.getIdTime());
		time.setCapitao(jogador.getId());

	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		Time time =  buscarTime(idTime);
		if ( time.getCapitao() != null) {
			return time.getCapitao();
		}else {
			throw new CapitaoNaoInformadoException("Time sem capitao definido");
		}
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		Jogador jogador = buscarJogador(idJogador);
		return jogador.getNome().toString();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		Time time = buscarTime(idTime);
		return time.getNome();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		Time time = buscarTime(idTime);
		List<Long> listJogadores = new ArrayList<>();
		for (Jogador jogador : jogadores) {
			if (jogador.getIdTime().equals(time.getId())){
				listJogadores.add(jogador.getId());
			}
		}
		return listJogadores;
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		Time time = buscarTime(idTime);;
		Jogador melhorJogador = jogadores.stream().filter(meuTime -> meuTime.getIdTime().equals(time.getId()))
				.max(Comparator.comparing(Jogador::getNivelHabilidade)).orElseThrow(NoSuchElementException::new);
		return melhorJogador.getId();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		Time time = buscarTime(idTime);
		Jogador maisVelho = jogadores.stream().filter(meuTime -> meuTime.getIdTime().equals(time.getId()))
				.min(Comparator.comparing(Jogador::getDataNascimento)).orElseThrow(NoSuchElementException::new);
		return maisVelho.getId();
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		List<Long> listTimes = new ArrayList<>();
		for (Time time : times) {
			listTimes.add(time.getId());
		}
		Collections.sort(listTimes);
		return listTimes;
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		Time time = buscarTime(idTime);
		Jogador melhorSalario = jogadores.stream().filter(meuTime -> meuTime.getIdTime().equals(time.getId()))
				.max(Comparator.comparing(Jogador::getSalario)).orElseThrow(NoSuchElementException::new);
		return melhorSalario.getId();
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		Jogador jogador = buscarJogador(idJogador);
		return jogador.getSalario();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		return jogadores.stream()
				.sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed().thenComparing(Jogador::getId))
				.limit(top).map(Jogador::getId).collect(Collectors.toList());
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		Time casa = buscarTime(timeDaCasa); 
		Time fora = buscarTime(timeDeFora);
		if (casa.getCorUniformePrincipal().equals(fora.getCorUniformePrincipal())) {
			return fora.getCorUniformeSecundario();
		}else {
			return fora.getCorUniformePrincipal();
		}
	}

	public Jogador buscarJogador(Long id) {
		Jogador jogadorRetorno = new Jogador();
		jogadorRetorno = null;
		for ( Jogador jogador : jogadores) {
			 if (jogador.getId().equals(id)) {
				 jogadorRetorno = jogador;
			 }
		}
		if (jogadorRetorno == null) {
			throw new JogadorNaoEncontradoException("Jogador " +id +" não encontrado");
		}else {
			return jogadorRetorno;
		}
	}
	
	public Time buscarTime(Long id) {
		Time timeRetorno = new Time();
		timeRetorno = null;
		for (Time time : times ) {
			if (time.getId().equals(id)) {
				timeRetorno = time;
			}
		}
		if (timeRetorno == null) {
			throw new TimeNaoEncontradoException("Time "+ id + " não encontrado.");
		}else {
			return timeRetorno;
		}
	}
	
	public boolean verificarTime(long id) {
		Boolean retorno = false;
		for (Time time : times) {
			if (time.getId().equals(id)) {
				retorno = true;
			}
		}
		return retorno;
	}
	
	public boolean verificarJogador(long id) {
		Boolean retorno = false;
		for (Jogador jogador: jogadores) {
			if (jogador.getId().equals(id)) {
				retorno = true;
			}
		}
		return retorno;
	}
}