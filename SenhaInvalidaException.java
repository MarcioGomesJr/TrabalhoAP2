// Autoria: Márcio Gomes Borges Júnior (201703685)

public class SenhaInvalidaException extends Exception {
	Conta senha;
	
	public SenhaInvalidaException() {
		super("Senha inválida: A senha deve possuir 8 caracteres");
	}

	

}
