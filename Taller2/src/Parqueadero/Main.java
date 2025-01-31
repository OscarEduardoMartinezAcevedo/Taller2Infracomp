package Parqueadero;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int capacidad = 10;
        final int numAutos = 40;
        Estacionamiento parqueaderoE2 = new Estacionamiento(capacidad);
        System.out.println("Inicializacion del parqueadero");
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de espera:");
        System.out.println("1 - Espera Activa");
        System.out.println("2 - Espera Semi-Pasiva");
        int opcion = scanner.nextInt();
        scanner.close();

        switch (opcion) {
            case 1:
                System.out.println("Ejecutando con espera activa...");
                for (int i = 0; i < numAutos; i++) {
                    new Auto(parqueaderoE2, true, i).start();
                }
                break;

            case 2:
                System.out.println("Ejecutando con espera semi-pasiva...");
                for (int i = 0; i < numAutos; i++) {
                    new Auto(parqueaderoE2, false, i).start();
                }
                break;

            default:
                System.out.println("Opción no válida. Saliendo...");
                break;
        }
    }
}
