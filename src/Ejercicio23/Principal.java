package Ejercicio23;

public class Principal {
	public static void main(String[] args) {
		
		Controlador control=new Controlador();
		Persona[] personas=new Persona[5];
		String [] nombres= {"Juan","Marcos","María","Ana","Pedro"};
		
		for (int i = 0; i < personas.length; i++) {
			personas[i]=new Persona(control, nombres[i]);
			personas[i].start();
		}
	}

}
