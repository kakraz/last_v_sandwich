package workers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Ingredients;
import java.sql.Connection;

public class IngredientsWorker {
    public static void createIngredients(Connection connection, Integer comp_id, String component, String unit) throws SQLException {
        String sql = "INSERT INTO Ingredients (id, component, unit) VALUES (?, ?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, comp_id);
        pstm.setString(2, component);
        pstm.setString(3, unit);
        pstm.executeUpdate();
    }

    public static void updateIngredients(Connection connection, Integer comp_id, String component, String unit) throws SQLException {
        String sql = "UPDATE Ingredients SET component = ?, unit = ? WHERE comp_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, component);
        pstm.setString(2, unit);
        pstm.setInt(3, comp_id);
        pstm.executeUpdate();
    }

    public static void deleteIngredients(Connection connection, Integer comp_id) throws SQLException {
        String sql = "DELETE FROM Ingredients WHERE comp_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, comp_id);
        pstm.executeUpdate();
    }

    public static List <Ingredients> getAllIngredientss(Connection connection) throws SQLException {
        List<Ingredients> ll = new LinkedList<Ingredients>();
        String sql = "SELECT * FROM Ingredients";
        PreparedStatement pstm = connection.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            Ingredients Ingredients = new Ingredients(rs.getInt("comp_id"), rs.getString("comp"), rs.getString("unit"));
            ll.add(Ingredients);
        }
        return ll;
    }

    public static List<Ingredients> getIngredientsForSandwich(Connection connection, Integer id) throws SQLException {
        List<Ingredients> ll = new LinkedList<Ingredients>();
        String sql = "select * from  Ingredients where comp_id IN (select I_id from Composition where S_id = ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, id);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            Ingredients Ingredients = new Ingredients(rs.getInt("comp_id"), rs.getString("comp"), rs.getString("unit"));
            ll.add(Ingredients);
        }
        return ll;
    }
}