import util.Queue;
import util.ResizableQueue;
import util.Helper;

public class Turno {
	String dniCliente;
	String obraSocial;
	boolean fueAtendido;
	public Turno(String dniCliente, String obraSocial, boolean fueAtendido) {
		this.dniCliente=dniCliente;
		this.obraSocial=obraSocial;
		this.fueAtendido=fueAtendido;
		
	}
	@Override
	public String toString() {
		return "Turno [dniCliente=" + dniCliente + ", obraSocial=" + obraSocial + ", fueAtendido=" + fueAtendido + "]";
	}
}

