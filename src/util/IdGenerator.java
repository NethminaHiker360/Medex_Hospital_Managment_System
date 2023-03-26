package util;

import com.developerstack.Medex.db.DBConnection;

import java.sql.*;

public class IdGenerator {
    public int generateId() {
        try {
            String sql = "SELECT user_id FROM user ORDER BY user_id DESC LIMIT 1";
            PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet rst = pstm.executeQuery();
            if (rst.next()){
                return rst.getInt(1)+1;
            }else {
                return 1;
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
