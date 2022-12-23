import java.util.List;

public class Carta{
	// Variaveis de classe / comuns a todas as cartas
	private static List<String> atributos;
	private static List<String> unidade;
	
	private String nome;
	private String codigo;
	private String extra;
	private Atributos valor;
	public Carta(){}
	
	public String toString() {
		String textojogo = "";
		for (int i = 0; i < atributos.size(); i++) {
			if (valor.getValor().get(i) instanceof Double) {
				textojogo.concat(";\n" + atributos.get(i) + ": " + valor.getValor().get(i).intValue() + " " + unidade.get(i));
			}
			if (valor.getValor().get(i) instanceof Integer) {
				textojogo.concat(";\n" + atributos.get(i) + ": " + valor.getValor().get(i).intValue() + " " + unidade.get(i));
			}
		}
		String texto = "Codigo: " + this.codigo + ";\nNome: " + this.nome + 
				";\nExtra: " + this.extra + textojogo;
		return texto;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public Atributos getValor() {
		return valor;
	}
	public void setValor(Atributos valor) {
		this.valor = valor;
	}
	
	// Variaveis de classe
	public static List<String> getAtributos() {
		return atributos;
	}
	public static void setAtributos(List<String> atributos) {
		Carta.atributos = atributos;
	}
	public static List<String> getUnidade() {
		return unidade;
	}
	public static void setUnidade(List<String> unidade) {
		Carta.unidade = unidade;
	}
}
