package classesDiagrama;

//Autoria: Nabila de Paula e Silva

//Classe que cria suas próprias classes de exceção para DepositoInvalido derivando da classe Exception.

	public class DepositoInvalidoException extends Exception {// encerra o nome de classe de exceção definida com a palavra "Exception

	private static final long serialVersionUID = -472049880178893597L;//o indentificador de versão de serialização da classe

	public DepositoInvalidoException() {//Implementação do construtor
		super("NÃ£o Ã© possÃ­vel realizar o depÃ³sito.");
	}

}
