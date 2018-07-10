package classesDiagrama;

//Autoria: Nabila de Paula e Silva

//Classe que cria suas pr�prias classes de exce��o para CpfCnpjInvalido derivando da classe Exception.

public class CpfCnpjInvalidoException extends Exception {

	private static final long serialVersionUID = -6319717677186635375L;//o indentificador de vers�o de serializa��o da classe

	public CpfCnpjInvalidoException() {//Implementa��o do construtor
		super("CPF/CNPJ inv�lido, tente novamente.");
	}

}
