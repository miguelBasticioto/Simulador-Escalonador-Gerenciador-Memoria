import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class Memoria extends JFrame{
	private ListaMemoria l;
	JPanel panel;
	private MemoriaUpdate bU;
	
	public MemoriaUpdate getbU() {
		return bU;
	}
	public void setbU(MemoriaUpdate bU) {
		this.bU = bU;
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
	public Memoria (ListaMemoria l){
		this.l = l;
		setSize(500,300);
		setLocationRelativeTo(null);
		
		setResizable(false);
		
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		
		bU = new MemoriaUpdate(l, panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		bU.start();
		
		setVisible(true);
	}
	
	public void novo(Bloco b){
		b.getLabel().setText("<html>Id: " + b.getId() + "<br>TT: " + b.getTamanho() + "<br>TU: " + b.getTamanhoUsado() + "</html>");;
		panel.add(b.getPanel());
	}
	
	public void pausar(){
		try {
			bU.stop();
			while(l.juntavel()){
				l.juntar();
			}
			bU = new MemoriaUpdate(l, panel);
			panel.removeAll();
			for(int i = 0; i < l.getSize(); i ++){
				novo(l.search(i));
			}
			bU.start();
			l.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
