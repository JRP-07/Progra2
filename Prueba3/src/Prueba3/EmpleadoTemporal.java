package Prueba3;

import java.util.Calendar;

public class EmpleadoTemporal extends Empleado{
    private Calendar finContrato;

    public EmpleadoTemporal(int codigo, String nombre, double salario){
        super(codigo, nombre, salario);
        this.contratacion = Calendar.getInstance();
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
        
    }
}
