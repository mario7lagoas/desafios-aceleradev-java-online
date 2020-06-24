package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
	
	private static final int LIMITE_VAGAS = 10 ;
	private static final int MAIOR_IDADE = 18 ;
	private static final int MAX_PONTOS = 20 ;
	private static final int MELHOR_IDADE = 55 ;
	
	List<Carro> carros = new ArrayList<>();

	public void estacionar(Carro carro) {
    	if (validarCarro(carro))
    		carros.add(carro);
    }

    public int carrosEstacionados() {
        return carros.size();
    }

    public boolean carroEstacionado(Carro carro) {
    	return carros.contains(carro);
    }
    
    public boolean validarCarro(Carro carro) {
    	if (carro == null || carro.getMotorista() == null || carro.getPlaca()== null 
    			|| carro.getCor() == null ) {
    		throw new EstacionamentoException("Falta de campos Obrigatorios.");
    	}else if(carro.getMotorista().getIdade() < MAIOR_IDADE || carro.getMotorista().getPontos() > MAX_PONTOS) {
    		throw new EstacionamentoException("Motorista não Permitido.");
    	}
    	if(carros.size() >= LIMITE_VAGAS ) {
    		carros.remove(carros.stream()
    				.filter(filter1 -> filter1.getMotorista().getIdade() < MELHOR_IDADE)
    				.findFirst()
    				.orElseThrow(() -> new EstacionamentoException("Sem vagas disponivel."))
    				);
    	}
    	return true;
    }
}
