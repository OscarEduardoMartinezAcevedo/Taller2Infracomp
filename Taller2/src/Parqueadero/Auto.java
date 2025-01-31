package Parqueadero;
import java.util.Random;

public class Auto extends Thread {
    private final Estacionamiento parqueadero;
    private final Random random = new Random();
    private final boolean esperaActiva;
    private final int id;

    public Auto(Estacionamiento parqueadero, boolean esperaActiva, int id) {
        this.parqueadero = parqueadero;
        this.esperaActiva = esperaActiva;
        this.id = id;
    }

    /**
     * Se sobreescribe {@link #run()} para que se ejecute la logica del parqueadero
     */
    
    @Override
    public void run() {
        while (true) {
            if (parqueadero.entrar(id)) {
                try {
                    Thread.sleep(random.nextInt(5000) + 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                parqueadero.salir(id);
                break;
            } else {
                if (!esperaActiva) {
                    Thread.yield();
                }
            }
        }
    }
}