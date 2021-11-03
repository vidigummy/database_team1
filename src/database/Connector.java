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
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String usr = "root";
            String passwd = "fbehddls147!";
            String url = "jdbc:mysql://101.101.219.145:3306/hw2";
            conn = DriverManager.getConnection(url, usr, passwd);
            System.out.println("SQL 연결 성공");
        }catch(SQLException e){
            System.out.println("db 연결 실패");
        }catch(ClassNotFoundException e){
            System.out.println("Class not found");
            System.out.print(e);
        }
    }
}
