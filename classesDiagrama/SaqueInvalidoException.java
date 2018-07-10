package classesDiagrama;

//Autoria: Nabila de Paula e Silva

//Classe que cria suas pr�prias classes de exce��o para SaqueInvalido derivando da classe Exception.

public class SaqueInvalidoException extends Exception {

	private static final long serialVersionUID = -6289701344905162402L;//o indentificador de vers�o de serializa��o da classe

	public SaqueInvalidoException(String message) {
		super(message);
	}
}
