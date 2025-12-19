package model;

public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String clave;

    public Usuario(int id, String nombre, String correo, String clave){
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
    }
    public String getNombre(){ return nombre;}
    public String getClave(){ return clave;}
    public int getId(){return id;}


}
