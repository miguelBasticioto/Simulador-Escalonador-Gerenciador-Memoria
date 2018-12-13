import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Begin extends JFrame{
	private JFormattedTextField cores;
	private JTextField tamanho;
	private JTextField textField;
	private JTextField textField_1;
	public Begin(){
		getContentPane().setLayout(null);
	
		String[] selects = {"Round Robin", "LTG"};
		String[] memoria = {"Merge Fit", "Quick Fit", "Best Fit"};
		
		JComboBox<?> comboBox = new JComboBox<Object>(selects);
		comboBox.setBounds(10, 128, 110, 20);
		
		JComboBox<?> comboBox_1 = new JComboBox<Object>(memoria);
		comboBox_1.setBounds(10, 159, 110, 20);
		getContentPane().add(comboBox_1);
		
		JFormattedTextField processos = new JFormattedTextField();
		processos.setHorizontalAlignment(SwingConstants.CENTER);
		processos.setColumns(10);
		processos.setBounds(280, 165, 86, 20);
		getContentPane().add(processos);
		
		cores = new JFormattedTextField();
		cores.setHorizontalAlignment(SwingConstants.CENTER);
		cores.setBounds(280, 128, 86, 20);
		getContentPane().add(cores);
		cores.setColumns(10);
		
		JLabel label = new JLabel("*1-64");
		label.setForeground(Color.RED);
		label.setBounds(376, 131, 46, 14);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("*1-20");
		label_1.setForeground(Color.RED);
		label_1.setBounds(376, 168, 46, 14);
		getContentPane().add(label_1);
		
		label.setVisible(false);
		label_1.setVisible(false);
		
		tamanho = new JTextField();
		tamanho.setHorizontalAlignment(SwingConstants.CENTER);
		tamanho.setBounds(280, 93, 86, 20);
		getContentPane().add(tamanho);
		tamanho.setColumns(10);
		
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(280, 202, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(280, 233, 86, 20);
		getContentPane().add(textField_1);
		
		JLabel lblTamanho = new JLabel("Tamanho(Kb):");
		lblTamanho.setBounds(195, 96, 86, 14);
		getContentPane().add(lblTamanho);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				int nCores = 0;
				int nProc = 0;
				int mTamanho = 0;
				try {
					nCores = Integer.valueOf(cores.getText());
					nProc = Integer.valueOf(processos.getText());
					mTamanho = Integer.valueOf(tamanho.getText());
				} catch(Exception e) {
					label.setVisible(true);
					label_1.setVisible(true);
				}
				
				if(comboBox.getSelectedIndex() == 1 && (nCores >= 1 && nCores <= 64) && (nProc >= 1 && nProc <= 20)) {
					GUI g = new GUI(Integer.valueOf(cores.getText()), Integer.valueOf(processos.getText()), Integer.valueOf(tamanho.getText()));
					dispose();
				} else {
					label.setVisible(true);
					label_1.setVisible(true);
				}
				
				if(comboBox.getSelectedIndex() == 0 && (nCores >= 1 && nCores <= 64) && (nProc >= 1 && nProc <= 20)){
					if(comboBox_1.getSelectedIndex() == 1){
						GUI2 g = new GUI2(Integer.valueOf(cores.getText()), Integer.valueOf(processos.getText()), Integer.valueOf(tamanho.getText()) * 1024, comboBox_1.getSelectedIndex(), Integer.valueOf(textField_1.getText()), Integer.valueOf(textField.getText()));
					} else {
						GUI2 g = new GUI2(Integer.valueOf(cores.getText()), Integer.valueOf(processos.getText()), Integer.valueOf(tamanho.getText()) * 1024, comboBox_1.getSelectedIndex(), 1, 1);

					}
					dispose();
				}
			}
		});
		btnStart.setBounds(280, 273, 89, 23);
		getContentPane().add(btnStart);
		
		getContentPane().add(comboBox);
		
		JLabel lblCores = new JLabel("Cores:");
		lblCores.setBounds(195, 131, 46, 14);
		getContentPane().add(lblCores);
		
		JLabel lblProcessos = new JLabel("Processos:");
		lblProcessos.setBounds(195, 168, 75, 14);
		getContentPane().add(lblProcessos);
		
		JLabel lblLegendas = new JLabel("Legendas:");
		lblLegendas.setVerticalAlignment(SwingConstants.TOP);
		lblLegendas.setBounds(36, 259, 234, 156);
		getContentPane().add(lblLegendas);
		lblLegendas.setText("<html>Legendas: <br>ID: Id do processador.<br>P: Id do processo executando.<br>D: Deadline.<br>Q: Quantum.<br>E: Tempo já executado.<br>TR: Tempo restante.\r\n<br>TB: Tamanho Bytes.");
		
		JLabel lblQtdReq = new JLabel("Qtd req:");
		lblQtdReq.setBounds(195, 205, 46, 14);
		getContentPane().add(lblQtdReq);
		
		JLabel lblQtdListas = new JLabel("Qtd listas:");
		lblQtdListas.setBounds(195, 234, 86, 14);
		getContentPane().add(lblQtdListas);
		
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
