package es.centroafuera.psp.ejemplosJava;

public class Hilos extends Thread {

    Callback callback;

    public Hilos (Callback callback) {
        this.callback = callback;
    }

    @Override
    public void run() {
        try {
            long num = (int) (Math.random() * 7000) + 1000;
            sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
