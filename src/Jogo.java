
public class Jogo {
	private JogadorAbstrato[] jogadores;
	private String tema;
	public Jogo(JogadorAbstrato[] jogadores, String tema) {
		this.jogadores = jogadores;
		this.tema = tema;
		Baralho baralho = new Baralho(this.tema);
		baralho.carregar();
		baralho.embaralhar();
		baralho.distribuir(this.jogadores);
		while (Ganhador() == false) {
			Rodada();
		}
	}
	public void Opcoes() {}
	public void Rodada() {
		
	}
	public void EscolherAtributo() {}
	public void Comparar() {}
	public void PassarCarta() {}
	public boolean Ganhador() {
		return false;
	}
	
	public JogadorAbstrato[] getJogadores() {
		return jogadores;
	}
	public void setJogadores(JogadorAbstrato[] jogadores) {
		this.jogadores = jogadores;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	
}
