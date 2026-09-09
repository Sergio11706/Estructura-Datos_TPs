package TP3.Ejercicio3;

import TP3.Ejercicio3.utilidades.Input;
import TP3.common.Stack;

public class Main {
  public static void main(String[] args) {
    int cantidadDeValores =
        Input.getPositiveInt("Ingrese la cantidad de numeros que desea genenrar");

    Stack<Integer> stack = new Stack<>(cantidadDeValores);
    IntStackUtils.cargarStack(stack, cantidadDeValores);

    int opcion = 7;

    do {
      opcion = Input.getPositiveInt(menu());

      switch (opcion) {
        case 1:
          OpcionMostrar(stack); 
          break;

        case 2:
          OpcionEliminarDivisoresDeX(stack);
          break;

        case 3:
          OpcionReemplazarImpares(stack);
          break;

        case 4:
          OpcionContarMayoresQueCima(stack);
          break;

        case 5:
          OpcionCambiarCimaPorMitad(stack);
          break;

        case 6: 
          OpcionOrdenAscendente(stack);
          break;

        case 7:
          System.out.println("\nFin del Programa.");
          break;
          
        default:
          Input.getString("La opcion ingresada no es valida\nPresione enter para continuar...");
          break;
      }
    } while (!(opcion == 7));
  }

  public static String menu() {
    return """
    ********** Menu de opciones ***********
    1. Mostar Pila
    2. Eliminar divisores de X
    3. Reemplazar impares por 0
    4. Cantidad de numeros mayores a la cima
    5. Intercambiar el valor de la Cima por le de la Mitad
    6. Ordenar de forma Ascendente
    7. Salir
    Seleccione una opcion\
    """;
  }

  public static void OpcionMostrar(Stack<Integer> stack) {
    System.out.println("\n" + stack);
    Input.getString("Presione enter para continuar");
  }

  public static void OpcionEliminarDivisoresDeX(Stack<Integer> stack) {
    int x = Input.getInt("Ingrese el valor de X");

    try {
      IntStackUtils.eliminarDivisoresDeX(stack, x);
      Input.getString("Se elimiaron los divisores de " + x + "\n\nPresione enter para continuar...");
    } catch (Exception e) {
      System.out.println("\n" + e.getMessage());
    }
  }

  public static void OpcionReemplazarImpares(Stack<Integer> stack) {
    try {
      IntStackUtils.reemplazarImpares(stack);
      Input.getString("Se reemplazaron los numeros impares por 0\n\nPresione una tecla para continuar...");
    } catch (Exception e) {
      System.out.println("\n" + e.getMessage());
    }
  }

  public static void OpcionContarMayoresQueCima(Stack<Integer> stack) {
    try {
      int cantidad = IntStackUtils.contarMayorQueCima(stack);
      System.out.println("\nCantidad de valores mayores a la cima (" + stack.peek() + ") = " + cantidad);
      Input.getString("Presione enter para continuar...");
    } catch (Exception e) {
      System.out.println("\n" + e.getMessage());    
    }
  }

  public static void OpcionCambiarCimaPorMitad(Stack<Integer> stack) {
    try {
      IntStackUtils.intercambioCimaPorMitad(stack);
      System.out.println("\nSe intercambiaron los valores de la Cima y de la Mitad");
      Input.getString("Presione enter para continuar...");
    } catch (Exception e) {
      System.out.println("\n" + e.getMessage());
    }
  }

  public static void OpcionOrdenAscendente(Stack<Integer> stack) {
    try {
      IntStackUtils.ordenarPilaAscendente(stack);
      System.out.println("\nLa pila se ordeno de forma ascendete");
      Input.getString("Presione enter para continuar...");
    } catch (Exception e) {
      System.out.println("\n" + e.getMessage());
    }
  }
}
