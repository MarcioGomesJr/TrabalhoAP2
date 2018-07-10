package gui;

import java.awt.GridBagConstraints;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

//Classes que monta a janela para realizar operações bancárias
//Rafael Nunes Santana

public class CaixaEletronico extends JanelaBase implements ActionListener {

	//Declarando botões
	private JButton voltarB;
	private JButton saqueB;
	private JButton depositoB;
	
	public CaixaEletronico(Point posicao) {

		super(600, 500, "Caixa Eletrônico", posicao);
		
		//Instanciando Botões e os adicionando ao ActionListener
		voltarB = new JButton("<- Voltar");
		saqueB = new JButton("Saque");
		depositoB = new JButton("Depósito");
		
		voltarB.addActionListener(this);
		saqueB.addActionListener(this);
		depositoB.addActionListener(this);
		
		//GridBagConstraint para organizar os componentes
		GridBagConstraints gb = new GridBagConstraints();
		
		gb.anchor = GridBagConstraints.CENTER;
		gb.fill = GridBagConstraints.HORIZONTAL;
		
		gb.weightx = 0.9;
		gb.weighty = 1;
		
		gb.gridx = 1;
		gb.gridy = 0;
		campos.add(espacos[0], gb);
		
		gb.weighty = 0.1;
		
		gb.gridx = 1;
		gb.gridy = 1;
		campos.add(depositoB, gb);
		
		gb.gridx = 1;
		gb.gridy = 2;
		campos.add(saqueB, gb);
		
		gb.gridx = 1;
		gb.gridy = 3;
		campos.add(voltarB, gb);
		
		gb.weightx = 3;
		gb.weighty = 3;
		
		gb.gridx = 0;
		gb.gridy = 4;
		campos.add(espacos[1], gb);
		
		gb.gridx = 2;
		campos.add(espacos[2], gb);
	
                
		iniciar();//carrega os paineis na janela e inicia o relógio
	}
        
        //Controla o comportamento dos botões
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
		
		if(e.getSource() == depositoB) {
			
			janela.dispose();
			new Thread() {
				public void run() {
					new Deposito(janela.getLocation());
				}
			}.start();
		}
		
		if(e.getSource() == saqueB) {
			
			janela.dispose();
			new Thread() {
				public void run() {
					new Saque(janela.getLocation());
				}
			}.start();

		}
	}

}
