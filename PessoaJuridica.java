package classesDiagrama;

public class PessoaJuridica extends Pessoa {
	protected static int geraID = 0;
	private String cnpj;
	
	public PessoaJuridica(String nome, Endereco endereco, String cnpj) throws CpfCnpjInvalidoException {
		super();
		this.nome = nome;
		atribuirEndereco(endereco);
		geraid++;
		id = String.valueOf(geraid);
		setCNPJ(cnpj);
	}

	protected String gerarID() {
<<<<<<< HEAD
		return "Pessoa Jur�dica - " + super.getGeraid() + " - " + geraid;
=======
		return "Pessoa Jur�dica - " + super.getGeraid() + " - " + geraid;
>>>>>>> b50680996f58592eee15154432b4804f4a40d9cb
	}
	
	public static boolean verificaCNPJ(String cnpj) {        
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
		return gerarID() + "\nNome: " + nome + "\nCNPJ: " + cnpj + "\nEndereco:\n" + getEndereco().toString();
	}
	
	
	
	
}
