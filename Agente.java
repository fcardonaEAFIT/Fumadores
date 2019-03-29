import java.util.Random;

public class Agente implements Runnable {

    private Mesa mesa;

    public Agente(Mesa mesa) {
	this.mesa = mesa;
    }

    public void run() {

	Random r = new Random();

	while (true) {

	    EnumFumadores fumador = EnumFumadores.NOFUMADOR;
	    switch(Math.abs(r.nextInt()) % 3) {
	    case 0:
		fumador = EnumFumadores.NOTABACO;
		break;
	    case 1:
		fumador = EnumFumadores.NOPAPEL;
		break;
	    case 2:
		fumador = EnumFumadores.NOCERILLA;
		break;
	    }
	    System.out.println("Agente: despertando " + fumador);
	    mesa.ponerIngrediente(fumador);
	    try {
		Thread.sleep(Math.abs(r.nextInt()) % 5000 + 1000);
	    }
	    catch (InterruptedException ie) { }

	    mesa.obtenerSeñalAgente();
	    try {
		Thread.sleep(Math.abs(r.nextInt()) % 5000 + 1000);
	    }
	    catch (InterruptedException ie) { }
	}
    }
}
