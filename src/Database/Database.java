package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Database extends DBConnection {
    private Connection con;
    private final byte attempts = 6;
    
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
    
    protected int truncate(String table) {
        this.con = this.getDatabaseConnection();
        PreparedStatement stmt = null;

        if (this.con != null) {
            try {
                stmt = this.con.prepareStatement("truncate table " + table + ";");
                stmt.executeUpdate();
                
            } catch (SQLException e) {
                System.err.println("ErrorCode: " + e.getErrorCode());
                System.err.println("Error, class: 'Database', line: '38'");
                System.err.println(e.getMessage()+"\n"+e.getClass());
                return e.getErrorCode();
                
            } finally {
                super.closeConnection(this.con, stmt);
            }
        }
        return -1;
    }
    
    protected int insertUpdate(String str_stmt, String[] obj) {
        this.con = this.getDatabaseConnection();
        PreparedStatement stmt = null;

        if (this.con != null) {
            try {
                stmt = this.con.prepareStatement(str_stmt);
                
                for (int index = 0; index < obj.length; index++) {
                    stmt.setString(index+1, obj[index]);
                }
                stmt.executeUpdate();
                
            } catch (SQLException e) {
                System.err.println("ErrorCode: " + e.getErrorCode());
                System.err.println("Error, class: 'Database', line: '65'");
                System.err.println(e.getMessage()+"\n"+e.getClass());
                return e.getErrorCode();
                
            } finally {
                super.closeConnection(this.con, stmt);
            }
        }
        return -1;
    }
    
    protected String[] getOne(String str_stmt) {
        this.con = this.getDatabaseConnection();
        
        if (this.con != null) {
            PreparedStatement stmt = null;
            ResultSet rs = null;
            String[] table = null;
            
            try {
                stmt = this.con.prepareStatement(str_stmt);
                rs = stmt.executeQuery();
                
                if (rs.next()) {
                    table = new String[rs.getMetaData().getColumnCount()];
                    
                    for (int index = 0; index < rs.getMetaData().getColumnCount(); index++) {
                        table[index] = rs.getString(index + 1);
                    }
                }
                return table;
                
            } catch (SQLException e) {
                System.err.println("ErrorCode: " + e.getErrorCode());
                System.err.println("Error, class: 'Database', line: '99'");
                System.err.println(e.getMessage()+"\n"+e.getClass());
                
            } finally {
                super.closeConnection(this.con, stmt, rs);
            }
        }
        return null;
    }
    
    protected ArrayList<String[]> getTable(String str_stmt) {
        this.con = this.getDatabaseConnection();
        
        if (this.con != null) {
            PreparedStatement stmt = null;
            ResultSet rs = null;
            ArrayList<String[]> tableList = new ArrayList();
            
            try {
                stmt = this.con.prepareStatement(str_stmt);
                rs = stmt.executeQuery();

                while (rs.next()) {
                    String[] itemList = new String[rs.getMetaData().getColumnCount()];

                    for (int index = 0; index < rs.getMetaData().getColumnCount(); index++) {
                        itemList[index] = rs.getString(index + 1);
                    }
                    tableList.add(itemList);
                }
                return tableList;
                
            } catch (SQLException e) {
                System.err.println("ErrorCode: " + e.getErrorCode());
                System.err.println("Error, class: 'Database', line: '133'");
                System.err.println(e.getMessage()+"\n"+e.getClass());
                
            } finally {
                super.closeConnection(this.con, stmt, rs);
            }
        }
        return null;
    }
}
