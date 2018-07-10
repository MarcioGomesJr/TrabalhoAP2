package gui;

import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//Classe para criar uma barra de rolagem
public class ScrollPane extends JFrame {
	
	private static final long serialVersionUID = 5379780688992614540L;
	
	JTextArea texto;
	JScrollPane scroll;
        JScrollPane scrollpane = new JScrollPane(texto);
        
	
        //Metodo construtor q passa a configuracao da janela
	public ScrollPane(String nome, Point posicao, String conteudo) {
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 500);
		setLocation(posicao);
		setTitle(nome);
		
		texto = new JTextArea(conteudo);
		texto.setEditable(false);
		scroll = new JScrollPane(texto);
		
		add(scroll);
	}
        
            
        }
