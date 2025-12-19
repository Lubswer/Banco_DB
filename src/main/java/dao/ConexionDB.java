package dao;
import java.sql.*;

public class ConexionDB {

    public static Connection getConnection() throws SQLException {

        String url = "jdbc:postgresql://metro.proxy.rlwy.net:39581/railway";  //conexion a la base de datos
        String usuarioDB = "postgres";
        String claveDB = "hsElgzOUPhMfuaJkQakPrhVNiTOCJkUs";

        return DriverManager.getConnection(url, usuarioDB, claveDB);
    }
}
