package com.mycompany.mavenproject2;

import java.util.Scanner;

public class CajeroAutomatico {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double saldo = 500.0; // La cuenta inicia con un saldo inicial
        int opcion = 0;

        System.out.println("--- CAJERO AUTOMÁTICO ---");

        do {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Realizar depósito");
            System.out.println("3. Realizar retiro");
            System.out.println("4. Finalizar");
            System.out.print("Seleccione una opción: ");

            if (entrada.hasNextInt()) {
                opcion = entrada.nextInt();

                switch (opcion) {
                    case 1:
                        // Opción para consultar el saldo actual
                        System.out.println("------------------------------------");
                        System.out.println("Saldo actual: $" + saldo);
                        System.out.println("------------------------------------");
                        break;

                    case 2:
                        // Opción para realizar un depósito
                        System.out.print("Ingrese el valor a depositar: ");
                        double deposito = entrada.nextDouble();
                        if (deposito > 0) {
                            saldo += deposito; // El valor se suma al saldo actual
                            System.out.println("¡Depósito exitoso!");
                        } else {
                            System.out.println("Error: El monto debe ser positivo.");
                        }
                        // Después de cada operación, se muestra el estado actualizado del saldo
                        System.out.println("SALDO ACTUALIZADO: $" + saldo);
                        break;

                    case 3:
                        // Opción para realizar un retiro
                        System.out.print("Ingrese el valor a retirar: ");
                        double retiro = entrada.nextDouble();

                        // Verificar que exista suficiente dinero
                        if (retiro > 0 && retiro <= saldo) {
                            saldo -= retiro;
                            System.out.println("¡Retiro exitoso!");
                        } else if (retiro > saldo) {
                            // Mensaje indicando que no hay fondos suficientes
                            System.out.println("ERROR: No hay fondos suficientes para realizar esta operación.");
                        } else {
                            System.out.println("Error: Monto inválido.");
                        }
                        // Después de cada operación, se muestra el estado actualizado del saldo
                        System.out.println("SALDO ACTUALIZADO: $" + saldo);
                        break;

                    case 4:
                        System.out.println("Gracias por usar el sistema. Finalizando...");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            } else {
                System.out.println("Error: Debe ingresar un número entero.");
                entrada.next(); // Limpiar el buffer
            }
        } while (opcion != 4); // Permite ejecutar varias operaciones hasta seleccionar finalizar

        entrada.close();
    }
}
