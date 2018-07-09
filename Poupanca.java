package classesDiagrama;

public class Poupanca extends Conta{
    
    //Classe que cria as possibilidades para saque e deposito em conta poupança
	
	public Poupanca(Pessoa cliente, String senha) throws SenhaInvalidaException {
		geraNumero++;//gera numero, smpre incrementando +1
		setNumero(geraNumero);
		setSaldo(0);
		setCliente(cliente);
		setSenha(senha);
	}

	public void deposito(double valor, String senha) throws DepositoInvalidoException, SenhaIncorretaException {//declaração do metodo
            // qualquer método que chame deposito deve obrigatoriamente tratar as exceções DepositoInvalidoException, SenhaIncorretaException com um try
            //um trecho de código que chame este método deve obrigatoriamente capturar as possíveis exceções que ele lance.
		if(CriptografarSenha.criptografar(senha).equals(getSenha())){  //Comparando os objetos 
			if(valor >0) {
				setSaldo(getSaldo()+valor); 
			}
			else {
				throw new DepositoInvalidoException();//lança uma exceção mas não exige que ela seja tratada por seus chamadores
			}
		}
		else {
			throw new SenhaIncorretaException(); //lança uma exceção mas não exige que ela seja tratada por seus chamadores
		}
	}

	public void saque(double valor, String senha) throws SaqueInvalidoException, SenhaIncorretaException {
		if(CriptografarSenha.criptografar(senha).equals(getSenha())) {//Comparando os objetos
			if (valor <= getSaldo()) {
				if(valor > 0) {
					setSaldo(getSaldo() - valor);
			}
			else 
				throw new SaqueInvalidoException("Por favor, insira um valor positivo.");//lança uma exceção mas não exige que ela seja tratada por seus chamadores
		}
			else 
				throw new SaqueInvalidoException("Você estorou seu limite! O maior saque permitido para você no momento é de R$" + getSaldo());
	}
		else {
			throw new SenhaIncorretaException();//lança uma exceção mas não exige que ela seja tratada por seus chamadores
		}
	}
}
