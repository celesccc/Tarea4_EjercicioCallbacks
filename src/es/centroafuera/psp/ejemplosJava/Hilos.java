package es.centroafuera.psp.ejemplosJava;

public class Hilos extends Thread {

    final int TOTAL_IT = 5;

    Callback callback;

    public Hilos (Callback callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        try {
            for (int i = 1 ; i <= TOTAL_IT; i++) {
                long num = (long) (Math.random() * 7000) + 1000;
                sleep(num);
                System.out.println("El " + getName() + " ha dormido por " + num + " milisegundos");
                callback.buscarHilo(i);
            }
            callback.proceso();
            callback.finalizar();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
