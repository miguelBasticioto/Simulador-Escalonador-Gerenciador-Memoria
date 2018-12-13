import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;

public class Process {
	private int totalTime;
	private int timeLeft;
	private int deadLine;
	private int quantum;
	private int id;
	private int priority;
	private int feito;
	private int pTamanho;
	private int bloco;
	private int lista;
	public int getLista() {
		return lista;
	}

	public void setLista(int lista) {
		this.lista = lista;
	}

	public ArrayList<Integer> getOpcoes() {
		return opcoes;
	}

	public void setOpcoes(ArrayList<Integer> opcoes) {
		this.opcoes = opcoes;
	}

	public int getCorreta() {
		return correta;
	}

	public void setCorreta(int correta) {
		this.correta = correta;
	}

	private ArrayList<Integer> opcoes;
	private int correta;
	private ArrayList<Integer> blocosA = new ArrayList<Integer>();
	
	public ArrayList<Integer> getBlocosA() {
		return blocosA;
	}

	public void setBlocosA(ArrayList<Integer> blocosA) {
		this.blocosA = blocosA;
	}

	private boolean usou;
	
	public boolean isUsou() {
		return usou;
	}

	public void setUsou(boolean usou) {
		this.usou = usou;
	}

	public int getBloco() {
		return bloco;
	}

	public void setBloco(int bloco) {
		this.bloco = bloco;
	}

	public int getpTamanho() {
		return pTamanho;
	}

	public void setpTamanho(int pTamanho) {
		this.pTamanho = pTamanho;
	}

	public int getFeito() {
		return feito;
	}

	public void setFeito(int feito) {
		this.feito = feito;
	}

	private Color c;
	
	public Process(int totalTime, int deadLine, int quantum, int id, int timeLeft, int priority, Color c, int pTamanho){
		this.totalTime = totalTime;
		this.deadLine = deadLine;
		this.quantum = quantum;
		this.id = id;
		this.timeLeft = timeLeft;
		this.priority = priority;
		this.c = c;
		this.pTamanho = pTamanho;
		this.opcoes = new ArrayList<Integer>();
		for(int i = 0; i < totalTime; i ++){
			opcoes.add(i);
		}
		correta = opcoes.get(0);
	}
	
	public Process(int pTamanho) {
		this.pTamanho = pTamanho;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getTimeLeft() {
		return timeLeft;
	}

	public void setTimeLeft(int timeLeft) {
		this.timeLeft = timeLeft;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public int getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(int deadLine) {
		this.deadLine = deadLine;
	}

	public int getQuantum() {
		return quantum;
	}

	public void setQuantum(int quantum) {
		this.quantum = quantum;
	}
	
	public boolean sorteado(){
		Collections.shuffle(opcoes);
		if(!opcoes.isEmpty()){
			if(opcoes.get(0) == correta){
				opcoes.remove(0);
				Collections.shuffle(opcoes);
				correta = opcoes.get(0);
				
				return true;
			} else {
				opcoes.remove(0);
			}
		}
		
		return false;
	}
}
