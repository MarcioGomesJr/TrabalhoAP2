package classesDiagrama;

public class SenhaIncorretaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6286606027395238573L;

	public SenhaIncorretaException() {
		super("Senha incorreta, tente novamente");
		}

}
