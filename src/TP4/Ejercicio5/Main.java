package TP4.Ejercicio5;
import TP4.common.Queue;

public class Main {

    public static void main(String[] args) {

        Queue<Envio> colaEnvios = new Queue<>(5);

        colaEnvios.add(new Envio(  "ENV001", 15.5,
                Destino.LOCAL, Estado.EN_CAMINO));

        colaEnvios.add(new Envio(
                "ENV002", 32.0,
                Destino.NACIONAL, Estado.ENTREGADO));

        colaEnvios.add(new Envio(
                "ENV003", 8.75,
                Destino.INTERNACIONAL, Estado.DEVUELTO));

        colaEnvios.add(new Envio(
                "ENV004", 45.0,
                Destino.NACIONAL, Estado.EN_CAMINO));

        colaEnvios.add(new Envio(
                "ENV005", 20.25,
                Destino.LOCAL, Estado.DEVUELTO));

        GestorEnvios gestor = new GestorEnvios();

        System.out.println("Cola inicial:\n");
        System.out.println(colaEnvios);

        double pesoNacional = gestor.pesoTotalPorDestino(
                colaEnvios, Destino.NACIONAL);

        System.out.println("\nPeso total de envíos nacionales: "
                + pesoNacional + " kg");

        gestor.envioMayorPeso(colaEnvios).ifPresent(envio ->
                System.out.println("\nEnvío con mayor peso:\n" + envio));

        int devueltos = gestor.contarEnviosDevueltos(colaEnvios);

        System.out.println("\nCantidad de envíos devueltos: " + devueltos);

        System.out.println("\nCola final:");
        System.out.println(colaEnvios);
    }
}
