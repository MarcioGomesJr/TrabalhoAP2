package classesDiagrama;

//Autor: Márcio Júnior
//Classe que cria funcionarios

public class Funcionario extends PessoaFisica{
	protected static int geraid = 0;
	private String cargo;
	
	public Funcionario(String nome, Endereco endereco, String cpf, String cargo) throws CpfCnpjInvalidoException {//Lança a exceção de cpf e cnpj invalidos
		super(nome, endereco, cpf);//Faz referencia a atributos da super classe 
		this.cargo = cargo;// atributo de instancia "cargo" vai receber o valor do paramentro "cargo"
		geraid++;//incrementa o geraid em +1
	}
	
	protected String gerarID() {//método gerarID: "<tipo do objeto> - <geraid"
		return "Funcionário  " + super.getGeraid() + " - " + geraid;
	}
	
	public void setCargo(String cargo) {//Altera o valor da variavel cargo pelo que foi passado pelo parametro
		this.cargo = cargo;
	}
	
	public String getCargo() {//Retorna o valor na variavel Cargo
		return cargo;
	}

	public String toString() {//Mensagem que mistra em formato de lista os dados do funcionario
		return gerarID() + "\nNome: " + nome + "\nCPF: " + getCPF() + "\nCargo: " + cargo + "\nEndereço: \n" + getEndereco().toString();
	}
}
