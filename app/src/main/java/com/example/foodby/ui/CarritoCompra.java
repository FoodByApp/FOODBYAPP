package com.example.foodby.ui;

public class CarritoCompra {

    private static int pos = 0;
    private static double total = 0;
    private static String datos = "";
    private static String carrito[][] = {
            {"0","Nada","0"}, {"0","Nada","0"},
            {"0","Nada","0"}, {"0","Nada","0"},
            {"0","Nada","0"}, {"0","Nada","0"},
            {"0","Nada","0"}, {"0","Nada","0"},
            {"0","Nada","0"}, {"0","Nada","0"}};


    public static void AgregarCarrito(int p, String dato, int cant, double precio) {
        Double tot = cant * precio;

        carrito[p][1] = dato;
        carrito[p][0] = String.valueOf(cant);
        carrito[p][2] = String.valueOf(tot);
        pos++;
    }

    public static int getPos() { return pos; }

    public static String getDatos() {
        datos = "";
        for (int i = 0; i < 10; i++) {
            if( !carrito[i][0].equals("0") )
                datos += carrito [i][0] + ", " + carrito [i][1] + ", " + carrito [i][2] + "\n";
        }
        return datos;
    }

    public static double getTotal() {
        total = 0;
        for (int i = 0; i < 10; i++) {
            double precio = Double.parseDouble(carrito[i][2]);
            total += precio;
        }
        return total;
    }

    public static void vaciarCarrito(){
        for (int i = 0; i < 10; i++) {
            carrito [i][0] = "0";
            carrito [i][1] = "Nada";
            carrito [i][2] = "0";
        }
        pos = 0;
    }
}
