package classesDiagrama;

//Autoria: Márcio Gomes Borges Júnior (201703685)

//Classe que cria suas próprias classes de exceção para CepInvalido derivando da classe Exception.
public class CepInvalidoException extends Exception {

	private static final long serialVersionUID = 1485858548226971469L;//o indentificador de versão de serialização da classe

	public CepInvalidoException() {//Implementação do construtor
		super("CEP inválido, digite novamente");
	}

}
