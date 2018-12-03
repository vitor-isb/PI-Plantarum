package model;

import java.sql.SQLException;
import java.util.ArrayList;

import services.DB;

public class EstoqueDAO implements DAO {

	// 1 2 3 4 5 6 7 8 9 10 11 12 13
	// cod_planta nome_planta ncientifico_planta familia_planta origem_planta
	// descricao_planta porte_planta displantio_planta tamcova_planta cor_planta
	// floracao_planta qtdestoque_planta preco_planta
	// cod nome ncientifico familia origem descricao porte displantio tamcova cor
	// floracao qtd preco

	public Estoque e = new Estoque();
	public DB bd = new DB();
	private String sql, ret;

	/**
	 * Grava o cadastro de um item do estoque.
	 * 
	 * @param e - o Item a ser salvo.
	 * @return String - mensagem de sucesso ou falha.
	 */
	public String salvar(Estoque e) {
		sql = "INSERT INTO [dbo].[estoque]([nome_planta], [ncientifico_planta], "
                        + "[familia_planta], [origem_planta], [descricao_planta], "
                        + "[porte_planta], [displantio_planta], [tamcova_planta], "
                        + "[cor_planta], [floracao_planta], [qtdestoque_planta], [preco_planta])\n" +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, e.getNome());
			bd.st.setString(2, e.getNcientifico());
			bd.st.setString(3, e.getFamilia());
			bd.st.setString(4, e.getOrigem());
			bd.st.setString(5, e.getDescricao());
			bd.st.setDouble(6, e.getPorte());
			bd.st.setDouble(7, e.getDisplantio());
			bd.st.setDouble(8, e.getTamcova());
			bd.st.setString(9, e.getCor());
			bd.st.setString(10, e.getFloracao());
			bd.st.setInt(11, e.getQtd());
			bd.st.setDouble(12, e.getPreco());
			bd.st.executeUpdate();
			ret = "Sucesso na inclusão";
		} catch (SQLException erro) {
			ret = "Falha " + erro.toString();
		} finally {
			bd.close();
		}
		return ret;
	}

	/**
	 * Atualiza o cadastro de um item no Estoque
	 * 
	 * @param e - item do Estoque a ser atualizado
	 * @return String - Sucesso ou mensagem de erro
	 */
	public String update(Estoque e) {
		sql = "update cliente set nome_planta=?, ncientifico_planta=?, "
				+ "familia_planta=?, origem_planta=?, descricao_planta=?, "
				+ "porte_planta=?, displantio_planta=?, tamcova_planta=?, "
				+ "cor_planta=?, qtdestoque_planta=?, preco_planta=? where cod_planta=?";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, e.getNome());
			bd.st.setString(2, e.getNcientifico());
			bd.st.setString(3, e.getFamilia());
			bd.st.setString(4, e.getOrigem());
			bd.st.setString(5, e.getDescricao());
			bd.st.setFloat(6, e.getPorte());
			bd.st.setFloat(7, e.getDisplantio());
			bd.st.setFloat(8, e.getTamcova());
			bd.st.setString(9, e.getCor());
			bd.st.setString(10, e.getFloracao());
			bd.st.setInt(11, e.getQtd());
			bd.st.setFloat(12, e.getPreco());
			bd.st.setInt(13, e.getCod());
			bd.st.executeUpdate();
			ret = "Sucesso na alteração";
		} catch (SQLException error) {
			ret = "Falha " + error.toString();
		} finally {
			bd.close();
		}
		return ret;
	}

	/**
	 * Função para localizar um determinado item no Estoqueatravés do seu código.
	 * 
	 * @param codigo - codigo do Item a ser buscado.
	 * @return Estoque - Retorna o objeto do item que será localizado; se null, o
	 *         item não foi encontrado.
	 */
	public Estoque localizar(int codigo) {
		sql = "select * from cliente where codigo = ?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigo);
			bd.rs = bd.st.executeQuery();
			if (bd.rs.next()) { // copia bd-->objeto
				e.setCod(bd.rs.getInt(1));
				e.setNome(bd.rs.getString(2));
				e.setNcientifico(bd.rs.getString(3));
				e.setFamilia(bd.rs.getString(4));
				e.setOrigem(bd.rs.getString(5));
				e.setDescricao(bd.rs.getString(6));
				e.setPorte(bd.rs.getFloat(7));
				e.setDisplantio(bd.rs.getFloat(8));
				e.setTamcova(bd.rs.getFloat(9));
				e.setCor(bd.rs.getString(10));
				e.setFloracao(bd.rs.getString(11));
				e.setQtd(bd.rs.getInt(12));
				e.setPreco(bd.rs.getFloat(13));
				return e;
			} else {
				return null;
			}
		} catch (SQLException erro) {
			return null;
		} finally {
			bd.close();
		}
	}

        /**
         * Lista para mostrar na tabela uma consulta no banco de dados
         * @return lista de estoque
         */
	public ArrayList<Estoque> lista() {
		ArrayList<Estoque> lista = new ArrayList<>();
		sql = "select * from estoque";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			Estoque e;
			while (bd.rs.next()) {
				e = new Estoque(bd.rs.getInt(1), bd.rs.getString(2), bd.rs.getString(3), bd.rs.getString(4),
						bd.rs.getString(5), bd.rs.getString(6), bd.rs.getFloat(7), bd.rs.getFloat(8), bd.rs.getFloat(9),
						bd.rs.getString(10), bd.rs.getString(11), bd.rs.getInt(12), bd.rs.getFloat(13));
				lista.add(e);
			}
			return lista;
		} catch (SQLException erro) {
			System.out.println(erro.toString());

		} finally {
			bd.close();
		}
		return lista;
	}

	
	@Override
	public String Excluir(int codigo) {
		sql = "delete from estoque where cod_planta=?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigo);
			int n = bd.st.executeUpdate();
			if (n == 1) {
				ret = "Exclusão realizada";
			} else {
				ret = "Código não localizado";
			}
		} catch (SQLException erro) {
			ret = "Falha " + erro.toString();
		} finally {
			bd.close();
		}
		return ret;
	}

	@Override
	public void listar() {
		sql = "select * from estoque";
		
	}

}
