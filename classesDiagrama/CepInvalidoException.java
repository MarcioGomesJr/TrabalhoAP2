package classesDiagrama;

//Autoria: M�rcio Gomes Borges J�nior (201703685)

//Classe que cria suas pr�prias classes de exce��o para CepInvalido derivando da classe Exception.
public class CepInvalidoException extends Exception {

	private static final long serialVersionUID = 1485858548226971469L;//o indentificador de vers�o de serializa��o da classe

	public CepInvalidoException() {//Implementa��o do construtor
		super("CEP inv�lido, digite novamente");
	}

}
