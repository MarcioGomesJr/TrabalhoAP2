package classesDiagrama;

//Autor: Nabila de Paula
//Classe criada para criar pessoas físicas

public class PessoaFisica extends Pessoa {
	protected static int geraid = 0;
	private String cpf;
	
        //chama o metodo PessoaFisica que deve capturar a exceção CpfCnpjInvalida que ele lança
	public PessoaFisica(String nome, Endereco endereco, String cpf) throws CpfCnpjInvalidoException {
		this.nome = nome;
		atribuirEndereco(endereco);
		geraid++;//Incrementaçao em geraid a cada cadastro de pessoa fisica feito
		id = String.valueOf(geraid);//Checagem de parametro, se é nulo ou nao
		setCPF(cpf);//metodo q define valor
	}
	
	protected String gerarID () {        
		return "Pessoa Física - " + super.getGeraid() + " - " + geraid;
	}
	
	public static boolean verificaCPF(String cpf) {
		return cpf.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}");//formatação dos numeros do cpf
	}
	
	protected void setCPF(String cpf) throws CpfCnpjInvalidoException{//Método que captura a exceção
		if(verificaCPF(cpf)) {
			this.cpf = cpf;
		}
		else {//lança a exceção
			throw new CpfCnpjInvalidoException();
		}
	}
	
	protected int getGeraid() {
		return geraid;
	}
	
	public String getCPF() {
		return cpf;
	}

	public String toString() {//Mensagem mostrando os dados inseridos
		return gerarID() + "\nNome: " + nome + "\nCPF: " + cpf + "\nEndereço:\n" + getEndereco().toString();
	}
}
