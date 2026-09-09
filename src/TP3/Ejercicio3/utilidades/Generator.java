package TP3.Ejercicio3.utilidades;

import java.util.Random;

public class Generator {
    private static final Random random = new Random();

    public static int randomInt(int rango1, int rango2) {
        if (rango1 == rango2) return rango1;

        int minimo = Math.min(rango1, rango2);
        int maximo = Math.max(rango1, rango2);

        return minimo + random.nextInt((maximo - minimo) + 1);
    }
}
