package model;

public class ItemOrcamento {
	private int cod, compraitem, qtd;
	public Orcamento orcamento;
	public Estoque planta;
	
	public ItemOrcamento(int cod, int compraitem, int qtd, Orcamento orcamento, Estoque planta) {
		this.cod = cod;
		this.compraitem = compraitem;
		this.qtd = qtd;
		this.orcamento = orcamento;
		this.planta = planta;
	}
	
	public ItemOrcamento() {
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public int getCompraitem() {
		return compraitem;
	}
	public void setCompraitem(int compraitem) {
		this.compraitem = compraitem;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public Orcamento getOrcamento() {
		return orcamento;
	}
	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}
	public Estoque getPlanta() {
		return planta;
	}
	public void setPlanta(Estoque planta) {
		this.planta = planta;
	}
	
}
