package matriz;

public class Acumulador {
    private int sumaTotal = 0;
    private int procesadas = 0;
    private int totalFilas;

    public Acumulador(int totalFilas) {
        this.totalFilas = totalFilas;
    }

    public synchronized void adicionarAcum(int valorFila) {
        sumaTotal += valorFila;
        procesadas++;
        if (procesadas == totalFilas) {
            System.out.println("Suma total: " + sumaTotal);
        }
    }

}
