package gui;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import classesDiagrama.*;

    //Classe que cria um banco de dados para armazenar dados de pessoa e conta

public class BancoDeDados {

	public static ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<PessoaFisica>();;//ArrayList pessoasFisicas armazena objeto PessoaFisica
	public static ArrayList<PessoaJuridica> pessoasJuridicas = new ArrayList<PessoaJuridica>();//ArrayList pessoasJuridicas armazena PessoaJuridica
	public static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();//ArrayList funcionarios armazena Funcionario
	
	public static ArrayList<ContaCorrente> contasCorrente = new ArrayList<ContaCorrente>();//ArrayList contasCorrente armazena objeto ContaCorrente
	public static ArrayList<Poupanca> poupancas = new ArrayList<Poupanca>();//ArrayList poupancas armazena objeto Poupanca
	
	public static void verificarERegistrar(Funcionario funcionario) {//Metodo para verificar se funcionario existe e registrar
		boolean funcionarioExiste = false;
		for(Funcionario f : BancoDeDados.funcionarios) {
			if(funcionario.getCPF().equals(f.getCPF())) {//Comparando os objetos 
				JOptionPane.showMessageDialog(null, "Um funcionário com esse CPF já foi registrado");
				funcionarioExiste = true;
			}
		}
		if(!funcionarioExiste)//funcionarioExiste =  false
			BancoDeDados.funcionarios.add(funcionario);
	}
	
	public static boolean verificarPessoaFisica(String cpf) { //Metodo para verificar Pessoa Fisica
		
		boolean pessoaExiste = false;//criando uma nova variavel pessoaExiste do tipo boolean falso
		for(PessoaFisica f : BancoDeDados.pessoasFisicas) {
			if(cpf.equals(f.getCPF())) {//Comparando os objetos cpf
				JOptionPane.showMessageDialog(null, "Você já possui uma conta!");
				pessoaExiste = true;
			}
		}
		return pessoaExiste;
	}
	
	public static boolean verificarPessoaJuridica(String cnpj) {//Metodo para verificar Pessoa Juridica
		
		boolean pessoaExiste = false;
		for(PessoaJuridica f : BancoDeDados.pessoasJuridicas) {
			if(cnpj.equals(f.getCNPJ())) {//Comparando os objetos cnpj
				JOptionPane.showMessageDialog(null, "Essa empresa já possui uma conta!");
				pessoaExiste = true;
			}
		}
		return pessoaExiste;
	}
}
