package classesDiagrama;

// Autoria: MÃ¡rcio Gomes Borges JÃºnior (201703685)


public abstract class Conta{
	
	protected static int geraNumero = 0;
	private int numero;
	private double saldo;
	private Pessoa cliente;
	private String senha;

	protected static int geraNumero() {
		return geraNumero;
	}
	
	public String getTipo() {
		return "Não especificado";
	}

	public double getSaldo() {
		return saldo;
	}
	
	public abstract void deposito(double valor, String senha) throws DepositoInvalidoException, SenhaIncorretaException;
	
	public abstract void saque(double valor, String senha) throws SaqueInvalidoException, SenhaIncorretaException;

	public Pessoa getCliente(){
		return cliente;
	}
	
	protected void setSenha(String senha) throws SenhaInvalidaException{
		if(VerificaSenha(senha)) {
			this.senha = CriptografarSenha.criptografar(senha);
		}
		else {
			throw new SenhaInvalidaException();
		}
	}
	
	public String getSenha(){
		return senha;
	}
	
	public int getNumero() {
		return numero;
	}
	
	protected void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	
	protected void setNumero(int numero) {
		this.numero = numero;
	}
	
	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	private boolean VerificaSenha(String senha) {
		if(senha.length()<8) {
			return false;
		}
		else {
			return true;
		}
	}
}
