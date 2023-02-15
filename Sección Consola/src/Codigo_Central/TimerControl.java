package Codigo_Central;

import java.util.Scanner;
import java.util.TimerTask;

public class TimerControl extends TimerTask{	//Comentario #1

	//ATRIBUTOS
	Ventana ventana;		//El Timer almacena el objeto ventana, la ventana almacena el Escenario y el Escenario los elementos
	
	//MÉTODOS
	
//Constructor
	public TimerControl(Ventana ventana) {
		this.ventana = ventana;
	}
	
//Método run sobreescrito de la clase abstracta TimerTask	
	@Override
	public void run() {								//Comentario #2
		if(ventana.seguirJugando() == false) {
			cancel();
			System.exit(0);
		}
		else {
			ventana.check();
			
			try {
				ventana.dibujarEscenario(ventana.getEscenario().getElementos(),ventana.getEscenario().ancho,ventana.getEscenario().alto);
			}
			
			catch(java.lang.ArrayIndexOutOfBoundsException excep_pantalla) {
				ventana.finPartida();
			}
		}
	}
	
//Getters
	public Ventana getVentana() {
		return ventana;
	}
	
	
	
}

//COMENTARIOS

/*Comentario #1: Al tener TimerTask un método abstracto, se convierte en una clase abstracta. Podemos heredar de esta clase para 
* utilizar sus métodos y sobreescribirlos, como hacemos con elemento y sus clases hija Personaje,Fruta...
* La idea es crear un objeto de la clase TareasJuego, sobreescribiendo el método abstracto "run" de TimerTask y añadiendo el resto
* de código requerido.*/

/*Comentario #2: La idea es que cada run compruebe si está jugando todavía o no. Si jugamos, dibujo la ventana, si no, termina el programa.
 * Me aprovecho de los getters y setters encadenados en ventana para obtener desde esta los elementos y el escenario de forma cómoda*/
