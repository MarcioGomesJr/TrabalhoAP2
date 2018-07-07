package classesDiagrama;

public class Poupanca extends Conta{
	
	public Poupanca(Pessoa cliente, String senha) throws SenhaInvalidaException {
		geraNumero++;
		setNumero(geraNumero);
		setSaldo(0);
		setCliente(cliente);
		setSenha(senha);
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
			if (valor < getSaldo()) {
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
	
	@Override
	public String toString() {
		return "numero: " + getNumero() + "\nsaldo: " + getSaldo() + "\ncliente: " + getCliente() + "\nsenha: " + getSenha();
	}
}
