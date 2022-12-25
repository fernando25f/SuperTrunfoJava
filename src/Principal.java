
public class Principal {
	public static void main(String[] args) {

		JogadorAbstrato[] jogadores = new JogadorAbstrato[2];
		jogadores[0] = new JogadorReal("Pessoa");
		jogadores[1] = new JogadorRandomico();
		
		Baralho baralho = new Baralho("Dinossauro");
		baralho.carregar();
		//baralho.embaralhar();
		//baralho.listarCartas();
		baralho.distribuir(jogadores);
		jogadores[0].getMonte().listarCartas();
		//double a = Double.valueOf(baralho.get(0).getValor().getValor().get(0)).doubleValue();
		//double b = Double.valueOf(baralho.get(1).getValor().getValor().get(0)).doubleValue();
		//System.out.println("1A -- Altura: " + baralho.get(0).getValor().getValor().get(0));
		//System.out.println("2A -- Altura: " + baralho.get(1).getValor().getValor().get(0));
		//if (a >b) {
		//	System.out.println("Certo");
		//}
		
	}
}
