import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class MainFrameUpdate extends Thread{
	JPanel painel = new JPanel();
	JPanel painelA = new JPanel();
	ArrayList<JPanel> painelProcessos = new ArrayList<JPanel>();
	ArrayList<JLabel> labelProcessos = new ArrayList<JLabel>();
	
	ArrayList<JPanel> painelProcessosA = new ArrayList<JPanel>();
	ArrayList<JLabel> labelProcessosA = new ArrayList<JLabel>();
	
	public MainFrameUpdate(JPanel painel, JPanel painelA) {
		this.painel = painel;
		this.painelA = painelA;
		painel.setLayout(new GridLayout(1, 20, 0, 0));
		painelA.setLayout(new GridLayout(1, 20, 0, 0));
		for(int i = 0; i < 20; i ++) {
			JPanel aux = new JPanel();
			aux.setBackground(Color.WHITE);
			aux.setBorder(new LineBorder(new Color(0, 0, 0)));
			JLabel auxL = new JLabel();
			auxL.setForeground(Color.BLACK);
			labelProcessos.add(auxL);
			aux.add(labelProcessos.get(i));
			painelProcessos.add(aux);
			painel.add(painelProcessos.get(i));
			painel.repaint();
		}
		
		for(int i = 0; i < 20; i ++) {
			JPanel aux = new JPanel();
			aux.setBorder(new LineBorder(new Color(0, 0, 0)));
			aux.setBackground(Color.WHITE);
			JLabel auxL = new JLabel();
			auxL.setForeground(Color.BLACK);
			labelProcessosA.add(auxL);
			aux.add(labelProcessosA.get(i));
			painelProcessosA.add(aux);
			painelA.add(painelProcessosA.get(i));
			painelA.repaint();
		}
	}
	
	@Override
	public void run() {
		while(1 < 2){
			System.out.print("");
			for(int i = 0; i < GUI.processos.getSize(); i ++){
				painelProcessos.get(i).setBackground(GUI.processos.search(i).getProcess().getC());
				labelProcessos.get(i).setText("<html>ID: " + GUI.processos.search(i).getProcess().getId()
						+ "<br>D: " + GUI.processos.search(i).getProcess().getDeadLine() +"<br>TT: "+GUI.processos.search(i).getProcess().getTotalTime()+"</html>");
			}
			for(int i = GUI.processos.getSize(); i < 20; i ++){
				painelProcessos.get(i).setBackground(Color.WHITE);
				labelProcessos.get(i).setText("");
			}
			for(int i = 0; i < GUI.processosA.getSize(); i ++){
				painelProcessosA.get(i).setBackground(GUI.processosA.search(i).getProcess().getC());
				labelProcessosA.get(i).setText("<html>ID: " + GUI.processosA.search(i).getProcess().getId()
						+ "<br>D: 0" +"<br>TT: "+GUI.processosA.search(i).getProcess().getTotalTime()+"</html>");
			}
			for(int i = GUI.processosA.getSize(); i < 20; i ++){
				painelProcessosA.get(i).setBackground(Color.WHITE);
				labelProcessosA.get(i).setText("");
			}
			
			for(int i = 0; i < GUI.cores.size(); i ++){
				if(GUI.cores.get(i).getCurrent() == null){
					GUI.cores.get(i).getPanel().setBackground(Color.WHITE);
					GUI.cores.get(i).getTexto().setText("<html>ID: " + GUI.cores.get(i).getId() + "<br>P: " + GUI.cores.get(i).getCurrent() + "<br>TR: ");
				} else {
					GUI.cores.get(i).getPanel().setBackground(GUI.cores.get(i).getCurrent().getC());
					GUI.cores.get(i).getTexto().setText("<html>ID: " + GUI.cores.get(i).getId() + "<br>P: " + GUI.cores.get(i).getCurrent().getId() + "<br>TR: " + GUI.cores.get(i).getCurrent().getTimeLeft());
				}
			}
			
			for(int i =0; i < GUI.cores.size(); i ++){
				if(GUI.cores.get(i).getCurrent() == null && !GUI.processos.isEmpty()) {
					GUI.cores.get(i).setCurrent(GUI.processos.search(0).getProcess());
					GUI.processos.removeFirst();
				}
			}
		}
	}
}
