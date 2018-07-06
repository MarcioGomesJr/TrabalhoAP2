package classesDiagrama;

public class CpfCnpjInvalidoException extends Exception {

	private static final long serialVersionUID = -6319717677186635375L;

	public CpfCnpjInvalidoException() {
		super("CPF/CNPJ inválido, tente novamente.");
	}

}
