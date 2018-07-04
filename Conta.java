// Autoria: Márcio Gomes Borges Júnior (201703685)


public abstract class Conta{
	
	protected int geraNumero = 0;
	private int numero;
	private double saldo = 0;
	private Pessoa cliente;
	private String senha;
	
	
	public Conta(int geraNumero, int numero, double saldo, Pessoa cliente, String senha) throws SenhaInvalidaException {
		this.geraNumero = geraNumero;
		this.numero = numero;
		this.saldo = saldo;
		this.cliente = cliente;
		setSenha(senha);
	}

	protected int geraNumero() {
		return geraNumero;
	}

	private double getSaldo() {
		return saldo;
	}
	
	public abstract void deposito(double valor);

	private Pessoa getCliente(){
		return cliente;
	}
	
	private void setSenha(String senha) throws SenhaInvalidaException{
		if(VerificaSenha(senha)) {
			this.senha = senha;
		}
		else {
			throw new SenhaInvalidaException();
		}
	}
	
	public String getSenha(){
		return senha;
	}
	
	private boolean VerificaSenha(String Senha) {
		if (senha.length()>8) {
			return false;
		}
		else if(senha.length()<8) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public abstract void saque(double valor);

}
