package classesDiagrama;

// Autoria: Márcio Gomes Borges Júnior (201703685)

public class CepInvalidoException extends Exception {

	private static final long serialVersionUID = 1485858548226971469L;

	public CepInvalidoException() {
		super("CEP inv�lido, digite novamente");
	}


}
