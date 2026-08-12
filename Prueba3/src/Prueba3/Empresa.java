package Prueba3;

import java.util.ArrayList;
import java.util.Scanner;

public class Empresa {
    static ArrayList<Empleado> empleados = new ArrayList<>();
    static Scanner lea = new Scanner(System.in);

    public static void main(String[] args){
        Empleado[] n = new Empleado[4];
        double[] salario = new double[4];
        System.out.println("Rellenando datos iniciales");
        System.out.println("Ingrese el salario del empleado 1:");
        salario[0]=lea.nextDouble();
        System.out.println("Ingrese el salario del empleado 2:");
        salario[1]=lea.nextDouble();
        System.out.println("Ingrese el salario del empleado 3:");
        salario[2]=lea.nextDouble();
        System.out.println("Ingrese el salario del empleado 4:");
        salario[3]=lea.nextDouble();

        n[0] = new EmpleadoNormal(1, "Juan", salario[0]);
        n[1] = new EmpleadoTemporal(2, "Pedro", salario[1]);
        n[2] = new EmpleadoPorVenta(3, "Maria", salario[2]);
        n[3] = new EmpleadoPorVenta(4, "Ana", salario[3]);
        for (Empleado e : n){
            empleados.add(e);
        }

        System.out.println("Seleccione la opcion que desea realizar:");
        System.out.println("1- Agregar empleado");
        System.out.println("2- Pagar empleado");
        System.out.println("3- Registrar venta");
        System.out.println("4- Establecer fecha de fin de contrato");
        System.out.println("5- Imprimir resumen de empleados");
        int opcion = lea.nextInt();
        switch (opcion) {
            case 1:
                int codigo = lea.nextInt();
                agregarEmpleado(codigo);
                break;
            case 2:
                int codigoPago = lea.nextInt();
                double pago = pagarEmpleado(codigoPago);
                System.out.println("Pago del empleado con código " + codigoPago + ": " + pago);
                break;
            case 3:
                int codigoVenta = lea.nextInt();
                double monto = lea.nextDouble();
                registrarVenta(codigoVenta, monto);
                break;
            case 4:
                int codigoFin = lea.nextInt();
                setFechaFin(codigoFin);
                break;
            default:
                break;
        }



    }

    public static Empleado buscar(int codigo){
        for (Empleado e : empleados){
            if(e.getCodigo() == codigo){
                return e;
            }
        }
        return null;
    }

    public static void agregarEmpleado(int codigo){
        if(buscar(codigo) == null){
            System.out.println("El Empleado ya existe");
            return;
        }
        System.out.println("Ingrese el nombre del empleado:");
        String nombre = lea.nextLine();
        lea.next();

        System.out.println("Ingrese el salario del empleado:");
        double salario = lea.nextDouble();

        System.out.println("Ingrese el tipo de empleado 1-Normal, 2-Temporal, Otro-Por Venta");
        int tInt= lea.nextInt();
        Empleado n = null;
        if (tInt == 1) {
            n=  new EmpleadoNormal(codigo, nombre, salario);
        }
        else if (tInt == 2){
            n=  new EmpleadoTemporal(codigo, nombre, salario);
        }
        else{
            n=  new EmpleadoPorVenta(codigo, nombre, salario);
        }
        empleados.add(n);
        

    }

    public static double pagarEmpleado(int codigo){
        Empleado e = buscar(codigo);
        if(e ==null)
            return 0;
        else    
            return e.pago();
    }

    public static void registrarVenta(int codigo, double monto){
        Empleado e = buscar(codigo);
        if(e instanceof EmpleadoPorVenta){
            ((EmpleadoPorVenta)e).actualizrVentas(monto);
        }
    }

    public static void setFechaFin(int codigo){
        Empleado e =buscar(codigo);
        if(e instanceof EmpleadoTemporal){
            System.out.println("Ingrese el año de fin de contrato:");
            int año = lea.nextInt();
            System.out.println("Ingrese el mes de fin de contrato (1-12):");
            int mes = lea.nextInt();
            System.out.println("Ingrese el día de fin de contrato:");
            int dia = lea.nextInt();
            ((EmpleadoTemporal)e).setFinContrato(año, mes, dia);
        }
    }

    public static void imprimir(){
        int e=0, et=0, ev=0;
        for (Empleado em : empleados){
            if(em instanceof EmpleadoNormal){
                e++;
            }
            else if (em instanceof EmpleadoTemporal){
                et++;
            }
            else if(em instanceof EmpleadoPorVenta){
                ev++;
            }
            else{
                System.out.println("Tipo de empleado invalido");
            }
        }
        System.out.println("e-"+e+"-et-"+et+"-ev-"+ev);
    }
}
