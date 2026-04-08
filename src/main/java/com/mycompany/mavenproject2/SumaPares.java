package com.mycompany.mavenproject2;

import java.util.Scanner;

public class SumaPares {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese un número entero positivo: ");
        int limite = 0;

        if (entrada.hasNextInt()) {
            limite = entrada.nextInt();

            if (limite > 0) {
                int suma = 0;
                System.out.println("Los números pares son:");

                boolean primero = true;
                for (int i = 1; i <= limite; i++) {
                    if (i % 2 == 0) {
                        if (!primero) {
                            System.out.print(", ");
                        }
                        System.out.print(i);
                        suma += i;
                        primero = false;
                    }
                }

                System.out.println("\nSuma = " + suma);
            } else {
                System.out.println("Error: El número debe ser positivo.");
            }
        } else {
            System.out.println("Error: Debe ingresar un número entero válido.");
        }

        entrada.close();
    }
}
