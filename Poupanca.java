package classesDiagrama;


public class Poupanca extends Conta{
	
	public Poupanca(Pessoa cliente, String senha) throws SenhaInvalidaException {
		geraNumero++;
		setNumero(geraNumero);
		setSaldo(0);
		setCliente(cliente);
		setSenha(senha);
	}


	public void deposito(double valor) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public String toString() {
		return "numero: " + getNumero() + "\nsaldo: " + getSaldo() + "\ncliente: " + getCliente() + "\nsenha: " + getSenha();
	}


	public void saque(double valor) {
		// TODO Auto-generated method stub
		
	}

}
