package classesDiagrama;

//Autoria: Nabila de Paula e Silva

//Classe que cria suas próprias classes de exceção para CpfCnpjInvalido derivando da classe Exception.

public class CpfCnpjInvalidoException extends Exception {

	private static final long serialVersionUID = -6319717677186635375L;//o indentificador de versão de serialização da classe

	public CpfCnpjInvalidoException() {//Implementação do construtor
		super("CPF/CNPJ inválido, tente novamente.");
	}

}
