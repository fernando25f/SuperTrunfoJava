
public abstract class JogadorAbstrato {
	private String nome;
	private Baralho monte;
		
	//Sobrecarga do Construtor
	public JogadorAbstrato(String nome) {this.nome = nome;}
	public JogadorAbstrato() {}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Baralho getMonte() {
		return monte;
	}
	
	public void setMonte(Baralho monte) {
		this.monte = monte;
	}


}
