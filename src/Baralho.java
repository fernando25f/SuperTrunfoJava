import java.util.*;

@SuppressWarnings("serial")
public class Baralho extends LinkedList<Carta>{
	private String tema;
	
	public Baralho(String tema) {
		this.tema = tema;
		this.carregar();
	}
	
	public void carregar() {}
	
	public void embaralhar() {
		Collections.shuffle(this);
	}
		
	public void distribuir(JogadorAbstrato[] jogadores) {
		int qJogadores = jogadores.length;
		Baralho jogador[] = new Baralho[qJogadores];
		int i = 0;
		while (this.isEmpty() == false) {
			jogador[i].add(this.getFirst());
			this.removeFirst();
			if(i != qJogadores - 1) {
				i++;
			} else {
				i = 0;
			}
		}
		for(i = 0; i < qJogadores; i++) {
			jogadores[i].setMonte(jogador[i]);
		}
	}
	
	public void listarCartas() {
		if (this.isEmpty() == false) {
			for (int i = 0; i < this.size(); i++) {
				System.out.println(this.get(i).toString());
			}
			System.out.print("\n\n");
		}
		else {
			System.out.println("Não há mais cartas");
		}
	}
	
	public Carta pegarTopo() {
		if (this.isEmpty() == false) {
			return this.getFirst();
		}
		else {
			Carta carta = new Carta();
			return carta;
		}
	}
	
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	
}
