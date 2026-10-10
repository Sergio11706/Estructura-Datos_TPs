package TP4.Ejercicio2.servicio;

import utilidades.Calculator;
import utilidades.edd.FastQueue;
import utilidades.edd.Queue;

public class GestorDeImpresiones {
  private Queue<Integer> codigos;
  private Queue<Integer> prioridad;

  public GestorDeImpresiones(Queue<Integer> codigos) {
    if (codigos == null || codigos.isEmpty()) {
      throw new IllegalArgumentException();
    }

    this.codigos = codigos;
    this.prioridad = new FastQueue<>(codigos.size());
  }

  public void ejecutar() {
    categorizarDocumentos();
    imprimirPrioridad();
  }

  public void categorizarDocumentos() {
    while (!codigos.isEmpty()) {
      Integer codigo = codigos.poll();

      if (Calculator.isEven(codigo)) {
        System.out.printf("%nAVISO: documento %d ---> cola de impresion a color%n", codigo);
        prioridad.offer(codigo);
      } else {
        imprimirBlancoNegro(codigo);
        System.out.printf("%nAVISO: documento %d ---> descartado%n", codigo);
      }
    }
  }

  public void imprimirPrioridad() {
    if (!prioridad.isEmpty()) {
      Object[] copiaPrioridad = prioridad.toArray();

      System.out.println(
          "\n### DOUCUMENTOS PARA IMPRIMIR A COLOR " + copiaPrioridad.length + "###");

      for (Object codigo : copiaPrioridad) {
        imprimirColor((Integer) codigo);
      }
    }
  }

  public void imprimirBlancoNegro(Integer codigo) {
    System.out.printf(
        "%n========================================================="
            + "%nIMPRESORA B&N: imprimiendo documento %d..."
            + "%n=========================================================%n",
        codigo);
  }

  public void imprimirColor(Integer codigo) {
    System.out.printf(
        "%n========================================================="
            + "%nIMPRESORA COLOR: imprimiendo documento %d..."
            + "%n=========================================================%n",
        codigo);
  }
}
