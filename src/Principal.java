import java.util.*;
public class Principal {
	public static void main(String[] args) {
		/*List<Number> lista = new ArrayList<Number>();
		lista.add(10);
		lista.add(14.5);
		lista.add(1223.23);
		lista.add(1212377341);
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) instanceof Double) {
				System.out.println("Double");
				System.out.println(lista.get(i).doubleValue());
			}
			if (lista.get(i) instanceof Integer) {
				System.out.println("Integer");
				System.out.println(lista.get(i).intValue());
			}
			if (lista.get(i) instanceof Long) {
				System.out.println("Long");
				System.out.println(lista.get(i).longValue());
			}
			if (lista.get(i) instanceof Float) {
				System.out.println("Float");
				System.out.println(lista.get(i).floatValue());
			}
		}
		List<String> lista = new ArrayList<String>();
		lista.add("oi");
		lista.add("mundo");
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}*/
		Baralho baralho = new Baralho("Dinossauro");
		baralho.carregar();
		//baralho.embaralhar();
		//baralho.listarCartas();
		System.out.println("1A -- Altura: " + baralho.get(0).getValor().getValor().get(0));
		System.out.println("2A -- Altura: " + baralho.get(1).getValor().getValor().get(0));
		
	}
}
