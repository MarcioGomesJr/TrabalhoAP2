package classesDiagrama;

public class ContaCorrente extends Conta{
	private	double limite;
	Poupanca contaPoupanca;
	

	public ContaCorrente(Pessoa cliente, String senha) throws SenhaInvalidaException {
		contaPoupanca = new Poupanca(cliente, senha);
		geraNumero++;
		setNumero(geraNumero);
		setSaldo(0);
		this.limite = 200.0;
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

	public void saque(double valor, String senha) throws SaqueInvalidoException, SenhaIncorretaException {
		if(CriptografarSenha.criptografar(senha).equals(getSenha())) {
			if (valor <= getSaldo() + limite) {
				if(valor > 0) {
					setSaldo(getSaldo() - valor);
			}
			else 
				throw new SaqueInvalidoException("Por favor, insira um valor positivo.");
		}
			else 
				throw new SaqueInvalidoException("Você estorou seu limite! O maior saque permitido para você no momento é de R$" + (getSaldo()+limite));
	}
		else {
			throw new SenhaIncorretaException();
		}
	}
}
