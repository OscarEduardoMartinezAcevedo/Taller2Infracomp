package Parqueadero;

public class Estacionamiento {
    private int espaciosDisponibles;

    public Estacionamiento(int capacidad) {
        this.espaciosDisponibles = capacidad;
    }
    /**
     * Se sincronizan {@link #entrar(int)} y {@link #salir(int)} para que nunca puedan ejecutarse simultaneamente
     */

    public synchronized boolean entrar(int id) {
    	System.out.println("El auto numero " + id + " llego");
        if (espaciosDisponibles == 0) { // Si no hay espacio, retorna false
            System.out.println("El auto numero " + id + " no encontró espacio y comienza a esperar");
            try {
                wait(); // El auto espera hasta que haya espacio
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("El auto número " + id + " fue interrumpido mientras esperaba");
                return false;
            }
            // Si despierta, vuelve a verificar si hay espacio antes de continuar
            if (espaciosDisponibles == 0) {
                return false; // Si aún no hay espacio, permite que `Auto.run()` maneje la espera
          }
        }
        espaciosDisponibles--;
        System.out.println("El auto numero " + id + " ya se estaciono");
        return true;
    }

    public synchronized void salir(int id) {
        espaciosDisponibles++;
        System.out.println("El auto numero " + id + " se fue");
        notify();
    }
}
