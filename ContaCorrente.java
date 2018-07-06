package classesDiagrama;

public class ContaCorrente extends Conta{
	private	double limite;
	Poupanca contaPoupanca;
	

	public ContaCorrente(Pessoa cliente, String senha) throws SenhaInvalidaException {
		contaPoupanca = new Poupanca(cliente, senha);
<<<<<<< HEAD
		geraNumero++;
		setNumero(geraNumero);
		setSaldo(0);
		setCliente(cliente);
		setSenha(senha);
=======
	}

	public void deposito(double valor) {
	}

	public void saque(double valor) {
		
>>>>>>> b50680996f58592eee15154432b4804f4a40d9cb
	}
	
	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public double getLimite() {
		return limite;
	}

<<<<<<< HEAD
	public String toString() {
		return contaPoupanca.toString() + "\nlimite: " + limite;
	}

	public void deposito(double valor, String senha) throws DepositoInvalidoException, SenhaIncorretaException {
		if(CriptografarSenha.criptografar(senha) == getSenha()){
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
		if(CriptografarSenha.criptografar(senha) == getSenha()) {
			if (valor <= getSaldo()+limite) {
				if(valor > 0) {
					setSaldo(getSaldo() - valor);
				}
				else {
					throw new SaqueInvalidoException();
				}
			}
		}
		else {
			throw new SenhaIncorretaException();
		}
	}
=======
	@Override
	public String toString() {
		return contaPoupanca.toString() + "\nlimite: " + limite;
	}
>>>>>>> b50680996f58592eee15154432b4804f4a40d9cb
	

}
