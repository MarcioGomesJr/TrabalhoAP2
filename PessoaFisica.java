package classesDiagrama;

public class PessoaFisica extends Pessoa {
	protected static int geraid = 0;
	private String cpf;
	
	public PessoaFisica(String nome, Endereco endereco, String cpf) throws CpfCnpjInvalidoException {
		this.nome = nome;
		atribuirEndereco(endereco);
		geraid++;
		id = String.valueOf(geraid);
		setCPF(cpf);
	}

	protected String gerarID() { 
<<<<<<< HEAD
		return "Pessoa Fï¿½sica - " + super.getGeraid() + " - " + geraid;
	}
	
	public static boolean verificaCPF(String cpf) {        
=======
		return "Pessoa Física - " + super.getGeraid() + " - " + geraid;
	}
	
	private boolean verificaCPF(String cpf) {        
>>>>>>> b50680996f58592eee15154432b4804f4a40d9cb
		return cpf.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}");
	}
	
	protected void setCPF(String cpf) throws CpfCnpjInvalidoException{
		if(verificaCPF(cpf)) {
			this.cpf = cpf;
		}
		else {
			throw new CpfCnpjInvalidoException();
		}
	}
	
	protected int getGeraid() {
		return geraid;
	}
	
	public String getCPF() {
		return cpf;
	}

	public String toString() {
		return gerarID() + "\nNome: " + nome + "\nCPF: " + cpf + "\nEndereco:\n" + getEndereco().toString();
	}

}
