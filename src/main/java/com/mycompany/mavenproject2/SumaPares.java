package com.mycompany.mavenproject2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SumaPares {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un número entero positivo:");

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n > 0) {
                calcularYMostrarPares(n);
            } else {
                System.out.println("Error: El número debe ser un entero positivo.");
            }
        } else {
            System.out.println("Error: Debe ingresar un número entero.");
        }
        scanner.close();
    }

    public static void calcularYMostrarPares(int limite) {
        List<Integer> pares = new ArrayList<>();
        int suma = 0;

        for (int i = 1; i <= limite; i++) {
            if (i % 2 == 0) {
                pares.add(i);
                suma += i;
            }
        }

        System.out.println("los números pares son:");
        String resultadoPares = pares.stream()
                                     .map(String::valueOf)
                                     .collect(Collectors.joining(","));
        System.out.println(resultadoPares);
        System.out.println("Suma=" + suma);
    }
}
