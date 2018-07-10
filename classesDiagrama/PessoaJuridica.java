package classesDiagrama;

//Autor: Nabila de Paula e Silva
//Classe que cria pessoas juridicas

public class PessoaJuridica extends Pessoa {
	protected static int geraID = 0;
	private String cnpj;
	
        //Chamada de metodo que captura a exceção
	public PessoaJuridica(String nome, Endereco endereco, String cnpj) throws CpfCnpjInvalidoException {
		super();
		this.nome = nome;
		atribuirEndereco(endereco);
		geraid++;//Incrementação do valor geraid a cada pessoa juridica criada
		id = String.valueOf(geraid);//checagem de parametro
		setCNPJ(cnpj);
	}

	protected String gerarID() {
		return "Pessoa Jurídica - " + super.getGeraid() + " - " + geraid;
	}
	
	public static boolean verificaCNPJ(String cnpj) {        
		return cnpj.matches("\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}");//formatando a estrutura dos numeros do cnpj
	}
	//chamada de metodo que captura a exceção
	protected void setCNPJ(String cnpj) throws CpfCnpjInvalidoException{
		if(verificaCNPJ(cnpj)) {//verificação de validade de CPF/CNPJ
			this.cnpj = cnpj;
		}
		else {
			throw new CpfCnpjInvalidoException();
		}
	}
	
	public String getCNPJ() {//Retorno do valor cnpj, ja depois de verificado
		return cnpj;
	}

	public String toString() {//Mensagem que mostra valores que foram inseridos para cirar nova pessoa juridica
		return gerarID() + "\nNome: " + nome + "\nCNPJ: " + cnpj + "\nEndereço:\n" + getEndereco().toString();
	}	
}
