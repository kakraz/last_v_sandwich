package workers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Admins;

import java.sql.Connection;

public class AdminWorker {
    public static void createAdmin(Connection connection, Integer adm_id, String login, String password) throws SQLException {
        String sql = "INSERT INTO Admin (id, login, password) VALUES (?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, adm_id);
        pstm.setString(2, login);
        pstm.setString(3, password);
        pstm.executeUpdate();
    }

    public static void updateAdmin(Connection connection, Integer adm_id, String login, String password) throws SQLException {
        String sql = "UPDATE Admin SET login = ?, password = ? WHERE adm_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, login);
        pstm.setString(2, password);
        pstm.setInt(3, adm_id);
        pstm.executeUpdate();
    }

    public static void deleteAdmin(Connection connection, Integer adm_id) throws SQLException {
        String sql = "DELETE FROM Admin WHERE adm_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, adm_id);
        pstm.executeUpdate();
    }

    public static List <Admins> getAllAdmins(Connection connection) throws SQLException {
        List<Admins> ll = new LinkedList<Admins>();
        String sql = "SELECT * FROM Admin";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            Admins Admin = new Admins(rs.getInt("adm_id"), rs.getString("login"), rs.getString("password"));
            ll.add(Admin);
        }
        return ll;
    }
    
    public static Admins findAdmin(Connection connection, String login, String password) throws SQLException {
    	String sql = "SELECT * from Admins where login = ? and passwordS = ?";
    	PreparedStatement pstm = connection.prepareStatement(sql);
    	pstm.setString(1, login);
    	pstm.setString(2, password);
    	ResultSet rs = pstm.executeQuery();
    	 while (rs.next()){
             Admins Admin = new Admins(rs.getInt("adm_id"), rs.getString("login"), rs.getString("passwordS"));
             return Admin;
         }
		return null;
    	
    }

}