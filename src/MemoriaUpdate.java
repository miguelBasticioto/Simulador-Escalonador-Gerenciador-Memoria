import java.awt.Color;

import javax.swing.JPanel;

public class MemoriaUpdate extends Thread{
	private ListaMemoria l;
	private JPanel painel;
	
	public MemoriaUpdate(ListaMemoria l, JPanel painel){
		this.l = l;
		this.painel = painel;
	}
	
	@Override
	public void run() {
		while(1 < 2){
			System.out.print("");
			for(int i = 0; i < l.getSize(); i ++){
				System.out.print("");
				//Esse print faz os outros nao aparecerem
				System.out.print("");
				l.search(i).getLabel().setText("<html>Id: " + l.search(i).getId() + "<br>TT: " + l.search(i).getTamanho() + "<br>TU: " + l.search(i).getTamanhoUsado() + "</html>");
				if(l.search(i).getProcesso() != null) {
					l.search(i).getPanel().setBackground(l.search(i).getProcesso().getC());
				} else {
					l.search(i).getPanel().setBackground(Color.white);
				}
				
			}
		}
	}

}
