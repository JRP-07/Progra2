package Prueba3;

public class EmpleadoNormal extends Empleado{
    public EmpleadoNormal(int codigo, String nombre, double Salario){
        super(codigo, nombre, Salario);
    }

    public double pago() {
        return salario-(salario*0.035);
    }
    
    public double bono() {
        int years=antiguedad();
        double porcentaje = Math.min(years*0.05, 0.25);
        return salario*porcentaje;
    }

    public String resumenAnual() {
        return "Empleado Normal - " + antiguedad() + " Año(s) de antiguedad , Bono anual: Lps. " + bono();  
    }


}
