package model;

public class Estoque {
	private int cod, qtd;
	private String nome, ncientifico, familia, origem, descricao, cor, floracao;
	private float porte, displantio, tamcova, preco;

	public Estoque() {
		
	}
        
	public Estoque(String nome, String ncientifico, String familia, String origem, String descricao,
			float porte, float displantio, float tamcova, String cor, String floracao, int qtd, float preco) {
		this.qtd = qtd;
		this.nome = nome;
		this.ncientifico = ncientifico;
		this.familia = familia;
		this.origem = origem;
		this.descricao = descricao;
		this.cor = cor;
		this.floracao = floracao;
		this.porte = porte;
		this.displantio = displantio;
		this.tamcova = tamcova;
		this.preco = preco;
	}
        
	public Estoque(int cod, String nome, String ncientifico, String familia, String origem, String descricao,
			float porte, float displantio, float tamcova, String cor, String floracao, int qtd, float preco) {
		this.cod = cod;
		this.qtd = qtd;
		this.nome = nome;
		this.ncientifico = ncientifico;
		this.familia = familia;
		this.origem = origem;
		this.descricao = descricao;
		this.cor = cor;
		this.floracao = floracao;
		this.porte = porte;
		this.displantio = displantio;
		this.tamcova = tamcova;
		this.preco = preco;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNcientifico() {
		return ncientifico;
	}

	public void setNcientifico(String ncientifico) {
		this.ncientifico = ncientifico;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getFloracao() {
		return floracao;
	}

	public void setFloracao(String floracao) {
		this.floracao = floracao;
	}

	public float getPorte() {
		return porte;
	}

	public void setPorte(float porte) {
		this.porte = porte;
	}

	public float getDisplantio() {
		return displantio;
	}

	public void setDisplantio(float displantio) {
		this.displantio = displantio;
	}

	public float getTamcova() {
		return tamcova;
	}

	public void setTamcova(float tamcova) {
		this.tamcova = tamcova;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

}
