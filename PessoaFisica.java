
public class PessoaFisica extends Pessoa {
	protected static int geraid = 0;
	private String cpf;
	
	public PessoaFisica(String nome, Endereco endereco, String cpf) throws CpfCnpjInvalidoException {
		super();
		this.nome = nome;
		//this.endereco = endereco;
		setCPF(cpf);
	}

	protected String gerarID() { 
		return null;
	}
	
	private boolean verificaCPF(String cpf) {        
		return cpf.matches("\\d{3}.\\d{3}.\\d{3}-d{2}");
	}
	
	protected void setCPF(String cpf) throws CpfCnpjInvalidoException{
		if(verificaCPF(cpf)) {
			this.cpf = cpf;
		}
		else {
			throw new CpfCnpjInvalidoException();
		}
	}
	
	public String getCPF() {
		return cpf;
	}

	public String toString() {
		return "PessoaFisica [cpf=" + cpf + "]";
	}

}
