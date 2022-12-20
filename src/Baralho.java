import java.util.*;

@SuppressWarnings("serial")
public class Baralho extends LinkedList<Carta>{
	private String tema;
	
	public Baralho() {}
	
	public void carregar() {}
	
	public void embaralhar() {
		Collections.shuffle(this);
	}
		
	public void distribuir(JogadorAbstrato[] jogadores) {}
	
	public void listarCartas() {}
	
	public Carta pegarTopo() {
		Carta carta = new Carta();
		return carta;
	}
	
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	
}
