package classesDiagrama;

//Autoria: Nabila de Paula e Silva

//Classe que cria suas pr�prias classes de exce��o para SenhaIncorreta derivando da classe Exception.

public class SenhaIncorretaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6286606027395238573L;//o indentificador de vers�o de serializa��o da classe

	public SenhaIncorretaException() {//Implementa��o do construtor
		super("Senha incorreta, tente novamente");
	}

}
