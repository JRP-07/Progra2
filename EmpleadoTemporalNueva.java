package Prueba3;

import java.util.Calendar;

public class EmpleadoTemporal extends Empleado {
    private Calendar finContrato;

    public EmpleadoTemporal(int codigo, String nombre, double salario) {
        super(codigo, nombre, salario);
        this.finContrato = Calendar.getInstance();
    }

    public void setFinContrato(int año, int mes, int dia) {
        this.finContrato = Calendar.getInstance();
        this.finContrato.set(año, mes - 1, dia);
    }

    @Override
    public String toString() {
        return super.toString() + " fin:" + finContrato.getTime();
    }

    @Override
    public double pago() {
        Calendar hoy = Calendar.getInstance();
        if (finContrato.after(hoy)) {
            return salario;
        } else {
            return 0;
        }
    }

    @Override
    public double bono() {
        Calendar hoy = Calendar.getInstance();
        if (finContrato.before(hoy)) {
            return 0;
        }

        // Calcular meses restantes
        int mesesRestantes = (finContrato.get(Calendar.YEAR) - hoy.get(Calendar.YEAR)) * 12 
                             + (finContrato.get(Calendar.MONTH) - hoy.get(Calendar.MONTH));
        
        // Ajustar si el día actual es mayor al día de fin de contrato en el mismo mes
        if (finContrato.get(Calendar.DAY_OF_MONTH) < hoy.get(Calendar.DAY_OF_MONTH)) {
            mesesRestantes--;
        }

        if (mesesRestantes <= 0) return 0;

        double bonoCalculado = salario * 0.02 * mesesRestantes;
        double tope = salario * 0.10;
        
        return Math.min(bonoCalculado, tope);
    }

    @Override
    public String resumenAnual() {
        Calendar hoy = Calendar.getInstance();
        if (finContrato.before(hoy)) {
            return "Empleado temporal - contrato finalizado, sin bono";
        } else {
            return "Empleado temporal - contrato vigente hasta " + finContrato.getTime() + ", bono anual: Lps." + bono();
        }
    }
}
