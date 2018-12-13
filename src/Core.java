import javax.swing.JLabel;
import javax.swing.JPanel;

public class Core {
	private Process current;
	private int id;
	private JPanel panel;
	private JLabel texto;
	
	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public Core(int id, JPanel panel, JLabel texto){
		this.id = id;
		this.texto = texto;
		this.panel = panel;
		current = null;
	}

	public JLabel getTexto() {
		return texto;
	}

	public void setTexto(JLabel texto) {
		this.texto = texto;
	}

	public Process getCurrent() {
		return current;
	}

	public void setCurrent(Process current) {
		this.current = current;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
