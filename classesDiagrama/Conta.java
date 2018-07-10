package classesDiagrama;

// Autoria: Márcio Gomes Borges Junior (201703685)

//Classe que cria as contas

public abstract class Conta{
	
	protected static int geraNumero = 0;//numero da conta
	private int numero;
	private double saldo;
	private Pessoa cliente;
	private String senha;

	protected static int geraNumero() {
		return geraNumero;
	}
	
	public String getTipo() {
		return "Não especificado";
	}

	public double getSaldo() {//método para acesso e retorno de valor de saldo
		return saldo;
	}
	//A assinatura do método diz que pode lançar 2 exceções, de deposito invalido e senha incorreta
	public abstract void deposito(double valor, String senha) throws DepositoInvalidoException, SenhaIncorretaException;
	//A assinatura do método diz que pode lançar 2 exceções, de saqueinvalido e senha incorreta
	public abstract void saque(double valor, String senha) throws SaqueInvalidoException, SenhaIncorretaException;

	public Pessoa getCliente(){//método para acesso e retorno de valor de cliente
		return cliente;
	}
	
	protected void setSenha(String senha) throws SenhaInvalidaException{//lança a exceção SenhaInvalidaException mas o método nao trata
		if(VerificaSenha(senha)) {
			this.senha = CriptografarSenha.criptografar(senha);//invocação do metodo por meio do objeto
		}
		else {
			throw new SenhaInvalidaException();//lançar a exceção de senha invalida de dentro do corpo do método
		}
	}
	
	public String getSenha(){//método para acesso e retorno de valor de senha
		return senha;
	}
	
	public int getNumero() {//acessa o atributo numero da classe e retorna o valor
		return numero;
	}
	
	protected void setCliente(Pessoa cliente) {// Modifica o valor do atributo cliente. Nao tem retorno.
		this.cliente = cliente;
	}
	
	protected void setNumero(int numero) {//Modifica o valor do atributo, que recebe o novo valor como parâmetro.
		this.numero = numero;
	}
	
	protected void setSaldo(double saldo) {// Modifica o valor do atributo saldo
		this.saldo = saldo;
	}
	
	private boolean VerificaSenha(String senha) {//Verificaçaõ da validação senha. valida se tamanho senha > 8
		if(senha.length()<8) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public String toString() {//Imprime a mensagem contendo todo o conteudo registrado na classe conta
		return "Número: " + getNumero() + "\nSaldo: R$" + getSaldo() + "\nCliente: " + getCliente();
	}
}
