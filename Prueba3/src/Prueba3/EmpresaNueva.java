package Prueba3;

import java.util.ArrayList;
import java.util.Scanner;

public class Empresa {
    private static ArrayList<Empleado> empleados = new ArrayList<>();
    private static Scanner lea = new Scanner(System.in);

    private static Empleado buscar(int codigo) {
        for (Empleado e : empleados) {
            if (e.getCodigo() == codigo) {
                return e;
            }
        }
        return null;
    }

    public static void agregarEmpleado(int codigo, String nombre, String tipo) {
        if (buscar(codigo) == null) {
            System.out.print("Ingrese el salario: ");
            double salario = lea.nextDouble();
            
            Empleado nuevo;
            if ("NORMAL".equalsIgnoreCase(tipo)) {
                nuevo = new EmpleadoNormal(codigo, nombre, salario);
            } else if ("TEMPORAL".equalsIgnoreCase(tipo)) {
                nuevo = new EmpleadoTemporalNueva(codigo, nombre, salario);
            } else {
                nuevo = new EmpleadoPorVenta(codigo, nombre, salario);
            }
            empleados.add(nuevo);
        } else {
            System.out.println("Error: El empleado con código " + codigo + " ya existe.");
        }
    }

    public static double pagarEmpleado(int codigo) {
        Empleado e = buscar(codigo);
        return (e != null) ? e.pago() : 0;
    }

    public static void registrarVenta(int codigo, double monto) {
        Empleado e = buscar(codigo);
        if (e instanceof EmpleadoPorVenta) {
            ((EmpleadoPorVenta) e).registrarVenta(monto);
        }
    }

    public static void setFechaFin(int codigo, int año, int mes, int dia) {
        Empleado e = buscar(codigo);
        if (e instanceof EmpleadoTemporalNueva) {
            ((EmpleadoTemporalNueva) e).setFinContrato(año, mes, dia);
        }
    }

    public static void imprimir() {
        int e = 0, et = 0, ev = 0;
        for (Empleado emp : empleados) {
            System.out.println(emp.toString());
            if (emp instanceof EmpleadoNormal) e++;
            else if (emp instanceof EmpleadoTemporalNueva) et++;
            else if (emp instanceof EmpleadoPorVenta) ev++;
        }
        System.out.println("e-" + e + "-et-" + et + "-ev-" + ev);
    }

    public static void main(String[] args) {
        // 1. Inicializar la lista de empleados (ya hecha en atributo estático)
        
        // 2. Agregar empleados de cada tipo
        System.out.println("--- Agregando Empleados ---");
        agregarEmpleado(1, "Juan Normal", "NORMAL");
        agregarEmpleado(2, "Ana Temporal", "TEMPORAL");
        agregarEmpleado(3, "Pedro Venta", "VENTA");

        // 3. Establecer fecha de fin de contrato
        // Caso futuro: Ana Temporal
        setFechaFin(2, 2026, 12, 31);
        
        // Caso pasado: Agregar otro temporal para probar
        agregarEmpleado(4, "Luis Pasado", "TEMPORAL");
        setFechaFin(4, 2020, 1, 1);

        // 4. Registrar venta para empleado por venta
        registrarVenta(3, 5000.0);
        registrarVenta(3, 2500.0);

        // 5. Calcular y mostrar el pago de cada empleado
        System.out.println("\n--- Pagos ---");
        for (Empleado emp : empleados) {
            System.out.println("Empleado " + emp.getCodigo() + " Pago: Lps." + pagarEmpleado(emp.getCodigo()));
        }

        // 6. Mostrar resumenAnual y bono
        System.out.println("\n--- Resúmenes Anuales y Bonos ---");
        for (Empleado emp : empleados) {
            System.out.println("Resumen: " + emp.resumenAnual());
            System.out.println("Bono: Lps." + emp.bono());
        }

        // 7. Imprimir listado completo y conteo
        System.out.println("\n--- Listado Completo ---");
        imprimir();
    }
}
