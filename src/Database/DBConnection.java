package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class DBConnection {
    private final String driver = "com.mysql.cj.jdbc.Driver"; // DATABASE DRIVER
    private final String server = "127.0.0.1"; // SERVER IP
    private final String port = "3306"; // SERVE PORT
    private final String database = "calculator"; // DATABASE NAME
    private final String user = "root"; // DATABASE USER
    private String password = "root"; // DATABASE PASSWORD
    
    private final String urlServe = "jdbc:mysql://" + this.server + ":" + this.port + "?useTimezone=true&serverTimezone=UTC";
    private final String urlDatabase = "jdbc:mysql://" + this.server + ":" + this.port + "/" + this.database + "?useTimezone=true&serverTimezone=UTC";
    
    protected Connection getServeConnection() {
        //EFETUA A CONEXAO COM O DATABASE
        //SE FOR BEM SUCEDIDO, RETORNA A CONEXAO
        try {
            Class.forName(this.driver);
            final Connection con = DriverManager.getConnection(this.urlServe, this.user, this.password);
            return con;
            
        } catch (SQLException e) {
            if (!this.password.equals("")) {
                this.password = "";
                return this.getDatabaseConnection();
            }
            System.err.println("erro, Nao conseguiu se Conectar ao Database");
            System.out.println(e.getMessage() + "\n" + e.getClass());
            return null;
            
        } catch (ClassNotFoundException e) {
            System.err.println("erro, Nao encontrou o Driver do Database");
            System.out.println(e.getMessage() + "\n" + e.getClass());
            return null;
        }
    }
    
    protected Connection getDatabaseConnection() {
        //EFETUA A CONEXAO COM O DATABASE
        //SE FOR BEM SUCEDIDO, RETORNA A CONEXAO
        try {
            Class.forName(this.driver);
            final Connection con = DriverManager.getConnection(this.urlDatabase, this.user, this.password);
            return con;
            
        } catch (SQLException e) {
            if (!this.password.equals("")) {
                this.password = "";
                return this.getDatabaseConnection();
            }
            System.err.println("erro, Nao conseguiu se Conectar ao Database");
            System.out.println(e.getMessage() + "\n" + e.getClass());
            return null;
            
        } catch (ClassNotFoundException e) {
            System.err.println("erro, Nao encontrou o Driver do Database");
            System.out.println(e.getMessage() + "\n" + e.getClass());
            return null;
        }
    }
    
    protected void closeConnection(Connection con) {
        //FINALIZA A CONEXAO COM O DATABASE, SE ESTIVER CONECTADO
        if (con != null) {
            try {
                con.close();
                
            } catch (SQLException e) {
                System.err.println("erro, Nao conseguiu se Desconectar do Database");
                System.out.println(e.getMessage() + "\n" + e.getClass());
            }
        }
    }
    
    protected void closeConnection(Connection con, PreparedStatement stmt) {
        this.closeConnection(con);
        
        //FECHA O "PreparedStatement", SE ESTIVER ABERTO
        if (stmt != null) {
            try {
                stmt.close();
                
            } catch (SQLException e) {
                System.err.println("erro, Nao conseguiu se Desconectar do PreparedStatement");
                System.out.println(e.getMessage() + "\n" + e.getClass());
            }
        }
    }
    
    protected void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        this.closeConnection(con, stmt);
        
        //FECHA O "ResultSet", SE ESTIVER ABERTO
        if (rs != null) {
            try {
                rs.close();
                
            } catch (SQLException e) {
                System.err.println("erro, Nao conseguiu se Desconectar do ResultSet");
                System.out.println(e.getMessage() + "\n" + e.getClass());
            }
        }
    }
}
