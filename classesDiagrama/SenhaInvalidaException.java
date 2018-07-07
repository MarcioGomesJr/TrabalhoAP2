package classesDiagrama;

// Autoria: MÃ¡rcio Gomes Borges JÃºnior (201703685)

public class SenhaInvalidaException extends Exception {
	
	private static final long serialVersionUID = 5512072876249242883L;
	
	Conta senha;
	
	public SenhaInvalidaException() {
		super("Senha inválida: A senha deve possuir pelo menos 8 caracteres");
	}
}
