import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MainFrameUpdate2 extends Thread{
	JPanel painel1;
	JPanel painel2;
	JPanel painel3;
	JPanel painel4;
	ArrayList<JPanel> painelProcessos1 = new ArrayList<JPanel>();
	ArrayList<JPanel> painelProcessos2 = new ArrayList<JPanel>();
	ArrayList<JPanel> painelProcessos3 = new ArrayList<JPanel>();
	ArrayList<JPanel> painelProcessos4 = new ArrayList<JPanel>();
	
	ArrayList<JLabel> labelProcessos1 = new ArrayList<JLabel>();
	ArrayList<JLabel> labelProcessos2 = new ArrayList<JLabel>();
	ArrayList<JLabel> labelProcessos3 = new ArrayList<JLabel>();
	ArrayList<JLabel> labelProcessos4 = new ArrayList<JLabel>();

	
	private ListaMemoria l;
	private ListaMemoria[] lista;
	private ArrayList<Integer> contAuxiliares;
	
	public ListaMemoria[] getLista() {
		return lista;
	}

	public void setLista(ListaMemoria[] lista) {
		this.lista = lista;
	}

	int contAux = 0;
	
	int cont = 0;
	boolean coreLivre = false;
	
	int mAlgo;
	
	private Memoria m;
	private QuickFit q;
	
	public MainFrameUpdate2(JPanel painel1, JPanel painel2, JPanel painel3, JPanel painel4, ListaMemoria l, Memoria m, int mAlgo, QuickFit q){
		this.painel1 = painel1;
		this.painel2 = painel2;
		this.painel3 = painel3;
		this.painel4 = painel4;
		painel1.setLayout(new GridLayout(1, 20, 0, 0));
		painel2.setLayout(new GridLayout(1, 20, 0, 0));
		painel3.setLayout(new GridLayout(1, 20, 0, 0));
		painel4.setLayout(new GridLayout(1, 20, 0, 0));

		if(mAlgo == 1){
			contAuxiliares = new ArrayList<Integer>();
			for(int k = 0; k < q.getQtdListas(); k ++){
				contAuxiliares.add(k,0);
			}
			
			for(int i = 0; i < contAuxiliares.size(); i ++){
				System.out.println("lista auxiliar: " + contAuxiliares.get(i));
			}
		}
		
		this.m = m;
		this.q = q;
		
		this.mAlgo = mAlgo;
		
		this.l = l;
		
		//Painel processos 1
		for(int i = 0; i < 20; i ++) {
			JPanel aux = new JPanel();
			aux.setBackground(Color.WHITE);
			aux.setBorder(new LineBorder(new Color(0, 0, 0)));
			JLabel auxL = new JLabel();
			auxL.setForeground(Color.BLACK);
			labelProcessos1.add(auxL);
			aux.add(labelProcessos1.get(i));
			painelProcessos1.add(aux);
			painel1.add(painelProcessos1.get(i));
			painel1.repaint();
		}
		
		//Painel processos 2
				for(int i = 0; i < 20; i ++) {
					JPanel aux = new JPanel();
					aux.setBackground(Color.WHITE);
					aux.setBorder(new LineBorder(new Color(0, 0, 0)));
					JLabel auxL = new JLabel();
					auxL.setForeground(Color.BLACK);
					labelProcessos2.add(auxL);
					aux.add(labelProcessos2.get(i));
					painelProcessos2.add(aux);
					painel2.add(painelProcessos2.get(i));
					painel2.repaint();
				}
				
				//Painel processos 3
				for(int i = 0; i < 20; i ++) {
					JPanel aux = new JPanel();
					aux.setBackground(Color.WHITE);
					aux.setBorder(new LineBorder(new Color(0, 0, 0)));
					JLabel auxL = new JLabel();
					auxL.setForeground(Color.BLACK);
					labelProcessos3.add(auxL);
					aux.add(labelProcessos3.get(i));
					painelProcessos3.add(aux);
					painel3.add(painelProcessos3.get(i));
					painel3.repaint();
				}
				
				//Painel processos 4
				for(int i = 0; i < 20; i ++) {
					JPanel aux = new JPanel();
					aux.setBackground(Color.WHITE);
					aux.setBorder(new LineBorder(new Color(0, 0, 0)));
					JLabel auxL = new JLabel();
					auxL.setForeground(Color.BLACK);
					labelProcessos4.add(auxL);
					aux.add(labelProcessos4.get(i));
					painelProcessos4.add(aux);
					painel4.add(painelProcessos4.get(i));
					painel4.repaint();
			}
	}
	
	public Memoria getM() {
		return m;
	}

	public void setM(Memoria m) {
		this.m = m;
	}

	@Override
	public void run(){
		while(1 < 2){
			if(q != null && q.prosseguir){
			System.out.print("");
			//Prioridade 0
			for(int i = 0; i < GUI2.listas[0].getSize(); i ++){
				painelProcessos1.get(i).setBackground(GUI2.listas[0].search(i).getProcess().getC());
				labelProcessos1.get(i).setText("<html>ID: " + GUI2.listas[0].search(i).getProcess().getId()
						+ "<br>Q: " + GUI2.listas[0].search(i).getProcess().getQuantum() +"<br>TT: "+GUI2.listas[0].search(i).getProcess().getTotalTime()+
						"<br>TB: " + GUI2.listas[0].search(i).getProcess().getpTamanho()+"</html>");
			}
			
			for(int i = GUI2.listas[0].getSize(); i < 20; i ++){
				painelProcessos1.get(i).setBackground(Color.WHITE);
				labelProcessos1.get(i).setText("");
			}
			
			//Prioridade 1
			for(int i = 0; i < GUI2.listas[1].getSize(); i ++){
				painelProcessos2.get(i).setBackground(GUI2.listas[1].search(i).getProcess().getC());
				labelProcessos2.get(i).setText("<html>ID: " + GUI2.listas[1].search(i).getProcess().getId()
						+ "<br>Q: " + GUI2.listas[1].search(i).getProcess().getQuantum() +"<br>TT: "+GUI2.listas[1].search(i).getProcess().getTotalTime()+
						"<br>TB: " + GUI2.listas[1].search(i).getProcess().getpTamanho()+"</html>");
			}
			
			for(int i = GUI2.listas[1].getSize(); i < 20; i ++){
				painelProcessos2.get(i).setBackground(Color.WHITE);
				labelProcessos2.get(i).setText("");
			}
			
			//Prioridade 2
			for(int i = 0; i < GUI2.listas[2].getSize(); i ++){
				painelProcessos3.get(i).setBackground(GUI2.listas[2].search(i).getProcess().getC());
				labelProcessos3.get(i).setText("<html>ID: " + GUI2.listas[2].search(i).getProcess().getId()
						+ "<br>Q: " + GUI2.listas[2].search(i).getProcess().getQuantum() +"<br>TT: "+GUI2.listas[2].search(i).getProcess().getTotalTime()+
						"<br>TB: " + GUI2.listas[2].search(i).getProcess().getpTamanho()+"</html>");
			}
			
			for(int i = GUI2.listas[2].getSize(); i < 20; i ++){
				painelProcessos3.get(i).setBackground(Color.WHITE);
				labelProcessos3.get(i).setText("");
			}
			
			//Prioridade 3
			for(int i = 0; i < GUI2.listas[3].getSize(); i ++){
				painelProcessos4.get(i).setBackground(GUI2.listas[3].search(i).getProcess().getC());
				labelProcessos4.get(i).setText("<html>ID: " + GUI2.listas[3].search(i).getProcess().getId()
						+ "<br>Q: " + GUI2.listas[3].search(i).getProcess().getQuantum() +"<br>TT: "+GUI2.listas[3].search(i).getProcess().getTotalTime()+
						"<br>TB: " + GUI2.listas[3].search(i).getProcess().getpTamanho()+"</html>");
			}
			
			for(int i = GUI2.listas[3].getSize(); i < 20; i ++){
				painelProcessos4.get(i).setBackground(Color.WHITE);
				labelProcessos4.get(i).setText("");
			}
			
			//Cores
			for(int i = 0; i < GUI2.cores.size(); i ++){
				if(GUI2.cores.get(i).getCurrent() == null){
					GUI2.cores.get(i).getPanel().setBackground(Color.WHITE);
					GUI2.cores.get(i).getPanel().setForeground(Color.BLACK);
					GUI2.cores.get(i).getTexto().setText("<html>ID: " + GUI2.cores.get(i).getId() + "<br>P: " + GUI2.cores.get(i).getCurrent() + "<br>TR: " + "<br>Q: <br>E: <br>TB: ");
				} else {
					GUI2.cores.get(i).getPanel().setBackground(GUI2.cores.get(i).getCurrent().getC());
					GUI2.cores.get(i).getPanel().setForeground(Color.BLACK);
					GUI2.cores.get(i).getTexto().setText("<html>ID: " + GUI2.cores.get(i).getId() + "<br>P: " + GUI2.cores.get(i).getCurrent().getId() + "<br>TR: " + GUI2.cores.get(i).getCurrent().getTimeLeft() +  "<br>Q: " + GUI2.cores.get(i).getCurrent().getQuantum() + "<br>E: "+ GUI2.cores.get(i).getCurrent().getFeito() + "<br>TB: " + GUI2.cores.get(i).getCurrent().getpTamanho());
				}
			}
			
			for(int i = 0; i < GUI2.cores.size(); i ++){
				if(GUI2.cores.get(i).getCurrent() == null){
					coreLivre = true;
					break;
				}
			}
			
			for(int i =0; i < GUI2.cores.size(); i ++){ 
				
				if(GUI2.cores.get(i).getCurrent() == null && !GUI2.listas[cont].isEmpty()) {
					GUI2.cores.get(i).setCurrent(GUI2.listas[cont].search(0).getProcess());
					if(mAlgo == 2){
						if(!GUI2.cores.get(i).getCurrent().isUsou() && !l.cheio(GUI2.cores.get(i).getCurrent().getpTamanho()) && GUI2.cores.get(i).getCurrent() != null){
							Bloco b = new Bloco(GUI2.cores.get(i).getCurrent().getpTamanho(), GUI2.cores.get(i).getCurrent().getpTamanho(), contAux, true);
							b.setUsado(true);
							b.setProcesso(GUI2.cores.get(i).getCurrent());
							l.adicionar(b);
							l.setTamanhoUsado(l.getTamanhoUsado() + b.getTamanho());
							m.novo(b);
							GUI2.cores.get(i).getCurrent().setBloco(b.getId());
							m.getPanel().revalidate();
							m.getPanel().repaint();
							contAux++;
							GUI2.cores.get(i).getCurrent().setUsou(true);
						} else {
							if(GUI2.cores.get(i).getCurrent().getBloco() == -1){
								if(l.fitPos(GUI2.cores.get(i).getCurrent()) != 1234){
									
									GUI2.cores.get(i).getCurrent().setBloco(l.search(l.fitPos(GUI2.cores.get(i).getCurrent())).getId());
									l.search(GUI2.cores.get(i).getCurrent().getBloco()).setTamanhoUsado(GUI2.cores.get(i).getCurrent().getpTamanho());
									l.search(GUI2.cores.get(i).getCurrent().getBloco()).setUsado(true);
									l.search(GUI2.cores.get(i).getCurrent().getBloco()).setProcesso(GUI2.cores.get(i).getCurrent());
									System.out.println("Bloco " + GUI2.cores.get(i).getCurrent().getBloco());
								} else {
									System.out.println("Abortado");
									GUI2.cores.get(i).setCurrent(null);
								}
							} else {
								l.search(GUI2.cores.get(i).getCurrent().getBloco()).setTamanhoUsado(GUI2.cores.get(i).getCurrent().getpTamanho());
								l.search(GUI2.cores.get(i).getCurrent().getBloco()).setUsado(true);
							}
							
						}
					} else {
						if(mAlgo == 0){
							//Merge fit
							if(l.getSize() < 1 && !GUI2.cores.get(i).getCurrent().isUsou()){
								Bloco b = new Bloco(l.getTamanhoTotal(),0,0,false);
								b.setProcesso(GUI2.cores.get(i).getCurrent());
								b.setUsado(true);
								l.adicionar(b);
								l.setTamanhoUsado(0);
								m.novo(b);
								m.getPanel().revalidate();
								m.getPanel().repaint();
								l.split(0, GUI2.cores.get(i).getCurrent().getpTamanho(), m, GUI2.cores.get(i).getCurrent());
								GUI2.cores.get(i).getCurrent().setUsou(true);
								GUI2.cores.get(i).getCurrent().setBloco(b.getId());
							} else {
								if(GUI2.cores.get(i).getCurrent().getBloco() == -1){
									if(!l.cheio(GUI2.cores.get(i).getCurrent().getpTamanho())){
										if(l.fitPos(GUI2.cores.get(i).getCurrent()) != 1234 && !GUI2.cores.get(i).getCurrent().isUsou()){
											System.out.println("ta aqui");
											l.split(l.fitPos(GUI2.cores.get(i).getCurrent()), GUI2.cores.get(i).getCurrent().getpTamanho(), m, GUI2.cores.get(i).getCurrent());
											GUI2.cores.get(i).getCurrent().setUsou(true);
											l.search(l.fitPos(GUI2.cores.get(i).getCurrent())).setUsado(true);
										} else {
											if(l.fitPos(GUI2.cores.get(i).getCurrent()) == 1234){
												System.out.println("Abortado");
												GUI2.cores.get(i).setCurrent(null);
											}
										}
									} 
								} else {
									System.out.println("entra aonde tem ai");
								}
							}
						} else {
							//Quick Fit
								System.out.println("Lista: " + GUI2.cores.get(i).getCurrent().getLista());
								if(q.getQtdAtual() >= q.getQtdReq() && !GUI2.cores.get(i).getCurrent().isUsou()){
									q.prosseguir = false;
									System.out.println("Fazer estatistica");
									q.fazerEstatistica(GUI2.cores, GUI2.listas, this);
									while(!q.prosseguir) {
										System.out.println("Ta parado");
									}
									q.setQtdAtual(0);
								}
								if(q.prosseguir && GUI2.cores.get(i).getCurrent() != null){
									if(GUI2.cores.get(i).getCurrent().getLista() == -1){
										if(!GUI2.cores.get(i).getCurrent().isUsou() && !l.cheio(GUI2.cores.get(i).getCurrent().getpTamanho()) && GUI2.cores.get(i).getCurrent() != null){
											if(mAlgo == 1){
											
											Bloco b = new Bloco(GUI2.cores.get(i).getCurrent().getpTamanho(), GUI2.cores.get(i).getCurrent().getpTamanho(), contAux, true);
											b.setUsado(true);
											b.setProcesso(GUI2.cores.get(i).getCurrent());
											l.adicionar(b);
											l.setTamanhoUsado(l.getTamanhoUsado() + b.getTamanho());
											q.novo(b);
											GUI2.cores.get(i).getCurrent().setBloco(b.getId());
											q.getPanel().revalidate();
											q.getPanel().repaint();
											contAux++;
											GUI2.cores.get(i).getCurrent().setUsou(true);
											boolean achou = false;
											int pos = 0;
											for(int k = 0; k < q.getRequisicoes().size(); k ++){
												if(GUI2.cores.get(i).getCurrent().getpTamanho() == q.getRequisicoes().get(k).getTamanho()){
													pos = k;
													achou = true;
												}
											}
											if(!achou){
												q.getRequisicoes().add(new Requisicoes(GUI2.cores.get(i).getCurrent().getpTamanho(), 1));
											} else {
												q.getRequisicoes().get(pos).setQtd(q.getRequisicoes().get(pos).getQtd() + 1);
											}
											
											
											q.setQtdAtual(q.getQtdAtual() + 1);
											System.out.println(q.getQtdAtual());
											for(int k = 0; k < q.getRequisicoes().size(); k ++){
												System.out.println(q.getRequisicoes().get(k).getTamanho() + " " + q.getRequisicoes().get(k).getQtd());
											}
										} else {
											if(q.getQtdAtual() >= q.getQtdReq() && !GUI2.cores.get(i).getCurrent().isUsou()){
												q.prosseguir = false;
												System.out.println("Fazer estatistica");
												q.fazerEstatistica(GUI2.cores, GUI2.listas, this);
												while(!q.prosseguir) {
													System.out.println("Ta parado");
												}
												q.setQtdAtual(0);
											}
											if(GUI2.cores.get(i).getCurrent().getBloco() == -1){
												if(l.firstFit(GUI2.cores.get(i).getCurrent()) != 1234){
													
													GUI2.cores.get(i).getCurrent().setBloco(l.search(l.firstFit(GUI2.cores.get(i).getCurrent())).getId());
													l.search(GUI2.cores.get(i).getCurrent().getBloco()).setTamanhoUsado(GUI2.cores.get(i).getCurrent().getpTamanho());
													l.search(GUI2.cores.get(i).getCurrent().getBloco()).setUsado(true);
													l.search(GUI2.cores.get(i).getCurrent().getBloco()).setProcesso(GUI2.cores.get(i).getCurrent());
													System.out.println("Bloco " + GUI2.cores.get(i).getCurrent().getBloco());
													boolean achou = false;
													int pos = 0;
													for(int k = 0; k < q.getRequisicoes().size(); k ++){
														if(GUI2.cores.get(i).getCurrent().getpTamanho() == q.getRequisicoes().get(k).getTamanho()){
															pos = k;
															achou = true;
														}
													}
													if(!achou){
														q.getRequisicoes().add(new Requisicoes(GUI2.cores.get(i).getCurrent().getpTamanho(), 1));
													} else {
														q.getRequisicoes().get(pos).setQtd(q.getRequisicoes().get(pos).getQtd() + 1);
													}
													
													q.setQtdAtual(q.getQtdAtual() + 1);
													System.out.println(q.getQtdAtual());
													for(int k = 0; k < q.getRequisicoes().size(); k ++){
														System.out.println(q.getRequisicoes().get(k).getTamanho() + " " + q.getRequisicoes().get(k).getQtd());
													}
												} else {
													System.out.println("Abortado");
													GUI2.cores.get(i).setCurrent(null);
												}
											} else {
												l.search(GUI2.cores.get(i).getCurrent().getBloco()).setTamanhoUsado(GUI2.cores.get(i).getCurrent().getpTamanho());
												l.search(GUI2.cores.get(i).getCurrent().getBloco()).setUsado(true);
											}
											
										}
									}
								} else {
									System.out.println(GUI2.cores.get(i).getCurrent().isUsou());
									//Inserção caso ele tenha que entrar em alguma das outras listas
									if(!GUI2.cores.get(i).getCurrent().isUsou() && !q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).cheio(GUI2.cores.get(i).getCurrent().getpTamanho()) && GUI2.cores.get(i).getCurrent() != null){
										
										if(mAlgo == 1){
										System.out.println("teste moises");
										Bloco b = new Bloco(GUI2.cores.get(i).getCurrent().getpTamanho(), GUI2.cores.get(i).getCurrent().getpTamanho(), contAuxiliares.get(GUI2.cores.get(i).getCurrent().getLista()), true);
										b.setUsado(true);
										b.setProcesso(GUI2.cores.get(i).getCurrent());
										q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).adicionar(b);
										q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).setTamanhoUsado(q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).getTamanhoUsado() + b.getTamanho());
										q.novoBlocoLista(b, GUI2.cores.get(i).getCurrent().getLista());
										GUI2.cores.get(i).getCurrent().setBloco(b.getId());
										q.getPanel().revalidate();
										q.getPanel().repaint();
										contAuxiliares.set(GUI2.cores.get(i).getCurrent().getLista(), contAuxiliares.get(GUI2.cores.get(i).getCurrent().getLista()) + 1);
										GUI2.cores.get(i).getCurrent().setUsou(true);
										boolean achou = false;
										int pos = 0;
										for(int k = 0; k < q.getRequisicoes().size(); k ++){
											if(GUI2.cores.get(i).getCurrent().getpTamanho() == q.getRequisicoes().get(k).getTamanho()){
												pos = k;
												achou = true;
											}
										}
										if(!achou){
											q.getRequisicoes().add(new Requisicoes(GUI2.cores.get(i).getCurrent().getpTamanho(), 1));
										} else {
											q.getRequisicoes().get(pos).setQtd(q.getRequisicoes().get(pos).getQtd() + 1);
										}
										
										
										q.setQtdAtual(q.getQtdAtual() + 1);
										System.out.println(q.getQtdAtual());
										for(int k = 0; k < q.getRequisicoes().size(); k ++){
											System.out.println(q.getRequisicoes().get(k).getTamanho() + " " + q.getRequisicoes().get(k).getQtd());
										}
									} else {
										if(q.getQtdAtual() >= q.getQtdReq() && !GUI2.cores.get(i).getCurrent().isUsou()){
											
											System.out.println("Fazer estatistica");
											q.fazerEstatistica(GUI2.cores, GUI2.listas, this);
											q.setQtdAtual(0);
										}
										if(GUI2.cores.get(i).getCurrent().getBloco() == -1){
											if(q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).firstFit(GUI2.cores.get(i).getCurrent()) != 1234){
												
												GUI2.cores.get(i).getCurrent().setBloco(q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).search(q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).firstFit(GUI2.cores.get(i).getCurrent())).getId());
												q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).search(GUI2.cores.get(i).getCurrent().getBloco()).setTamanhoUsado(GUI2.cores.get(i).getCurrent().getpTamanho());
												q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).search(GUI2.cores.get(i).getCurrent().getBloco()).setUsado(true);
												q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).search(GUI2.cores.get(i).getCurrent().getBloco()).setProcesso(GUI2.cores.get(i).getCurrent());
												System.out.println("Bloco " + GUI2.cores.get(i).getCurrent().getBloco());
												boolean achou = false;
												int pos = 0;
												for(int k = 0; k < q.getRequisicoes().size(); k ++){
													if(GUI2.cores.get(i).getCurrent().getpTamanho() == q.getRequisicoes().get(k).getTamanho()){
														pos = k;
														achou = true;
													}
												}
												if(!achou){
													q.getRequisicoes().add(new Requisicoes(GUI2.cores.get(i).getCurrent().getpTamanho(), 1));
												} else {
													q.getRequisicoes().get(pos).setQtd(q.getRequisicoes().get(pos).getQtd() + 1);
												}
												
												q.setQtdAtual(q.getQtdAtual() + 1);
												System.out.println(q.getQtdAtual());
												for(int k = 0; k < q.getRequisicoes().size(); k ++){
													System.out.println(q.getRequisicoes().get(k).getTamanho() + " " + q.getRequisicoes().get(k).getQtd());
												}
											} else {
												System.out.println("Abortado");
												GUI2.cores.get(i).setCurrent(null);
											}
										} else {
											q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).search(GUI2.cores.get(i).getCurrent().getBloco()).setTamanhoUsado(GUI2.cores.get(i).getCurrent().getpTamanho());
											q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).search(GUI2.cores.get(i).getCurrent().getBloco()).setUsado(true);
										}
										
									}
								}
								}
								}
						}
					}
					GUI2.listas[cont].removeFirst();
					cont++;
					if(cont > 3){
						cont = 0;
					}
				}

				if(GUI2.cores.get(i).getCurrent() == null){
					cont++;
					if(cont > 3){
						cont = 0;
					}
				}
				if(GUI2.cores.get(i).getCurrent()!= null){
					if(GUI2.cores.get(i).getCurrent().getFeito() >= GUI2.cores.get(i).getCurrent().getQuantum() ){
						
						GUI2.cores.get(i).getCurrent().setFeito(0);
						GUI2.cores.get(i).getCurrent().setTotalTime(GUI2.cores.get(i).getCurrent().getTimeLeft());
						if(GUI2.cores.get(i).getCurrent().getPriority() == 0)GUI2.listas[0].enqueue(GUI2.cores.get(i).getCurrent());
						if(GUI2.cores.get(i).getCurrent().getPriority() == 1)GUI2.listas[1].enqueue(GUI2.cores.get(i).getCurrent());
						if(GUI2.cores.get(i).getCurrent().getPriority() == 2)GUI2.listas[2].enqueue(GUI2.cores.get(i).getCurrent());
						if(GUI2.cores.get(i).getCurrent().getPriority() == 3)GUI2.listas[3].enqueue(GUI2.cores.get(i).getCurrent());
						
						GUI2.cores.get(i).setCurrent(null);
					}
				}
			}
			
			if(cont == 0){
				GUI2.separator.setForeground(Color.RED);
				GUI2.separator_1.setForeground(Color.BLACK);
				GUI2.separator_2.setForeground(Color.BLACK);
				GUI2.separator_3.setForeground(Color.BLACK);
			} else {
				if(cont == 1){
					GUI2.separator_1.setForeground(Color.RED);
					GUI2.separator.setForeground(Color.BLACK);
					GUI2.separator_2.setForeground(Color.BLACK);
					GUI2.separator_3.setForeground(Color.BLACK);
				} else {
					if(cont == 2){
						GUI2.separator_2.setForeground(Color.RED);
						GUI2.separator_1.setForeground(Color.BLACK);
						GUI2.separator.setForeground(Color.BLACK);
						GUI2.separator_3.setForeground(Color.BLACK);
					} else {
						if(cont == 3){
							GUI2.separator_3.setForeground(Color.RED);
							GUI2.separator_1.setForeground(Color.BLACK);
							GUI2.separator_2.setForeground(Color.BLACK);
							GUI2.separator.setForeground(Color.BLACK);
						}
					}
				}
			}
		} else {
			if(mAlgo != 1){
				System.out.print("");
				//Prioridade 0
				for(int i = 0; i < GUI2.listas[0].getSize(); i ++){
					painelProcessos1.get(i).setBackground(GUI2.listas[0].search(i).getProcess().getC());
					labelProcessos1.get(i).setText("<html>ID: " + GUI2.listas[0].search(i).getProcess().getId()
							+ "<br>Q: " + GUI2.listas[0].search(i).getProcess().getQuantum() +"<br>TT: "+GUI2.listas[0].search(i).getProcess().getTotalTime()+
							"<br>TB: " + GUI2.listas[0].search(i).getProcess().getpTamanho()+"</html>");
				}
				
				for(int i = GUI2.listas[0].getSize(); i < 20; i ++){
					painelProcessos1.get(i).setBackground(Color.WHITE);
					labelProcessos1.get(i).setText("");
				}
				
				//Prioridade 1
				for(int i = 0; i < GUI2.listas[1].getSize(); i ++){
					painelProcessos2.get(i).setBackground(GUI2.listas[1].search(i).getProcess().getC());
					labelProcessos2.get(i).setText("<html>ID: " + GUI2.listas[1].search(i).getProcess().getId()
							+ "<br>Q: " + GUI2.listas[1].search(i).getProcess().getQuantum() +"<br>TT: "+GUI2.listas[1].search(i).getProcess().getTotalTime()+
							"<br>TB: " + GUI2.listas[1].search(i).getProcess().getpTamanho()+"</html>");
				}
				
				for(int i = GUI2.listas[1].getSize(); i < 20; i ++){
					painelProcessos2.get(i).setBackground(Color.WHITE);
					labelProcessos2.get(i).setText("");
				}
				
				//Prioridade 2
				for(int i = 0; i < GUI2.listas[2].getSize(); i ++){
					painelProcessos3.get(i).setBackground(GUI2.listas[2].search(i).getProcess().getC());
					labelProcessos3.get(i).setText("<html>ID: " + GUI2.listas[2].search(i).getProcess().getId()
							+ "<br>Q: " + GUI2.listas[2].search(i).getProcess().getQuantum() +"<br>TT: "+GUI2.listas[2].search(i).getProcess().getTotalTime()+
							"<br>TB: " + GUI2.listas[2].search(i).getProcess().getpTamanho()+"</html>");
				}
				
				for(int i = GUI2.listas[2].getSize(); i < 20; i ++){
					painelProcessos3.get(i).setBackground(Color.WHITE);
					labelProcessos3.get(i).setText("");
				}
				
				//Prioridade 3
				for(int i = 0; i < GUI2.listas[3].getSize(); i ++){
					painelProcessos4.get(i).setBackground(GUI2.listas[3].search(i).getProcess().getC());
					labelProcessos4.get(i).setText("<html>ID: " + GUI2.listas[3].search(i).getProcess().getId()
							+ "<br>Q: " + GUI2.listas[3].search(i).getProcess().getQuantum() +"<br>TT: "+GUI2.listas[3].search(i).getProcess().getTotalTime()+
							"<br>TB: " + GUI2.listas[3].search(i).getProcess().getpTamanho()+"</html>");
				}
				
				for(int i = GUI2.listas[3].getSize(); i < 20; i ++){
					painelProcessos4.get(i).setBackground(Color.WHITE);
					labelProcessos4.get(i).setText("");
				}
				
				//Cores
				for(int i = 0; i < GUI2.cores.size(); i ++){
					if(GUI2.cores.get(i).getCurrent() == null){
						GUI2.cores.get(i).getPanel().setBackground(Color.WHITE);
						GUI2.cores.get(i).getPanel().setForeground(Color.BLACK);
						GUI2.cores.get(i).getTexto().setText("<html>ID: " + GUI2.cores.get(i).getId() + "<br>P: " + GUI2.cores.get(i).getCurrent() + "<br>TR: " + "<br>Q: <br>E: <br>TB: ");
					} else {
						GUI2.cores.get(i).getPanel().setBackground(GUI2.cores.get(i).getCurrent().getC());
						GUI2.cores.get(i).getPanel().setForeground(Color.BLACK);
						if(GUI2.cores.get(i) != null)GUI2.cores.get(i).getTexto().setText("<html>ID: " + GUI2.cores.get(i).getId() + "<br>P: " + GUI2.cores.get(i).getCurrent().getId() + "<br>TR: " + GUI2.cores.get(i).getCurrent().getTimeLeft() +  "<br>Q: " + GUI2.cores.get(i).getCurrent().getQuantum() + "<br>E: "+ GUI2.cores.get(i).getCurrent().getFeito() + "<br>TB: " + GUI2.cores.get(i).getCurrent().getpTamanho());
					}
				}
				
				for(int i = 0; i < GUI2.cores.size(); i ++){
					if(GUI2.cores.get(i).getCurrent() == null){
						coreLivre = true;
						break;
					}
				}
				
				for(int i =0; i < GUI2.cores.size(); i ++){
					if(GUI2.cores.get(i).getCurrent() == null && !GUI2.listas[cont].isEmpty()) {
						GUI2.cores.get(i).setCurrent(GUI2.listas[cont].search(0).getProcess());
						if(mAlgo == 2){
							if(!GUI2.cores.get(i).getCurrent().isUsou() && !l.cheio(GUI2.cores.get(i).getCurrent().getpTamanho()) && GUI2.cores.get(i).getCurrent() != null){
								Bloco b = new Bloco(GUI2.cores.get(i).getCurrent().getpTamanho(), GUI2.cores.get(i).getCurrent().getpTamanho(), contAux, true);
								b.setUsado(true);
								b.setProcesso(GUI2.cores.get(i).getCurrent());
								l.adicionar(b);
								l.setTamanhoUsado(l.getTamanhoUsado() + b.getTamanho());
								m.novo(b);
								GUI2.cores.get(i).getCurrent().setBloco(b.getId());
								m.getPanel().revalidate();
								m.getPanel().repaint();
								contAux++;
								GUI2.cores.get(i).getCurrent().setUsou(true);
							} else {
								if(GUI2.cores.get(i).getCurrent().getBloco() == -1){
									if(l.fitPos(GUI2.cores.get(i).getCurrent()) != 1234){
										
										GUI2.cores.get(i).getCurrent().setBloco(l.search(l.fitPos(GUI2.cores.get(i).getCurrent())).getId());
										l.search(GUI2.cores.get(i).getCurrent().getBloco()).setTamanhoUsado(GUI2.cores.get(i).getCurrent().getpTamanho());
										l.search(GUI2.cores.get(i).getCurrent().getBloco()).setUsado(true);
										l.search(GUI2.cores.get(i).getCurrent().getBloco()).setProcesso(GUI2.cores.get(i).getCurrent());
										System.out.println("Bloco " + GUI2.cores.get(i).getCurrent().getBloco());
									} else {
										System.out.println("Abortado");
										GUI2.cores.get(i).setCurrent(null);
									}
								} else {
									l.search(GUI2.cores.get(i).getCurrent().getBloco()).setTamanhoUsado(GUI2.cores.get(i).getCurrent().getpTamanho());
									l.search(GUI2.cores.get(i).getCurrent().getBloco()).setUsado(true);
								}
								
							}
						} else {
							if(mAlgo == 0){
								//Merge fit
								if(l.getSize() < 1 && !GUI2.cores.get(i).getCurrent().isUsou()){
									Bloco b = new Bloco(l.getTamanhoTotal(),0,0,false);
									b.setProcesso(GUI2.cores.get(i).getCurrent());
									b.setUsado(true);
									l.adicionar(b);
									l.setTamanhoUsado(0);
									m.novo(b);
									m.getPanel().revalidate();
									m.getPanel().repaint();
									l.split(0, GUI2.cores.get(i).getCurrent().getpTamanho(), m, GUI2.cores.get(i).getCurrent());
									GUI2.cores.get(i).getCurrent().setUsou(true);
									GUI2.cores.get(i).getCurrent().setBloco(b.getId());
								} else {
									if(GUI2.cores.get(i).getCurrent().getBloco() == -1){
										if(!l.cheio(GUI2.cores.get(i).getCurrent().getpTamanho())){
											if(l.fitPos(GUI2.cores.get(i).getCurrent()) != 1234 && !GUI2.cores.get(i).getCurrent().isUsou()){
												System.out.println("ta aqui");
												l.split(l.fitPos(GUI2.cores.get(i).getCurrent()), GUI2.cores.get(i).getCurrent().getpTamanho(), m, GUI2.cores.get(i).getCurrent());
												GUI2.cores.get(i).getCurrent().setUsou(true);
												l.search(l.fitPos(GUI2.cores.get(i).getCurrent())).setUsado(true);
											} else {
												if(l.fitPos(GUI2.cores.get(i).getCurrent()) == 1234){
													System.out.println("Abortado");
													GUI2.cores.get(i).setCurrent(null);
												}
											}
										} 
									} else {
										System.out.println("entra aonde tem ai");
									}
								}
							} else {
								//Quick Fit
									System.out.println("Lista: " + GUI2.cores.get(i).getCurrent().getLista());
									if(q.getQtdAtual() >= q.getQtdReq() && !GUI2.cores.get(i).getCurrent().isUsou()){
										q.prosseguir = false;
										System.out.println("Fazer estatistica");
										q.fazerEstatistica(GUI2.cores, GUI2.listas, this);
										while(!q.prosseguir) {
											System.out.println("Ta parado");
										}
										q.setQtdAtual(0);
									}
									if(q.prosseguir && GUI2.cores.get(i).getCurrent() != null){
										if(GUI2.cores.get(i).getCurrent().getLista() == -1){
											if(!GUI2.cores.get(i).getCurrent().isUsou() && !l.cheio(GUI2.cores.get(i).getCurrent().getpTamanho()) && GUI2.cores.get(i).getCurrent() != null){
												if(mAlgo == 1){
												
												Bloco b = new Bloco(GUI2.cores.get(i).getCurrent().getpTamanho(), GUI2.cores.get(i).getCurrent().getpTamanho(), contAux, true);
												b.setUsado(true);
												b.setProcesso(GUI2.cores.get(i).getCurrent());
												l.adicionar(b);
												l.setTamanhoUsado(l.getTamanhoUsado() + b.getTamanho());
												q.novo(b);
												GUI2.cores.get(i).getCurrent().setBloco(b.getId());
												q.getPanel().revalidate();
												q.getPanel().repaint();
												contAux++;
												GUI2.cores.get(i).getCurrent().setUsou(true);
												boolean achou = false;
												int pos = 0;
												for(int k = 0; k < q.getRequisicoes().size(); k ++){
													if(GUI2.cores.get(i).getCurrent().getpTamanho() == q.getRequisicoes().get(k).getTamanho()){
														pos = k;
														achou = true;
													}
												}
												if(!achou){
													q.getRequisicoes().add(new Requisicoes(GUI2.cores.get(i).getCurrent().getpTamanho(), 1));
												} else {
													q.getRequisicoes().get(pos).setQtd(q.getRequisicoes().get(pos).getQtd() + 1);
												}
												
												
												q.setQtdAtual(q.getQtdAtual() + 1);
												System.out.println(q.getQtdAtual());
												for(int k = 0; k < q.getRequisicoes().size(); k ++){
													System.out.println(q.getRequisicoes().get(k).getTamanho() + " " + q.getRequisicoes().get(k).getQtd());
												}
											} else {
												if(q.getQtdAtual() >= q.getQtdReq() && !GUI2.cores.get(i).getCurrent().isUsou()){
													q.prosseguir = false;
													System.out.println("Fazer estatistica");
													q.fazerEstatistica(GUI2.cores, GUI2.listas, this);
													while(!q.prosseguir) {
														System.out.println("Ta parado");
													}
													q.setQtdAtual(0);
												}
												if(GUI2.cores.get(i).getCurrent().getBloco() == -1){
													if(l.firstFit(GUI2.cores.get(i).getCurrent()) != 1234){
														
														GUI2.cores.get(i).getCurrent().setBloco(l.search(l.firstFit(GUI2.cores.get(i).getCurrent())).getId());
														l.search(GUI2.cores.get(i).getCurrent().getBloco()).setTamanhoUsado(GUI2.cores.get(i).getCurrent().getpTamanho());
														l.search(GUI2.cores.get(i).getCurrent().getBloco()).setUsado(true);
														l.search(GUI2.cores.get(i).getCurrent().getBloco()).setProcesso(GUI2.cores.get(i).getCurrent());
														System.out.println("Bloco " + GUI2.cores.get(i).getCurrent().getBloco());
														boolean achou = false;
														int pos = 0;
														for(int k = 0; k < q.getRequisicoes().size(); k ++){
															if(GUI2.cores.get(i).getCurrent().getpTamanho() == q.getRequisicoes().get(k).getTamanho()){
																pos = k;
																achou = true;
															}
														}
														if(!achou){
															q.getRequisicoes().add(new Requisicoes(GUI2.cores.get(i).getCurrent().getpTamanho(), 1));
														} else {
															q.getRequisicoes().get(pos).setQtd(q.getRequisicoes().get(pos).getQtd() + 1);
														}
														
														q.setQtdAtual(q.getQtdAtual() + 1);
														System.out.println(q.getQtdAtual());
														for(int k = 0; k < q.getRequisicoes().size(); k ++){
															System.out.println(q.getRequisicoes().get(k).getTamanho() + " " + q.getRequisicoes().get(k).getQtd());
														}
													} else {
														System.out.println("Abortado");
														GUI2.cores.get(i).setCurrent(null);
													}
												} else {
													l.search(GUI2.cores.get(i).getCurrent().getBloco()).setTamanhoUsado(GUI2.cores.get(i).getCurrent().getpTamanho());
													l.search(GUI2.cores.get(i).getCurrent().getBloco()).setUsado(true);
												}
												
											}
										}
									} else {
										System.out.println("Arriba :" + GUI2.cores.get(i).getCurrent().isUsou());
										//Inserção caso ele tenha que entrar em alguma das outras listas
										if(!GUI2.cores.get(i).getCurrent().isUsou() && !q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).cheio(GUI2.cores.get(i).getCurrent().getpTamanho()) && GUI2.cores.get(i).getCurrent() != null){
											if(mAlgo == 1){
											
												System.out.println("Lista que vai entrar: " +  contAuxiliares.get(GUI2.cores.get(i).getCurrent().getLista()));
											Bloco b = new Bloco(GUI2.cores.get(i).getCurrent().getpTamanho(), GUI2.cores.get(i).getCurrent().getpTamanho(), contAuxiliares.get(GUI2.cores.get(i).getCurrent().getLista()), true);
											b.setUsado(true);
											b.setProcesso(GUI2.cores.get(i).getCurrent());
											q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).adicionar(b);
											q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).setTamanhoUsado(q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).getTamanhoUsado() + b.getTamanho());
											q.novoBlocoLista(b, GUI2.cores.get(i).getCurrent().getLista());
											GUI2.cores.get(i).getCurrent().setBloco(b.getId());
											q.getPanel().revalidate();
											q.getPanel().repaint();
											contAuxiliares.set(GUI2.cores.get(i).getCurrent().getLista(), contAuxiliares.get(GUI2.cores.get(i).getCurrent().getLista()) + 1);
											GUI2.cores.get(i).getCurrent().setUsou(true);
											boolean achou = false;
											int pos = 0;
											for(int k = 0; k < q.getRequisicoes().size(); k ++){
												if(GUI2.cores.get(i).getCurrent().getpTamanho() == q.getRequisicoes().get(k).getTamanho()){
													pos = k;
													achou = true;
												}
											}
											if(!achou){
												q.getRequisicoes().add(new Requisicoes(GUI2.cores.get(i).getCurrent().getpTamanho(), 1));
											} else {
												q.getRequisicoes().get(pos).setQtd(q.getRequisicoes().get(pos).getQtd() + 1);
											}
											
											
											q.setQtdAtual(q.getQtdAtual() + 1);
											System.out.println(q.getQtdAtual());
											for(int k = 0; k < q.getRequisicoes().size(); k ++){
												System.out.println(q.getRequisicoes().get(k).getTamanho() + " " + q.getRequisicoes().get(k).getQtd());
											}
										} else {
											if(q.getQtdAtual() >= q.getQtdReq() && !GUI2.cores.get(i).getCurrent().isUsou()){
												
												System.out.println("Fazer estatistica");
												q.fazerEstatistica(GUI2.cores, GUI2.listas, this);
												q.setQtdAtual(0);
											}
											if(GUI2.cores.get(i).getCurrent().getBloco() == -1){
												if(q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).firstFit(GUI2.cores.get(i).getCurrent()) != 1234){
													
													GUI2.cores.get(i).getCurrent().setBloco(q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).search(q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).firstFit(GUI2.cores.get(i).getCurrent())).getId());
													q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).search(GUI2.cores.get(i).getCurrent().getBloco()).setTamanhoUsado(GUI2.cores.get(i).getCurrent().getpTamanho());
													q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).search(GUI2.cores.get(i).getCurrent().getBloco()).setUsado(true);
													q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).search(GUI2.cores.get(i).getCurrent().getBloco()).setProcesso(GUI2.cores.get(i).getCurrent());
													System.out.println("Bloco " + GUI2.cores.get(i).getCurrent().getBloco());
													boolean achou = false;
													int pos = 0;
													for(int k = 0; k < q.getRequisicoes().size(); k ++){
														if(GUI2.cores.get(i).getCurrent().getpTamanho() == q.getRequisicoes().get(k).getTamanho()){
															pos = k;
															achou = true;
														}
													}
													if(!achou){
														q.getRequisicoes().add(new Requisicoes(GUI2.cores.get(i).getCurrent().getpTamanho(), 1));
													} else {
														q.getRequisicoes().get(pos).setQtd(q.getRequisicoes().get(pos).getQtd() + 1);
													}
													
													q.setQtdAtual(q.getQtdAtual() + 1);
													System.out.println(q.getQtdAtual());
													for(int k = 0; k < q.getRequisicoes().size(); k ++){
														System.out.println(q.getRequisicoes().get(k).getTamanho() + " " + q.getRequisicoes().get(k).getQtd());
													}
												} else {
													System.out.println("Abortado");
													GUI2.cores.get(i).setCurrent(null);
												}
											} else {
												q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).search(GUI2.cores.get(i).getCurrent().getBloco()).setTamanhoUsado(GUI2.cores.get(i).getCurrent().getpTamanho());
												q.getListas().get(GUI2.cores.get(i).getCurrent().getLista()).search(GUI2.cores.get(i).getCurrent().getBloco()).setUsado(true);
											}
											
										}
									}
									}
									}
							}
						}
						GUI2.listas[cont].removeFirst();
						cont++;
						if(cont > 3){
							cont = 0;
						}
					}

					if(GUI2.cores.get(i).getCurrent() == null){
						cont++;
						if(cont > 3){
							cont = 0;
						}
					}
					if(GUI2.cores.get(i).getCurrent()!= null){
						if(GUI2.cores.get(i).getCurrent().getFeito() >= GUI2.cores.get(i).getCurrent().getQuantum() ){
							
							GUI2.cores.get(i).getCurrent().setFeito(0);
							GUI2.cores.get(i).getCurrent().setTotalTime(GUI2.cores.get(i).getCurrent().getTimeLeft());
							if(GUI2.cores.get(i).getCurrent().getPriority() == 0)GUI2.listas[0].enqueue(GUI2.cores.get(i).getCurrent());
							if(GUI2.cores.get(i).getCurrent().getPriority() == 1)GUI2.listas[1].enqueue(GUI2.cores.get(i).getCurrent());
							if(GUI2.cores.get(i).getCurrent().getPriority() == 2)GUI2.listas[2].enqueue(GUI2.cores.get(i).getCurrent());
							if(GUI2.cores.get(i).getCurrent().getPriority() == 3)GUI2.listas[3].enqueue(GUI2.cores.get(i).getCurrent());
							
							GUI2.cores.get(i).setCurrent(null);
						}
					}
				}
				
				if(cont == 0){
					GUI2.separator.setForeground(Color.RED);
					GUI2.separator_1.setForeground(Color.BLACK);
					GUI2.separator_2.setForeground(Color.BLACK);
					GUI2.separator_3.setForeground(Color.BLACK);
				} else {
					if(cont == 1){
						GUI2.separator_1.setForeground(Color.RED);
						GUI2.separator.setForeground(Color.BLACK);
						GUI2.separator_2.setForeground(Color.BLACK);
						GUI2.separator_3.setForeground(Color.BLACK);
					} else {
						if(cont == 2){
							GUI2.separator_2.setForeground(Color.RED);
							GUI2.separator_1.setForeground(Color.BLACK);
							GUI2.separator.setForeground(Color.BLACK);
							GUI2.separator_3.setForeground(Color.BLACK);
						} else {
							if(cont == 3){
								GUI2.separator_3.setForeground(Color.RED);
								GUI2.separator_1.setForeground(Color.BLACK);
								GUI2.separator_2.setForeground(Color.BLACK);
								GUI2.separator.setForeground(Color.BLACK);
							}
						}
					}
				}
			}
		}
		}
	}
}
