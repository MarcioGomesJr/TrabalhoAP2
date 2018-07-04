
public class ContaCorrente extends Conta{
	private	double limite;
	Poupanca contaPoupanca;
	

	public ContaCorrente(Pessoa cliente) {
		super(geraNumero, geraNumero, limite, cliente, senha);
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
	

}
