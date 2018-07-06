package classesDiagrama;

public class ContaCorrente extends Conta{
	private	double limite;
	Poupanca contaPoupanca;
	

	public ContaCorrente(Pessoa cliente, String senha) throws SenhaInvalidaException {
		contaPoupanca = new Poupanca(cliente, senha);
	}

	public void deposito(double valor) {
	}

	public void saque(double valor) {
		
	}
	
	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	public double getLimite() {
		return limite;
	}

	@Override
	public String toString() {
		return contaPoupanca.toString() + "\nlimite: " + limite;
	}
	

}
