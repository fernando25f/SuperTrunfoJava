import java.util.Random;
import java.util.Scanner;

public class Console {
	private int qJogadores;
	private int qAtributos;
	private static Scanner scan = new Scanner(System.in);
	private static int rodada = 0;
	private int opcao = 0;
	Console (){
		qJogadores = Jogo.getJogadores().length;
		qAtributos = Carta.getAtributos().size();
		System.out.println("Iniciando o jogo no Console");
		int i = 0;
		do {
			if (Jogo.getJogadores()[i] instanceof JogadorReal) {
				do {
				System.out.println("Escolha uma das opcoes: \n[1]Ver carta do topo \n[2]Ver Baralho \n[3]Jogar Rodada");
				opcao = scan.nextInt();
				if (opcao == 1)
					System.out.println(Jogo.getJogadores()[i].getMonte().pegarTopo().toString());
				else if (opcao == 2)
					Jogo.getJogadores()[i].getMonte().listarCartas();
				}while (opcao != 3);
				
				if (opcao == 3) {
					System.out.println("Escolha um atributo: ");
					escolherAtributo();
					if (Jogo.identificarTrunfo() && Jogo.identificarCartaA() == false) {
						Jogo.passarCarta(Jogo.procurarTrunfo());
					} else {
						Jogo.passarCarta(i = Jogo.comparar(opcao-1));
					}
					System.out.println("O vencedor da rodada foi o jogador " + Jogo.getJogadores()[i].getNome());
				}
			}
			else {
				Random gerador = new Random();
				opcao = gerador.nextInt(Carta.getAtributos().size());
				Jogo.passarCarta(i = Jogo.comparar(opcao));
				System.out.println("O vencedor da rodada foi o jogador " + Jogo.getJogadores()[i].getNome());
			}
			for (int j = 0; j < Jogo.getJogadores().length; j++) {
				System.out.println(Jogo.getJogadores()[j].getNome() + ": " + Jogo.getJogadores()[j].getMonte().size() + " Cartas\n");
			}
			opcao = 0;
		}while (Jogo.ganhador() == false);
		System.out.println("O vencedor da partida foi: " + Jogo.getJogadores()[Jogo.getJogadordavez()].getNome());
		scan.close();
	}
	public void escolherAtributo() {
		String texto = "";
		for (int i = 0; i < qAtributos; i++) {
			texto = texto + "[" + (i+1) + "] " + Carta.getAtributos().get(i) + "\n";
		}
		System.out.println(texto);
		opcao = scan.nextInt();
	}
	
	public static int getRodada() {
		return rodada;
	}
	public static void setRodada(int rodada) {
		Console.rodada = rodada;
	}
	
}
