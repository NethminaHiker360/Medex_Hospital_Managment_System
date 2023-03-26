package util;

import com.developerstack.Medex.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudUtil {
    public static <T> T execute(String sql, Object... Params) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);
        for (int i = 0; i < Params.length; i++) {
            pstm.setObject(i+1,Params[i]);
        }
        if (sql.startsWith("SELECT")){
            return (T) pstm.executeQuery();
        }
        return (T) (Boolean) (pstm.executeUpdate()>0);
    }
    /*public static boolean executeUpdate(String sql, Object... Params) throws SQLException, ClassNotFoundException {
        *//*PreparedStatement pstm = execute(sql, Params);
        int i = pstm.executeUpdate();
        if (i>0){
            return true;
        }else {
            return false;
        }*//*
        //=====================================
        return execute(sql, Params).executeUpdate()>0;
    }
    public static ResultSet executeQuery(String sql, Object... Params) throws SQLException, ClassNotFoundException {
        return execute(sql, Params).executeQuery();
    }*/
}
