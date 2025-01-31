package matriz;

public class FilaThread extends Thread{
    private final int[] fila;
    private final Acumulador acumulador;

    public FilaThread(int[] fila, Acumulador acumulador) {
        this.fila = fila;
        this.acumulador = acumulador;
    }

    @Override
    public void run() {
        int valorFila = 0;
        for (int num : fila) {
            valorFila += num;
        }
        acumulador.adicionarAcum(valorFila);
    }

}
