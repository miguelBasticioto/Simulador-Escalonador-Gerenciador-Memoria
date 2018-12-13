
public class Requisicoes {
	private int tamanho;
	private int qtd;
	
	public Requisicoes(int tamanho, int qtd){
		this.tamanho = tamanho;
		this.qtd = qtd;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
}
