package Prueba3;

import java.util.Calendar;

public class EmpleadoTemporal extends Empleado{
    private Calendar finContrato;

    public EmpleadoTemporal(int codigo, String nombre, double salario){
        super(codigo, nombre, salario);
        this.contratacion = Calendar.getInstance();
    }

    public void setFinContrato(int año, int mes, int dia){
        this.finContrato = Calendar.getInstance();
        this.finContrato.set(año, mes-1, dia);
    }

    public String toString(){
        return super.toString() + " Fin de contrato: " + finContrato.get(Calendar.DATE);
    }

    public double pago(){
        if(finContrato.after(Calendar.getInstance())){
            return salario;
        }
        else{
            return 0;
        }
    }

    public double bono(){
        if(finContrato.before(contratacion)){
            return 0;
        }
        int yearQueda = finContrato.get(Calendar.YEAR) - Calendar.getInstance().get(Calendar.YEAR)*12;
        int mesesQueda = finContrato.get(Calendar.MONTH) - Calendar.getInstance().get(Calendar.MONTH);
        int tiempoQueda = yearQueda + mesesQueda;
        if(tiempoQueda <=0){
            return 0;
        }
        else{
            double bono = salario*0.02*tiempoQueda;
            double max = salario * 0.10;
            return Math.min(bono, max);
        }
    }

    public String resumenAnual(){
        if(finContrato.before(contratacion)){
            return "Empleado temporal - contrato finalizado, sin bono";
        }
        else{
            return "Empleado temporal - contrato vigente hasta " + finContrato.getTime() + ", bono anual: Lps." + bono();
        }
    }
}