package challenge;

public class CriptografiaCesariana implements Criptografia {
	String textoMin;
	private static final int salto = 3;	

    @Override
    public String criptografar(String texto) {
    	if(texto == null) {
    		throw new NullPointerException("Texto nulo.");
		}else if (texto.isEmpty()) {
			throw new IllegalArgumentException("Texto vazio.");
		}else
			this.textoMin = texto.toLowerCase();
		 
    	return cry(textoMin ,0);
    }

    @Override
    public String descriptografar(String texto) {
		 if(texto == null) {
			  throw new NullPointerException("Texto nulo.");
		 }else if (texto.isEmpty()) {
			  throw new IllegalArgumentException("Texto vazio.");
		 }else
			  this.textoMin = texto.toLowerCase();
		 
		 return cry(textoMin ,1);    
    }
	
    public String cry (String texto , int type) {
		String result = "";  
		for (int i= 0;i < texto.length() ;i++) {
			char c = texto.charAt(i);
			result = result + getAlpha(Character.toString(c), type);
		}
		return result;
	}
	
	public String getAlpha(String letra, int type) {
		String tabela[] = new String [] {"a","b","c","d","e","f","g","h","i","j","k",
				"l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		int ctrl = 25 - salto;

		for (int i = 0; i < tabela.length ; i++) {
			if (letra.equals(tabela[i])) {
				if (type == 1 ) {
					int swap = i - salto;
					if (i < ctrl) {
						int total = i - salto;
						int mod = total + 26;
						if ( mod > 25 ) {
							mod = mod - 26;
						}
						return  tabela[mod]; 
					}else {
						return tabela[swap];
					}
				}else {
					int swap = i + salto;
					if ( i > ctrl) {
						int total = i - salto;
						int mod = (total % 26);
						return  tabela[mod];
					}else {
						return tabela[swap];
					}
				}
			}
		}
		return letra;
	}

}
