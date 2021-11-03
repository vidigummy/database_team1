package database;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Connector {
    Connection connection;
    public void connect(){
        System.out.println("??");
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String usr = "adm";
            String passwd = "database";
            String url = "jdbc:mysql://49.50.167.99:3306/company";
            conn = DriverManager.getConnection(url, usr, passwd);
            System.out.println("SQL 연결 성공");
        }catch(SQLException e){
            System.out.println("db 연결 실패");
            System.out.println(e);
            e.printStackTrace();
            e.getErrorCode();
        }catch(ClassNotFoundException e){
            System.out.println("Class not found");
            System.out.print(e);
        }
    }
}
