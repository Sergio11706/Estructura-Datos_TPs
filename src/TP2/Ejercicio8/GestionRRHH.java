class Empleado {
  int legajo;
  String nombre;
  double sueldo;

  public Empleado(int legajo, String nombre, double sueldo) {
    this.legajo = legajo;
    this.nombre = nombre;
    this.sueldo = sueldo;
  }
}

public class GestionRRHH {
  public static void main(String[] args) {
    Empleado[] empleados = new Empleado[3];

    empleados[0] = new Empleado(101, "Ana", 500.0);
    empleados[1] = new Empleado(102, "Beto", 700.0);
    empleados[2] = new Empleado(103, "Carla", 600.0);

    int legajoBuscado = 103;

    int indice = buscarEmpleado(empleados, legajoBuscado);

    System.out.println(
        (indice != -1) ? "Encontrado: " + empleados[indice].nombre : "Legajo no encontrado.");

    Empleado mayorSueldo = empleadoMayorSueldo(empleados);

    System.out.println("Mayor sueldo: " + mayorSueldo.nombre);
  }

  public static int buscarEmpleado(Empleado[] empleados, int legajo) {
    if (empleados == null || empleados.length == 0)
      throw new RuntimeException("\nERROR: array null o vacío");

    for (int i = 0; i < empleados.length; i++) if (empleados[i].legajo == legajo) return i;
    return -1;
  }

  public static Empleado empleadoMayorSueldo(Empleado[] empleados) {
    if (empleados == null || empleados.length == 0)
      throw new RuntimeException("\nERROR: array null o vacío");

    Empleado mayorSueldo = empleados[0];

    for (int i = 1; i < empleados.length; i++)
      if (empleados[i].sueldo > mayorSueldo.sueldo) mayorSueldo = empleados[i];

    return mayorSueldo;
  }
}
