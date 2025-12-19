package model;

public class Cuenta {
    private int  id_cuenta;
    private double saldo;
    private int id_usuario;
    public Cuenta(int id_cuenta, double saldo, int id_usuario){
        this.id_cuenta = id_cuenta;
        this.saldo = saldo;
        this.id_usuario = id_usuario;
    }
    public int getId_usuarioC(){return this.id_usuario;}
    public double getSaldo(){return this.saldo;}
}
