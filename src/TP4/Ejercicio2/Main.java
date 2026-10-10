package TP4.Ejercicio2;

import TP4.Ejercicio2.servicio.GestorDeImpresiones;
import utilidades.Input;
import utilidades.edd.FastQueue;
import utilidades.edd.Queue;

public class Main {
  public static void main(String[] args) {
    System.out.println(
        "\n========================================================="
            + "\nGESTOR DE IMPRESIONES"
            + "\n=========================================================");

    int cantidadDocumentos =
        Input.getPositiveInt(
            "Ingrese la cantidad de documentos a cargar",
            "ERROR: debe ingresar una cantidad mayor a 0");

    Queue<Integer> codigos = new FastQueue<Integer>(cantidadDocumentos);
    cargarQueue(codigos, cantidadDocumentos);

    GestorDeImpresiones gestor = new GestorDeImpresiones(codigos);
    gestor.ejecutar();
  }

  public static void cargarQueue(Queue<Integer> codigos, int cantidadDocumentos) {
    for (int i = 0; i < cantidadDocumentos; i++) {
      codigos.offer(i);
    }
  }
}
