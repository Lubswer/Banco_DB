package service;
import dao.UsuarioDao;
import model.Usuario;
public class LoginService {
    public static Usuario verificarLogin(String nombre, String clave) {

        Usuario u = UsuarioDao.buscarPorNombre(nombre);

        if (u == null) {
            throw new IllegalArgumentException("Usuario no existe");
        }

        if (!u.getClave().equals(clave)) {
            throw new IllegalArgumentException("Clave o Usuario incorrecto");
        }

        return u; // login exitoso
    }
}
