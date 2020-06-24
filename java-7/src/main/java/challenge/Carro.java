package challenge;

import java.util.Objects;

public class Carro {

    private final Motorista motorista;

    private final String placa;

    private final Cor cor;

    private Carro(Motorista motorista, String placa, Cor cor) {
    	this.motorista = motorista;
        this.placa = verificarCor(placa);
        this.cor = verificarCor(cor);
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public String getPlaca() {
        return placa;
    }

    public Cor getCor() {
        return cor;
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Carro carro = (Carro) o;
        return Objects.equals(motorista, carro.motorista) &&
                Objects.equals(placa, carro.placa) &&
                cor == carro.cor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(motorista, placa, cor);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "motorista=" + motorista +
                ", placa='" + placa + '\'' +
                ", cor=" + cor +
                '}';
    }

    public static CarroBuilder builder() {
        return new CarroBuilder();
    }

    public static class CarroBuilder {

        private Motorista motorista;

        private String placa;

        private Cor cor;

        private CarroBuilder() {
        }

        public CarroBuilder withMotorista(Motorista motorista) {
        		this.motorista = motorista;
        		return this;
        }
  
        public CarroBuilder withPlaca(String placa) {
        	this.placa = verificarCor(placa);
            return this;
        }

        public CarroBuilder withCor(Cor cor) {
        	this.cor = verificarCor(cor);
        	return this;
        }

        public Carro build() {
        	return new Carro(motorista, placa, cor);
        }
    }

    private static String verificarCor(String placa) {
    	if(placa == null || placa.isEmpty()) {
    		throw new NullPointerException("Carro de conter cor.");
    	}else {
    		return placa;
    	}
    }
    private static Cor verificarCor(Cor cor) {
    	if(cor == null) {
    		throw new NullPointerException("Carro de conter cor.");
    	}else {
    		return cor;
    	}
    }
 }