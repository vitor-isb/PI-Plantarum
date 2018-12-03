package model;

import java.sql.SQLException;
import java.util.ArrayList;

import services.DB;

public class ClienteDAO implements DAO{
	public Cliente c = new Cliente();
	public DB bd = new DB();
	private String sql, ret;
	
	//			1			2					3				4						5					6
	//	cod_cliente		nome_cliente		cpf_cliente		email_cliente		contato_cliente		endereco_cliente
	//		cod				nome				cpf				email				contato				endereco
	
        public ArrayList<Cliente> lista() {
        ArrayList<Cliente> lista = new ArrayList<>();
        sql = "select * from cliente";
        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.rs = bd.st.executeQuery();
            Vendedor v;
            while (bd.rs.next()) {
                c = new Cliente(bd.rs.getInt(1), bd.rs.getString(2), bd.rs.getString(3), bd.rs.getString(4),
				bd.rs.getString(5), bd.rs.getString(6), bd.rs.getString(7));
                lista.add(c);
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
	 * Grava o cadastro de um Cliente.
	 * @param c - o Cliente a ser salvo.
	 * @return String - mensagem de sucesso ou falha.
	 */
	public String salvar(Cliente c) {
		sql = "INSERT INTO [dbo].[cliente] ([nome_cliente], [cpf_cliente], "
                        + "[email_cliente], [contato_cliente], [endereco_cliente], "
                        + "[cidade_cliente]) VALUES (?,?,?,?,?,?)";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, c.getNome());
			bd.st.setString(2, c.getCpf());
			bd.st.setString(3, c.getEmail());
			bd.st.setString(4, c.getContato());
			bd.st.setString(5, c.getEndereco());
                        bd.st.setString(6, c.getCidade());
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
	 * Atualiza o cadastro de um Cliente
	 * @param c - Cliente a ser atualizado
	 * @return String - Sucesso ou mensagem de erro
	 */
	public String update(Cliente c) {
		sql = "update cliente set nome_cliente=?, cpf_cliente=?, email_cliente=?, contato_cliente=?, endereco_cliente=? where cod_cliente=?";
		try {
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, c.getNome());
			bd.st.setString(2, c.getCpf());
			bd.st.setString(3, c.getEmail());
			bd.st.setString(4, c.getContato());
			bd.st.setString(5, c.getEndereco());
			bd.st.setInt(6, c.getCod());
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
	 * Função para localizar um determinado Cliente através do seu código.
	 * @param codigo - codigo do Cliente a ser buscado.
	 * @return Cliente - Retorna o objeto do Cliente que será localizado; se null, o Cliente não foi encontrado.
	 */
	public Cliente localizar(int codigo) {
		sql = "select * from cliente where cod_cliente=?";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codigo);
			bd.rs = bd.st.executeQuery();
			if (bd.rs.next()) { // copia bd-->objeto
				c.setCod(bd.rs.getInt(1));
				c.setNome(bd.rs.getString(2));
				c.setCpf(bd.rs.getString(3));
				c.setEmail(bd.rs.getString(4));
				c.setContato(bd.rs.getString(5));
				c.setEndereco(bd.rs.getString(6));
				return c;
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
		sql = "select * from cliente";
		try {
			bd.getConnection();
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while (bd.rs.next()) {
				System.out.println("[" + bd.rs.getInt(1) + "," + 
										bd.rs.getString(2) + "," + 
										bd.rs.getString(3) + "," + 
										bd.rs.getString(4) + "," + 
										bd.rs.getString(5) + "," + 
										bd.rs.getString(6) + "]");
			}
		} catch (SQLException erro) {
			System.out.println(erro.toString());
		} finally {
			bd.close();
		}
	}

	@Override
	public String Excluir(int codigo) {
		sql = "delete from cliente where cod_cliente=?";
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
