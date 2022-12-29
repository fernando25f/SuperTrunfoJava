//import java.util.Random;
import java.util.Scanner;

public class Jogo {
	private static JogadorAbstrato[] jogadores;
	private static String tema;
	private static Scanner scan = new Scanner(System.in);
	private static int escolha;
	private static int jogadordavez;
	public Jogo(JogadorAbstrato[] jogadores, String tema) {
		setJogadores(jogadores);
		setTema(tema);
		Baralho baralho = new Baralho(tema);
		baralho.carregar();
		baralho.embaralhar();
		baralho.distribuir(jogadores);
	}
	
	public static int comparar(int atributo) {
		double maior = 0;
		int jogador = 0;
		for (int i = 0; i <jogadores.length; i++) {
			double valor = Double.valueOf(jogadores[i].getMonte().pegarTopo().getValor().getValor().get(atributo)).doubleValue();
			if (i == 0)
				maior = valor;
			else {
				if (valor > maior) {
					maior = valor;
					jogador = i;
				}
				else if(valor == maior) {
					jogador = getJogadordavez();
					break;
				}
			}
		}
		setJogadordavez(jogador);
		return jogador;
	}
	
	public static void passarCarta(int jogador) {
		for (int i = 0; i < jogadores.length; i++) {
			jogadores[jogador].getMonte().addLast(jogadores[i].getMonte().pegarTopo());
			jogadores[i].getMonte().removeFirst();
		}
	}
	
	public static boolean identificarTrunfo() {
		boolean verificador = false;
		String trunfo = Baralho.getTrunfo();
		for (int i = 0; i < jogadores.length; i++) {
			if (jogadores[i].getMonte().pegarTopo().getCodigo().equals(trunfo)) {
				verificador = true;
			}
		}
		System.out.println("Trunfo");
		return verificador;
	}
	public static int procurarTrunfo() {
		int jogador = 0;
		String trunfo = Baralho.getTrunfo();
		for (int i = 0; i < jogadores.length; i++) {
			if (jogadores[i].getMonte().pegarTopo().getCodigo().equals(trunfo))
				jogador = i;
		}
		return jogador;
	}
	public static boolean identificarCartaA() {
		boolean verificador = false;
		for (int i = 0; i < jogadores.length; i++) {
			if (jogadores[i].getMonte().pegarTopo().getCodigo().substring(1,2).equals(""))
				verificador = true;		
		}
		System.out.println("Carta A");
		return verificador;
	}
	
	public static boolean ganhador() {
		boolean vencedor = false;
		for (int j = 0; j< jogadores.length; j++) {
			if (jogadores[j].getMonte().size() == 32) {
				System.out.println("O vencedor foi o jogador " + j);
				vencedor = true;
			}
		}
		return vencedor;
	}
	
	public static JogadorAbstrato[] getJogadores() {
		return Jogo.jogadores;
	}
	public static void setJogadores(JogadorAbstrato[] jogadores) {
		Jogo.jogadores = jogadores;
	}
	public static String getTema() {
		return Jogo.tema;
	}
	public static void setTema(String tema) {
		Jogo.tema = tema;
	}

	public static Scanner getScan() {
		return scan;
	}

	public static void setScan(Scanner scan) {
		Jogo.scan = scan;
	}

	public static int getEscolha() {
		return escolha;
	}

	public static void setEscolha(int escolha) {
		Jogo.escolha = escolha;
	}

	public static int getJogadordavez() {
		return jogadordavez;
	}

	public static void setJogadordavez(int jogadordavez) {
		Jogo.jogadordavez = jogadordavez;
	}
	
}
