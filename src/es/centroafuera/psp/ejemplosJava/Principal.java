package es.centroafuera.psp.ejemplosJava;

import java.util.ArrayList;
import java.util.Map;

interface Callback {
    public void buscarHilo(int i);
    public void proceso();
    public void finalizar();
}

public class Principal implements Callback {

    final int TOTAL_HILOS = 100;
    int numIt = 0;

    ArrayList <Integer> hilo = new ArrayList<>();

    public Principal() {
        for (int j = 1; j <= TOTAL_HILOS; j++) {
            Hilos hilo = new Hilos(this);
            hilo.setName("Hilo " + j);
            hilo.start();
        }
    }

    @Override
    public void buscarHilo(int i) {
        ArrayList<String> lista = new ArrayList<>();

        lista = new ArrayList<String>((hilo.get(i)));
        numIt++;

    }

    @Override
    public void proceso() {
        for (int i = 1; i <= 5; i++)
            System.out.println("ITERACION " + i);
    }

    @Override
    public void finalizar () {
        numIt++;
    }
}
