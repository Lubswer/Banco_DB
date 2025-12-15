package service;
import dao.UsuarioDao;

public class RegistroService {
    public static void registrar(String nombre, String correo, String clave, String clave2) {

        if(clave.equals(clave2)){
            if( nombre != null  && !nombre.isBlank() && correo != null && !correo.isBlank() && clave != null  && !clave.isBlank() && clave2 != null  && !clave2.isBlank()){
                UsuarioDao.nuevoUsuario(nombre, correo, clave);
            }else{
                throw new IllegalArgumentException("Algun campo no ha sido llenado");
            }
        }else{
            throw new IllegalArgumentException("Las contraseñas no coinciden");

        }
    }

}
