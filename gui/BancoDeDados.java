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
	
	public static void verificarERegistrar(Funcionario funcionario) {
		boolean funcionarioExiste = false;
		for(Funcionario f : BancoDeDados.funcionarios) {
			if(funcionario.getCPF().equals(f.getCPF())) {
				JOptionPane.showMessageDialog(null, "Um funcionário com esse CPF já foi registrado");
				funcionarioExiste = true;
			}
		}
		if(!funcionarioExiste)
			BancoDeDados.funcionarios.add(funcionario);
	}
	
	public static boolean verificar(PessoaFisica pessoa) {
		boolean pessoaExiste = false;
		for(Funcionario f : BancoDeDados.funcionarios) {
			if(pessoa.getCPF().equals(f.getCPF())) {
				JOptionPane.showMessageDialog(null, "Uma pessoa com esse CPF já foi registrada");
				pessoaExiste = true;
			}
		}
		return pessoaExiste;
	}
	
	public static boolean verificar(PessoaJuridica pessoa) {
		boolean pessoaExiste = false;
		for(PessoaJuridica f : BancoDeDados.pessoasJuridicas) {
			if(pessoa.getCNPJ().equals(f.getCNPJ())) {
				JOptionPane.showMessageDialog(null, "Uma pessoa jurídica com esse CNPJ já foi registrada");
				pessoaExiste = true;
			}
		}
		return pessoaExiste;
	}
}
