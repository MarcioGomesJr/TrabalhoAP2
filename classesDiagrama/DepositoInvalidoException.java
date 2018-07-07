package classesDiagrama;

public class DepositoInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -472049880178893597L;
	

	public DepositoInvalidoException() {
				super ("Não é possível realizar o depósito.");
	}

}
