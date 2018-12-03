package model;

public class Orcamento {
	private int cod;
	private String data;
	public int ven;
	public int cli;
        private boolean venda;
	
	public Orcamento(int cod, String data, int ven, int cli, boolean venda) {
		this.cod = cod;
		this.data = data;
		this.ven = ven;
                this.cli = cli;
	}
        
        public Orcamento(String data, int ven, int cli, boolean venda) {
//		this.cod = cod;
		this.data = data;
		this.ven = ven;
                this.cli = cli;
	}

	public Orcamento() {}
	
	public int getCod() {
		return cod;
	}
        
	public void setCod(int cod) {
		this.cod = cod;
	}
        
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
        
	public int getVen() {
		return ven;
	}
        
	public void setVen(int ven) {
		this.ven = ven;
	}
        
	public int getCli() {
		return cli;
	}
        
	public void setCli(int cli) {
		this.cli = cli;
	}
        
        public boolean getVenda(){
            return venda;
        }
        
        public void setVenda(boolean venda){
            this.venda = venda;
        }
}
