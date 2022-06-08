package com.example.foodby;

public class DatosUsuarios {
    public static String Nombre;
    public static String Direccion;
    public static String Contraseña;
    public static String PedidosAnteriores;
    public static int NumeroControl;

    public static String getNombre() { return Nombre;}
    public static void setNombre(String nombre) { Nombre = nombre; }

    public static String getDireccion() { return Direccion; }
    public static void setDireccion(String direccion) { Direccion = direccion; }

    public static String getContraseña() { return Contraseña; }
    public static void setContraseña(String contraseña) { Contraseña = contraseña; }

    public static String getPedidosAnteriores() { return PedidosAnteriores; }
    public static void setPedidosAnteriores(String pedidosAnteriores) { PedidosAnteriores = pedidosAnteriores; }

    public static int getNumeroControl() { return NumeroControl; }
    public static void setNumeroControl(int numeroControl) { NumeroControl = numeroControl; }
}
