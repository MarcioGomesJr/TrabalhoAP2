package gui;

import java.awt.GridBagConstraints;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import classesDiagrama.CepInvalidoException;
import classesDiagrama.CpfCnpjInvalidoException;
import classesDiagrama.Endereco;
import classesDiagrama.Pessoa;
import classesDiagrama.PessoaFisica;
import classesDiagrama.PessoaJuridica;
import classesDiagrama.Poupanca;
import classesDiagrama.SenhaInvalidaException;

//Classes que monta a janela para criar contas de poupança
//Rafael Nunes Santana

public class CriarContaPoupanca extends JanelaBase implements ActionListener {
        
        //Declarando labels
	private JLabel lblNome;
	private JLabel lblId;
	private JLabel lblTipoDeLogradouro;
	private JLabel lblLogradouro;
	private JLabel lblNumero;
	private JLabel lblBairro;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JLabel lblCep;
	private JLabel lblSenha;
		
	//Declarando campos de texto
	private JTextField fdNome;
	private JTextField fdId;
	private JTextField fdTipoDeLogradouro;
	private JTextField fdLogradouro;
	private JTextField fdNumero;
	private JTextField fdBairro;
	private JTextField fdCidade;
	private JTextField fdEstado;
	private JTextField fdCep;
	private JTextField fdSenha;
	
	//Declarando bot�es
	private JButton criarB;
	private JButton voltarB;
	
	public CriarContaPoupanca(Point posicao) {
		
		//Passando as especificações para a super classe
		super(600, 500, "Criar Conta Poupança", posicao);
		
		//Instanciando os componentes e adicionando os botões ao Action Listener
		lblNome = new JLabel("Nome: ");
		lblId = new JLabel("CPF/CNPJ: ");
		lblTipoDeLogradouro = new JLabel("Tipo de Logradouro: ");
		lblLogradouro = new JLabel("Logradouro: ");
		lblNumero = new JLabel("Número: ");
		lblBairro = new JLabel("Bairo: ");
		lblCidade = new JLabel("Cidade: ");
		lblEstado = new JLabel("Estado: ");
		lblCep = new JLabel("CEP: ");
		lblSenha = new JLabel("Senha: ");
		
		fdNome = new JTextField(10);
		fdId = new JTextField(10);
		fdTipoDeLogradouro = new JTextField(10);
		fdLogradouro = new JTextField(10);
		fdNumero = new JTextField(10);
		fdBairro = new JTextField(10);
		fdCidade = new JTextField(10);
		fdEstado = new JTextField(10);
		fdCep = new JTextField(10);
		fdSenha = new JTextField(10);
		
		criarB = new JButton("Criar conta");
		voltarB = new JButton("<- Voltar");
		
		criarB.addActionListener(this);
		voltarB.addActionListener(this);
		
		//GridBagConstraint para organizar os componentes
		GridBagConstraints gb = new GridBagConstraints();
		
		//Primeira coluna
		gb.anchor = GridBagConstraints.LINE_END;
		
		gb.weightx = 0.05;
		gb.weighty = 0.5;
		
		gb.gridx = 0;
		gb.gridy = 0;
		campos.add(lblNome, gb);
		
		gb.gridy = 1;
		campos.add(lblId, gb);
		
		gb.gridy = 2;
		campos.add(lblTipoDeLogradouro, gb);
		
		gb.gridy = 3;
		campos.add(lblLogradouro, gb);
		
		gb.gridy = 4;
		campos.add(lblNumero, gb);
		
		gb.gridy = 5;
		campos.add(lblBairro, gb);
		
		gb.gridy = 6;
		campos.add(lblCidade, gb);
		
		gb.gridy = 7;
		campos.add(lblEstado, gb);
		
		gb.gridy = 8;
		campos.add(lblCep, gb);
		
		gb.gridy = 9;
		campos.add(lblSenha, gb);
		
		gb.gridy = 10;
		campos.add(voltarB, gb);
		
		gb.weighty = 5;
		
		gb.gridy = 11;
		campos.add(espacos[0], gb);
		
		//Segunda coluna
		gb.anchor = GridBagConstraints.LINE_START;
		gb.fill = GridBagConstraints.HORIZONTAL;
		
		gb.weightx = 1;
		gb.weighty = 0.5;
		
		gb.gridx = 1;
		gb.gridy = 0;
		campos.add(fdNome, gb);
				
		gb.gridy = 1;
		campos.add(fdId, gb);
		
		gb.gridy = 2;
		campos.add(fdTipoDeLogradouro, gb);
		
		gb.gridy = 3;
		campos.add(fdLogradouro, gb);
		
		gb.gridy = 4;
		campos.add(fdNumero, gb);
		
		gb.gridy = 5;
		campos.add(fdBairro, gb);
		
		gb.gridy = 6;
		campos.add(fdCidade, gb);
		
		gb.gridy = 7;
		campos.add(fdEstado, gb);
		
		gb.gridy = 8;
		campos.add(fdCep, gb);
				
		gb.gridy = 9;
		campos.add(fdSenha, gb);
				
		gb.gridy = 10;
		
		gb.fill = GridBagConstraints.NONE;
		gb.anchor = GridBagConstraints.LINE_END;

		campos.add(criarB, gb);
		
		//Atualizando os paineis e iniciando o relógio
		iniciar();
	}
        //Controla o comportamento dos botões
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == voltarB) {
			
			janela.dispose();
			new Thread() {
				public void run() {
					new CriarConta(janela.getLocation());
				}
			}.start();
		}
		
		if(e.getSource() == criarB) {
			
			Pessoa pessoa;
			Poupanca conta;
			
			if(PessoaFisica.verificaCPF(fdId.getText())) {
				//Verifica se o que foi digitado bate com o padrão do CPF
				try {//codigo a ser executado
					//Verifica no banco de dados se existe uma pessoa juridica com o mesmo CNPJ que foi digitado 
					if(!BancoDeDados.verificarPessoaJuridica(fdId.getText())) {

						pessoa = new PessoaFisica(fdNome.getText(), new Endereco(fdTipoDeLogradouro.getText(),fdLogradouro.getText(),Integer.parseInt(fdNumero.getText()),fdBairro.getText(),fdCidade.getText(),fdEstado.getText(),fdCep.getText()),fdId.getText());
						conta = new Poupanca(pessoa, fdSenha.getText());
                                                //Se o CPF nao constar no banco de dados é criado uma nova pessoa física,poupança com os dados fornecidos
						BancoDeDados.pessoasFisicas.add((PessoaFisica) pessoa);
						BancoDeDados.poupancas.add(conta);
                                                //Adiciona tudo ao banco de dados
						JOptionPane.showMessageDialog(null, "Conta criada com sucesso!\nSuas informações:\n" + conta.toString());
					}
					//tratando exceções
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Por favor digite um número em \"Número\"");
				} catch (CpfCnpjInvalidoException | CepInvalidoException | SenhaInvalidaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
			else {
				
				try {
					
					if(!BancoDeDados.verificarPessoaJuridica(fdId.getText())) {
                                        //Verifica se o que foi digitado bate com o padrão do CNPJ
						pessoa = new PessoaFisica(fdNome.getText(), new Endereco(fdTipoDeLogradouro.getText(),fdLogradouro.getText(),Integer.parseInt(fdNumero.getText()),fdBairro.getText(),fdCidade.getText(),fdEstado.getText(),fdCep.getText()),fdId.getText());
						conta = new Poupanca(pessoa, fdSenha.getText());
                                                //Se o CNPJ nao constar no banco de dados é criado uma nova pessoa juridica,poupança com os dados fornecidos
						BancoDeDados.pessoasJuridicas.add((PessoaJuridica) pessoa);
						BancoDeDados.poupancas.add(conta);
                                                //Adiciona tudo ao banco de dados
						JOptionPane.showMessageDialog(null, "Conta criada com sucesso!\nSuas informações:\n" + conta.toString());
					}
				//tratando exceções	
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Por favor digite um número em \"Número\"");
				} catch (CpfCnpjInvalidoException | CepInvalidoException | SenhaInvalidaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
	}
}
}
