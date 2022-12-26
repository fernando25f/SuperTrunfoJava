import java.util.Random;
import java.util.Scanner;

public class Jogo {
	private JogadorAbstrato[] jogadores;
	private String tema;
	private static Scanner scan = new Scanner(System.in);
	private static int escolha;
	private static int jogadordavez;
	public Jogo(JogadorAbstrato[] jogadores, String tema) {
		this.jogadores = jogadores;
		this.tema = tema;
		Baralho baralho = new Baralho(this.tema);
		baralho.carregar();
		baralho.embaralhar();
		baralho.distribuir(this.jogadores);
		
		do {
			rodada();
		} while (ganhador() == false);
		scan.close();
	}
	
	public void rodada() {

		if (jogadores[jogadordavez] instanceof JogadorRandomico) {
			Random gerador = new Random();
			escolha = gerador.nextInt(Carta.getAtributos().size()) + 1;
			System.out.println("Atributo escolhido: " + Carta.getAtributos().get(escolha-1));
			passarCarta(comparar(escolha));
		}
		else {
			opcoes();			
			while (escolha != 3) {
				if (escolha == 1)
					jogadores[0].getMonte().listarCartas();
				else if (escolha == 2)
					System.out.println(jogadores[0].getMonte().pegarTopo().toString());
				opcoes();
			}
			if (escolha == 3) {
				escolherAtributo();
				passarCarta(comparar(escolha));
			}
		}
	}
	
	public void opcoes() {
		System.out.println("[1] Ver Baralho");
		System.out.println("[2] Ver Carta do topo");
		System.out.println("[3] Jogar");
		System.out.print("Escolher: ");
		escolha = scan.nextInt();
		System.out.println();
		while (escolha != 3 && escolha != 2 && escolha != 1) {
			System.out.print("Escolha novamente: ");
			escolha = scan.nextInt();
		}
	}
	
	public void escolherAtributo() {
		for (int i = 0; i < Carta.getAtributos().size(); i++) {
			System.out.println("[" + (i+1) + "] " + Carta.getAtributos().get(i));
		}
		System.out.print("Escolher: ");
		escolha = scan.nextInt();
		System.out.println();
		while (escolha < 1 || escolha > Carta.getAtributos().size()) {
			System.out.println("Escolha invalida! Tente novamente.");
			for (int i = 0; i < Carta.getAtributos().size(); i++) {
				System.out.println(Carta.getAtributos().get(i) + "[" + (i+1) + "]");
			}
			System.out.print("Escolher: ");
			escolha = scan.nextInt();
		}
	}
	
	public int comparar(int atributo) {
		double maior = 0;
		int jogador = 0;
		for (int i = 0; i <jogadores.length; i++) {
			if (i == 0)
				maior = Double.valueOf(jogadores[0].getMonte().pegarTopo().getValor().getValor().get(atributo-1)).doubleValue();
			else {
				if (Double.valueOf(jogadores[i].getMonte().pegarTopo().getValor().getValor().get(atributo-1)).doubleValue() > maior) {
					maior = Double.valueOf(jogadores[i].getMonte().pegarTopo().getValor().getValor().get(atributo-1)).doubleValue();
					jogador = i;
				}
			}
			System.out.println("Jogador " + (i+1));
			System.out.println(jogadores[i].getMonte().pegarTopo().toString() + "\n");
		}
		System.out.println("O vencedor da rodada foi: jogador " + (jogador+1));
		jogadordavez = jogador;
		return jogador;
	}
	
	public void passarCarta(int jogador) {
		for (int i = 0; i < jogadores.length; i++) {
			jogadores[jogador].getMonte().addLast(jogadores[i].getMonte().pegarTopo());
			jogadores[i].getMonte().removeFirst();
		}
	}
	
	public boolean ganhador() {
		boolean vencedor = false;
		for (int j = 0; j< jogadores.length; j++) {
			if (jogadores[j].getMonte().size() == 32) {
				System.out.println("O vencedor foi o jogador " + j);
				vencedor = true;
			}
		}
		return vencedor;
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
