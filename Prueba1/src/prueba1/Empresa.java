/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba1;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author josep
 */
public class Empresa {

    static ArrayList<Empleado> empleados;
    static Scanner lea = new Scanner(System.in);

    public static void main(String[] args) {
        empleados = new ArrayList<>();

        int opcion;

        do {

            System.out.println("1- Agregar Empleado");

            System.out.println("2- Pagar Empleado");

            System.out.println("3- Lista de Empleados");

            System.out.println("4- Sub Menu especifico");

            System.out.println("5- Salir");

            System.out.print("Escoja Opción: ");

            opcion = lea.nextInt();

            switch (opcion) {

                case 1:

                    hire();

                    break;

                case 2:

                    pay();

                    break;

                case 3:

                    list();

                    break;

                case 4:

                    submenu();

                    break;

            }

        } while (opcion != 5);
    }

    /**
     * 
     * Recorre la lista de Empleados. Si encuentra un
     * 
     * empleado con ese codigo, se retorna, sino, retorna null
     * 
     * @param cod Codigo del Empleado
     * 
     * @return El obj Empleado si se encuentra, null si no
     * 
     */

    private static Empleado search(int cod) {
        for (Empleado e : empleados) {
            if (e.getCodigo() == cod) {
                return e;
            }
        }
        return null;
    }

    /**
     * 
     * Contrata un nuevo empleado
     * 
     * 1- Se pide del teclado el tipo: COMUN, HORA, VENTA o TEMPORAL
     * 
     * 2- Se instancia un objeto segun el tipo y se guarda en el arreglo,
     * 
     * 3- pero siempre y cuando el Codigo NO este repetido
     * 
     * 4- LOS DATOS requeridos se ingresan del teclado
     * 
     */

    private static void hire() {
        int codigo;
        String nombre;
        int tipo;
        Empleado e = new Empleado();
        boolean existe = false;
        lea.nextLine();
        do {
            System.out.println("Ingrese el codigo del empleado");
            codigo = lea.nextInt();
            existe = false;
            if (search(codigo) != null) {
                System.out.println("El codidog ya esta registrado");
                existe = true;
            } else {
                e.setCodigo(codigo);
            }
        } while (existe == true);
        lea.nextLine();

        System.out.println("Ingrese el nombre del empleado");
        nombre = lea.nextLine();
        e.setNombre(nombre);

        do {
            System.out.println("Seleccione el tipo de empleado");
            System.out.println("1.Comun---2.Hora---3.Ventas---4.Temporal");
            tipo = lea.nextInt();
    
            switch (tipo) {
                case 1:
                    e.setTipo("Comun");
                    break;
                case 2:
                    e.setTipo("Hora");
                    break;
                case 3:
                    e.setTipo("Ventas");
                    break;
    
                case 4:
                    e.setTipo("Temporal");
                    break;
                default:
                    System.out.println("Tipo invalido");
                    break;
            }
        } while (tipo > 4 || tipo < 1);
        
        double sueldo;
        do {
            System.out.println("Ingrese el sueldo del empleado");
            sueldo=lea.nextDouble();
        } while (sueldo<=0);

        empleados.add(e);
        System.out.println("Empleado guardado correctamente");
    }

    /**
     * 
     * Le paga a un empleado
     * 
     * 1- Pide del teclado el codigo
     * 
     * 2- Buscamos ese empleado
     * 
     * 3- Si existe, mostramos en pantalla su pago
     * 
     */

    private static void pay() {
        System.out.print("Ingrese el código del empleado para pagar: ");
        int cod = lea.nextInt();
        Empleado e = search(cod);
        if (e != null) {
            System.out.println("El pago para " + e.getNombre() + " es: " + e.getSueldo());
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }

    /**
     * 
     * Imprimir la lista de empleados
     * 
     */

    private static void list() {
        for (Empleado e : empleados) {
            System.out.println("\nCodigo de empleado:" + e.getCodigo());
            System.out.println("\nNombre de empleado:" + e.getNombre());
            System.out.println("\nTipo de empleado:" + e.getTipo());
            System.out.println("");
        }
    }

    private static void submenu() {

        int opcion;

        do {

            System.out.println("1-Fecha Fin Contrato a Temporales");

            System.out.println("2-Ingresar Venta");

            System.out.println("3-Ingresar Horas de Trabajo");

            System.out.println("4-Regresar al Menu Principal");

            System.out.print("Escoja Opcion: ");

            opcion = lea.nextInt();

            switch (opcion) {

                case 1:

                    setFin();

                    break;

                case 2:

                    ventas();

                    break;

                case 3:

                    horas();

            }

        } while (opcion != 4);

    }

    /**
     * 
     * 1- Leer un codigo
     * 
     * 2- Buscar el empleado, que existe y que sea Temporal
     * 
     * 3- Si concuerda, set fecha y el fin del contrato
     * 
     * 4- Leer del teclado los datos
     * 
     */

    private static void setFin() {
        System.out.print("Ingrese el código del empleado temporal: ");
        int cod = lea.nextInt();
        Empleado e = search(cod);
        if (e != null && "Temporal".equalsIgnoreCase(e.getTipo())) {
            System.out.print("Ingrese la fecha de fin de contrato (en formato entero): ");
            int fecha = lea.nextInt();
            e.setFechaF(fecha);
            System.out.println("Fecha de fin de contrato actualizada.");
        } else {
            System.out.println("El empleado no existe o no es de tipo Temporal.");
        }
    }

    /**
     * 
     * 1- Leer un codigo
     * 
     * 2- Buscar empleado, que exista y que sea por Ventas
     * 
     * 3- Si concuerda, agregar una venta
     * 
     * 4- Leer del teclado los datos
     * 
     */

    private static void ventas() {
        System.out.print("Ingrese el código del empleado de ventas: ");
        int cod = lea.nextInt();
        Empleado e = search(cod);
        if (e != null && e.getTipo().equals("Ventas")) {
            System.out.print("Ingrese el monto de la venta a agregar: ");
            double monto = lea.nextDouble();
            e.setSueldo(e.getSueldo() + monto);
            System.out.println("Venta agregada exitosamente.");
        } else {
            System.out.println("El empleado no existe o no es de Ventas.");
        }
    }

    /**
     * 
     * 1- Leer un codigo
     * 
     * 2- Buscar empleado, que exista y que sea por Horas
     * 
     * 3- Si concuerda, agregar las horas trabajadas
     * 
     * 4- Leer del teclado los datos
     * 
     */

    private static void horas() {
        System.out.print("Ingrese el código del empleado por horas: ");
        int cod = lea.nextInt();
        Empleado e = search(cod);
        if (e != null && e.getTipo().equals("Hora")) {
            System.out.print("Ingrese el monto a pagar por las horas: ");
            double pagoHoras = lea.nextDouble();
            e.setSueldo(e.getSueldo() + pagoHoras);
            System.out.println("Pago por horas agregado exitosamente.");
        } else {
            System.out.println("El empleado no existe o no es de Hora.");
        }
    }

}
