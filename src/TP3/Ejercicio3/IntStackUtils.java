package TP3.Ejercicio3;

import TP3.Ejercicio3.utilidades.Calculator;
import TP3.Ejercicio3.utilidades.Generator;
import TP3.common.Stack;

public class IntStackUtils {
  public static void cargarStack(Stack<Integer> stack, int catidadDeValores) {
    if (!stack.isEmpty()) throw new RuntimeException("\nERROR: La pila ya contiene valores");

    for (int i = 0; i < catidadDeValores; i++) {
      stack.push(Integer.valueOf(Generator.randomInt(-100, 100)));
    }
  }

  public static void eliminarDivisoresDeX(Stack<Integer> stack, Integer x) {
    validarStack(stack);

    Stack<Integer> auxStack = new Stack<>(stack.size());
    Integer numero;

    while (!stack.isEmpty()) {
      numero = stack.pop();
      if (!Calculator.isDivisible(numero, x)) auxStack.push(numero);
    }

    recargar(stack, auxStack);
  }

  public static void reemplazarImpares(Stack<Integer> stack) {
    validarStack(stack);

    Stack<Integer> auxStack = new Stack<>(stack.size());
    Integer numero;

    while (!stack.isEmpty()) {
      numero = stack.pop();

      if (Calculator.isEven(Integer.valueOf(numero))) auxStack.push(numero);
      else auxStack.push(0);
    }

    recargar(stack, auxStack);
  }

  public static int contarMayorQueCima(Stack<Integer> stack) {
    validarStack(stack);

    if (stack.size() == 1) return 0;

    Integer[] copia = (Integer[]) stack.toArray();
    Integer cima = stack.peek();
    int count = 0;

    for (int i = 0; i < copia.length - 1; i++) {
      if (copia[i] > cima) count++;
    }

    return count;
  }

  public static void intercambioCimaPorMitad(Stack<Integer> stack) {
    validarStack(stack);

    if (stack.size() <= 2)
      throw new RuntimeException(
          "ERROR: La pila con cumple con la cantidad de elementos minimos necesarios (3)");

    Stack<Integer> auxStack = new Stack<>(stack.size());
    Integer cima = stack.pop();

    int mitad = stack.size() / 2;

    for (int i = 0; i < mitad; i++) {
      auxStack.push(stack.pop());
    }

    Integer medio = stack.pop();
    stack.push(cima);
    recargar(stack, auxStack);
    stack.push(medio);
  }

  public static void ordenarPilaAscendente(Stack<Integer> stack) {
    validarStack(stack);

    Stack<Integer> auxStack = new Stack<>(stack.size());

    auxStack.push(stack.pop());

    while (!stack.isEmpty()) {
      Integer aux = stack.pop();

      while (!auxStack.isEmpty() && aux > auxStack.peek()) {
        stack.push(auxStack.pop());
      }
      auxStack.push(aux);
    }
    recargar(stack, auxStack);
  }

  private static void recargar(Stack<Integer> original, Stack<Integer> aux) {
    while (!aux.isEmpty()) original.push(aux.pop());
  }

  private static void validarStack(Stack<Integer> stack) {
    if (stack.isEmpty() || stack == null)
      throw new RuntimeException("ERROR: La pila esta vacia o null");
  }
}
