package classesDiagrama;

// Autoria: Nabila de Paula

//Classe que cria suas próprias classes de exceção para SenhaIncorreta derivando da classe Exception.

public class SenhaInvalidaException extends Exception {

	private static final long serialVersionUID = 5512072876249242883L;//o indentificador de versão de serialização da classe

	Conta senha;

	public SenhaInvalidaException() {//Implementação do construtor 
		super("Senha inválida: A senha deve possuir pelo menos 8 caracteres");
	}
}
