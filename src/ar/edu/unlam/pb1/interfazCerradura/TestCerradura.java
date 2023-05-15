package ar.edu.unlam.pb1.interfazCerradura;

import java.util.Scanner;

import ar.edu.unlam.pb1.dominioCerradura.Cerradura;

public class TestCerradura {
	static Scanner teclado = new Scanner(System.in);
	static boolean seAbrio;
	static final int CANTIDADMAX=3;
	
	public static void main(String[] args) {
		int intentosQueLleva = 0; // ESTO SE PUEDE DEFINIR EN EL METEDO
		int clave;
		int claveIngresada;
		
		mostrarMensaje("Ingrese contraseña deseada");
		clave = teclado.nextInt();
		/*mostrarMensaje("Ingrese cantidad Maxima de intentos hasta ser bloqueada");
		int CantidadMax = teclado.nextInt();*/
		Cerradura miCerradura = new Cerradura(clave);
		Cerradura otraCerradura= new Cerradura();// ----> clave 1234, intentos para bloqueo=3, seAbrio false					
		do {
			mostrarMensaje("Ingrese la clave para abrir");
			claveIngresada = teclado.nextInt();
			seAbrio = miCerradura.abrir(claveIngresada, intentosQueLleva);
			if (seAbrio) {
				mostrarMensaje("La cerradura se ABRIO");
				intentosQueLleva = 0;
			} else {
				mostrarMensaje("La cerradura NO SE ABRIO");
				intentosQueLleva++;
				mostrarMensaje("Usted lleva: "+ intentosQueLleva + " Intentos\n");
			}
		} while (seAbrio != true && CANTIDADMAX != intentosQueLleva); // VALIDACION DE DATOS

		boolean fueBloqueada = miCerradura.fueBloqueada(intentosQueLleva);
		if (fueBloqueada)
			mostrarMensaje("-----SU CERRADURA FUE BLOQUEADA-----> " + miCerradura.getFueBloqueada());
		mostrarMensaje("\nLa cerradura esta abierta??: " + miCerradura.getSeabrio());
	}

	public static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}

}
