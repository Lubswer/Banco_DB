package service;
import dao.CuentanDao;
import model.Usuario;
import model.Cuenta;

import javax.swing.*;

import static dao.CuentanDao.*;
import static service.LoginService.u;
//Logica de negosio por parte de la cuenta bancaria
public class BancoService {
    static Cuenta c = new Cuenta(0,0.00,u.getId()); // le hice un objeto temporal para solo cambiar los datos
    public static void  datosCuenta(Usuario us) {
        c = CuentanDao.mandarCuenta(us);
    } //exactamente con esto hago el control de versiones
    public static void mandarBD(String deposito){
        try{
            double monto = Double.parseDouble(deposito);
            if(monto < 0){
                throw new IllegalArgumentException("Error, el monto es NEGATIVO");
            }else{
                nuevoDeposito(monto, u.getId());
            }

        }catch (NumberFormatException ne){
            JOptionPane.showMessageDialog(null, ne.getMessage());
        }
    }
    public static String saldoCuenta(){
        datosCuenta(u);
        String sc = String.valueOf(c.getSaldo());
        return sc;
    }
    public static void retirarBD(String retiro){


        try{
            double retirar = Double.parseDouble(retiro);
            datosCuenta(u);
            if(retirar > c.getSaldo()){
                throw new IllegalArgumentException("Error, el monto es mayor a la cantidad en la cuenta");
            }else if(retirar < 0){
                throw new IllegalArgumentException("Error, el monto es menor a cero");
            }else{
                nuevoRetiro(retirar, u.getId());
            }

        }catch (NumberFormatException ne){
            JOptionPane.showMessageDialog(null, ne.getMessage());
        }
    }
    public static void eliminarBD(){
            int id_eliminar = u.getId();
            eliminarCuenta(id_eliminar);
    }
    public static int obtenerID( String nombre){
        int id = mandarID(nombre);
        return id;

    }
    public static void transfeririDestinatario( String nombre, String cantidad){
        int id = obtenerID(nombre);
        double monton = Double.parseDouble(cantidad);
        transferirDB(monton,id);
    }




}
