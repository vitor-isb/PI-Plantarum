package model;

public class Cliente{
	private int cod;
	private String nome, cpf, email, contato, endereco, cidade;
	
	public Cliente() {
		
	}
	
        public Cliente(String nome, String cpf, String email, String contato, String endereco, String cidade) {
//		this.cod = cod;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.contato = contato;
		this.endereco = endereco;
                this.cidade = cidade;
	}
        
	public Cliente(int cod, String nome, String cpf, String email, String contato, String endereco, String cidade) {
		this.cod = cod;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.contato = contato;
		this.endereco = endereco;
                this.cidade = cidade;
	}
	
	public int getCod() {
		return cod;
	}
	
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContato() {
		return contato;
	}
	
	public void setContato(String contato) {
		this.contato = contato;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
        
        public String getCidade(){
            return cidade;
        }
        
        public void setCidade(String cidade){
            this.cidade = cidade;
        }
	
}
