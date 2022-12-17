
public class Carta extends Atributos{

	private String codigo;
	private String extra;
	private String nome;
	Carta (int quantidadeAtributos){
		super(quantidadeAtributos);
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
