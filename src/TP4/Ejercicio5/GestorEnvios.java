package TP4.Ejercicio5;
import java.util.Optional;
import TP4.common.Queue;

public class GestorEnvios {

    private Queue<Envio> copiaCola(Queue<Envio> colaOriginal) {
        int cantidad = colaOriginal.size();
        Queue<Envio> copia = new Queue<>(cantidad);

        
        for (int i = 0; i < cantidad; i++) {
            Envio envio = colaOriginal.poll();
            copia.add(envio);
            colaOriginal.add(envio);
        }

        return copia;
    }

    public double pesoTotalPorDestino(
            Queue<Envio> colaOriginal,
            Destino destinoBuscado) {

        Queue<Envio> copia = copiaCola(colaOriginal);
        double pesoTotal = 0;

        while (!copia.isEmpty()) {
            Envio envio = copia.poll();

            if (envio.getDestino() == destinoBuscado) {
                pesoTotal += envio.getPeso();
            }
        }

        return pesoTotal;
    }

    public Optional<Envio> envioMayorPeso(Queue<Envio> colaOriginal) {

        Queue<Envio> copia = copiaCola(colaOriginal);
        Envio envioMayor = null;

        while (!copia.isEmpty()) {
            Envio envioActual = copia.poll();

            if (envioMayor == null ||
                    envioActual.getPeso() > envioMayor.getPeso()) {

                envioMayor = envioActual;
            }
        }

        return Optional.ofNullable(envioMayor);
    }

    public int contarEnviosDevueltos(Queue<Envio> colaOriginal) {

        Queue<Envio> copia = copiaCola(colaOriginal);
        int cantidadDevueltos = 0;

        while (!copia.isEmpty()) {
            Envio envio = copia.poll();

            if (envio.getEstado() == Estado.DEVUELTO) {
                cantidadDevueltos++;
            }
        }

        return cantidadDevueltos;
    }
}
