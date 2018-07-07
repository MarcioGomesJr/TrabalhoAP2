package gui;

import java.awt.GridBagConstraints;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//Classes que monta a janela para a cria��o de contas
//Rafael Nunes Santana

public class CriarConta extends JanelaBase implements ActionListener {

	//Criando Bot�es
	private JButton contaCorrenteB;
	private JButton contaPoupancaB;
	private JButton voltarB;
	
	public CriarConta(Point posicao) {

		super(600, 500, "Criar conta", posicao);
		
		//Instanciando Bot�es e os adicionando ao ActionListener
		contaCorrenteB = new JButton("Criar Conta Corrente");
		contaPoupancaB = new JButton("Criar Conta Poupanca");
		voltarB = new JButton("<- Voltar");
		
		contaCorrenteB.addActionListener(this);
		contaPoupancaB.addActionListener(this);
		voltarB.addActionListener(this);
		
		//GridBagConstraint para organizar os componentes
		GridBagConstraints gb = new GridBagConstraints();
				
		gb.anchor = GridBagConstraints.CENTER;
		gb.fill = GridBagConstraints.HORIZONTAL;
		
		gb.weightx = 0.5;
		gb.weighty = 2;
		
		gb.gridx = 1;
		gb.gridy = 0;
		campos.add(espacos[0], gb);
		
		gb.weighty = 0.2;
		
		gb.gridx = 1;
		gb.gridy = 1;
		campos.add(contaCorrenteB, gb);
		
		gb.gridx = 1;
		gb.gridy = 2;
		campos.add(contaPoupancaB, gb);
		
		gb.gridx = 1;
		gb.gridy = 3;
		campos.add(voltarB, gb);
		
		gb.weightx = 5;
		gb.weighty = 5;
		
		gb.gridx = 0;
		gb.gridy = 4;
		campos.add(espacos[1], gb);
		
		gb.gridx = 2;
		campos.add(espacos[2], gb);
		
		iniciar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == voltarB) {
			
			janela.dispose();
			new Thread() {
				public void run() {
					new AbaMenus(janela.getLocation());
				}
			}.start();

		}
		
		if(e.getSource() == contaCorrenteB) {
			
			janela.dispose();
			new Thread() {
				public void run() {
					new CriarContaCorrente(janela.getLocation());
				}
			}.start();
		}
		
		if(e.getSource() == contaPoupancaB) {
			
			janela.dispose();
			new Thread() {
				public void run() {
					new CriarContaPoupanca(janela.getLocation());
				}
			}.start();
		}
	}

}
