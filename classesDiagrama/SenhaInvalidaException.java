package classesDiagrama;

// Autoria: Nabila de Paula

//Classe que cria suas pr�prias classes de exce��o para SenhaIncorreta derivando da classe Exception.

 public class SenhaInvalidaException extends Exception {

	private static final long serialVersionUID = 5512072876249242883L;//o indentificador de vers�o de serializa��o da classe

	Conta senha;

	public SenhaInvalidaException() {//Implementa��o do construtor 
		super("Senha inv�lida: A senha deve possuir pelo menos 8 caracteres");
	}
}
