
public abstract class JogadorAbstrato {
	protected String nome;
	protected Baralho monte;
		
	//Sobrecarga do Construtor
	public JogadorAbstrato(String nome) {this.nome = nome;}
	public JogadorAbstrato() {}
	
	protected String getNome() {
		return nome;
	}
	
	protected void setNome(String nome) {
		this.nome = nome;
	}
	
	protected Baralho getMonte() {
		return monte;
	}
	
	protected void setMonte(Baralho monte) {
		this.monte = monte;
	}


}
