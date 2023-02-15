package Codigo_Central;

import java.util.Scanner;
import java.util.TimerTask;

public class TimerControl extends TimerTask{	//Comentario #1

	//ATRIBUTOS
	Ventana ventana;		//El Timer almacena el objeto ventana, la ventana almacena el Escenario y el Escenario los elementos
	
	//M�TODOS
	
//Constructor
	public TimerControl(Ventana ventana) {
		this.ventana = ventana;
	}
	
//M�todo run sobreescrito de la clase abstracta TimerTask	
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

/*Comentario #1: Al tener TimerTask un m�todo abstracto, se convierte en una clase abstracta. Podemos heredar de esta clase para 
* utilizar sus m�todos y sobreescribirlos, como hacemos con elemento y sus clases hija Personaje,Fruta...
* La idea es crear un objeto de la clase TareasJuego, sobreescribiendo el m�todo abstracto "run" de TimerTask y a�adiendo el resto
* de c�digo requerido.*/

/*Comentario #2: La idea es que cada run compruebe si est� jugando todav�a o no. Si jugamos, dibujo la ventana, si no, termina el programa.
 * Me aprovecho de los getters y setters encadenados en ventana para obtener desde esta los elementos y el escenario de forma c�moda*/
