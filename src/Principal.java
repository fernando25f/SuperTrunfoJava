
public class Principal {
	public static void main(String[] args) {
		JogadorAbstrato[] jogadores = new JogadorAbstrato[2];
		jogadores[0] = new JogadorReal("Pessoa");
		jogadores[1] = new JogadorRandomico();
		new Jogo(jogadores, "DC");
		new Tela();
	}
}
