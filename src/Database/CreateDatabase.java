package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class CreateDatabase extends DBConnection {
    private Connection con;
    private final byte attempts = 6;
    
    @Override
    protected Connection getServeConnection() {
        //RECEBE A CONEXAO E O VEREFICA SE FOI BEM SUCEDIDO
        //SE A CONEXAO FOR NULO, REALIZA OUTRAS X TENTATIVAS DE CONEXAO
        byte counter = 0;
        this.con = null;
        
        while (this.con == null && counter < this.attempts) {
            this.con = super.getServeConnection();
            counter++;
        }
        return this.con;
    }
    
    @Override
    protected Connection getDatabaseConnection() {
        //RECEBE A CONEXAO E O VEREFICA SE FOI BEM SUCEDIDO
        //SE A CONEXAO FOR NULO, REALIZA OUTRAS X TENTATIVAS DE CONEXAO
        byte counter = 0;
        this.con = null;
        
        while (this.con == null && counter < this.attempts) {
            this.con = super.getDatabaseConnection();
            counter++;
        }
        return this.con;
    }
    
    private CreateDatabase() {
        this.createDatabase();
        this.createTableHistoric();
    }
    
    public static void initComponents() {
        CreateDatabase createDatabase = new CreateDatabase();
    }
    
    private int createDatabase() {
        this.con = this.getServeConnection();
        PreparedStatement stmt = null;

        if (this.con != null) {
            try {
                stmt = this.con.prepareStatement("create database if not exists calculator;");
                stmt.executeUpdate();
                
            } catch (SQLException e) {
                System.err.println("ErrorCode: " + e.getErrorCode());
                System.err.println("Error, class: 'Database', line: '46'");
                System.err.println(e.getMessage()+"\n"+e.getClass());
                return e.getErrorCode();
                
            } finally {
                super.closeConnection(this.con, stmt);
            }
        }
        return -1;
    }
    
    private int createTableHistoric() {
        this.con = this.getDatabaseConnection();
        PreparedStatement stmt = null;

        if (this.con != null) {
            try {
                stmt = this.con.prepareStatement(
                    "create table if not exists historic (" +
                    "id tinyint unsigned primary key not null auto_increment," +
                    "expression varchar(200) not null," +
                    "result varchar(200) not null," +
                    "created_at timestamp not null default current_timestamp," +
                    "updated_at timestamp on update current_timestamp," +
                    "deleted_at timestamp);"
                );
                stmt.executeUpdate();
                
            } catch (SQLException e) {
                System.err.println("ErrorCode: " + e.getErrorCode());
                System.err.println("Error, class: 'Database', line: '165'");
                System.err.println(e.getMessage()+"\n"+e.getClass());
                return e.getErrorCode();
                
            } finally {
                super.closeConnection(this.con, stmt);
            }
        }
        return -1;
    }
}
