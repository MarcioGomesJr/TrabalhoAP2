package gui;

import java.awt.GridBagConstraints;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import classesDiagrama.ContaCorrente;
import classesDiagrama.Funcionario;
import classesDiagrama.Poupanca;

//Classes que monta a janela do menu principal
//Rafael Nunes Santana
//Eduardo Silvestre P. Goncalves

public class AbaMenus extends JanelaBase implements ActionListener {
	
	//Botões para abrir os outros menus
	private JButton registrarFuncionarioB;
	private JButton criarContaB;
	private JButton caixaEletronicoB;
	private JButton funcionariosB;
	private JButton contasB;
	
	//Contrutor que monta a janela
	public AbaMenus(Point posicao) {
		
		//Passando as especificações para a super classe
		super(600, 500, "Menu Principal", posicao);
		
		//Instanciando os botões e os adicionando ao action Listener
		registrarFuncionarioB = new JButton("Registrar Funcionário");
		criarContaB = new JButton("Criar Conta");
		caixaEletronicoB = new JButton("Caixa Eletrônico");
		funcionariosB = new JButton("Funcionários");
		contasB = new JButton("Contas");
		
		registrarFuncionarioB.addActionListener(this);
		criarContaB.addActionListener(this);
		caixaEletronicoB.addActionListener(this);
		funcionariosB.addActionListener(this);
		contasB.addActionListener(this);
		
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
		
		gb.gridy = 5;		
		campos.add(funcionariosB, gb);
		
		gb.gridy = 6;		
		campos.add(contasB, gb);
		
		//Espaços para organizar melhor
		gb.weighty = 10;
		gb.gridx = 0;
		gb.gridy = 7;
		campos.add(espacos[0], gb);
		
		gb.gridx = 2;
		gb.gridy = 7;
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
		
			if(relogio.getHora() >= 10 && relogio.getHora() < 15) {
				janela.dispose();
				new Thread() {
					public void run() {
						new CriarConta(janela.getLocation());
					}
				}.start();
			}
			else
				JOptionPane.showMessageDialog(null, "Desculpe, só podemos cadastrar contas entre as 10:00 e as 15:00hrs!");
		}
		
		if(e.getSource() == caixaEletronicoB) {
			
			if(relogio.getHora() >= 7 && relogio.getHora() < 22) {
				janela.dispose();
				new Thread() {
					public void run() {
						new CaixaEletronico(janela.getLocation());
					}
				}.start();
			}
			else
				JOptionPane.showMessageDialog(null, "Desculpe, só podemos realizar operações entre as 7:00 e as 22:00hrs!");
		}
		
		if(e.getSource() == funcionariosB) {
			
			StringBuilder funcionarios = new StringBuilder("");
			for(Funcionario	funcionario : BancoDeDados.funcionarios) {
				funcionarios.append(funcionario.toString());
				funcionarios.append("\n\n");
			}
			
			new Thread() {
				public void run() {
					//new ScrollPane("Funcionarios" ,janela.getLocation(), funcionarios.toString());
					JOptionPane.showMessageDialog(null, funcionarios);
				}
			}.start();
		}
		if(e.getSource() == contasB) {
			
			StringBuilder contasCorrente = new StringBuilder("");
			StringBuilder contasPoupanca = new StringBuilder("");
			
			for(ContaCorrente	contaCorrente : BancoDeDados.contasCorrente) {
				contasCorrente.append(contaCorrente.toString());
				contasCorrente.append("\n\n");
			}
			for(Poupanca	contaPoupanca : BancoDeDados.poupancas) {
				contasPoupanca.append(contaPoupanca.toString());
				contasCorrente.append("\n\n");
			}
			

			
			new Thread() {
				public void run() {
					//new ScrollPane("ContaCorrente e Poupanca" ,janela.getLocation(), contasCorrente.toString(),contasPoupanca.toString());
					JOptionPane.showMessageDialog(null, contasCorrente);
					JOptionPane.showMessageDialog(null, contasPoupanca);
				}
			}.start();
		}
	}
	
	
	//Inicializa o app pelos menus
	public static void main(String args[]) {
		new AbaMenus(new Point(600, 300));
	}
}
