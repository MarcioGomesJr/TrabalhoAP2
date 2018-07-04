package gui;

import java.awt.GridBagConstraints;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

//Classe que monta a janela para registrar pessoas jurídicas
//Rafael Nunes Santana

public class RegistrarPessoaJ extends JanelaBase implements ActionListener {

	//Declarando labels
	private JLabel lblNome;
	private JLabel lblCnpj;
	private JLabel lblTipoDeLogradouro;
	private JLabel lblLogradouro;
	private JLabel lblNumero;
	private JLabel lblBairro;
	private JLabel lblCidade;
	private JLabel lblEstado;
	private JLabel lblCep;
		
	//Declarando campos de texto
	private JTextField fdNome;
	private JTextField fdCnpj;
	private JTextField fdTipoDeLogradouro;
	private JTextField fdLogradouro;
	private JTextField fdNumero;
	private JTextField fdBairro;
	private JTextField fdCidade;
	private JTextField fdEstado;
	private JTextField fdCep;
		
	//Declarando botões
	private JButton voltarB;
	private JButton registrarB;
	
	public RegistrarPessoaJ(Point posicao) {
		
		//Passando as especificações para a super classe
		super(600, 500, "Registrar Pessoa Jurídica", posicao);
		
		//Instancioando componentes
		lblNome = new JLabel("Nome: ");
		lblCnpj = new JLabel("CNPJ: ");
		lblTipoDeLogradouro = new JLabel("Tipo de Logradouro: ");
		lblLogradouro = new JLabel("Logradouro: ");
		lblNumero = new JLabel("Número: ");
		lblBairro = new JLabel("Bairo: ");
		lblCidade = new JLabel("Cidade: ");
		lblEstado = new JLabel("Estado: ");
		lblCep = new JLabel("CEP: ");
		
		fdNome = new JTextField(10);
		fdCnpj = new JTextField(10);
		fdTipoDeLogradouro = new JTextField(10);
		fdLogradouro = new JTextField(10);
		fdNumero = new JTextField(10);
		fdBairro = new JTextField(10);
		fdCidade = new JTextField(10);
		fdEstado = new JTextField(10);
		fdCep = new JTextField(10);
		
		voltarB = new JButton("<- Voltar");
		registrarB = new JButton("Registrar");
		
		voltarB.addActionListener(this);
		registrarB.addActionListener(this);
		
		//GridBagConstraint para organizar os componentes
		GridBagConstraints gb = new GridBagConstraints();
				
		gb.anchor = GridBagConstraints.CENTER;
				
		//Primeira coluna:
		gb.anchor = GridBagConstraints.LINE_END;
		gb.weightx = 0.5;
		gb.weighty = 0.5;
		
		gb.gridx = 0;
		
		gb.gridy = 0;
		campos.add(lblNome, gb);
		
		gb.gridy = 1;
		campos.add(lblCnpj, gb);
		
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
		
		gb.anchor = GridBagConstraints.LINE_START;
		
		gb.weighty = 1;
		gb.gridy = 9;		
		campos.add(voltarB, gb);
		
		//Segunda coluna:
		gb.fill = GridBagConstraints.HORIZONTAL;
		gb.weightx = 5;
		
		gb.gridx = 1;
		
		gb.gridy = 0;
		campos.add(fdNome, gb);
		
		gb.gridy = 1;
		campos.add(fdCnpj, gb);
		
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
		
		gb.fill = GridBagConstraints.NONE;
		gb.anchor = GridBagConstraints.LINE_END;
		
		gb.gridy = 9;
		campos.add(registrarB, gb);
		
		//Espaço para organizar
		gb.weightx = 0.4;
		gb.gridx = 2;
		campos.add(espacos[0], gb);
		
		//Atualizando os paineis e iniciando o relógio
		iniciar();
	}

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == voltarB) {
			
			janela.dispose();
			new Thread() {
				public void run() {
					new AbaMenus(janela.getLocation());
				}
			}.start();
		}
	}
}
