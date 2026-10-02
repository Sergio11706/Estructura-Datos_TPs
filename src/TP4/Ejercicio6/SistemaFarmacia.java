import util.Queue;
import util.ResizableQueue;
import util.Helper;
public class SistemaFarmacia {
	public static void main(String[] args) {
		Queue<Turno> colaTurnos =new ResizableQueue<>();
		cargarTurnosIniciales(colaTurnos);
		System.out.println("--- Cola Original ---");
		mostrarCola(colaTurnos);
		Queue <Turno> pendientes = generarColaPendientes(colaTurnos);
		System.out.println("\n--- Turnos Pendientes (No Atendidos) ---");
		mostrarCola(pendientes);
		System.out.println();
		String osBuscada = Helper.readString("Ingrese la Obra Social a consultar (ej. PAMI, ISJ, Particular): ");
		int cantidadOS = contarPorObraSocial(colaTurnos, osBuscada);
		System.out.println("Cantidad de turnos para " + osBuscada + ": " + cantidadOS);
		System.out.println();
		String dniBuscado = Helper.readString("Ingrese el DNI del cliente a verificar: ");
		boolean estadoAtencion = verificarAtencionPorDni(colaTurnos, dniBuscado);
		System.out.println("El cliente con DNI " + dniBuscado + 
                (estadoAtencion ? " YA fue atendido." : " NO fue atendido o no existe en la cola."));
	}
	
	private static void cargarTurnosIniciales(Queue<Turno> cola) {
        cola.add(new Turno("11111111", "PAMI", true));
        cola.add(new Turno("22222222", "ISJ", false));
        cola.add(new Turno("33333333", "Particular", false));
        cola.add(new Turno("44444444", "PAMI", false));
        cola.add(new Turno("55555555", "ISJ", true));
    }
	
	public static Queue<Turno> generarColaPendientes(Queue<Turno> original) {
        Queue<Turno> pendientes = new ResizableQueue<>();
        int tamano = original.size();
        
        for (int i = 0; i < tamano; i++) {
            Turno actual = original.poll();
            
            if (actual != null) {
                if (!actual.fueAtendido) {
                    pendientes.add(actual);
                }
                original.add(actual);
            }
        }
        return pendientes;
    }
	
	public static int contarPorObraSocial(Queue<Turno> original, String obraSocial) {
        int contador = 0;
        int tamano = original.size();
        
        for (int i = 0; i < tamano; i++) {
            Turno actual = original.poll();
            
            if (actual != null) {
                if (actual.obraSocial.equalsIgnoreCase(obraSocial)) {
                    contador++;
                }
                original.add(actual);
            }
        }
        return contador;
    }
	
	public static boolean verificarAtencionPorDni(Queue<Turno> original, String dni) {
        boolean fueAtendido = false;
        int tamano = original.size();
        
        for (int i = 0; i < tamano; i++) {
            Turno actual = original.poll();
            
            if (actual != null) {
                if (actual.dniCliente.equals(dni)) {
                    fueAtendido = actual.fueAtendido;
                }
                original.add(actual);
            }
        }
        return fueAtendido;
    }
	
	private static void mostrarCola(Queue<Turno> cola) {
        int tamano = cola.size();
        for (int i = 0; i < tamano; i++) {
            Turno actual = cola.poll();
            System.out.println(actual.toString());
            cola.add(actual);
        }
    }
	
	
	
	
}
