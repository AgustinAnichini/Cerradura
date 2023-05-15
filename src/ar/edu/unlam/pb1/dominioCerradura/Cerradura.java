package ar.edu.unlam.pb1.dominioCerradura;

public class Cerradura {
	private int clave;
	private static final int cantidadDeIntentosMaxParaBloqueo = 3;
	private boolean seAbrio;
	private boolean fueBloqueada;

	public Cerradura() {
		this.clave = 1234;
		this.seAbrio = false;
	}

	public Cerradura(int clave) {
		this.clave = clave;
		this.seAbrio = false;
	}

	public boolean abrir(int claveIngresada, int intentosQueLleva) {
		if (clave == claveIngresada && cantidadDeIntentosMaxParaBloqueo >= intentosQueLleva && fueBloqueada == true) {
			return seAbrio = true;
		}
		return seAbrio = false;
	}

	public boolean fueBloqueada(int intentosQueLleva) {
		if (cantidadDeIntentosMaxParaBloqueo == intentosQueLleva) {
			seAbrio = false;
			fueBloqueada = true;
			return fueBloqueada;
		}
		seAbrio = true;
		return fueBloqueada == false;
	}

	public boolean getSeabrio() {
		return this.seAbrio;
	}

	public boolean getFueBloqueada() {
		return this.fueBloqueada;
	}
}
