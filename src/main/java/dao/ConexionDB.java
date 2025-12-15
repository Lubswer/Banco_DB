package dao;
import java.sql.*;

public class ConexionDB {
    public static Connection getConnection() throws SQLException {
        String usuarioDB = "postgres";
        String claveDB = "root";
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/banco",usuarioDB,claveDB);
    }


}
