package model;
import java.sql.SQLException;
import java.util.ArrayList;
import services.DB;

public class VendedorDAO implements DAO{

    public Vendedor v = new Vendedor();
    public DB bd = new DB();
    private String sql, ret; // variáveis internas

    public VendedorDAO(String usuario, String senha){
        v.setNome(usuario);
        v.setSenha(senha);
    }
    
    public VendedorDAO(){
        
    }
    /**
     * Esse método retorna uma lista com todos os vendedores dentro do banco de dados
     * @return lista do tipo vendedor
     */
    public ArrayList<Vendedor> lista() {
        ArrayList<Vendedor> lista = new ArrayList<>();
        sql = "SELECT [cod_vendedor], [nome_vendedor], [cpf_vendedor], "
                + "[sal_vendedor], [senha_vendedor], [email_vendedor], "
                + "[endereco_vendedor], [cidade_vendedor] FROM [dbo].[vendedor]";
        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.rs = bd.st.executeQuery();
            Vendedor v;
            while (bd.rs.next()) {
                v = new Vendedor(bd.rs.getInt(1), bd.rs.getString(2), bd.rs.getString(3),
                        bd.rs.getDouble(4), bd.rs.getString(5), bd.rs.getString(6),
                        bd.rs.getString(7), bd.rs.getString(8));
                lista.add(v);
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
     * Grava o cadastro de um Vendedor
     * 
     * @param v - o Vendedor a ser salvo
     * @return String - mensagem de retorno
     */
    public String salvar(Vendedor v) {
    	sql = "INSERT INTO [dbo].[vendedor]"
                + "([nome_vendedor], [cpf_vendedor], [sal_vendedor], "
                + "[senha_vendedor],[email_vendedor],[endereco_vendedor],"
                + "[cidade_vendedor]) VALUES(?,?,?,?,?,?,?)";
    	try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setString(1, v.getNome());
            bd.st.setString(2, v.getCpf());
            bd.st.setDouble(3, v.getSalario());
            bd.st.setString(4, v.getSenha());
            bd.st.setString(5, v.getEmail());
            bd.st.setString(6, v.getEndereco());
            bd.st.setString(7, v.getCidade());
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
     * Atualiza o cadastro de um vendedor
     * @param v - Vendedor a ser atualizado
     * @return String - Sucesso ou mensagem de erro
     */
    public String update(Vendedor v) {
    	sql = "update vendedor set nome_vendedor=?, cpf_vendedor=?, sal_vendedor=?, senha_vendedor=?, email_vendedor =? where cod_vendedor=?";
	try {
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setString(1, v.getNome());
            bd.st.setString(2, v.getCpf());
            bd.st.setDouble(3, v.getSalario());
            bd.st.setString(4, v.getSenha());
            bd.st.setString(5, v.getEmail());
            bd.st.setInt(6, v.getCod());
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
     * Função para localizar um determinado vendedor através do seu código
     * @param codigo - codigo do vendedor a ser buscado
     * @return Vendedor - Retorna o objeto do vendedor que será localizado; se null, o vendedor não foi encontrado.
     */
    public Vendedor localizar(int codigo) {
	sql = "select * from vendedor where cod_vendedor = ?";
	try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1, codigo);
            bd.rs = bd.st.executeQuery();
            if (bd.rs.next()) { // copia bd-->objeto
		v.setCod(bd.rs.getInt(1));
		v.setNome(bd.rs.getString(2));
		v.setCpf(bd.rs.getString(3));
		v.setSalario(bd.rs.getDouble(4));
                v.setSenha(bd.rs.getString(5));
                v.setEmail(bd.rs.getString(6));
                v.setEndereco(bd.rs.getString(7));
                v.setCidade(bd.rs.getString(8));
		return v;
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
	sql = "delete from vendedor where cod_vendedor=?";
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
        sql = "select * from vendedor";
        try {
            bd.getConnection();
            bd.st = bd.con.prepareStatement(sql);
            bd.rs = bd.st.executeQuery();
            while (bd.rs.next()) {
                System.out.println("[" + bd.rs.getInt(1) + "," + bd.rs.getString(2) + "," + bd.rs.getFloat(3) + ","
                        + bd.rs.getInt(4) + "]");
            }
        } catch (SQLException erro) {
            System.out.println(erro.toString());
        } finally {
            bd.close();
        }
    }
}
