package gui;

//Autor: Eduardo Silvestre
//Classe que cria a janela para fazer deposito

import java.awt.GridBagConstraints;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import classesDiagrama.PessoaFisica;
import classesDiagrama.PessoaJuridica;

public class Deposito extends JanelaBase implements ActionListener, ItemListener {

	private JLabel lblId;
	private JLabel lblSenha;
	private JLabel lblValor;
	
	private JTextField fdId;
	private JTextField fdSenha;
	private JTextField fdValor;
	
	private JButton depositarB;
	private JButton voltarB;
	
	private JRadioButton corrente;
	private JRadioButton poupanca;
	
	public Deposito(Point posicao) {
		
		//Passando as especificações para a super classe
		super(600, 500, "Deposito", posicao);
		
		//Instanciando os componentes e adicionando os botões ao Action Listener
		lblId = new JLabel("CPF/CNPJ: ");
		lblSenha = new JLabel("Senha: ");
		lblValor = new JLabel("Valor: ");
		
		fdId = new JTextField(10);
		fdSenha = new JTextField(10);
		fdValor = new JTextField(10);
		
		depositarB = new JButton("Depositar");
		voltarB = new JButton("<- Voltar");
		
		depositarB.addActionListener(this);
		voltarB.addActionListener(this);
		
		corrente = new JRadioButton("Conta Corrente", true);
		poupanca = new JRadioButton("Conta Poupan�a", false);
		
		corrente.addItemListener(this);
		poupanca.addItemListener(this);
		
		//GridBagConstraint para organizar os componentes
		GridBagConstraints gb = new GridBagConstraints();
		
		//Primeira coluna	
		gb.anchor = GridBagConstraints.LINE_END;
		
		gb.weightx = 0.05;
		gb.weighty = 0.5;
		
		gb.gridx = 0;
		gb.gridy = 0;
		campos.add(lblId, gb);
		
		gb.gridy = 2;
		campos.add(lblSenha, gb);
		
		gb.gridy = 3;
		campos.add(lblValor, gb);
		
		gb.gridy = 4;
		campos.add(corrente, gb);
		
		gb.gridy = 5;
		campos.add(voltarB, gb);
		
		gb.weighty = 5;
		
		gb.gridy = 6;
		campos.add(espacos[0], gb);
		
		//Segunda coluna
		gb.anchor = GridBagConstraints.LINE_START;
		gb.fill = GridBagConstraints.HORIZONTAL;
		
		gb.weightx = 1;
		gb.weighty = 0.5;
		
		gb.gridx = 1;
		gb.gridy = 0;
		campos.add(fdId, gb);
				
		gb.gridy = 2;
		campos.add(fdSenha, gb);
				
		gb.fill = GridBagConstraints.NONE;
		
		gb.gridy = 3;
		campos.add(fdValor, gb);
		
		gb.gridy = 4;
		campos.add(poupanca, gb);
		
		gb.anchor = GridBagConstraints.LINE_END;
		
		gb.gridy = 5;
		campos.add(depositarB, gb);
		
		//Atualizando os paineis e iniciando o relógio
		iniciar();
	}
        //Controla o comportamento dos botões
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == voltarB) {
			
			janela.dispose();
			new Thread() {
				public void run() {
					new CaixaEletronico(janela.getLocation());
				}
			}.start();
		}
		
		if(e.getSource() == depositarB) {
				
                                //Verifica se o que foi digitado bate com o padrao do CPF/CNPJ
				if(PessoaFisica.verificaCPF(fdId.getText())) 
					if(corrente.isSelected())//Verifica se existe uma pessoa e dados com o mesmo CPF/CNPJ que foi digitado
						Operacoes.correntePessoaFisica(fdId.getText(), fdSenha.getText(), Double.parseDouble(fdValor.getText()), false);
					else
						Operacoes.poupancaPessoaFisica(fdId.getText(), fdSenha.getText(), Double.parseDouble(fdValor.getText()), false);
                                //Verifica se o que foi digitado bate com o padrao do CNPJ/cpf           
				else if(PessoaJuridica.verificaCNPJ(fdId.getText()))
					if(corrente.isSelected())//Verifica se existe uma pessoa e dados com o mesmo CPF/CNPJ que foi digitado
						Operacoes.correntePessoaJuridica(fdId.getText(), fdSenha.getText(), Double.parseDouble(fdValor.getText()), false);
					else
						Operacoes.poupancaPessoaJuridica(fdId.getText(), fdSenha.getText(), Double.parseDouble(fdValor.getText()), false);

				else 	
					JOptionPane.showMessageDialog(null, "O CPF ou o CNPJ é inválido");
				}
			}
	
        //Controla o comportamento dos botões de escolha                
	@Override
	public void itemStateChanged(ItemEvent e) {
		
		if(e.getSource() == corrente) {
			if(corrente.isSelected())
				poupanca.setSelected(false);
			if(!corrente.isSelected() && !poupanca.isSelected()) {
				corrente.setSelected(true);
			}
		}
		
		if(e.getSource() == poupanca) {
			if(poupanca.isSelected())
				corrente.setSelected(false);
			if(!poupanca.isSelected() && !corrente.isSelected()) {
				poupanca.setSelected(true);
			}
		}
	}

}
