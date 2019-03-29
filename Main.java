public class Main {

    public static void main(String args[]) {
	EnumFumadores fumadores[] = { EnumFumadores.NOTABACO,
				      EnumFumadores.NOPAPEL,
				      EnumFumadores.NOCERILLA};

	Mesa mesa = new Mesa();
	for (int i = 0; i < fumadores.length; i++) {
	    Thread t = new Thread(new Fumador(fumadores[i], mesa));
	    t.start();
	}

	Thread tAgente = new Thread(new Agente(mesa));

	tAgente.start();

	try {
	    tAgente.join();
	}
	catch (InterruptedException ie) { }
    }
}
