package Abstract;

import java.text.DateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public abstract class Empleado {
    protected int codigo;
    protected String nombre;
    protected double salario;
    protected Calendar contratacion;

    public Empleado(int codigo, String nombre, double salario){
        this.codigo=codigo;
        this.nombre=nombre;
        this.salario=salario;
        this.contratacion=Calendar.getInstance();
    }

    public int getCodigo(){
        return codigo;
    }

    public abstract double pago();

    public abstract double bono();

    public abstract String resumenAnual();

    public int antiguedad(){
        Calendar hoy =Calendar.getInstance();
        int years=hoy.get(Calendar.YEAR)-contratacion.get(Calendar.YEAR);
        if(hoy.get(Calendar.DAY_OF_YEAR)<contratacion.get(Calendar.DAY_OF_YEAR)){
            years--;
        }
        return years;
    }

    public String toString(){
        return codigo + "-" + nombre + "-" + "Lps." + salario;
    }

}
