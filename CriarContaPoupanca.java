package gui;

import java.awt.GridBagConstraints;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

//Classes que monta a janela para criar contas de poupança
//Rafael Nunes Santana

public class CriarContaPoupanca extends JanelaBase implements ActionListener {

	private JLabel lblNome;
	private JLabel lblId;
	private JLabel lblSenha;
	private JLabel lblSenhaConf;
	
	private JTextField fdNome;
	private JTextField fdId;
	private JTextField fdSenha;
	private JTextField fdSenhaConf;
	
	private JButton criarB;
	private JButton voltarB;
	
	public CriarContaPoupanca(Point posicao) {
		
		//Passando as especificações para a super classe
		super(600, 500, "Criar Conta Poupanca", posicao);
		
		//Instanciando os componentes e adicionando os botões ao Action Listener
		lblNome = new JLabel("Nome: ");
		lblId = new JLabel("CPF/CNPJ: ");
		lblSenha = new JLabel("Senha: ");
		lblSenhaConf = new JLabel("Confirmar senha: ");
		
		fdNome = new JTextField(10);
		fdId = new JTextField(10);
		fdSenha = new JTextField(10);
		fdSenhaConf = new JTextField(10);
		
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
		campos.add(lblSenha, gb);
		
		gb.gridy = 3;
		campos.add(lblSenhaConf, gb);
		
		gb.gridy = 4;
		campos.add(voltarB, gb);
		
		gb.weighty = 5;
		
		gb.gridy = 5;
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
		campos.add(fdSenha, gb);
				
		gb.gridy = 3;
		campos.add(fdSenhaConf, gb);
		
		gb.fill = GridBagConstraints.NONE;
		gb.anchor = GridBagConstraints.LINE_END;
		
		gb.gridy = 4;
		campos.add(criarB, gb);

		//Atualizando os paineis e iniciando o relógio
		iniciar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == voltarB) {
			
			janela.dispose();
			new Thread() {
				public void run() {
					new CriarConta(janela.getLocation());
				}
			}.start();
		}
	}

}
