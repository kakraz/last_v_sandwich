package workers;

import java.sql.PreparedStatement;
import java.sql.SQLException;


import java.sql.Connection;

public class CompabilityWorker {
    public static void createCompability(Connection connection, Integer Sandwiches_id, Integer Addition_add_id) throws SQLException {
        String sql = "INSERT INTO Compability (Sandwiches_id, Addition_add_id) VALUES (?, ?)";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, Sandwiches_id);
        pstm.setInt(2, Addition_add_id);
        pstm.executeUpdate();
    }

    public static void deleteCompability(Connection connection, Integer Sandwiches_id, Integer Addition_add_id) throws SQLException {
        String sql = "DELETE FROM Compability WHERE Sandwiches_id = ? and Addition_add_id  = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setInt(1, Sandwiches_id);
        pstm.setInt(2, Addition_add_id);
        pstm.executeUpdate();
    }
    
    
}