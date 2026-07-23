package Ejercicios;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author josep
 */
public class TestRecursividad {
    
    
    static FuncionesRecursivas f = new FuncionesRecursivas();
    static void main(String[] args){
        // System.out.println(FuncionesRecursivas.sumaUP(5));
        Scanner sc = new Scanner(System.in);
        System.out.println(f.esP(sc.nextLine()));
    }
    
}
