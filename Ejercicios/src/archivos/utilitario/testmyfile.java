package utilitario;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class testmyfile {
    static myfile f = new myfile();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int op = 0;
        do {

            System.out.println("\n=====MENU=====");
            System.out.println("1.Set el archivo/folder");
            System.out.println("2.Ver informacion");
            System.out.println("3.Crear archivo");
            System.out.println("4.Crear folder");
            System.out.println("5.Eliminar");
            System.out.println("6.Salir");
            System.out.println("Escoja una opcion");

            try {
                // sc.useDelimiter("\n");
                // String cadena = sc.next();
                op = sc.nextInt();
                sc.nextLine();

                switch (op) {
                    case 1:
                        set();
                        break;
                    case 2:
                        f.info();
                        break;
                    case 3:
                        f.crearArchivo();
                        break;

                    case 4:
                        f.crearFolder();
                        break;
                    case 5:
                        f.borrar();
                        break;
                    case 6:
                        System.out.println("Saliendo");
                        break;
                    default:
                        System.out.println("Opción no válida");
                        break; 
                }
            } catch (NullPointerException e) {
                System.out.println("Debe seleccionar la opcion 1");
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Favor ingresar una opcion correcta");
            } catch (IOException e) {
                System.out.println("Error" + e.getMessage());
            }

        } while (op != 6);
    }

    private static void set() {
        System.out.println("Direccion:");
        String ruta = sc.nextLine();
        f.setmyfile(ruta);
    }
}
