package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List<Integer> lista = new ArrayList<Integer>();
		int i = 0; int swap = 1; int result = 0;
		
		lista.add(i);
		lista.add(swap);
		
		do{
			result = i + swap;
			
			lista.add(result);
			i = swap;
			swap = result;

		}while ( result <= 350 );
		
		return lista;
	}

	public static Boolean isFibonacci(Integer a) {
		return fibonacci().contains(a);
	}

}