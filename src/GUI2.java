import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class GUI2 extends JFrame{
	static ArrayList<Core> cores = new ArrayList<Core>();
	static List [] listas = new List[4];
	int cont = 0;
	ArrayList<Integer> tt = new ArrayList<Integer>();
	ArrayList<Integer> priority = new ArrayList<Integer>();
	static JSeparator separator;
	static JSeparator separator_1;
	static JSeparator separator_2;
	static JSeparator separator_3;
	Random r;
	
	
	ArrayList<Integer> tamanhosQuick;
	
	int contAux2 = 0;
	
	private ListaMemoria[] listasQuick;
	
	private ListaMemoria l;
	
	private Memoria m;
	
	MainFrameUpdate2 mU;
	
	QuickFit q;
	int inicio = 32;
	private int qtdReq;
	private int qtdListas;
	
	@SuppressWarnings("unused")
	public GUI2(int nCores, int nProcessos, int mTamanho, int mAlgo, int qtdListas, int qtdReq) {
		this.qtdListas = qtdListas;
		this.qtdReq = qtdReq;
		
		l = new ListaMemoria(mTamanho);
		tamanhosQuick = new ArrayList<Integer>();
		
		for(int i = 0; i < 6; i ++){
			System.out.println(inicio);
			tamanhosQuick.add(inicio);
			inicio = 2*inicio;
		}
		
		for(int i = 4; i <= 20; i++){
			tt.add(i);
		}
		
		for(int i = 0; i < 4; i++){
			priority.add(i);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(size.width,size.height - 30);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1340, 307);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 32, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 318, 1330, 75);
		getContentPane().add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 404, 1330, 75);
		getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 490, 1330, 75);
		getContentPane().add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 588, 1330, 75);
		getContentPane().add(panel_5);
		
		if(mAlgo == 1){
			q = new QuickFit(qtdReq, qtdListas,l, l.getTamanhoTotal());
			
		}
		
		JButton btnProcesso = new JButton("Processo");
		btnProcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int tempoTotal = random();
				int prioridade = randomP();
				r = new Random();
				int pTamanho;
				if(mAlgo != 1){
					pTamanho = r.nextInt(1024 - 32 + 1) + 32;
				} else {
					pTamanho = tamanhoAleatorio();
				}
				Process p = new Process(tempoTotal, random(), 0, cont, tempoTotal, prioridade, Color.CYAN, pTamanho);
				if(mAlgo == 1){
					int lista = -1;
					p.setLista(lista);
					for(int k = 0; k < q.getListas().size(); k ++){
						if(p.getpTamanho() == q.getListas().get(k).getTamanhoQuick()){
							p.setLista(k);
						}
					}
				}
				if(prioridade == 0){		
					p.setQuantum(16);
					p.setBloco(-1);
					listas[0].insertionSort(p);
					listas[0].show();
					System.out.println();
					cont++;
				} else {
					if(prioridade == 1){
						p.setQuantum(12);
						p.setBloco(-1);
						p.setC(Color.RED);
						listas[1].insertionSort(p);
						listas[1].show();
						System.out.println();
						cont++;
					} else {
						if(prioridade == 2){
							p.setQuantum(8);
							p.setBloco(-1);
							p.setC(Color.GREEN);
							listas[2].insertionSort(p);
							listas[2].show();
							System.out.println();
							cont++;
						} else {
							if(prioridade == 3){
								p.setQuantum(4);
								p.setBloco(-1);
								p.setC(Color.ORANGE);
								listas[3].insertionSort(p);
								listas[3].show();
								System.out.println();
								cont++;
							}
						}
					}
				}
			}
		});
		btnProcesso.setBounds(1251, 665, 89, 23);
		getContentPane().add(btnProcesso);
		
		for(int i = 0; i < nCores; i ++){
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			JLabel aux = new JLabel();
			Core c = new Core(i, panel_1, aux);
			panel_1.add(c.getTexto());
			c.getTexto().setText("<html>ID: " + c.getId() + "<br>P: " + c.getCurrent() + "<br>TR: ");
			cores.add(c);
			panel.add(cores.get(i).getPanel());
		}
		
		for(int i = 0;i < listas.length; i ++){
			List l = new List();
			listas[i] = l;
		}
		
		for(int i = 0; i < nProcessos;i ++) {
			int tempoTotal = random();
			int prioridade = randomP();
			Random r = new Random();
			int pTamanho;
			if(mAlgo != 1){
				pTamanho = r.nextInt(1024 - 32 + 1) + 32;
			} else {
				pTamanho = tamanhoAleatorio();
			}
			Process p = new Process(tempoTotal, random(), 0, cont, tempoTotal, prioridade, Color.WHITE, pTamanho);
			if(mAlgo == 1){
				int lista = -1;
				p.setLista(lista);
				for(int k = 0; k < q.getListas().size(); k ++){
					if(p.getpTamanho() == q.getListas().get(k).getTamanhoQuick()){
						lista = k;
					}
				}
			}
			if(prioridade == 0){
				p.setQuantum(16);
				p.setBloco(-1);
				listas[0].insertionSort(p);
				listas[0].show();
				System.out.println();
				cont++;
			} else {
				if(prioridade == 1){
					p.setQuantum(12);
					p.setBloco(-1);
					listas[1].insertionSort(p);
					listas[1].show();
					System.out.println();
					cont++;
				} else {
					if(prioridade == 2){
						p.setQuantum(8);
						p.setBloco(-1);
						listas[2].insertionSort(p);
						listas[2].show();
						System.out.println();
						cont++;
					} else {
						if(prioridade == 3){
							p.setQuantum(4);
							p.setBloco(-1);
							listas[3].insertionSort(p);
							listas[3].show();
							System.out.println();
							cont++;
						}
					}
				}
			}
		}
		
		if(mAlgo == 1){
			
		}
		
		if(mAlgo == 2){
			m = new Memoria(l);
		} else {
			if(mAlgo == 0){
				m = new Memoria(l);
			}
			
		}
					
		if(mAlgo == 0 || mAlgo == 2){
			mU = new MainFrameUpdate2(panel_2, panel_3, panel_4, panel_5, l, m, mAlgo, q);
			mU.start();
		} else {
			mU = new MainFrameUpdate2(panel_2, panel_3, panel_4, panel_5, l, m, mAlgo, q);
			mU.start();
		}
		
		
		
		Timer timer = new Timer();

		timer.schedule(new TimerTask() {
			public void run() {
				if(mU.getState() != Thread.State.WAITING){
				for(int i = 0; i < cores.size(); i ++){
					if(cores.get(i).getCurrent() != null){
						cores.get(i).getCurrent().setTimeLeft(cores.get(i).getCurrent().getTimeLeft() - 1);
						cores.get(i).getCurrent().setFeito(cores.get(i).getCurrent().getFeito() + 1);
						
						if(cores.get(i).getCurrent().getTimeLeft() < 1){
							if(mAlgo == 2){
								l.search(GUI2.cores.get(i).getCurrent().getBloco()).setUsado(false);
								l.search(GUI2.cores.get(i).getCurrent().getBloco()).setTamanhoUsado(0);
								l.search(GUI2.cores.get(i).getCurrent().getBloco()).setProcesso(null);
							}
							
							
							if(mAlgo == 1 && q.prosseguir){
								if(cores.get(i).getCurrent().getLista() == -1){
									System.out.println("Ta branco");
									l.search(GUI2.cores.get(i).getCurrent().getBloco()).setUsado(false);
									l.search(GUI2.cores.get(i).getCurrent().getBloco()).setTamanhoUsado(0);
									l.search(GUI2.cores.get(i).getCurrent().getBloco()).setProcesso(null);
								} else {
									System.out.println("Ta branco");
									System.out.println("Tirando bloco: " + cores.get(i).getCurrent().getBloco() + " lista:  " + cores.get(i).getCurrent().getLista());
									q.getListas().get(cores.get(i).getCurrent().getLista()).search(cores.get(i).getCurrent().getBloco()).setUsado(false);
									q.getListas().get(cores.get(i).getCurrent().getLista()).search(cores.get(i).getCurrent().getBloco()).setTamanhoUsado(0);
									q.getListas().get(cores.get(i).getCurrent().getLista()).search(cores.get(i).getCurrent().getBloco()).setProcesso(null);
								
								}
							}
							
							if(mAlgo == 0 && GUI2.cores.get(i).getCurrent() != null){
								l.search(GUI2.cores.get(i).getCurrent().getBloco()).setUsado(false);
								l.search(GUI2.cores.get(i).getCurrent().getBloco()).setTamanhoUsado(0);
								l.search(GUI2.cores.get(i).getCurrent().getBloco()).setProcesso(null);
							}
							
							if(cores.get(i).getCurrent().getTimeLeft() < 1){
								for(int j = 0; j < l.getSize(); j ++){
									if(l.search(j).getProcesso() == cores.get(i).getCurrent()){
										l.search(j).setUsado(false);
										l.search(j).setTamanhoUsado(0);
										l.search(j).setProcesso(null);
									}
								}
							}
							if(mAlgo == 0){
								for(int j = 0; j < l.getSize(); j ++){
									if(cores.get(i).getCurrent() == l.search(j).getProcesso()){
										l.search(j).setProcesso(null);
										l.search(j).setUsado(false);
										l.search(j).setTamanhoUsado(0);
									}
								}
							}
							if(mAlgo == 0){
								try {
									mU.wait();
								} catch(Exception e){
									
								}
								m.pausar();
								try {
									mU.notify();
								} catch(Exception e){
									
								}
								m.getPanel().revalidate();
								m.getPanel().repaint();
							}
							cores.get(i).setCurrent(null);
							//mudar para == 0 depois
							
						}
						if(mAlgo == 2){
							if(cores.get(i).getCurrent() != null && cores.get(i).getCurrent().sorteado()){
								System.out.println("Sorteado");
								r = new Random();
								int tamanhoAux = r.nextInt(1024 - 32 + 1) + 32;
								if(!l.cheio(tamanhoAux)){
									l.show();
									Bloco b = new Bloco(tamanhoAux,tamanhoAux, mU.contAux, true);
									b.setProcesso(cores.get(i).getCurrent());
									b.setUsado(true);
									cores.get(i).getCurrent().getBlocosA().add(b.getId());
									l.adicionar(b);
									l.setTamanhoUsado(l.getTamanhoUsado() + b.getTamanho());
									mU.getM().novo(b);
									mU.getM().getPanel().revalidate();
									mU.getM().getPanel().repaint();
									mU.contAux ++;
								} else {
									System.out.println("");
									if(cores.get(i).getCurrent()!= null){
										if(l.fitPos(new Process(tamanhoAux)) == 1234){
											System.out.println("Abortado por aleatorio");
											for(int j = 0; j < l.getSize(); j ++){
												System.out.println(cores.get(i).getCurrent().getpTamanho());
												if(l.search(j).getProcesso() == cores.get(i).getCurrent()){
													System.out.println("Ta aqui " + l.search(j).getProcesso().getId());
													l.search(j).setUsado(false);
													l.search(j).setTamanhoUsado(0);
													l.search(j).setProcesso(null);
												}
											}
											cores.get(i).getCurrent().setTimeLeft(cores.get(i).getCurrent().getTimeLeft() - 1);
											cores.get(i).getCurrent().setFeito(cores.get(i).getCurrent().getFeito() + 1);

											cores.get(i).setCurrent(null);
											} else {
												//Colocar aleatorio nos blocos existentes
												int aux = l.fitPos(new Process(tamanhoAux));
												l.search(aux).setTamanhoUsado(tamanhoAux);
												l.search(aux).setProcesso(cores.get(i).getCurrent());
												l.search(aux).setUsado(true);
												cores.get(i).getCurrent().getBlocosA().add(aux);
											}
										}
								}
							}
						} else {
							//Merge fit
							
							if(mAlgo == 0){
								r = new Random();
								int tamanhoAux = r.nextInt(1024 - 32 + 1) + 32;
								if(cores.get(i).getCurrent() != null  && GUI2.cores.get(i).getCurrent().sorteado()){
									if(!l.cheio(tamanhoAux)){
										System.out.println("Sorteado");
										int pos = l.fitPos(new Process(tamanhoAux));
										l.split(pos, tamanhoAux, m, cores.get(i).getCurrent());
										l.search(pos).setUsado(true);
										l.refazerId();
										
									} else {
										System.out.println("Abortado");
		
										for(int j = 0; j < l.getSize(); j ++){
											
											if(cores.get(i).getCurrent() == l.search(j).getProcesso()){
												l.search(j).setProcesso(null);
												l.search(j).setUsado(false);
												l.search(j).setTamanhoUsado(0);
											}
											l.refazerId();

											
											cores.get(i).setCurrent(null);
											l.refazerId();
										}
										if(mAlgo == 0){
											try {
												mU.wait();
											} catch(Exception e){
												
											}
											m.pausar();
											try {
												mU.notify();
											} catch(Exception e){
												
											}
											m.getPanel().revalidate();
											m.getPanel().repaint();
										}
										
									}
								}
							}
						}
					}
				}
			}
		}
		}, 0, 1000);	
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				timer.cancel();
				mU.interrupt();
				cores = new ArrayList<Core>();
				listas = new List[4];
				cont = 0;
				separator = new JSeparator();
				separator_1 = new JSeparator();
				separator_2 = new JSeparator();
				separator_3 = new JSeparator();
				Begin b = new Begin();
				dispose();
			}
		});
		btnVoltar.setBounds(10, 665, 89, 23);
		getContentPane().add(btnVoltar);
		
		separator = new JSeparator();
		separator.setBounds(10, 309, 1330, 5);
		getContentPane().add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 397, 1330, 11);
		getContentPane().add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(10, 483, 1330, 11);
		getContentPane().add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(10, 576, 1330, 11);
		getContentPane().add(separator_3);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(mAlgo == 0){
						m.pausar();
						m.getPanel().revalidate();
						m.getPanel().repaint();
					}
				} catch(Exception e){
					
				}
			}
		});
		btnNewButton.setBounds(312, 674, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				l.show();
			}
		});
		btnNewButton_1.setBounds(421, 674, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		setVisible(true);
		
	}
	
	public int random(){
		Collections.shuffle(tt);
		return tt.get(0);
	}
	
	public int randomP(){
		Collections.shuffle(priority);
		return priority.get(0);
	}
	
	
	public int tamanhoAleatorio(){
		Collections.shuffle(tamanhosQuick);
		return tamanhosQuick.get(0);
	}
}