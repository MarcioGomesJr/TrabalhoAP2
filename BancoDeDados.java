package gui;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import classesDiagrama.*;

public class BancoDeDados {

	public static ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<PessoaFisica>();
	public static ArrayList<PessoaJuridica> pessoasJuridicas = new ArrayList<PessoaJuridica>();
	public static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public static ArrayList<ContaCorrente> contasCorrente = new ArrayList<ContaCorrente>();
	public static ArrayList<Poupanca> poupancas = new ArrayList<Poupanca>();
	
	public static boolean verificarERegistrar(Funcionario funcionario) {
		boolean funcionarioExiste = false;
		for(Funcionario f : BancoDeDados.funcionarios) {
			if(funcionario.getCPF().equals(f.getCPF())) {
				JOptionPane.showMessageDialog(null, "Um funcionário com esse CPF já foi registrado");
				funcionarioExiste = true;
				return false;
			}
		}
		if(!funcionarioExiste)
			BancoDeDados.funcionarios.add(funcionario);
			return true;
	}
	
	public static boolean verificarPessoaFisica(String cpf) {
		
		boolean pessoaExiste = false;
		for(PessoaFisica f : BancoDeDados.pessoasFisicas) {
			if(cpf.equals(f.getCPF())) {
				JOptionPane.showMessageDialog(null, "Você já possui uma conta!");
				pessoaExiste = true;
			}
		}
		return pessoaExiste;
	}
	
	public static boolean verificarPessoaJuridica(String cnpj) {
		
		boolean pessoaExiste = false;
		for(PessoaJuridica f : BancoDeDados.pessoasJuridicas) {
			if(cnpj.equals(f.getCNPJ())) {
				JOptionPane.showMessageDialog(null, "Essa empresa já possui uma conta!");
				pessoaExiste = true;
			}
		}
		return pessoaExiste;
	}
}
