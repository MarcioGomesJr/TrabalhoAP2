package gui;

import javax.swing.JOptionPane;

import classesDiagrama.ContaCorrente;
import classesDiagrama.DepositoInvalidoException;
import classesDiagrama.Pessoa;
import classesDiagrama.Poupanca;
import classesDiagrama.SaqueInvalidoException;
import classesDiagrama.SenhaIncorretaException;

//Classe que valida as condições de operações no caixa eletronico 
//Autor: Eduardo Silvestre

public class Operacoes {
        //Validação operaçoes de conta corrente para PessoaFisica
    
	//Se o booleano saque for verdadeiro, é um saque, se for falso, é um deposito
	public static void correntePessoaFisica(String cpf, String senha, double valor, boolean saque) {
	        //Validação operaçoes para PessoaFisica
		boolean contaExiste = false;
		//busca no banco de dados de pessoas que tem conta corrente  por uma pessoa com o CPF fornecido. 
			for(ContaCorrente c : BancoDeDados.contasCorrente){
				Pessoa cliente = c.getCliente();
				if(cliente.getCPF().equals(cpf)){//Comparando os objetos
                                    //Se achar, ele então faz uma operação de saque ou depósito na conta encontrada
					try {//Lança a exceção
						contaExiste = true;
						if(saque)
							c.saque(valor, senha);
						else//deposito
							c.deposito(valor, senha);
						JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!\nSeu saldo atual: R$" + c.getSaldo());
						} catch (DepositoInvalidoException | SenhaIncorretaException | SaqueInvalidoException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						} catch (NumberFormatException  e1) {
							JOptionPane.showMessageDialog(null, "Por favor digite um número em \"Valor\"");
						}	
					}	
		}
			if(!contaExiste)//contaExiste = falso
				JOptionPane.showMessageDialog(null, "Esse CPF/CNPJ não existe em nosso banco de dados!\nPor favor, crie uma conta antes de realizar operações.");
        }
        
	//Validação operaçoes de conta corrente para PessoaJuridica
        
	public static void correntePessoaJuridica(String cnpj, String senha, double valor, boolean saque) {
		
		boolean contaExiste = false;
		//busca no banco de dados de pessoas que tem conta corrente  por uma pessoa com o CNPJ fornecido. 
		for(ContaCorrente c : BancoDeDados.contasCorrente){
			Pessoa cliente = c.getCliente();
			if(cliente.getCNPJ().equals(cnpj)){//Comparando os objetos
                         //Se achar, ele então faz uma operação de saque ou depósito na conta encontrada
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
		if(!contaExiste)//Caso nao ache
			JOptionPane.showMessageDialog(null, "Esse CPF/CNPJ não existe em nosso banco de dados!\nPor favor, crie uma conta antes de realizar operações.");
	}
	//Validação operaçoes de conta poupança para PessoaFisica
	public static void poupancaPessoaFisica(String cpf, String senha, double valor, boolean saque) {
		
		boolean contaExiste = false;
		//busca no banco de dados de pessoas que tem conta poupança por uma pessoa com o CPFfornecido. 		
		for(Poupanca c : BancoDeDados.poupancas){
			Pessoa cliente = c.getCliente();
			if(cliente.getCPF().equals(cpf)){//Comparando os objetos
				try {
                                    //Se achar, ele então faz uma operação de saque ou depósito na conta encontrada
					contaExiste = true;
					if(saque)
						c.saque(valor, senha);
					else
						c.deposito(valor, senha);
					JOptionPane.showMessageDialog(null, "Operação realizada com sucesso!\nSeu saldo atual: R$" + c.getSaldo());
					} catch (DepositoInvalidoException | SenhaIncorretaException | SaqueInvalidoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (NumberFormatException  e1) {
						JOptionPane.showMessageDialog(null, "Por favor digite um numero em \"Valor\"");
					}	
				}		
		}
		if(!contaExiste)//Se não achar
			JOptionPane.showMessageDialog(null, "Esse CPF/CNPJ não existe em nosso banco de dados!\nPor favor, crie uma conta antes de realizar opera��es.");
	}
	//Validação operaçoes de conta poupança para PessoaJuridica
	public static void poupancaPessoaJuridica(String cnpj, String senha, double valor, boolean saque) {
		
		boolean contaExiste = false;
		//busca no banco de dados de pessoas que tem conta poupanç por uma pessoa com o CNPJ fornecido. 				
		for(Poupanca c : BancoDeDados.poupancas){
			Pessoa cliente = c.getCliente();
			if(cliente.getCNPJ().equals(cnpj)){
				try {
                                //Se achar, ele então faz uma operação de saque ou depósito na conta encontrada
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
		if(!contaExiste)//Se não achar
			JOptionPane.showMessageDialog(null, "Esse CPF/CNPJ não existe em nosso banco de dados!\nPor favor, crie uma conta antes de realizar operações.");
	}
}
