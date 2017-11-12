package Ejercicio23;

import java.util.Random;

public class Controlador {
	final int MAX_PERSONAS = 3;
	int numPersonas;

	public Controlador() {
		numPersonas = 0;// Inicalmente, no hay nadie en el baño
	}

	// El mactodo no puede ser completamente sincronizado, porque quiero que entren
	// varias personas por el baño a la vez.
	// Solo puedo sincronizar la entrada y la salida.
	public void entrarBanio(String nombre) {

		synchronized (this) {
			while (numPersonas >= MAX_PERSONAS) { // ese while se pone por si se despierta un hilo enter medio de la
				System.out.println(nombre + " espera porque el baño está lleno"); // ejecucion
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			numPersonas++;// Entro
			System.out.println("Ha entrado ********** " + nombre + ",hay " + numPersonas);// Lo notifico

		}

		int tiempoDormido = generarAleatorio(20);

		System.out.println(nombre + " se duerme " + tiempoDormido);
		try {
			Thread.sleep(tiempoDormido);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		synchronized (this) {// Sincronizo por que voy a salir
			numPersonas--;// Salgo
			System.out.println("Sale " + nombre + " hay " + numPersonas);// Lo digo
			notify();// Despierto al siguiente hilo antes de dormirme
		}

		// esto sería fuera del baño xq si no se bloquea el hilo
		try {
			Thread.sleep(500);// Me duermo
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int generarAleatorio(int rango) {
		Random rd = new Random();
		return rd.nextInt(rango);
	}

}
