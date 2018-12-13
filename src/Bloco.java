import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Bloco {
	private Bloco next;
	private int tamanho;
	private int tamanhoUsado;
	private boolean usado;
	private int id;
	private Process processo;
	public Process getProcesso() {
		return processo;
	}

	public void setProcesso(Process processo) {
		this.processo = processo;
	}

	private JLabel label;
	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	private JPanel panel;
	
	public Bloco(int tamanho, int tamanhoUsado, int id, boolean usado) {
		next = null;
		this.tamanho = tamanho;
		this.tamanhoUsado = tamanhoUsado;
		this.usado = usado;
		this.id = id;
		
		label = new JLabel("<html>Id: " + id + "<br>TT: " + tamanho + "<br>TU: " + tamanhoUsado + "</html>");
		panel = new JPanel();
		panel.add(label);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setPreferredSize(new Dimension(100,100));
	}

	public Bloco getNext() {
		return next;
	}

	public void setNext(Bloco next) {
		this.next = next;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getTamanhoUsado() {
		return tamanhoUsado;
	}

	public void setTamanhoUsado(int tamanhoUsado) {
		this.tamanhoUsado = tamanhoUsado;
	}

	public boolean isUsado() {
		return usado;
	}

	public void setUsado(boolean usado) {
		this.usado = usado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}	
