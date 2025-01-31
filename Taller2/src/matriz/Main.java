package matriz;

public class Main {
    public static void main(String[] args) {
        int N = 100;
        int J = 100;
        int[][] matriz;
        CrearMatriz creadorMatriz = new CrearMatriz(N,J);
        matriz = creadorMatriz.generarMatriz();
        
        Acumulador acumulador = new Acumulador(N);
        Thread[] threads = new Thread[N];
        
        // Crear y ejecutar hilos
        for (int i = 0; i < N; i++) {
            threads[i] = new FilaThread(matriz[i], acumulador);
            threads[i].start();
        }
        
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
