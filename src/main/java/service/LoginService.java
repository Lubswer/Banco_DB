package service;

import dao.CuentanDao;
import dao.UsuarioDao;
import model.Usuario;

import static dao.UsuarioDao.buscarUsuario;


public class LoginService {

    static Usuario u = new Usuario(0, "ninguno", "@", ""); // en esata parte hago el control de sesiones

    public static Usuario verificarLogin(String nombre, String clave) {
        //Me falta implementar el metodo para validar que el usuario no existe
        u = UsuarioDao.cargarUsuario(nombre);

        if (!buscarUsuario(nombre)) {
            throw new IllegalArgumentException("El usuario no existe");
        }
        if (u.getNombre() == null && !u.getNombre().isBlank()) { //acá me falta hacerle mejor, no le rganice bien la lógica
            throw new IllegalArgumentException("Campo usuario vacio");
        }

        if (!u.getClave().equals(clave)) {
            System.out.println("Clave: " + u.getClave());
            throw new IllegalArgumentException("Clave o Usuario incorrecto");

        }
        CuentanDao.mandarCuenta(u);


        return u; // login exitoso


    }

    public static void buscarDestinatario(String nombre) {

        if(buscarUsuario(nombre)){
            System.out.println("si se encontro");
        }else{
            throw new IllegalArgumentException("Cuenta no encontrada");
        }
    }


    public static String nombreCuenta() {
        String nc = String.valueOf(u.getNombre());
        return nc;
    }
}
