package Codigo_Central;

public class Personaje extends Elemento{
	
	//ATRIBUTOS
	final String nombre_jugador = "Rub�n";
	public int velocidad;
	public String nombre_enemigo;
	int puntuacion;
	public boolean invisible = false;
	public int contador_aux;
	
	//M�TODOS
	
//M�todo Constructor para personaje principal
	public Personaje(int posicionX,int posicionY,int ancho,int alto,float imagen,char simbolo,int velocidad) {
		super(posicionX,posicionY,ancho,alto,imagen,simbolo);
		this.velocidad = velocidad;
		this.nombre_enemigo = this.nombre_jugador;
	}
	
//M�todo Constructor sobrecargado para personajes enemigos
	
	public Personaje(int posicionX,int posicionY,int ancho,int alto,float imagen,char simbolo,String nombre_enemigo,int velocidad) {
		super(posicionX,posicionY,ancho,alto,imagen,simbolo);
		this.velocidad = velocidad;
		this.nombre_enemigo = nombre_enemigo;
	}

//M�todo saltar
	public void saltar(Personaje personaje,boolean check_salto) {		//Pendiente hacer la interrupci�n
		if(check_salto == true) {
			personaje.posicionY++;
		}
		else if (check_salto == false) {
			personaje.posicionY--;
		}
		
		else {}
	}	
	
//M�todo avanzar
	public void avanzar(Personaje personaje) {		
		personaje.posicionX = personaje.posicionX+velocidad; 
	}
	
//M�todo coger fruta
	public void cogerFruta(Personaje protagonista, Elemento fruta){
		
		if(fruta.simbolo=='H') {
			protagonista.invisible=true;
			protagonista.contador_aux=-1;
		}
		
		if(fruta.simbolo=='G' || fruta.simbolo=='H' || fruta.simbolo=='V') {
			FrutaMagica frutaMagica = (FrutaMagica) fruta;
			frutaMagica.simbolo=' ';
			protagonista.puntuacion = protagonista.puntuacion + frutaMagica.puntos;
			frutaMagica.aplicarEfectos(protagonista,frutaMagica);
		}
		
		else if(fruta.simbolo=='D' || fruta.simbolo=='P'){
			Fruta frutaNormal = (Fruta) fruta;
			fruta.simbolo=' ';
			protagonista.puntuacion = protagonista.puntuacion + frutaNormal.puntos;
		}
		else {System.out.println("No se detecta la fruta");}
		
	}
	
//M�todo mostrar frutas
	public void mostrarFrutas(Fruta frutasCogidas[],Personaje protagonista) {	
		System.out.println("Usted ha recogido las siguientes frutas durante su aventura:");	
		for(int i=0; i<frutasCogidas.length; i++) {
			if(frutasCogidas[i]!=null && frutasCogidas[i].puntos==300) {
				System.out.println((i+1)+"� fruta: "+frutasCogidas[i].nombre+" : "+frutasCogidas[i].puntos+" puntos : Efecto VELOCIDAD");
			}
			else if(frutasCogidas[i]!=null && frutasCogidas[i].puntos==-100) {
				System.out.println((i+1)+"� fruta: "+frutasCogidas[i].nombre+" : "+frutasCogidas[i].puntos+" puntos : Efecto RALENTIZAR");
			}
			else if(frutasCogidas[i]!=null && frutasCogidas[i].puntos==-50) {
				System.out.println((i+1)+"� fruta: "+frutasCogidas[i].nombre+" : "+frutasCogidas[i].puntos+" puntos : Efecto DESAPARECER");
			}
			else if(frutasCogidas[i]!=null && (frutasCogidas[i].puntos==100 || frutasCogidas[i].puntos==200)) {
				System.out.println((i+1)+"� fruta: "+frutasCogidas[i].nombre+" : "+frutasCogidas[i].puntos+" puntos");
			}
			else {}
		}
		System.out.println("El total de puntos obtenidos ha sido de: "+protagonista.puntuacion+" puntos\n");
		System.out.println("Diario del explorador\n");

	}

	
//M�todo mostrar datos sobrescrito
	@Override
	public void mostrarDatos() {
		System.out.println("Datos del personaje "+nombre_enemigo+":\n"
				+ "Posici�n X: "+posicionX+"\nPosici�n Y: "+posicionY+"\nAnchura: "+ancho+"\nAltura: "+alto+"\nImagen: "+imagen+"\n"
						+ "S�mbolo: "+simbolo+"\nNombre del personaje: "+nombre_enemigo+"\nVelocidad: "+velocidad+"\n");
	}	
	
}



//INFORMACI�N

/*		ESCENARIO 1
 * El gigante se queda quieto y quita puntos si te golpea. Lo mato atacandole como drag�n con la fruta drag�n.
 * El hombre lobo ataca corriendo hacia el objetivo. Debes de coger la fruta plateada para derrotarlo de un pu�etazo de plata 
 * 
 * 		ESCENARIO 2
 * Jinete de nuevo
 * Mujer Serpiente escupe veneno en las zonas cercanas. Toma la fruta de veneno para ser inmune al veneno o la dorada para repeler el veneno gracias a sus efectos curativos.
 * El radio de veneno de la serpiente es de 5 a cada lado.
 * El jinete fantasma corre hacia t� y te ataca, quitandote puntos. Lo mato endurenciendome con la fruta dorada y chocando contra el.
 * 
 * 		ESCENARIO 3
 * El drag�n pasar� volando por la zona y me atacar� si no tengo la fruta de invisibilidad Potter, dejando una zona de fuego de 20 bloques
 * 
 * 		ESCENARIO 4
 * El golem es inmune a todas las frutas exceptuando la uni�n de la fruta plateada y la drag�n, convirtiendote en un drag�n plateado.
 *Se mantendr� quieto durante los ataques.
 * El Necrom�ntico es inmune a todas las frutas exceptuando la plateada. Generar� un �ura de oscuridad
 * destructiva de 10 al frente
 * */ 	

	
	
	//USAR FRUTA PLATEADA PARA MATAR AL HOMBRE LOBO
	