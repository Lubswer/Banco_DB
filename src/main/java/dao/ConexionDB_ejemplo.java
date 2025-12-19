package dao;
import java.sql.*;

public class ConexionDB_ejemplo {
    public static Connection getConnection() throws SQLException {

        String url = "TU URL";  //conexion a la base de datos
        String usuarioDB = "TU USUARIO";
        String claveDB = "TU CONTRASEÑÁ";

        return DriverManager.getConnection(url, usuarioDB, claveDB);
    }
}
