package classesDiagrama;

//Autoria: Nabila de Paula e Silva

//Classe que cria suas próprias classes de exceção para SaqueInvalido derivando da classe Exception.

public class SaqueInvalidoException extends Exception {

	private static final long serialVersionUID = -6289701344905162402L;//o indentificador de versão de serialização da classe

	public SaqueInvalidoException(String message) {
		super(message);
	}
}
