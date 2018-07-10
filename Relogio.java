package gui;

import java.text.DecimalFormat;
import java.util.Calendar;

//Classe para registrar a hora e data, que será necessária para as outras classes
//Rafael Nunes Santana

public class Relogio {

	private DecimalFormat formato;
	private int hora, minuto, segundo, dia, mes, ano;
	private String data;
	private String horas;
	private Calendar calendario;
	
	//Construtor pega a data hora atual
	public Relogio() {
		
		formato = new DecimalFormat("00");
		atualizarHora();
	}

	//Método que atualiza o relógio e deve ser chamado a cada segundo
	public void atualizarHora() {
		
		calendario = Calendar.getInstance();
		
		hora = calendario.get(Calendar.HOUR_OF_DAY);
		minuto = calendario.get(Calendar.MINUTE);
		segundo = calendario.get(Calendar.SECOND);
		dia = calendario.get(Calendar.DAY_OF_MONTH);
		//Por algum motivo o mês retornado aqui é atrasado...
		mes = calendario.get(Calendar.MONTH) + 1;
		ano = calendario.get(Calendar.YEAR);
		
		horas = formatar(hora) + ":" + formatar(minuto) + ":" + formatar(segundo);
		data = formatar(dia) + "/" + formatar(mes) + "/" + ano;
	}
	
	//Formatador para padronizar as horas
	private String formatar(int num){
        return formato.format(num);
    }
	
	//Getters para serem usados em outras classes
	public int getHora() {
		return hora;
	}

	public int getMinuto() {
		return minuto;
	}

	public int getSegundo() {
		return segundo;
	}

	public int getDia() {
		return dia;
	}

	public int getMes() {
		return mes;
	}

	public int getAno() {
		return ano;
	}

	public String getHoras() {
		return horas;
	}

	public String getData() {
		return data;
	}
}
