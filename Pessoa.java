package classesDiagrama;

// Autoria: Márcio Gomes Borges Júnior (201703685)

public abstract class Pessoa {
	
	protected static int geraid = 0;
	protected String id;
	protected String nome;
	private Endereco endereco;
	
	protected abstract String gerarID();
	
	public Pessoa() {
		geraid++;
		id = String.valueOf(geraid);
	}
	
	protected int getGeraid() {
		return geraid;
	}

	protected String getId() {
		return id;
	}

	protected Endereco getEndereco() {
		return endereco;
	}
	
	protected String getNome() {
		return nome;
	}

	private void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	protected void atribuirEndereco(Endereco endereco) {
		setEndereco(endereco);
	}

	public String toString() {
		return "Id: " + id + "\nNome: " + nome + "\nEndereco:\n" + endereco.toString();
	}
}
