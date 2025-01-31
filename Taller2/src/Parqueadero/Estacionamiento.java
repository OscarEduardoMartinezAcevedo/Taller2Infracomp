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
        while (espaciosDisponibles == 0) {
        	System.out.println("El auto numero " + id + " no encontro donde meterse y comienza a esperar");
            try {
                wait();
                System.out.println("El conductor del auto numero " + id + " empieza a estresarse");
            } catch (InterruptedException e) {
                e.printStackTrace();
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