package classesDiagrama;

public class Funcionario extends PessoaFisica{
	protected static int geraid = 0;
	private String cargo;
	
	public Funcionario(String nome, Endereco endereco, String cpf, String cargo) throws CpfCnpjInvalidoException {
		super(nome, endereco, cpf);
		this.cargo = cargo;
		geraid++;
	}
	
	protected String gerarID() {
		return "Funcionário - " + super.getGeraid() + " - " + geraid;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getCargo() {
		return cargo;
	}

	public String toString() {
		return gerarID() + "\nNome: " + nome + "\nCPF: " + getCPF() + "\nCargo: " + cargo + "\nEndereço:\n" + getEndereco().toString();
	}
}
