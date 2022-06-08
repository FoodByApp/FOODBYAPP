package com.example.foodby;

public class RegistrarUsuario {
    String Nombre;
    String Direccion;
    String Contraseña;
    String PedidosAnteriores;
    int NumeroControl;

    public RegistrarUsuario(String nombre, String direccion, String contraseña, String pedidos, int numeroControl){
        this.Nombre = nombre;
        this.Direccion = direccion;
        this.Contraseña = contraseña;
        this.PedidosAnteriores = pedidos;
        this.NumeroControl = numeroControl;
    }

    public String getNombre() { return Nombre; }
    public String getDireccion() { return Direccion; }
    public String getContraseña() { return Contraseña; }
    public String getPedidosAnteriores() { return PedidosAnteriores; }
    public int getNumeroControl() { return NumeroControl; }
}
