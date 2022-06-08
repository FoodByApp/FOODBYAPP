package com.example.foodby;

public class RegistroCompra {
    String Detalles;
    String Total;

    public RegistroCompra(String detalles, String total){
        this.Detalles = detalles;
        this.Total = total;
    }

    public String getDetalles() { return Detalles; }
    public String getTotal() { return Total; }
}
