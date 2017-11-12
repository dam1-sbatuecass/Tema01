package Ejercicio23;

public class Persona extends Thread {
	Controlador control;

	public Persona(Controlador control, String nombre) {
		this.control = control;
		this.setName(nombre);
	}

	@Override
	public void run() {
		while (true) {
			control.entrarBanio((this.getName()));
			yield();
		}

	}

}
