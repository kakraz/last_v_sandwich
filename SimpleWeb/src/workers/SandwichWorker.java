package workers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Sandwiches;

import java.sql.Connection;

public class SandwichWorker {
    public static void createSandwich(Connection connection, Integer id, String name, String type, Integer minutes,
            String bread, String comment) throws SQLException {
        String sql = "INSERT INTO Sandwiches (id, name, type, minutes, bread, comment) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.setString(2, name);
        pstm.setString(3, type);
        pstm.setInt(4, minutes);
        pstm.setString(5, bread);
        pstm.setString(6, comment);
        pstm.executeUpdate();
    }

    public static void updateSandwich(Connection connection, Integer id, String name, String type, Integer minutes,
            String bread, String comment) throws SQLException {
        String sql = "UPDATE Sandwiches SET name = ?, type = ?, minutes = ?, bread = ?, comment = ? WHERE id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, name);
        pstm.setString(2, type);
        pstm.setInt(3, minutes);
        pstm.setString(4, bread);
        pstm.setString(5, comment);
        pstm.setInt(6, id);
        pstm.executeUpdate();
    }

    public static void deleteSandwich(Connection connection, Integer id) throws SQLException {
        String sql = "DELETE FROM Sandwiches WHERE id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.executeUpdate();
        String sql1 = "DELETE FROM Composition WHERE Sandwiches_id = ?";
        PreparedStatement pstm1 = connection.prepareStatement(sql1);
        pstm1.setInt(1, id);
        pstm1.executeUpdate();
        String sql2 = "DELETE FROM Compability  WHERE Sandwiches_id = ?";
        PreparedStatement pstm2 = connection.prepareStatement(sql2);
        pstm2.setInt(1, id);
        pstm2.executeUpdate();
    }

    public static List<Sandwiches> getAllSandwiches(Connection connection) throws SQLException {
        List<Sandwiches> ll = new LinkedList<Sandwiches>();
        String sql = "SELECT * FROM Sandwiches";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Sandwiches sandwich = new Sandwiches(rs.getInt("id"), rs.getString("name"), rs.getString("type"),
                    rs.getInt("minutes"), rs.getString("bread"), rs.getString("comment"));
            ll.add(sandwich);
        }
        return ll;
    }

    public static Sandwiches getSandwichById(Connection connection, Integer id) throws SQLException {
        String sql = "SELECT * FROM Sandwiches WHERE id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
        	Sandwiches sandwich = new Sandwiches(id, rs.getString("name"), rs.getString("type"), rs.getInt("minutes"), rs.getString("bread"), rs.getString("comment"));
            return sandwich;
        }
        return null;
    }

    public static Sandwiches getSandwichByType(Connection connection, String type) throws SQLException {
        String sql = "SELECT * FROM Sandwiches WHERE type = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, type);
        ResultSet rs = pstm.executeQuery();
        Sandwiches sandwich = new Sandwiches(rs.getInt("id"), rs.getString("name"), rs.getString("type"),
                rs.getInt("minutes"), rs.getString("bread"), rs.getString("comment"));
        return sandwich;
    }

    public static Sandwiches getSandwichByIdAndType(Connection connection, Integer id, String type) throws SQLException {
        String sql = "SELECT * FROM Sandwiches WHERE id = ? AND type = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.setString(2, type);
        ResultSet rs = pstm.executeQuery();
        Sandwiches sandwich = new Sandwiches(rs.getInt("id"), rs.getString("name"), rs.getString("type"),
                rs.getInt("minutes"), rs.getString("bread"), rs.getString("comment"));
        return sandwich;
    }

    public static List<Sandwiches> getSandwichByIngredient(Connection connection, Integer comp_id) throws SQLException {
        List<Sandwiches> ll = new LinkedList<Sandwiches>();
        String sql = "select Sandwiches.* from Sandwiches where id IN (Select Sandwiches_id from Composition where Ingredients_comp_id = ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, comp_id);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Sandwiches sandwich = new Sandwiches(rs.getInt("id"), rs.getString("name"), rs.getString("type"),
                    rs.getInt("minutes"), rs.getString("bread"), rs.getString("comment"));
            ll.add(sandwich);
        }
        return ll;
    }
}