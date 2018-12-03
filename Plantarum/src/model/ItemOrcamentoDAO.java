package model;
import java.sql.SQLException;

import services.DB;

public class ItemOrcamentoDAO implements DAO{
	//item_orcamento
	//		1				2					3					4				5
	//	cod_iorcamento	compra_iorcamento	qtdprod_iorcamento	fk_orcamento	fk_planta
	//		cod				compraitem			qtd				orcamento		planta
	
	public ItemOrcamento Io = new ItemOrcamento();
	public DB bd = new DB();
	private String sql, ret;
	
	/**
	 * Atualiza o cadastro de um Item do orcamento
	 * @param Io - Item do orcamento a ser atualizado
	 * @return String - Sucesso ou mensagem de erro
	 */
	public String update(ItemOrcamento Io) {
		sql = "update vendedor set compra_iorcamento=?, compra_iorcamento=?, qtdprod_iorcamento=?, fk_orcamento=? where cod_vendedor=?";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, Io.getCompraitem());
			bd.st.setInt(2, Io.getQtd());
			bd.st.setInt(3, Io.orcamento.getCod());
			bd.st.setInt(4, Io.planta.getCod());
			bd.st.setInt(5, Io.getCod());
			bd.st.executeUpdate();
			ret = "Sucesso na alteração";
		} catch (SQLException e) {
			ret = "Falha " + e.toString();
		}
		finally {
			bd.close();
		}
		return ret;
	}
	
	/**
	 * Função para localizar um determinado Item do orcamento através do seu código
	 * @param codigo - codigo do Item do orcamento a ser buscado
	 * @return ItemOrcamento - Retorna o objeto do Item do orcamento que será localizado; se null, o Item do orcamento não foi encontrado.
	 */
	public ItemOrcamento localizar(int codigo) {
		sql = "select * from item_orcamento where cod_iorcamento=?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigo);
			bd.rs = bd.st.executeQuery();
			if (bd.rs.next()) { // copia bd-->objeto
				Io.setCod(bd.rs.getInt(1));
				Io.setCompraitem(bd.rs.getInt(2));
				Io.setQtd(bd.rs.getInt(3));
				Io.orcamento.setCod(bd.rs.getInt(4));
				Io.planta.setCod(bd.rs.getInt(5));
				return Io;
			} else {
				return null;
			}
		} catch (SQLException erro) {
			return null;
		} finally {
			bd.close();
		}
	}
	
	@Override
	public String Excluir(int codigo) {
		sql = "delete from vendedor where cod_iorcamento=?";
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
		sql = "select * from item_orcamento";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while (bd.rs.next()) {
				System.out.println("[" + bd.rs.getInt(1) + ", " + bd.rs.getInt(2) + ", " + bd.rs.getInt(3) + ", "+bd.rs.getInt(4)+", "
						+ bd.rs.getInt(5) + "]");
			}
		} catch (SQLException erro) {
			System.out.println(erro.toString());
		} finally {
			bd.close();
		}
	}
	
}
