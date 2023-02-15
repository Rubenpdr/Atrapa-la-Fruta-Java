package Codigo_Central;

import java.util.Scanner;		//Scanner para pedir datos por pantalla
import java.util.Timer;			//Timer para medir instantes temporales
import java.util.TimerTask;		//Timer para especificar tareas

public class Main {
	public static void main(String args[]) throws InterruptedException {
		
		Scanner consola = new Scanner(System.in);		//Receptor de Datos
		Timer cronometro = new Timer();					//Cronometro para acciones repetitivas
	
//Presentación
		
		Salida_Pantalla texto = new Salida_Pantalla();			//Objeto para llamar a los textos		
		byte selección = texto.selector_esc();					//Escenario escogido

//Creación de todos los objetos necesarios para el juego
		Escenario crear_escenario = new Escenario();			//Objeto auxiliar de ayuda
		TimerControl Timer = new TimerControl(crear_escenario.seleccionEscenario(selección));	
		crear_escenario=null;
		  	
//Control del Timer	
  		cronometro.schedule(Timer,0,200);	
  		Timer.getVentana().setLectura("Start");	
	
//Bucle infinito	
   		while(true) {
  			String lectura=consola.nextLine();
  			Timer.getVentana().setLectura(lectura);
  		}
		
	}
}



//COMENTARIOS


