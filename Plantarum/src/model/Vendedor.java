package model;

public class Vendedor {
	private int cod;
	private String nome, cpf, senha, email, endereco, cidade;
	private double salario;
	
	public Vendedor() {
		
	}
	
        public Vendedor(int cod, String nome, String cpf, double salario, String senha, String email, String endereco, String cidade) {
		this.cod = cod;
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
                this.senha = senha;
                this.email = email;
                this.endereco = endereco;
                this.cidade = cidade;
	}
        
	public Vendedor(String nome, String cpf, double salario, String senha, String email, String endereco, String cidade) {
//		this.cod = cod;
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
                this.senha = senha;
                this.email = email;
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
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
        public String getSenha(){
            return senha;
        }
        
        public void setSenha(String senha){
            this.senha = senha;
        }
        
        public String getEmail(){
            return email;
        }
        
        public void setEmail(String email){
            this.email = email;
        }
        
        public String getEndereco(){
            return endereco;
        }
        
        public void setEndereco(String endereco){
            this.endereco = endereco;
        }
        
        public String getCidade(){
            return cidade;
        }
        
        public void setCidade(String cidade){
            this.cidade = cidade;
        }
}
