package br.com.codenation.calculadora;


public class CalculadoraSalario {
	private double calculo; 
		
	public long calcularSalarioLiquido(double salarioBase) {
		if (salarioBase < 1039.0) {
			return Math.round(0.0);
		}else if( salarioBase < 1500.01){
			this.calculo = (salarioBase - ((salarioBase * 8)/100));
		}else if (salarioBase < 4000.01) {
			this.calculo = (salarioBase -((salarioBase * 9)/100));
		}else {
			this.calculo = (salarioBase -((salarioBase * 11)/100));
		}
		//Use o Math.round apenas no final do método para arredondar o valor final.
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		double retorno = 0.0;
		retorno = calcularInss(calculo);
		//return Math.round(0.0);
		return Math.round(retorno);
	}
	
	
	//Exemplo de método que pode ser criado para separar melhor as responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {
		double irpf = 0.0;
		if ( salarioBase < 3000.01 ) {
			return salarioBase;
		}else if( salarioBase < 6000.01) {
			irpf = (salarioBase -((salarioBase * 7.5) / 100));
		}else{
			irpf = (salarioBase - ((salarioBase * 15) / 100));
		}
		return irpf;
	}

}
/*Dúvidas ou Problemas?
Manda e-mail para o meajuda@codenation.dev que iremos te ajudar! 
*/