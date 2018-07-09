package classesDiagrama;

//Autoria: Nabila de Paula e Silva

//Classe que cria suas pr�prias classes de exce��o para DepositoInvalido derivando da classe Exception.

	public class DepositoInvalidoException extends Exception {// encerra o nome de classe de exce��o definida com a palavra "Exception

	private static final long serialVersionUID = -472049880178893597L;//o indentificador de vers�o de serializa��o da classe

	public DepositoInvalidoException() {//Implementa��o do construtor
		super("Não é possível realizar o depósito.");
	}

}
