package model;
import java.sql.SQLException;
import java.util.ArrayList;

import services.DB;
public class OrcamentoDAO implements DAO{
	
	//		1				2				3			4				5
	//	cod_orcamento	data_orcamento	num_pedido	fk_vendedor		fk_cliente
	//		cod				data		numpedido 		ven				cli;
	
    public Orcamento o = new Orcamento();
    public DB bd = new DB();
    private String sql, ret;
	
    public ArrayList<Orcamento> lista(boolean venda) {
        ArrayList<Orcamento> lista = new ArrayList<>();
        sql = "SELECT [cod_orcamento], [data_orcamento], [fk_vendedor], [fk_cliente], "
                + "[venda] FROM [dbo].[orcamento]";
        if(venda)
            sql+=" where venda = 1";
        else
            sql+=" where venda = 0";
        
        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.rs = bd.st.executeQuery();
            Orcamento o;
            while (bd.rs.next()) {
                o = new Orcamento(bd.rs.getInt(1), bd.rs.getString(2),
                        bd.rs.getInt(3), bd.rs.getInt(4), venda);
                lista.add(o);
            }
            return lista;
        } catch (SQLException erro) {
            System.out.println(erro.toString());
        } finally {
            bd.close();
        }
        return lista;
    }
        
	/**
	 * Grava o cadastro de um Orçamento
	 * @param o - o Orçamento a ser salvo
	 * @return String - mensagem de retorno
	 */
    public String salvar(Orcamento o) {
	sql = "insert into orcamento values (?,?,?,?)";
	try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1, o.getCod());
            bd.st.setString(2, o.getData());
            bd.st.setInt(3, o.getVen());
            bd.st.setInt(4, o.getCli());
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
	 * Atualiza o cadastro de um Orçamento
	 * @param o - Orçamento a ser atualizado
	 * @return String - Sucesso ou mensagem de erro
	 */
	public String update(Orcamento o) {
		sql = "update orcamento set data_orcamento=?, fk_vendedor=?, fk_cliente=? where cod_orcamento=?";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, o.getData());
			bd.st.setInt(2, o.getVen());
			bd.st.setInt(3, o.getCli());
			bd.st.setInt(4, o.getCod());
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
	 * Função para localizar um determinado orcamento através do seu código
	 * @param codigo - codigo do orcamento a ser buscado
	 * @return Orcamento - Retorna o objeto do orcamento que será localizado; se null, o orcamento não foi encontrado.
	 */
	public Orcamento localizar(int codigo) {
		sql = "select * from orcamento where cod_orcamento=?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigo);
			bd.rs = bd.st.executeQuery();
			if (bd.rs.next()) { // copia bd-->objeto
				o.setCod(bd.rs.getInt(1));
				o.setData(bd.rs.getString(2));
				o.setVen(bd.rs.getInt(3));
				o.setCli(bd.rs.getInt(4));
				return o;
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
	public void listar() {
		sql = "select * from orcamento";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while (bd.rs.next()) {
				System.out.println("[" + bd.rs.getInt(1) + ", " + bd.rs.getString(2) + ", " + bd.rs.getInt(4)+ ", "
						+ bd.rs.getInt(5) + "]");
			}
		} catch (SQLException erro) {
			System.out.println(erro.toString());
		} finally {
			bd.close();
		}
	}
	
	@Override
	public String Excluir(int codigo) {
		sql = "delete from orcamento where cod_orcamento=?";
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
	
}
