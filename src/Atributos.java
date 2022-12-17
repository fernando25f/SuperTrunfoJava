
public class Atributos {
	private String[] atributo;
	private double[] valor;
	private String[] unidade;
	private int quantidadeAtributos;
	
	Atributos(int quantidadeAtributos){
		this.quantidadeAtributos=quantidadeAtributos;
	}
	
	public String[] getAtributo() {
		return this.atributo;
	}
	public double[] getValor() {
		return this.valor;
	}
	public String[] getUnidade() {
		return this.unidade;
	}
	public int getQuantidadeAtributos() {
		return this.quantidadeAtributos;
	}
	
	public void setAtributos(String[] atributo) {
		// pegar dados
		this.atributo = atributo;
	}
	public void setValores(double[] valor) {
		// pegar dados
		this.valor = valor;
	}
	public void setUnidades(String[] unidade) {
		// pegar dados
		this.unidade = unidade;
	}
	public void setQuantidadeAtributos(int quantidadeAtributos) {
		// pegar dados
		this.quantidadeAtributos = quantidadeAtributos;
	}
}
