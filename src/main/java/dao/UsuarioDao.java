package dao;
import java.sql.*;

import model.Cuenta;
import model.Usuario;
public class UsuarioDao {
//metodos para el usuario y la base de datos
    public static Usuario cargarUsuario(String nombre) {

        String sql = "SELECT * FROM cliente WHERE nombre = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Usuario( // nos devuelve los datos recatados de la base en forma de objeto
                            rs.getInt("id_usuario"),
                            rs.getString("nombre"),
                            rs.getString("correo"),
                            rs.getString("clave")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // no existe
    }


    public static void  nuevoUsuario(String n, String c, String cl){
        String sql = "INSERT INTO cliente (nombre,correo,clave) VALUES(?,?,?);";

        try(Connection conn = ConexionDB.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, n);
            ps.setString(2, c);
            ps.setString(3, cl);
            int filas = ps.executeUpdate();
            System.out.println(" Insertado. Filas afectadas: " + filas);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static boolean buscarUsuario( String n ) {

        String sql = "SELECT * FROM cliente WHERE nombre = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, n);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // no existe
    }

    public static void listarUsuarios() {
        String sql = "SELECT * FROM cliente";

        try (Connection conn = ConexionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
