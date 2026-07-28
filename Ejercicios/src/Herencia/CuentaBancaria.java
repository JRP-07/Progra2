package Herencia;

import java.util.Calendar;

public class CuentaBancaria {
    protected int numero;
    protected double saldo;
    protected String cliente, moneda;
    protected Calendar calendario;

    public CuentaBancaria(int numero, double saldo, String cliente, String moneda){
        this.numero=numero;
        this.saldo=saldo;
        
    }
}
