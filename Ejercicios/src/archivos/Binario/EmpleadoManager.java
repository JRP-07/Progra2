package Binario;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class EmpleadoManager {
    private RandomAccessFile rcods, remps;

    public EmpleadoManager() {
        try {
            // 1.Asegurar el folder raiz
            File root = new File("Company");
            root.mkdir();

            // 2.Instanciar los archivos randomaccessfile
            rcods = new RandomAccessFile("Company/Codigos.emp", "rw");
            remps = new RandomAccessFile("Company/Emmpleados.emp", "rw");

            // 3.Inicializar el codigo;
            initCode();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // Formato codigo - 4 bytes
    // int code

    private void initCode() throws IOException {
        if (rcods.length() == 0) {
            rcods.writeInt(1);
        }
    }

    private int getCode() throws IOException {
        rcods.seek(0);
        int xnum = rcods.readInt();
        rcods.seek(0);
        rcods.writeInt(xnum + 1);
        return xnum;
    }

    /*
     * Formato empleados.emp
     * int code
     * String name;
     * double salary
     * long Hdate;
     * long Tdate;
     */

    public void addEmployee(String nombre, double salario) throws IOException {
        remps.seek(remps.length());

        int codigoE = getCode();
        remps.writeInt(codigoE);

        remps.writeUTF(nombre);
        remps.writeDouble(salario);

        remps.writeLong(Calendar.getInstance().getTimeInMillis());
        remps.writeLong(0);

        // Archivos individuales

    }

    private String folderEmpleado(int code) {
        return "company/empleado" + code;
    }

    private RandomAccessFile salesFilefor(int codigo) throws IOException {
        String dirPadre = folderEmpleado(codigo);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        String path = dirPadre + "/ventas" + year;

        return new RandomAccessFile(path, "rw");
    }

    /*
     * Formato ventaaño.emp
     * double ventames
     * boolean sepago;
     */

    private void crearVentasAnuales(int codigo) throws IOException {
        RandomAccessFile ryear = salesFilefor(codigo);
        if (ryear.length() == 0) {
            for (int mes = 0; mes < 12; mes++) {
                ryear.writeDouble(0);
                ryear.writeBoolean(false);
            }
        }
    }

    private void crearFolderEmpleado(int codigo) throws IOException {
        File dir = new File(folderEmpleado(codigo));
        dir.mkdir();
        crearVentasAnuales(codigo);
    }

    /*
     * codigo - nombre - salario - contratacion
     * no empleados despedidos
     */
    public void listaEmpleado() throws IOException {
        remps.seek(0);
        while (remps.getFilePointer() < remps.length()) {
            int codigo = remps.readInt();
            String nombre = remps.readUTF();
            double salario = remps.readDouble();
            Date fechaC = new Date(remps.readLong());
            long fechaD = remps.readLong();
            if (fechaD == 0) {
                System.out.println(codigo + "-" + nombre + "-" + salario+ "-" + fechaC);
            }
        }
    }
}