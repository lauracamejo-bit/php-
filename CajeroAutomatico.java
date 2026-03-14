import java.util.InputMismatchException;
import java.util.Scanner;

public class CajeroAutomatico {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double saldo = 500.0; // Saldo inicial
        int opcion = 0;
        double monto;

        System.out.println("--- Bienvenido al Cajero Automático ---");

        do {
            try {
                System.out.println("\nMenú de Opciones:");
                System.out.println("1. Consultar saldo");
                System.out.println("2. Realizar depósito");
                System.out.println("3. Realizar retiro");
                System.out.println("4. Finalizar");
                System.out.print("Seleccione una opción: ");

                opcion = entrada.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Su saldo actual es: $" + saldo);
                        break;
                    case 2:
                        System.out.print("Ingrese el monto a depositar: ");
                        monto = entrada.nextDouble();
                        if (monto > 0) {
                            saldo = saldo + monto;
                            System.out.println("Depósito exitoso.");
                            System.out.println("Nuevo saldo: $" + saldo);
                        } else {
                            System.out.println("Monto inválido.");
                        }
                        break;
                    case 3:
                        System.out.print("Ingrese el monto a retirar: ");
                        monto = entrada.nextDouble();
                        if (monto > 0) {
                            if (monto <= saldo) {
                                saldo = saldo - monto;
                                System.out.println("Retiro exitoso.");
                                System.out.println("Nuevo saldo: $" + saldo);
                            } else {
                                System.out.println("Error: Fondos insuficientes.");
                                System.out.println("Su saldo actual es: $" + saldo);
                            }
                        } else {
                            System.out.println("Monto inválido.");
                        }
                        break;
                    case 4:
                        System.out.println("Gracias por usar el cajero automático. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada no válida. Por favor ingrese un número.");
                entrada.nextLine(); // Limpiar el buffer
                opcion = 0;
            }
        } while (opcion != 4);

        entrada.close();
    }
}
