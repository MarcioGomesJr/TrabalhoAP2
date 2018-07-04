package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


//Classe que cria uma janela b�sica com um painel para componentes e um com o rel�gio
//Deve ser herdada pelos outras classes que definem janelas no pacote
//Rafael Nunes Santana

public class JanelaBase implements Runnable {

	//Rel�gio que ser� usado pela janela
	protected Relogio relogio;
	
	//Labels onde ser�o mostardas a hora e a data
	protected JLabel hora;
	protected JLabel data;
	
	//Label vazia para organiza��o
	protected JLabel[] espacos;
	
	//Paineis separados para os campos e o rel�gio
	protected JPanel campos;
	protected JPanel relogioP;
	
	//A janela propriamente dita
	protected JFrame janela;
		
	//Container da janela para organizar melhor os paineis
	protected Container container;
		
	//Contrutor que monta a janela especificanco seu tamanho e nome da label dos componentes
	public JanelaBase(int largura, int altura, String nome, Point posicao) {
		
		//Vetor de espa�oes vazios para organizar as labels
		espacos = new JLabel[6];
				
		for(int i = 0; i < espacos.length; i++)
			espacos[i] = new JLabel("");
						
		//Instanciando as labels do rel�gio e o rel�gio
		relogio = new Relogio();
		data = new JLabel();
		hora = new JLabel();
		
		//Dimenson para dimensionar os paineis
		Dimension tamanho = new Dimension();
				
		//Definindo os padr�es b�sicos da janela, como tamanho, posi��o inicial, nome, visibilidade, e possibilidade de fechar
		janela = new JFrame("Banco RENM");
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(largura, altura);
		janela.setLocation(posicao);
				
		//Criando os paineis para organizar os componentes
		campos = new JPanel();
		campos.setBorder(BorderFactory.createTitledBorder(nome));
				
		relogioP = new JPanel();
		relogioP.setBorder(BorderFactory.createTitledBorder("Data e Hora"));
		
		//Iniciando o GidBagConstraints para organizar os paineis e setando suas dimen��es
		campos.setLayout(new GridBagLayout());
		tamanho.height = altura - 90;
		campos.setPreferredSize(tamanho);
				
		relogioP.setLayout(new GridBagLayout());				
				
		//GridBagConstraint para organizar os componentes
		GridBagConstraints gb = new GridBagConstraints();
				
		gb.anchor = GridBagConstraints.CENTER;
		gb.fill = GridBagConstraints.HORIZONTAL;
		
		gb.weightx = 1;
		gb.gridx = 0;
		gb.gridy = 0;
		relogioP.add(espacos[4], gb);
		
		gb.weighty = 0.5;
		gb.gridx = 1;
		gb.gridy = 0;
		relogioP.add(data, gb);
			
		gb.gridx = 2;
		gb.gridy = 0;
		relogioP.add(hora, gb);
		
		gb.weighty = 1;
		gb.gridx = 3;
		gb.gridy = 0;
		relogioP.add(espacos[5], gb);
	}

	//Essa fun��o deve ser chamada no fim do contrutor de toda classe que herdar dela.
	//Ela carrega os paineis na janela e inicia o rel�gio
	protected void iniciar() {
		
		//Criando o container para organizar os paineis
		janela.setLayout(new BorderLayout());
		container = janela.getContentPane();
						
		//Adicionando os paineis (e seus componentes) na janela principal
		container.add(campos, BorderLayout.NORTH);
		container.add(relogioP, BorderLayout.SOUTH);
						
		//Inicia o rel�gio
		run();
	}
	
	//M�todo que atualiza o rel�gio a cada segundo
	public void run() {
		
		while(true) {
			
			relogio.atualizarHora();
			hora.setText(relogio.getHoras());
			data.setText(relogio.getData());
		
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
		
				e.printStackTrace();
			}
		
		}
	}
}
