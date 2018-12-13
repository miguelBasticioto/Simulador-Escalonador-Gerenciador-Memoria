import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class GUI extends JFrame{
	//LTG
	static ArrayList<Core> cores = new ArrayList<Core>();
	static List processos = new List();
	static List processosA = new List();
	int cont = 0;
	ArrayList<Integer> tt = new ArrayList<Integer>();
	ArrayList<Integer> priority = new ArrayList<Integer>();
	boolean clicked = false;	
	
	public GUI(int nCores, int nProcessos, int mTamanho){	
		
		for(int i = 4; i <= 20; i++){
			tt.add(i);
		}
		
		for(int i = 0; i < 4; i++){
			priority.add(i);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1340, 187);
		getContentPane().add(panel);
		
		panel.setLayout(new GridLayout(3, 32, 0, 0));
		
		JButton btnProcesso = new JButton("Processo");
		btnProcesso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tempoTotal = random();
				Random r = new Random();
				int pTamanho = r.nextInt(1024 - 32 + 1) + 32;
				Process p = new Process(tempoTotal, random(), 0, cont, tempoTotal, randomP(), Color.CYAN, pTamanho);
				processos.insertionSort(p);
				processos.show();
				System.out.println();
				cont++;
			}
		});
		btnProcesso.setBounds(1251, 648, 89, 23);
		getContentPane().add(btnProcesso);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 188, 1350, 75);
		getContentPane().add(panel_2);
		
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
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 364, 1330, 75);
		getContentPane().add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		MainFrameUpdate mU = new MainFrameUpdate(panel_2, panel_1);
		mU.start();
		
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(size.width,size.height - 30);
		
		Timer timer = new Timer();
		
		timer.schedule(new TimerTask() {
			public void run() {
				if(!clicked){
				for(int i = 0; i < processos.getSize(); i ++){
					if(!processos.isEmpty()) {
						processos.search(i).getProcess().setDeadLine(processos.search(i).getProcess().getDeadLine() - 1);
						mU.labelProcessos.get(i).setText("<html>ID: " + processos.search(i).getProcess().getId()
						+ "<br>D: " + processos.search(i).getProcess().getDeadLine() +"<br>TT: " +processos.search(i).getProcess().getTotalTime() +"</html>");
						if(!processos.isEmpty()){
							if(processos.search(i).getProcess().getDeadLine() < 1){
								mU.labelProcessos.get(i).setText("");
								processosA.enqueue(processos.search(0).getProcess());
								processos.removeFirst();					
							}
						}
					}
				}
				
				for(int i = 0; i < cores.size(); i ++){
					if(cores.get(i).getCurrent() != null){
						cores.get(i).getCurrent().setTimeLeft(cores.get(i).getCurrent().getTimeLeft() - 1);
						if(cores.get(i).getCurrent().getTimeLeft() < 1){
							cores.get(i).setCurrent(null);
						}
					}
				}
				}
			}
		}, 0, 1000);
		
		for(int i = 0; i < nProcessos;i ++) {
			int tempoTotal = random();
			Random r = new Random();
			int pTamanho = r.nextInt(1024 - 32 + 1) + 32;
			Process p = new Process(tempoTotal, random(), 0, cont, tempoTotal, randomP(), Color.WHITE, pTamanho);
			processos.insertionSort(p);
			processos.show();
			System.out.println();
			cont++;
		}
		JButton btnReturn = new JButton("Voltar");
		btnReturn.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				mU.interrupt();
				timer.cancel();				
				processos = new List();
				processosA = new List();
				mU.painel = new JPanel();
				mU.painelA = new JPanel();
				mU.painelProcessos = new ArrayList<JPanel>();
				mU.labelProcessos = new ArrayList<JLabel>();
				mU.painelProcessosA = new ArrayList<JPanel>();
				mU.labelProcessosA = new ArrayList<JLabel>();
				cores = new ArrayList<Core>();
				cont = 0;				
				Begin b = new Begin();
				dispose();
			}
		});
		btnReturn.setBounds(10, 648, 89, 23);
		getContentPane().add(btnReturn);
	}
	
	public ArrayList<Core> getCores() {
		return cores;
	}

	@SuppressWarnings("static-access")
	public void setCores(ArrayList<Core> cores) {
		this.cores = cores;
	}

	public int getCont() {
		return cont;
	}

	public void setCont(int cont) {
		this.cont = cont;
	}

	public ArrayList<Integer> getTt() {
		return tt;
	}

	public void setTt(ArrayList<Integer> tt) {
		this.tt = tt;
	}

	public ArrayList<Integer> getPriority() {
		return priority;
	}

	public void setPriority(ArrayList<Integer> priority) {
		this.priority = priority;
	}

	public int random(){
		Collections.shuffle(tt);
		return tt.get(0);
	}
	
	public int randomP(){
		Collections.shuffle(priority);
		return priority.get(0);
	}
}
