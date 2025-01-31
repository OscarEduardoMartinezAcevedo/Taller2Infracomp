package matriz;

import java.util.Random;

public class CrearMatriz {

    private int N; //Numero de filas
    private int J; //Numero de columnas

    public CrearMatriz(int N, int J){
        this.N = N;
        this.J = J;
    }

    public int[][] generarMatriz() {
        int[][] matriz = new int[N][N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < J; j++) {
                matriz[i][j] = random.nextInt(); //La llenamos de datos random
            }
        }
        return matriz;
    }

}
