package com.mycompany.mavenproject2;

import java.util.Scanner;

public class CajeroAutomatico {

    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            double saldo = 500.0;
            int opcion;

            System.out.println("--- BIENVENIDO AL CAJERO AUTOMÁTICO ---");

            do {
                System.out.println("\nMenú de Opciones:");
                System.out.println("1. Consultar saldo");
                System.out.println("2. Realizar depósito");
                System.out.println("3. Realizar retiro");
                System.out.println("4. Finalizar");
                System.out.print("Seleccione una opción: ");

                opcion = entrada.nextInt();

                switch (opcion) {
                    case 1 -> System.out.println("Su saldo actual es: $" + saldo);

                    case 2 -> {
                        System.out.print("Ingrese el monto a depositar: ");
                        double monto = entrada.nextDouble();
                        if (monto > 0) {
                            saldo += monto;
                            System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
                        } else {
                            System.out.println("Error: El monto debe ser positivo.");
                        }
                    }

                    case 3 -> {
                        System.out.print("Ingrese el monto a retirar: ");
                        double monto = entrada.nextDouble();
                        if (monto > 0 && monto <= saldo) {
                            saldo -= monto;
                            System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
                        } else if (monto > saldo) {
                            System.out.println("Error: Fondos insuficientes (Saldo: $" + saldo + ")");
                        } else {
                            System.out.println("Error: Monto inválido.");
                        }
                    }

                    case 4 -> System.out.println("Gracias por usar nuestro servicio. ¡Hasta luego!");

                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (opcion != 4);
        } catch (Exception e) {
            System.out.println("Error en la entrada de datos. Reinicie el programa.");
        }
    }
}
