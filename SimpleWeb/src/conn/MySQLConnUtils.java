package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
  
public class MySQLConnUtils {
  
 public static Connection getMySQLConnection()
         throws ClassNotFoundException, SQLException {
     // ����������: �������� ��������� ���������� ��������������.
     String hostName = "localhost";
     String dbName = "mytest";
     String userName = "root";
     String password = "12345";
     return getMySQLConnection(hostName, dbName, userName, password);
 }
  
 public static Connection getMySQLConnection(String hostName, String dbName,
         String userName, String password) throws SQLException,
         ClassNotFoundException {
    
     Class.forName("com.mysql.cj.jdbc.Driver");
  
     // ��������� URL Connection ��� MySQL:
     // ��������:
     // jdbc:mysql://localhost:3306/simplehr
     String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?useSSL=false&serverTimezone=UTC";
  
     Connection conn = DriverManager.getConnection(connectionURL, userName, password);
     return conn;
 }
}