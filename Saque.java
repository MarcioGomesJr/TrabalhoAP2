package gui;

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

public class Saque extends JanelaBase implements ActionListener, ItemListener {
        //Declarando labels
	private JLabel lblId;
	private JLabel lblSenha;
	private JLabel lblValor;
	
        //Declarando campos de texto
	private JTextField fdId;
	private JTextField fdSenha;
	private JTextField fdValor;
	
        //Declarando botões
	private JButton depositarB;
	private JButton voltarB;
	
        //Declarando Botões de escolha
	private JRadioButton corrente;
	private JRadioButton poupanca;
	
	//Passando as especificações para a super classe
	public Saque(Point posicao) {
		
			super(600, 500, "Saque", posicao);
			
			//Instanciando os componentes e adicionando os bot�es ao Action Listener
			lblId = new JLabel("CPF/CNPJ: ");
			lblSenha = new JLabel("Senha: ");
			lblValor = new JLabel("Valor: ");
			
			fdId = new JTextField(10);
			fdSenha = new JTextField(10);
			fdValor = new JTextField(10);
			
			depositarB = new JButton("Sacar");
			voltarB = new JButton("<- Voltar");
			
			depositarB.addActionListener(this);
			voltarB.addActionListener(this);
			
			corrente = new JRadioButton("Conta Corrente", true);
			poupanca = new JRadioButton("Conta Poupança", false);
			
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
				//
				if(PessoaFisica.verificaCPF(fdId.getText())) //Metodo de verificação de cpf de PessoaFisica
                                                                             //Retorna uma String de um JTextComponent
					if(corrente.isSelected())
						Operacoes.correntePessoaFisica(fdId.getText(), fdSenha.getText(), Double.parseDouble(fdValor.getText()), true);
					else
						Operacoes.poupancaPessoaFisica(fdId.getText(), fdSenha.getText(), Double.parseDouble(fdValor.getText()), true);

				else if(PessoaJuridica.verificaCNPJ(fdId.getText()))//Metodo de verificação de cnpj de PessoaJuridica
					if(corrente.isSelected())
						Operacoes.correntePessoaJuridica(fdId.getText(), fdSenha.getText(), Double.parseDouble(fdValor.getText()), true);
					else
						Operacoes.poupancaPessoaJuridica(fdId.getText(), fdSenha.getText(), Double.parseDouble(fdValor.getText()), true);

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
