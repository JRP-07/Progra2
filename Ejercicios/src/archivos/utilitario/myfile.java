package utilitario;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class myfile{
    private File file=null;

    public void setmyfile(String dir){
        file = new File(dir);
    }

    public void info(){
        if(file.exists()){
            System.out.println("\nSi existe\n");
            System.out.println("Nombre: " + file.getName());
            System.out.println("Path: " + file.getPath());
            System.out.println("Absolute Path: " + file.getAbsolutePath());
            System.out.println("Padre:" + file.getAbsoluteFile().getParentFile().getName());
            System.out.println("Bytes:" + file.length());
            if(file.isFile()){
                System.out.println("Es un archivo");
            }
            else if (file.isDirectory()){
                System.out.println("Es un folder");
            }

            System.out.println("Ultima modificacion:" + new Date(file.lastModified()));
        }
        else{
            System.out.println("Aun no existe");
        }

    }

    void crearArchivo() throws IOException{
        if(file.createNewFile()){
            System.out.println("Creado exitosamente");
        }
        else{
            System.out.println("No se pudo crear");
        }
    }
    
    void crearFolder() {
        if(file.mkdirs()){
            System.out.println("Creado exitosamente");
        }
        else{
            System.out.println("No se pudo crear");
        }
    }

    void borrar(){
        if(borrarTodo(file)){
            System.out.println("Eliminado exitosamente");
        }
        else{
            System.out.println("No se pudo eliminar");
        }
    }

    private boolean borrarTodo(File f){
        if(f.isDirectory()){
            for (File child : f.listFiles()) {
                borrarTodo(child);
            }
        }
        return f.delete();
    }

}