import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int opcao = 0;
		String[] baralhos = {"Dinossauro", "Marvel", "DC"};
		JogadorAbstrato[] jogadores = new JogadorAbstrato[2];
		jogadores[0] = new JogadorReal("Fernando");
		jogadores[1] = new JogadorRandomico();
		System.out.println("Iniciando o supertrunfo" + "\n"+ "Qual baralho:");
		for (int i = 0; i < baralhos.length; i++) {
			System.out.println("["+ (i+1) + "] " + baralhos[i]);
		}
		opcao = scan.nextInt();
		new Jogo(jogadores,baralhos[opcao-1]);
		System.out.println("Onde deseja jogar?\n[1] Console\n[2] GUI");
		opcao = scan.nextInt();
		if (opcao == 1) {
			new Console();
		}
		else if (opcao == 2) {
			new Tela();
		}
	}
}
