
public class PessoaJuridica extends Pessoa {
	protected static int geraID = 0;
	private String cnpj;
	
	public PessoaJuridica(String nome, Endereco endereco, String cnpj) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		//this.endereco = endereco;
	}

	protected String gerarID() {
		return null;
	}
	
	private boolean verificaCNPJ(String cnpj) {        
		return cnpj.matches("\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}");
	}
	
	protected void setCNPJ(String cnpj) throws CpfCnpjInvalidoException{
		if(verificaCNPJ(cnpj)) {
			this.cnpj = cnpj;
		}
		else {
			throw new CpfCnpjInvalidoException();
		}
	}
	
	public String getCNPJ() {
		return cnpj;
	}

	public String toString() {
		return "\ncnpj:" + cnpj;
	}
	
	
	
	
}
