package workers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Addition;

import java.sql.Connection;

public class AdditionWorker {
    public static void createAddition(Connection connection, Integer add_id, String complement, String type) throws SQLException {
        String sql = "INSERT INTO Addition (id, complement, type) VALUES (?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, add_id);
        pstm.setString(2, complement);
        pstm.setString(3, type);
        pstm.executeUpdate();
    }

    public static  void updateAddition(Connection connection, Integer add_id, String complement, String type) throws SQLException {
        String sql = "UPDATE Addition SET complement = ?, type = ? WHERE add_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, complement);
        pstm.setString(2, type);
        pstm.setInt(3, add_id);
        pstm.executeUpdate();
    }

    public static void deleteAddition(Connection connection, Integer add_id) throws SQLException {
        String sql = "DELETE FROM Addition WHERE add_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, add_id);
        pstm.executeUpdate();
    }

    public static List <Addition> getAllAdditions(Connection connection) throws SQLException {
        List<Addition> ll = new LinkedList<Addition>();
        String sql = "SELECT * FROM Addition";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            Addition addition = new Addition(rs.getInt("add_id"), rs.getString("complement"), rs.getString("type"));
            ll.add(addition);
        }
        return ll;
    }

    public static List<Addition> getAdditionForSandwich(Connection connection, Integer id) throws SQLException {
        List<Addition> ll = new LinkedList<Addition>();
        String sql = "select * from Addition where add_id in (select A_id from Compability where S_id = ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            Addition addition = new Addition(rs.getInt("add_id"), rs.getString("complement"), rs.getString("type"));
            ll.add(addition);
        }
        return ll;
    }
}