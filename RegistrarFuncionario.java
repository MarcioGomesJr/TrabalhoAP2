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
import classesDiagrama.Funcionario;

//Classe que monta a janela para registrar funcionários
//Rafael Nunes Santana

public class RegistrarFuncionario extends JanelaBase implements ActionListener {

		//Declarando labels
		private JLabel lblNome;
		private JLabel lblCpf;
		private JLabel lblTipoDeLogradouro;
		private JLabel lblLogradouro;
		private JLabel lblNumero;
		private JLabel lblBairro;
		private JLabel lblCidade;
		private JLabel lblEstado;
		private JLabel lblCep;
		private JLabel lblCargo;
		
		//Declarando campos de texto
		private JTextField fdNome;
		private JTextField fdCpf;
		private JTextField fdTipoDeLogradouro;
		private JTextField fdLogradouro;
		private JTextField fdNumero;
		private JTextField fdBairro;
		private JTextField fdCidade;
		private JTextField fdEstado;
		private JTextField fdCep;
		private JTextField fdCargo;
		
		//Declarando botões
		private JButton voltarB;
		private JButton registrarB;
		
		public RegistrarFuncionario(Point posicao) {
			
			//Passando as especificações para a super classe
			super(600, 500, "Registrar Funcionário", posicao);
			
			//Instancioando componentes
			lblNome = new JLabel("Nome: ");
			lblCpf = new JLabel("CPF: ");
			lblCargo = new JLabel("Cargo: ");
			lblTipoDeLogradouro = new JLabel("Tipo de Logradouro: ");
			lblLogradouro = new JLabel("Logradouro: ");
			lblNumero = new JLabel("Número: ");
			lblBairro = new JLabel("Bairro: ");
			lblCidade = new JLabel("Cidade: ");
			lblEstado = new JLabel("Estado: ");
			lblCep = new JLabel("CEP: ");
			
			fdNome = new JTextField(10);
			fdCpf = new JTextField(10);
			fdCargo = new JTextField(10);
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
			campos.add(lblCpf, gb);
			
			gb.gridy = 2;
			campos.add(lblCargo, gb);
			
			gb.gridy = 3;
			campos.add(lblTipoDeLogradouro, gb);
			
			gb.gridy = 4;
			campos.add(lblLogradouro, gb);
			
			gb.gridy = 5;
			campos.add(lblNumero, gb);
			
			gb.gridy = 6;
			campos.add(lblBairro, gb);
			
			gb.gridy = 7;
			campos.add(lblCidade, gb);
			
			gb.gridy = 8;
			campos.add(lblEstado, gb);
			
			gb.gridy = 9;
			campos.add(lblCep, gb);
			
			gb.anchor = GridBagConstraints.LINE_START;
			
			gb.weighty = 1;
			gb.gridy = 10;		
			campos.add(voltarB, gb);
			
			//Segunda coluna:
			gb.fill = GridBagConstraints.HORIZONTAL;
			gb.weightx = 5;
			
			gb.gridx = 1;
			
			gb.gridy = 0;
			campos.add(fdNome, gb);
			
			gb.gridy = 1;
			campos.add(fdCpf, gb);
			
			gb.gridy = 2;
			campos.add(fdCargo, gb);
			
			gb.gridy = 3;
			campos.add(fdTipoDeLogradouro, gb);
			
			gb.gridy = 4;
			campos.add(fdLogradouro, gb);
			
			gb.gridy = 5;
			campos.add(fdNumero, gb);
			
			gb.gridy = 6;
			campos.add(fdBairro, gb);
			
			gb.gridy = 7;
			campos.add(fdCidade, gb);
			
			gb.gridy = 8;
			campos.add(fdEstado, gb);
			
			gb.gridy = 9;
			campos.add(fdCep, gb);
			
			gb.fill = GridBagConstraints.NONE;
			gb.anchor = GridBagConstraints.LINE_END;
			
			gb.gridy = 10;
			campos.add(registrarB, gb);
			
			//Espaço para organizar
			gb.weightx = 0.4;
			gb.gridx = 2;
			campos.add(espacos[0], gb);
			
			//Atualizando os paineis e iniciando o relógio
			iniciar();
		}
                //Controla o comportamento dos botões
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == voltarB) {
				
				janela.dispose();
				new Thread() {
					public void run() {
						new AbaMenus(janela.getLocation());
					}
				}.start();
			}
			if(e.getSource() == registrarB) {
				try {//codigo a ser executado
					Funcionario funcionario = new Funcionario(fdNome.getText(),new Endereco(fdTipoDeLogradouro.getText(),fdLogradouro.getText(),Integer.parseInt(fdNumero.getText()),fdBairro.getText(),fdCidade.getText(),fdEstado.getText(),fdCep.getText()),fdCpf.getText(),fdCargo.getText());
					
					BancoDeDados.verificarERegistrar(funcionario);//Acessando metodo da classe Banco de dados
                                        //verifica se o cpf do funcionario ja existe no banco de dados, se nao, é criado novo funcionario
				
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,"Por favor digite um número em \"Número\"");
                                //Cada catch tem sua devida classe
				} catch (CpfCnpjInvalidoException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());//tratamento de exceção
				} catch (CepInvalidoException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		}
		

}
