
public class Funcionario extends PessoaFisica{
	protected static int geraid = 0;
	private String cargo;
	
	public Funcionario(String nome, Endereco endereco, String cpf, String cargo) throws CpfCnpjInvalidoException {
		super(nome, endereco, cpf);
		this.cargo = cargo;
	}
	
	protected String gerarID() {
		return null;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getCargo() {
		return cargo;
	}

	public String toString() {
		return "\ncargo:" + cargo;
	}

	
	
	
}
