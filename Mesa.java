public class Mesa {

    private EnumFumadores siguiente;
    private EnumAgente  señalAgente;

    public Mesa() {
	siguiente = EnumFumadores.NOFUMADOR;
	señalAgente = EnumAgente.NOAGENTE;
    }

    public synchronized void ponerIngrediente(EnumFumadores fumador) {
	siguiente = fumador;
	notifyAll();
    }

    public synchronized void obtenerIngredientes(EnumFumadores fumador) {
	try {
	    while (siguiente != fumador) wait();
	}
	catch (InterruptedException ie) { }
	siguiente = EnumFumadores.NOFUMADOR;
    }

    public synchronized void obtenerSeñalAgente() {
	try {
	    while (señalAgente == EnumAgente.NOAGENTE) wait();
	}
	catch (InterruptedException ie) { }
	señalAgente = EnumAgente.NOAGENTE;
    }

    public synchronized void ponerSeñalAgente() {
	señalAgente = EnumAgente.AGENTE;
	notifyAll();
    }
}
