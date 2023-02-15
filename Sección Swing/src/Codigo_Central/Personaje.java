package Codigo_Central;

import javax.swing.ImageIcon;

public class Personaje extends Elemento{	
	
	//ATRIBUTOS
	final String nombre = "Rubén";							//Indica el nombre del Personaje, en este caso, el mio
	public int velocidad;									//Número de píxeles que recorrre el personaje por ciclo del Timer 					
	int puntuacion;											//Almacena la puntuación actual del protagonista en base a las frutas atrapadas
	public boolean invisible = false;						//Booleano que indica si el personaje se encuentra en estado de invisibilidad o no
	public int contador_aux;
	
	//MÉTODOS
	
//Método Constructor
	public Personaje(int posicionX,int posicionY,int ancho,int alto,ImageIcon imagen,char simbolo,int velocidad) {
		super(posicionX,posicionY,ancho,alto,imagen,simbolo);
		this.velocidad = velocidad;
	}

//Método saltar
	public void saltar(boolean check_salto) {								//Comentario #1
		if(check_salto == true && this.posicionY>200) {						//Compruebo si puedo saltar y tengo una altura tal que no me salga de pantalla
			this.posicionY = this.posicionY - 120;				
		}
		else if (check_salto == false) {									//Compruebo si puedo caer y caigo tras el salto
			this.posicionY = this.posicionY + 120;
		}
		
		else {}
	}	
	
//Método avanzar
	public void avanzar(Personaje personaje) {										//Avanzo la posición X del personaje de forma lineal a la velocidad de este, para que se produzca un desplazamiento
		personaje.posicionX = personaje.posicionX+velocidad; 
	}
	
//Método gestor de frutas cogidas
	public void cogerFruta(Personaje protagonista, Elemento fruta){
		if(fruta.simbolo=='H') {													//Si la fruta cogida es particularmente una Harry, voy activando la variable de checkeo de invisibilidad y el contador antes de gestionar el efecto  
			protagonista.invisible=true;
			protagonista.contador_aux=-1;
		}
		
		if(fruta.simbolo=='G' || fruta.simbolo=='H' || fruta.simbolo=='V') {
			FrutaMagica frutaMagica = (FrutaMagica) fruta;										//Dado que se trata de una fruta mágica,hago un cast para facilitar las operaciones
			frutaMagica.posicionX=5000;															//Saco la fruta de la pantalla para aparentar que desaparece sin tener que hacer null su imagen o un JPanel exclusivo
			protagonista.puntuacion = protagonista.puntuacion + frutaMagica.puntos;				//Sumo la puntuación
			frutaMagica.aplicarEfectos(protagonista);											//Y aplico efectos
		}
		
		else if(fruta.simbolo=='D' || fruta.simbolo=='P'){
			Fruta frutaNormal = (Fruta) fruta;													//Al ser una fruta normal, hago un cast para facilitar operaciones
			fruta.posicionX=5000;																//Saco de nuevo la fruta de la pantalla
			protagonista.puntuacion = protagonista.puntuacion + frutaNormal.puntos;				//Y acumulo los puntos
		}
		else {System.out.println("No se detecta la fruta");}
		
	}
	
//Método mostrar frutas
	public String mostrarFrutas(Fruta frutasCogidas[]) {										//Recorro todas las frutas cogidas, compruebo que tipo de frutas son por sus puntos y muestro los datos por pantalla
		String total = "Usted ha recogido las siguientes frutas durante su aventura:\n";
		for(int i=0; i<frutasCogidas.length; i++) {
			if(frutasCogidas[i]!=null && frutasCogidas[i].puntos==300) {
				total = total + ((i+1)+"º fruta: "+frutasCogidas[i].nombre_fruta+" : "+frutasCogidas[i].puntos+" puntos : Efecto VELOCIDAD\n");
			}
			else if(frutasCogidas[i]!=null && frutasCogidas[i].puntos==-100) {
				total = total + ((i+1)+"º fruta: "+frutasCogidas[i].nombre_fruta+" : "+frutasCogidas[i].puntos+" puntos : Efecto RALENTIZAR\n");
			}
			else if(frutasCogidas[i]!=null && frutasCogidas[i].puntos==-50) {
				total = total + ((i+1)+"º fruta: "+frutasCogidas[i].nombre_fruta+" : "+frutasCogidas[i].puntos+" puntos : Efecto DESAPARECER\n");
			}
			else if(frutasCogidas[i]!=null && (frutasCogidas[i].puntos==100 || frutasCogidas[i].puntos==200)) {
				total = total + ((i+1)+"º fruta: "+frutasCogidas[i].nombre_fruta+" : "+frutasCogidas[i].puntos+" puntos\n");
			}
			else {}
		}
		
		total = total + ("El total de puntos obtenidos ha sido de: "+this.puntuacion+" puntos.");
		return total;

	}

	
//Método mostrar datos sobrescrito
	@Override
	public void mostrarDatos() {											//Un método particular para mostrar todos los atributos del personaje
		System.out.println("Datos del personaje "+nombre+":\n"
				+ "Posición X: "+posicionX+"\nPosición Y: "+posicionY+"\nAnchura: "+ancho+"\nAltura: "+alto+"\nImagen: "+imagen+"\n"
						+ "Símbolo: "+simbolo+"\nNombre del personaje: "+nombre+"\nVelocidad: "+velocidad+"\n");
	}	
	
}



//COMENTARIOS
/*Comentario #1-> Recordar que el punto (0,0) en Swing comienza en la esquina superior izquierda de la pantalla, de forma que aumentar 
 * el valor de las posiciones consiste en desplazar hacia la derecha o abajo*/
	