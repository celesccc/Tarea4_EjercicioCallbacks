package es.centroafuera.psp.ejemplosJava;

public class Principal implements Callback {

    final int TOTAL_HILOS = 4;

    public Principal() {

        for (int i = 0; i < 5; i++) {
            System.out.println("Iteración " + i);

            for (int j = 0; j < TOTAL_HILOS; j++) {
                Hilos hilo = new Hilos(this);
                hilo.setName("Hilo " + j);
                hilo.start();
            }

            System.out.println("ITERACIÓN " + (i+1));

        }
    }

    @Override
    public void tiempoTotal(String cadena) {

    }
}
