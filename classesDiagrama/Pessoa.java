package classesDiagrama;

// Autoria: Márcio Gomes Borges Júnior (201703685)

//Classe que cria, armazena e mostra como mensagem dados do cadastro da pessoa

public abstract class Pessoa {
	
	protected static int geraid = 0;
	protected String id;
	protected String nome;
	private Endereco endereco;
	
	protected abstract String gerarID();//Metodo gerador do numero de id
	
	public Pessoa() {
		geraid++;//Incrementação de geraid( +1)
		id = String.valueOf(geraid);//Retorna uma representação em fommato String 
	}
	
	protected int getGeraid() {//Retorna o valor da variavel Gerarid
		return geraid;
	}
	
	public String getCPF() {
		return "";
	}
	
	public String getCNPJ() {
		return "";
	}

	protected String getId(){ //Retorna o valor da variavel Id
		return id;
	}

	protected Endereco getEndereco() {//Retorna o valor da variavel Endereço
		return endereco;
	}
	
	protected String getNome() {//Retorna o valor da variavel Nome
		return nome;
	}

	private void setEndereco(Endereco endereco) {//Altera o valor da variavel endereço pelo que foi passado pelo parametro
		this.endereco = endereco;
	}
	
	protected void atribuirEndereco(Endereco endereco) {
		setEndereco(endereco);
	}

	public String toString() {//Mensagem que mostra em forma de lista os dados da pessoa cadastrada
		return "Id: " + id + "\nNome: " + nome + "\nEndereço:\n" + endereco.toString();//Endereço atribuido
	}
}
