package gui;

import javax.swing.JOptionPane;

import classesDiagrama.ContaCorrente;
import classesDiagrama.DepositoInvalidoException;
import classesDiagrama.Pessoa;
import classesDiagrama.Poupanca;
import classesDiagrama.SaqueInvalidoException;
import classesDiagrama.SenhaIncorretaException;

public class Operacoes {

	//Se o booleano saque for verdadeiro, é um saque, se for falso, é um deposito
	public static void correntePessoaFisica(String cpf, String senha, double valor, boolean saque) {
	
		boolean contaExiste = false;
		
			for(ContaCorrente c : BancoDeDados.contasCorrente){
				Pessoa cliente = c.getCliente();
				if(cliente.getCPF().equals(cpf)){
					try {
						contaExiste = true;
						if(saque)
							c.saque(valor, senha);
						else
							c.deposito(valor, senha);
						JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!\nSeu saldo atual: R$" + c.getSaldo());
						} catch (DepositoInvalidoException | SenhaIncorretaException | SaqueInvalidoException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						} catch (NumberFormatException  e1) {
							JOptionPane.showMessageDialog(null, "Por favor digite um número em \"Valor\"");
						}	
					}	
		}
			if(!contaExiste)
				JOptionPane.showMessageDialog(null, "Esse CPF/CNPJ não existe em nosso banco de dados!\nPor favor, crie uma conta antes de realizar operações.");
	}
	
	public static void correntePessoaJuridica(String cnpj, String senha, double valor, boolean saque) {
		
		boolean contaExiste = false;
		
		for(ContaCorrente c : BancoDeDados.contasCorrente){
			Pessoa cliente = c.getCliente();
			if(cliente.getCNPJ().equals(cnpj)){
				try {
					contaExiste = true;
					if(saque)
						c.saque(valor, senha);
					else
						c.deposito(valor, senha);
					JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!\nSeu saldo atual: R$" + c.getSaldo());
					} catch (DepositoInvalidoException | SenhaIncorretaException | SaqueInvalidoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (NumberFormatException  e1) {
						JOptionPane.showMessageDialog(null, "Por favor digite um número em \"Valor\"");
					}	
				}	
		}
		if(!contaExiste)
			JOptionPane.showMessageDialog(null, "Esse CPF/CNPJ não existe em nosso banco de dados!\nPor favor, crie uma conta antes de realizar operações.");
	}
	
	public static void poupancaPessoaFisica(String cpf, String senha, double valor, boolean saque) {
		
		boolean contaExiste = false;
		
		for(Poupanca c : BancoDeDados.poupancas){
			Pessoa cliente = c.getCliente();
			if(cliente.getCPF().equals(cpf)){
				try {
					contaExiste = true;
					if(saque)
						c.saque(valor, senha);
					else
						c.deposito(valor, senha);
					JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!\nSeu saldo atual: R$" + c.getSaldo());
					} catch (DepositoInvalidoException | SenhaIncorretaException | SaqueInvalidoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (NumberFormatException  e1) {
						JOptionPane.showMessageDialog(null, "Por favor digite um número em \"Valor\"");
					}	
				}		
		}
		if(!contaExiste)
			JOptionPane.showMessageDialog(null, "Esse CPF/CNPJ não existe em nosso banco de dados!\nPor favor, crie uma conta antes de realizar operações.");
	}
	
	public static void poupancaPessoaJuridica(String cnpj, String senha, double valor, boolean saque) {
		
		boolean contaExiste = false;
		
		for(Poupanca c : BancoDeDados.poupancas){
			Pessoa cliente = c.getCliente();
			if(cliente.getCNPJ().equals(cnpj)){
				try {
					contaExiste = true;
					if(saque)
						c.saque(valor, senha);
					else
						c.deposito(valor, senha);
					JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!\nSeu saldo atual: R$" + c.getSaldo());
					} catch (DepositoInvalidoException | SenhaIncorretaException | SaqueInvalidoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (NumberFormatException  e1) {
						JOptionPane.showMessageDialog(null, "Por favor digite um número em \"Valor\"");
					}	
				}		
		}
		if(!contaExiste)
			JOptionPane.showMessageDialog(null, "Esse CPF/CNPJ não existe em nosso banco de dados!\nPor favor, crie uma conta antes de realizar operações.");
	}
}
