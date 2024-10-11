import java.io.IOException;
import java.util.Scanner;

public class Main {
    // Método para limpiar la consola
    public static void limpiarConsola() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // Ejecuta el comando 'cls' para limpiar la consola en Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Ejecuta el comando 'clear' para limpiar la consola en sistemas Unix/macOS
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al intentar limpiar la consola.");
        }
    }

    // Método para pausar la ejecución y esperar a que el usuario presione Enter
    public static void esperarEnter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPresione 'Enter' para continuar...");
        scanner.nextLine();  // Espera hasta que el usuario presione "Enter"
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaEmpleados lista = new ListaEmpleados();

        // Crear empleados y agregarlos a la lista
        lista.agregarEmpleado(new Empleado(1, "Carlos Alberto", "Martínez Rodríguez", "M", 2952670.00));
        lista.agregarEmpleado(new Empleado(2, "Teresa", "Nicolás Otaño", "F", 2338617.00));
        lista.agregarEmpleado(new Empleado(3, "Rosa Alquidia", "Lázala Polanco", "F", 2355228.00));
        lista.agregarEmpleado(new Empleado(4, "Ivelisse", "Estévez Ventura", "M", 1801728.00));
        lista.agregarEmpleado(new Empleado(5, "Margarita", "Núñez de la Cruz", "F", 3124269.00));
        lista.agregarEmpleado(new Empleado(6, "Belkis Josefina", "Hernández", "F", 2975450.00));
        lista.agregarEmpleado(new Empleado(7, "Ruth", "Ortega", "F", 2306902.00));
        lista.agregarEmpleado(new Empleado(8, "Lourdes", "Florentino de la Cruz", "F", 2583729.00));
        lista.agregarEmpleado(new Empleado(9, "Luisa", "Mejía", "F", 2160378.00));
        lista.agregarEmpleado(new Empleado(10, "Cándido Mercedes", "Vargas", "M", 1961114.00));

        // Ordenar por salario
        lista.ordenarPorSalario();

        int opcion = -1;
        do {
            limpiarConsola();

            // Menú de opciones
            System.out.println("\n=== MENÚ DE OPCIONES ===");
            System.out.println("1. Mostrar lista ordenada por salario");
            System.out.println("2. Realizar búsqueda lineal por salario");
            System.out.println("3. Realizar búsqueda binaria por salario");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nLista de empleados ordenada por salario:");
                    lista.imprimirLista();
                    esperarEnter();
                    break;

                case 2:
                    System.out.print("\nIngrese el salario para la búsqueda lineal: ");
                    double salarioLineal = scanner.nextDouble();
                    scanner.nextLine();
                    Empleado encontradoLineal = lista.busquedaLineal(salarioLineal);
                    if (encontradoLineal != null) {
                        System.out.println("Empleado encontrado: " + encontradoLineal);
                    } else {
                        System.out.println("Empleado no encontrado con ese salario.");
                    }
                    esperarEnter();
                    break;

                case 3:
                    System.out.print("\nIngrese el salario para la búsqueda binaria: ");
                    double salarioBinario = scanner.nextDouble();
                    scanner.nextLine();
                    Empleado encontradoBinario = lista.busquedaBinaria(salarioBinario);
                    if (encontradoBinario != null) {
                        System.out.println("Empleado encontrado: " + encontradoBinario);
                    } else {
                        System.out.println("Empleado no encontrado con ese salario.");
                    }
                    esperarEnter();
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida, intente nuevamente.");
                    esperarEnter();
            }
        } while (opcion != 0);

        scanner.close();

    }
}

