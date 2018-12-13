import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class QuickFit extends JFrame{
	private int qtdAtual;
	private QuickFitUpdate qU;
	JLabel lblNewLabel;
	boolean prosseguir = true;
	public int getQtdAtual() {
		return qtdAtual;
	}
	public void setQtdAtual(int qtdAtual) {
		this.qtdAtual = qtdAtual;
	}
	public ArrayList<JScrollPane> getScrolls() {
		return scrolls;
	}
	public void setScrolls(ArrayList<JScrollPane> scrolls) {
		this.scrolls = scrolls;
	}
	private int qtdReq;
	private int qtdListas;
	private ArrayList<ListaMemoria> listas;
	private ArrayList<JPanel> paineis;
	private ListaMemoria l;
	private int tamanhoLista;
	private ArrayList<Requisicoes> requisicoes;
	private JPanel panel;
	private ArrayList<JScrollPane> scrolls;
	
	public ArrayList<Requisicoes> getRequisicoes() {
		return requisicoes;
	}
	public void setRequisicoes(ArrayList<Requisicoes> requisicoes) {
		this.requisicoes = requisicoes;
	}
	public QuickFit(int qtdReq, int qtdListas, ListaMemoria l, int tamanhoLista){
		this.qtdReq = qtdReq;
		this.qtdListas = qtdListas;
		this.l = l;
		this.tamanhoLista = tamanhoLista;
		requisicoes = new ArrayList<Requisicoes>();
		
		listas = new ArrayList<ListaMemoria>();
		paineis = new ArrayList<JPanel>();
		scrolls = new ArrayList<JScrollPane>();
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(84, 0, 400, 661);
		getContentPane().add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		for(int i = 0; i < qtdListas; i ++){
			JScrollPane scrollA = new JScrollPane();
			scrolls.add(scrollA);
			listas.add(new ListaMemoria(tamanhoLista/5));
			JPanel aux = new JPanel();
			aux.setBorder(new LineBorder(new Color(0, 0, 0))); 
			paineis.add(aux);
			scrolls.get(i).setViewportView(paineis.get(i));
			panel_1.add(scrolls.get(i));
		}
		setSize(500,700);
		
		setLocationRelativeTo(null);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(0, 0, 74, 230);
		getContentPane().add(lblNewLabel);
		
		qU = new QuickFitUpdate(paineis, panel, l, listas, requisicoes, qtdAtual, lblNewLabel);
		
		lblNewLabel.setText("<html>LG<br>");
		for(int i = 0 ; i< listas.size(); i ++){
			lblNewLabel.setText(lblNewLabel.getText() + "L" + i + ": " + listas.get(i).getTamanhoQuick()+"<br>");
		}
		lblNewLabel.setText(lblNewLabel.getText() + "</html>");
		qU.start();
		
		setVisible(true);
	}
	public QuickFitUpdate getqU() {
		return qU;
	}
	public void setqU(QuickFitUpdate qU) {
		this.qU = qU;
	}
	public void novo(Bloco b){
		b.getLabel().setText("<html>Id: " + b.getId() + "<br>TT: " + b.getTamanho() + "<br>TU: " + b.getTamanhoUsado() + "</html>");;
		panel.add(b.getPanel());
	}
	
	public void novoBlocoLista(Bloco b, int lista ){
		b.getLabel().setText("<html>Id: " + b.getId() + "<br>TT: " + b.getTamanho() + "<br>TU: " + b.getTamanhoUsado() + "</html>");
		paineis.get(lista).add(b.getPanel());
		revalidate();
		repaint();
	}
	public int getQtdReq() {
		return qtdReq;
	}
	public void setQtdReq(int qtdReq) {
		this.qtdReq = qtdReq;
	}
	public int getQtdListas() {
		return qtdListas;
	}
	public void setQtdListas(int qtdListas) {
		this.qtdListas = qtdListas;
	}
	public ArrayList<ListaMemoria> getListas() {
		return listas;
	}
	public void setListas(ArrayList<ListaMemoria> listas) {
		this.listas = listas;
	}
	public ArrayList<JPanel> getPaineis() {
		return paineis;
	}
	public void setPaineis(ArrayList<JPanel> paineis) {
		this.paineis = paineis;
	}
	public ListaMemoria getL() {
		return l;
	}
	public void setL(ListaMemoria l) {
		this.l = l;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public int getTamanhoLista() {
		return tamanhoLista;
	}
	public void setTamanhoLista(int tamanhoLista) {
		this.tamanhoLista = tamanhoLista;
	}
	
	public void fazerEstatistica(ArrayList<Core> cores, List[] listasEspera, MainFrameUpdate2 mU){

		for(int i = 0; i < listas.size(); i ++){
			listas.get(i).setTamanhoQuick(0);
		}
		
		for(int i = 0; i < GUI2.cores.size(); i ++){
			if(GUI2.cores.get(i).getCurrent()!= null){
				GUI2.cores.get(i).getCurrent().setFeito(0);
				GUI2.cores.get(i).getCurrent().setTotalTime(GUI2.cores.get(i).getCurrent().getTimeLeft());
				if(GUI2.cores.get(i).getCurrent().getPriority() == 0)GUI2.listas[0].enqueue(GUI2.cores.get(i).getCurrent());
				if(GUI2.cores.get(i).getCurrent().getPriority() == 1)GUI2.listas[1].enqueue(GUI2.cores.get(i).getCurrent());
				if(GUI2.cores.get(i).getCurrent().getPriority() == 2)GUI2.listas[2].enqueue(GUI2.cores.get(i).getCurrent());
				if(GUI2.cores.get(i).getCurrent().getPriority() == 3)GUI2.listas[3].enqueue(GUI2.cores.get(i).getCurrent());
				
				GUI2.cores.get(i).setCurrent(null);
			}
		}

		//Achar os x maiores e setando as listas do quick para esses valores
		int valor = listas.size();
		if(requisicoes.size() < valor){
			valor = requisicoes.size();
		}
		for(int i = 0; i < valor; i ++){
			int maior = 0;
			int pos = -2;
			
			for(int j = 0; j < requisicoes.size(); j ++){
				if(requisicoes.get(j).getQtd() > maior){
					maior = requisicoes.get(j).getQtd();
					pos = j;
				}
			}
			listas.get(i).setTamanhoQuick(requisicoes.get(pos).getTamanho());
			requisicoes.remove(pos);
			
			//remover da lista generica quem nao pertence mais
		}
		for(int i = 0; i < listas.size(); i ++){
			System.out.println("Lista: " + i + " tamanho " + listas.get(i).getTamanhoQuick());
		}
		
		//atualizar os valores das listas do que esta na lista de espera
		for(int i = 0; i < listasEspera.length; i ++){
			for(int j = 0; j < listasEspera[i].getSize(); j ++){
				for(int k = 0; k < listas.size(); k ++){
					if(listasEspera[i].search(j).getProcess().getpTamanho() == listas.get(k).getTamanhoQuick() && !listasEspera[i].search(j).getProcess().isUsou()){
						listasEspera[i].search(j).getProcess().setLista(k);
					}
				}
			}
		}
		
		try{
			qU.interrupt();
		} catch(Exception e){
			
		}

		
		try{
			qU = new QuickFitUpdate(paineis, panel, l, listas, requisicoes, qtdAtual, lblNewLabel);
			qU.start();
		} catch(Exception e){
			
		}
		
		prosseguir = true;
		
		lblNewLabel.setText("<html>LG<br>");
		for(int i = 0 ; i< listas.size(); i ++){
			lblNewLabel.setText(lblNewLabel.getText() + "L" + i + ": " + listas.get(i).getTamanhoQuick()+"<br>");
		}
		lblNewLabel.setText(lblNewLabel.getText() + "</html>");
	}
}
