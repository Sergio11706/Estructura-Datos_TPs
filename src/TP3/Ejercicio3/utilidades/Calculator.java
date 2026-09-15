package TP3.Ejercicio3.utilidades;

public class Calculator {
  public static double average(int[] valores) {
    if (valores.length == 0) return 0.;
    // return (double) Arrays.stream(valores).sum() / valores.length;

    int suma = 0;
    for (int valor : valores) {
      suma += valor;
    }

    return (double) suma / valores.length;
  }

  public static boolean isDivisible(int dividendo, int divisor) {
    if (divisor == 0) throw new ArithmeticException("/nERROR: No es posible dividir por 0");
    return dividendo % divisor == 0;
  }

  public static boolean isEven(int number) {
    return isDivisible(number, 2) || number == 0;
  }
}
