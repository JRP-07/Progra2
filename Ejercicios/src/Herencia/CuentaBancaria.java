package Herencia;

import java.util.Calendar;

public class CuentaBancaria {
    protected int numero;
    protected double saldo;
    protected String cliente, moneda;
    protected Calendar apertura;
    protected TipoCuenta tipo;

    public CuentaBancaria(int numero, String cliente, String moneda) {
        this.numero = numero;
        this.cliente = cliente;
        this.moneda = moneda;

        saldo = 0;
        apertura = Calendar.getInstance();
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getMoneda() {
        return moneda;
    }

    public String getCliente() {
        return cliente;
    }

    public TipoCuenta getTipo() {
        return tipo;
    }

    public Calendar getApertura() {
        return apertura;
    }

    public void Depositar(int numero, double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto no puede ser negativo");
            return;
        } else
            saldo += monto;
    }

    public boolean Retirar(int numero, double monto) {
        // if(monto >0 && saldo>=monto){
        // System.out.println("El monto ha sido retirado con exito");
        // return true;
        // }
        if (monto > 0) {
            if (monto <= saldo) {
                saldo += monto;
                return true;
            }
            System.out.println("Error: saldo insuficiente");
            return false;
        }
        System.out.println("Error: el monto no puede ser negativo");
        return false;
    }
}
