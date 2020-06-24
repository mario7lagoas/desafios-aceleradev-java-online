package com.challenge.desafio;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

public class CalculadorDeClasses implements Calculavel {

	@Override
	public BigDecimal somar(Object objeto) {
		return result(objeto, Somar.class);
	}

	@Override
	public BigDecimal subtrair(Object objeto) {
		return result(objeto, Subtrair.class);
	}

	@Override
	public BigDecimal totalizar(Object objeto) {
		return somar(objeto).subtract(subtrair(objeto));
	}

	private BigDecimal result(Object objeto, Class anotacao) {

		BigDecimal retorno = BigDecimal.ZERO;
		Field[] fields = objeto.getClass().getDeclaredFields();

		for (Field field : fields) {
			field.setAccessible(true);
			if (field.getAnnotation(anotacao) != null) {
				if (field.getType().equals(BigDecimal.class) && field.isAnnotationPresent(anotacao)) {
					try {
						retorno = retorno.add((BigDecimal) field.get(objeto));
					} catch (IllegalArgumentException | IllegalAccessException e) {
						e.getMessage();
					}
				}
			}
		}
		return retorno;
	}

}
