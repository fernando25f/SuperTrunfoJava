import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.io.*;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

@SuppressWarnings("serial")
public class Baralho extends LinkedList<Carta>{
	private static String tema;
	private static String trunfo;
	public Baralho(String tema) {
		setTema(tema);
	}
	
	@SuppressWarnings("rawtypes")
	public void carregar() {
		try {
			File diretorio = new File("Cartas");
			File cartas = new File(diretorio,tema.concat(".txt"));
			BufferedReader leitor = new BufferedReader(new FileReader(cartas));
			int i = 0;
			String s = null;
			while((s = leitor.readLine()) != null) {
				String texto = s;
				@SuppressWarnings("unchecked")
				List<String> atributos = new ArrayList();
				while (texto.isEmpty() == false) {
					if (texto.contains("#") == false) {
						atributos.add(texto);
						texto = "";
					}
					else{
						for (int j = 0; j < texto.length(); j++){
							if (texto.substring(j,j+1).equals("#")) {
								atributos.add(texto.substring(0,j));
								texto = texto.substring(j+1,texto.length());
								break;
							}
						}
					}
				}
				if (i == 0) 
					Carta.setAtributos(atributos);
				else if (i == 1)
					Carta.setUnidade(atributos);
				else if (i == 2) {
					setTrunfo(atributos.get(0));
				}
				else {
					Carta carta = new Carta(atributos.get(0),atributos.get(1));
					carta.setExtra(atributos.get(2));
					Atributos valor = new Atributos();
					valor.setValor(atributos.subList(3,atributos.size()));
					carta.setValor(valor);	
					this.add(carta);
				}
				i++;
			}
			leitor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void embaralhar() {
		Collections.shuffle(this);
	}
		
	public void distribuir(JogadorAbstrato[] jogadores) {
		int qJogadores = jogadores.length;
		Baralho[] jogador = new Baralho[qJogadores];
		int i = 0;
		for (i = 0; i < qJogadores; i++) {
			jogador[i] = new Baralho(getTema());
		}
		i = 0;
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
			System.out.printf("Ha %d cartas ainda\n\n", this.size());
		}
		else {
			System.out.println("Nao ha mais cartas");
		}
	}
	
	public Carta pegarTopo() {
		if (this.isEmpty() == false) {
			return this.getFirst();
		}
		else {
			Carta carta = new Carta("", "");
			return carta;
		}
	}
	
	public static String getTema() {
		return Baralho.tema;
	}
	public static void setTema(String tema) {
		Baralho.tema = tema;
	}

	public static String getTrunfo() {
		return trunfo;
	}

	public static void setTrunfo(String trunfo) {
		Baralho.trunfo = trunfo;
	}
	
}
