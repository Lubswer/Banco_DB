package dao;

import model.Cuenta;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CuentanDao {
    public static Cuenta mandarCuenta(Usuario us) {
// metodos para interactuar con la base de datos
        String sql = "SELECT * FROM cuenta WHERE id_usuario = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, us.getId());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Cuenta(
                            rs.getInt("id_cuenta"),
                            rs.getDouble("saldo"),
                            rs.getInt("id_usuario")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // no existe
    }

    public static void nuevoDeposito(double d, int ide) {
        String sql = "UPDATE cuenta SET saldo = saldo + ? WHERE id_usuario = ?;";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, d);
            ps.setInt(2, ide);
            ps.executeUpdate();
            System.out.println(" Saldo actualizado ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void nuevoRetiro(double r, int ide) {
        String sql = "UPDATE cuenta SET saldo = saldo - ? WHERE id_usuario = ?;";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, r);
            ps.setInt(2, ide);
            ps.executeUpdate();
            System.out.println(" Saldo actualizado ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void eliminarCuenta(int ide) {
        String sql = "DELETE FROM cliente WHERE id_usuario = ?;";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, ide);
            ps.executeUpdate();
            System.out.println(" Cuenta eliminada ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static int mandarID(String n) {
        String sql = "SELECT * FROM cliente WHERE nombre = ?";


        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, n);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return (rs.getInt("id_usuario"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0; // no existe
    }

    public static void transferirDB(double r, int ide) {
        String sql = "UPDATE cuenta SET saldo = saldo + ? WHERE id_usuario = ?;";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, r);
            ps.setInt(2, ide);
            ps.executeUpdate();
            System.out.println(" Saldo actualizado ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
