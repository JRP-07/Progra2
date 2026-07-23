package Ejercicios;

public class FuncionesRecursivas {
    public static int sumaUP(int num){
        if(num>=1)
            return sumaUP(num-1)+num;
        return 0;
    }

    private static int sumarDown(int num, int acum){
        if(num>=1)
            return sumarDown(num-1, acum+num);
        return acum;
    }

    public static int sumarDown(int num){
        return sumarDown(num,0);
    }

    private static boolean esP(String palabra, int izq, int der){
        if(izq<=der){
            if(palabra.charAt(izq) == palabra.charAt(der)){
                return esP(palabra, izq+1, der-1);
            }
            return false;
            
        }
        return true;
    }

    public static boolean esP(String palabra){
        return esP(palabra, 0, palabra.length()-1);
    }

}
