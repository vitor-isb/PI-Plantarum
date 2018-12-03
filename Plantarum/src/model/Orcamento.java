package model;

public class Orcamento {
	private int cod, numpedido;
	private String data;
	public Vendedor ven;
	public Cliente cli;
        private boolean venda;
	
	public Orcamento(int cod, String data, int numpedido, int ven, int cli, boolean venda) {
		this.cod = cod;
		this.numpedido = numpedido;
		this.data = data;
		this.ven.setCod(ven);
                this.cli.setCod(cli);
	}
        
        public Orcamento(int numpedido, String data, int ven, int cli, boolean venda) {
//		this.cod = cod;
		this.numpedido = numpedido;
		this.data = data;
		this.ven.setCod(ven);
                this.cli.setCod(cli);
	}

	public Orcamento() {}
	
	public int getCod() {
		return cod;
	}
        
	public void setCod(int cod) {
		this.cod = cod;
	}
        
	public int getNumpedido() {
		return numpedido;
	}
        
	public void setNumpedido(int numpedido) {
		this.numpedido = numpedido;
	}
        
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
        
	public Vendedor getVen() {
		return ven;
	}
        
	public void setVen(Vendedor ven) {
		this.ven = ven;
	}
        
	public Cliente getCli() {
		return cli;
	}
        
	public void setCli(Cliente cli) {
		this.cli = cli;
	}
        
        public boolean getVenda(){
            return venda;
        }
        
        public void setVenda(boolean venda){
            this.venda = venda;
        }
}
