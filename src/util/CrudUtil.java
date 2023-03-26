package util;

import com.developerstack.Medex.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {
    private static PreparedStatement execute(String sql, Object... Params) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        for (int i = 0; i < Params.length; i++) {
            pstm.setObject(i+1,Params[i]);
        }
        return pstm;
    }
    public static boolean executeUpdate(String sql, Object... Params) throws SQLException, ClassNotFoundException {
        /*PreparedStatement pstm = execute(sql, Params);
        int i = pstm.executeUpdate();
        if (i>0){
            return true;
        }else {
            return false;
        }*/
        //=====================================
        return execute(sql, Params).executeUpdate()>0;
    }
}
