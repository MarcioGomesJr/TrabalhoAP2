// Autoria: Márcio Gomes Borges Júnior (201703685)

public abstract class Pessoa {
	
	protected static int geraid = 0;
	protected String id;
	protected String nome;
	private Endereco endereco;	
	protected abstract String gerarID();

	protected String getId() {
		return id;
	}

	protected String getNome() {
		return nome;
	}

	private void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "id: " + id + ", nome=" + nome + ", endereco=" + endereco + "]";
	}
}
