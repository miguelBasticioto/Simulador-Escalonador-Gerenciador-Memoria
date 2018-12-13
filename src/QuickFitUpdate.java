import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuickFitUpdate extends Thread{
	private ArrayList<JPanel> paineis;
	private JPanel painel;
	private ListaMemoria l;
	private ArrayList<ListaMemoria> listas;
	private ArrayList<Requisicoes> requisicoes;
	private int qtdAtual;
	private JLabel label;
	
	public QuickFitUpdate( ArrayList<JPanel> paineis, JPanel painel, ListaMemoria l, ArrayList<ListaMemoria> listas, ArrayList<Requisicoes> requisicoes, int qtdAtual, JLabel label){
		this.paineis = paineis;
		this.painel = painel;
		this.l = l;
		this.listas = listas;
		this.requisicoes = requisicoes;
		this.qtdAtual = qtdAtual;
		this.label = label;
	}
	
	@Override
	public void run() {
		while(1<2){
			System.out.print("");
			for(int i = 0; i < l.getSize(); i ++){
				l.search(i).getLabel().setText("<html>Id: " + l.search(i).getId() + "<br>TT: " + l.search(i).getTamanho() + "<br>TU: " + l.search(i).getTamanhoUsado() + "</html>");
				if(l.search(i).getProcesso() != null) {
					l.search(i).getPanel().setBackground(l.search(i).getProcesso().getC());
				} else {
					l.search(i).getPanel().setBackground(Color.white);
				}
			}
			
			for(int i = 0; i < listas.size(); i ++){
				System.out.print("");
				for(int j = 0; j < listas.get(i).getSize(); j ++){	
					listas.get(i).search(j).getLabel().setText("<html>Id: " + listas.get(i).search(j).getId() + "<br>TT: " + listas.get(i).search(j).getTamanho() + "<br>TU: " + listas.get(i).search(j).getTamanhoUsado() + "</html>");
					if(listas.get(i).search(j).getProcesso() != null) {
						listas.get(i).search(j).getPanel().setBackground(listas.get(i).search(j).getProcesso().getC());
					} else {
						listas.get(i).search(j).getPanel().setBackground(Color.white);
					}
				}
			}
		}
	}
}
