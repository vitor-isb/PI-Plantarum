package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
    public Connection con;
    public PreparedStatement st;
    public ResultSet rs;
    private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //**
    private final String BANCO = "Plantarum";//nome do banco de dados
    private final String URL = "jdbc:sqlserver://localhost:1433;databasename=" + BANCO; //**
    private final String LOGIN = "sa";
    private final String SENHA = "teste123";

    /**
     * FunÃ§Ã£o que faz a conexÃ£o ao banco de dados
     * @return Boolean - Conectou ou nÃ£o.
     */
    public boolean getConnection() {
    	try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, LOGIN, SENHA);
            System.out.println("conectou");
            return true;
    	}
    	catch(ClassNotFoundException erro) {
            System.out.println(erro.toString());
            return false;
    	}
    	catch(SQLException erro) {
            System.out.println(erro.toString());
            return false;
    	}
    }
    
    /**
     * Encerra a conexÃ£o com o banco de dados
     */
    public void close() {
    	try {
            if(rs!=null)
                rs.close();
        }
        catch(SQLException e) {System.out.println(e.toString());}
        try {
            if(st!=null)
                st.close();
        }
        catch(SQLException e) {System.out.println(e.toString());}
        try {
            if(con!=null){
                con.close();
                System.out.println("Desconectou");
            }
        }
        catch(SQLException e) {
        }
    }

    public static void main(String[] args) throws SQLException {
        DB bd = new DB();
        bd.getConnection();
        bd.close();
    }
}
