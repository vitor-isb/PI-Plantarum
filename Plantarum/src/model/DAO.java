package model;

public interface DAO {
	/**
	 * Listar todos os dados de uma tabela; o retorno será no console.
	 */
	public void listar();
	
	/**
	 * Excluir um item que possua um determinado código.
	 * @param codigo - codigo do item que deve ser excluído.
	 * @return String - retornar mensagem de sucesso na exclusão, caso seja encontrado o código do item, e mensagem de erro caso não seja.
	 */
	public String Excluir(int codigo);
	

}
