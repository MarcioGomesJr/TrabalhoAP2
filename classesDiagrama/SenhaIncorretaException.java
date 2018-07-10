package classesDiagrama;

//Autoria: Nabila de Paula e Silva

//Classe que cria suas próprias classes de exceção para SenhaIncorreta derivando da classe Exception.

public class SenhaIncorretaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6286606027395238573L;//o indentificador de versão de serialização da classe

	public SenhaIncorretaException() {//Implementação do construtor
		super("Senha incorreta, tente novamente");
	}

}
