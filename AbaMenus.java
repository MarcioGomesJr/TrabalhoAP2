package gui;

import java.awt.GridBagConstraints;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//Classes que monta a janela do menu principal
//Rafael Nunes Santana

public class AbaMenus extends JanelaBase implements ActionListener {
	
	//Botões para abrir os outros menus
	private JButton registrarFuncionarioB;
	private JButton criarContaB;
	private JButton caixaEletronicoB;
	
	//Contrutor que monta a janela
	public AbaMenus(Point posicao) {
		
		//Passando as especificações para a super classe
		super(600, 500, "Menu Principal", posicao);
		
		//Instanciando os botões e os adicionando ao action Listener
		registrarFuncionarioB = new JButton("Registrar Funcionário");
		criarContaB = new JButton("Criar Conta");
		caixaEletronicoB = new JButton("Caixa Eletrônico");
		
		registrarFuncionarioB.addActionListener(this);
		criarContaB.addActionListener(this);
		caixaEletronicoB.addActionListener(this);
		
		//GridBagConstraint para organizar os componentes
		GridBagConstraints gb = new GridBagConstraints();
		
		gb.anchor = GridBagConstraints.CENTER;
		gb.fill = GridBagConstraints.HORIZONTAL;
		
		gb.weightx = 0.5;
		gb.weighty = 5;
		
		gb.gridx = 1;
		gb.gridy = 0;
		campos.add(espacos[2], gb);
		
		gb.weighty = 0.5;
		
		gb.gridy = 2;		
		campos.add(registrarFuncionarioB, gb);
	
		gb.gridy = 3;		
		campos.add(criarContaB, gb);
		
		gb.gridy = 4;		
		campos.add(caixaEletronicoB, gb);
		
		//Espaços para organizar melhor
		gb.weighty = 10;
		gb.gridx = 0;
		gb.gridy = 5;
		campos.add(espacos[0], gb);
		
		gb.gridx = 2;
		gb.gridy = 5;
		campos.add(espacos[1], gb);
		
		//Atualizando os paineis e iniciando o relógio
		iniciar();
	}
	
	//Controla o comportamento dos botões
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == registrarFuncionarioB) {
			
			janela.dispose();
			new Thread() {
				public void run() {
					new RegistrarFuncionario(janela.getLocation());
				}
			}.start();
		}
		
		if(e.getSource() == criarContaB) {
		
			janela.dispose();
			new Thread() {
				public void run() {
					new CriarConta(janela.getLocation());
				}
			}.start();
		}
		
		if(e.getSource() == caixaEletronicoB) {
			
			janela.dispose();
			new Thread() {
				public void run() {
					new CaixaEletronico(janela.getLocation());
				}
			}.start();
		}
	}
	
	//Inicializa o app pelos menus
	public static void main(String args[]) {
		new AbaMenus(new Point(600, 300));
	}
}
