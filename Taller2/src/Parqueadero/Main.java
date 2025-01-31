package Parqueadero;

public class Main {
    public static void main(String[] args) {
        final int capacidad = 10;
        final int numAutos = 40;
        Estacionamiento parqueaderoE2 = new Estacionamiento(capacidad);
        System.out.println("Inicializacion del parqueadero");
        
        /**
         * Espera activa, el booleano en @Auto determina que for usar, en este caso el siguiente
         */
        for (int i = 0; i < numAutos; i++) {
            new Auto(parqueaderoE2, true,i).start();
        }
        
        
        /**
         * Espera semi-pasiva, el booleano en @Auto determina que for usar, en este caso el siguiente
         */
        for (int i = 0; i < numAutos; i++) {
            new Auto(parqueaderoE2, false,i).start();
        }
    }
}
