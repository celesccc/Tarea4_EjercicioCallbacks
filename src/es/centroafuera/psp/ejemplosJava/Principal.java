package es.centroafuera.psp.ejemplosJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

interface Callback {
    public void buscarHilo(String cad, int i);
    public void proceso();
    public void finalizar();
}

public class Principal implements Callback {

    final int TOTAL_HILOS = 100;
    int numIt = 0;

    HashMap <Integer, ArrayList<String>> hilo = new HashMap<>();

    public Principal() {
        for (int j = 1; j <= TOTAL_HILOS; j++) {
            Hilos hilo = new Hilos(this);
            hilo.setName("Hilo " + j);
            hilo.start();
        }
    }

    @Override
    public void buscarHilo(String cad, int i) {
        ArrayList<String> lista = new ArrayList<>();
        if (hilo.containsKey(i)){
            lista = new ArrayList<String>(hilo.get(i));
            lista.add(cad);
            hilo.put(i, lista);
            numIt++;
        }else{
            lista = new ArrayList<>();
            lista.add(cad);
            hilo.put(i, lista);
            numIt++;
        }
    }

    @Override
    public void proceso() {
        if (numIt >= 5) {
            for (Map.Entry<Integer, ArrayList<String>> it : hilo.entrySet()) {
                System.out.println("ITERACION " + it.getKey());
                for (String s : it.getValue())
                    System.out.println(s);
            }
        }
    }

    @Override
    public void finalizar () {
        numIt++;
    }
}
