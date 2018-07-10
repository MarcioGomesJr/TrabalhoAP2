package classesDiagrama;

//Autor: Nabila de Paula
//Classe que cria novas contas correntes

public class ContaCorrente extends Conta{
	private	double limite;
	Poupanca contaPoupanca;
	
        //trecho de código que chama o método ContaCorrente deve capturar a exceção SenhaInvalida que ele lança
	public ContaCorrente(Pessoa cliente, String senha) throws SenhaInvalidaException {
		contaPoupanca = new Poupanca(cliente, senha);
		geraNumero++;
		setNumero(geraNumero);//Incrementa o numero a cada conta corrente criada
		setSaldo(0);//Estabelece valor inicial saldo em zero
		this.limite = 200.0;//Estabelece valor limite 
		setCliente(cliente);
		setSenha(senha);
	}
	
	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public Poupanca getPoupanca() {
		return contaPoupanca;
	}
	
	public double getLimite() {
		return limite;
	}

	public String toString() {
		return super.toString() + "\nLimite: R$" + limite;
	}
        //um trecho de código que chama o método deposito deve capturar as exceção que ele lança
	public void deposito(double valor, String senha) throws DepositoInvalidoException, SenhaIncorretaException {
		if(CriptografarSenha.criptografar(senha).equals(getSenha())){
			if(valor >0) {
				setSaldo(getSaldo()+valor); 
			}
			else {
				throw new DepositoInvalidoException();
			}
		}
		else {
			throw new SenhaIncorretaException(); 
		}
	}
        //um trecho de código que chama o método saque deve capturar as exceções que ele lança
	public void saque(double valor, String senha) throws SaqueInvalidoException, SenhaIncorretaException {
		if(CriptografarSenha.criptografar(senha).equals(getSenha())) {//igualando os objetos para verificar se senha corresponde
			//Se iguais, realiza saque 
                        if (valor <= getSaldo() + limite) {
				if(valor > 0) {
					setSaldo(getSaldo() - valor);
			}
			else //lançando exceção para valor negatigo
				throw new SaqueInvalidoException("Por favor, insira um valor positivo.");
		}
			else //lançando exceção para valor > saldo + limite
				throw new SaqueInvalidoException("Você estorou seu limite! O maior saque permitido para você no momento é de R$" + (getSaldo()+limite));
	}
                //Se diferentes
		else {
			throw new SenhaIncorretaException();
		}
	}
}
