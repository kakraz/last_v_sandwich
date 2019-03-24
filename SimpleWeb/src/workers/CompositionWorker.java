package workers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.LinkedList;
//import java.util.List;

//import com.example.sandwich.model.Composition;

import java.sql.Connection;

public class CompositionWorker {
    public static void createComposition(Connection connection, Integer Sandwiches_id, Integer Ingredients_comp_id) throws SQLException {
        String sql = "INSERT INTO Composition (S_id, I_id) VALUES (?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, Sandwiches_id);
        pstm.setInt(2, Ingredients_comp_id);
        pstm.executeUpdate();
    }

    public static void deleteComposition(Connection connection, Integer Sandwiches_id, Integer Ingredients_comp_id) throws SQLException {
        String sql = "DELETE FROM Composition WHERE S_id = ? and I_id  = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, Sandwiches_id);
        pstm.setInt(2, Ingredients_comp_id);
        pstm.executeUpdate();
    }

    public static void updateComposition(Connection connection, Integer Sandwiches_id, Integer Ingredients_comp_id, Integer ing_numb) throws SQLException {
        String sql = "UPDATE Composition SET ing_numb = ? WHERE S_id = ? and I_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, ing_numb);
        pstm.setInt(2, Sandwiches_id);
        pstm.setInt(3, Ingredients_comp_id);
        pstm.executeUpdate();
    }

    public static Integer getNumbForSandwich(Connection connection, Integer Sandwiches_id, Integer Ingredients_comp_id) throws SQLException {
        String sql = "select * from  Composition where S_id = ? and I_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, Sandwiches_id);
        pstm.setInt(2, Ingredients_comp_id);
        ResultSet rs = pstm.executeQuery();
        while(rs.next()) {
        	return rs.getInt("ing_numb");
        }
		return null;
    }

}