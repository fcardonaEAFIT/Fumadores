import java.util.Random;

public class Fumador implements Runnable {

    private EnumFumadores fumador;
    private Mesa mesa;

    public Fumador(EnumFumadores fumador, Mesa mesa) {
	this.fumador = fumador;
	this.mesa = mesa;
    }

    public void run() {

	Random r = new Random();

	while (true) {

	    mesa.obtenerIngredientes(fumador);
	    System.out.println("Fumador: " + fumador + " fumando");
	    try {
		Thread.sleep(Math.abs(r.nextInt()) % 5000 + 1000);
	    }
	    catch (InterruptedException ie) { }
	    System.out.println("Fumador: " + fumador + " despertando agente");
	    mesa.ponerSeñalAgente();
	    try {
		Thread.sleep(Math.abs(r.nextInt()) % 5000 + 1000);
	    }
	    catch (InterruptedException ie) { }
	}
    }
}
