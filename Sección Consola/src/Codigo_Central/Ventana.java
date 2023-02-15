package Codigo_Central;

public class Ventana {

	//ATRIBUTOS
	public int ancho;
	public int alto;
	Escenario escenario;		//Comentario #3
	private String lectura;
	int contador,contador2, contador3;
	Fruta frutasCogidas[] = new Fruta[10];
	boolean caida;
	
	//MÉTODOS

//Construtor
	public Ventana(int ancho,int alto,Escenario escenario) {
		this.ancho = ancho;
		this.alto = alto;
		this.escenario = escenario;
		this.contador = 0;
		this.contador2 = 0;
		this.contador3 = 0;
		this.caida = false;
	}
	
//Método para dibujar escenario
	
	public static void dibujarEscenario(Elemento elementos[], int anchura, int altura) { //Comentario #2     
		  char[][] escenarioTextual = new char[anchura][altura];  
		  for (int i = 0; i < anchura; i++) {     
		    for (int j = 0; j < altura; j++) {           
		      if (j==0) {              
		        escenarioTextual[i][j] = '#';           
		      }else {              
		        escenarioTextual[i][j] = ' ';          
		       }        
		    }     
		  }     
		  for (Elemento barrido: elementos) {    														  
		      escenarioTextual[(int) barrido.posicionX][(int) barrido.posicionY] = barrido.getSimbolo();         
		  }     
		  for (int y =altura - 1; y >= 0; y--) {        
		    for (int x = 0; x < altura; x++) {           
		      if (y==0) {              
		        System.out.printf("#");           
		      }else {
		        System.out.printf(Character.toString(escenarioTextual[x][y]));           
		      }        
		    }        
		    System.out.printf("\n");     
		  }  
		}

//Método seguir jugando
	public boolean seguirJugando() {
		if(escenario.ancho == escenario.getProtagonista().posicionX) {
			return false;
		}
		else {
			return true;
		}
		
	}

//Método para comprobar situaciones
	public void check(){
		
		Personaje protagonista = escenario.getProtagonista();
		Elemento frutas[] = escenario.getFrutas();	
		
		Ventana auxiliar = new Ventana(1,1,null);
		auxiliar.check_desenfoque(protagonista);
		auxiliar = null;
		
		if(contador==2) {contador = -1; protagonista.avanzar(protagonista);}
		contador++;

		if(lectura.equals("w")) {
			caida = true;	
			contador2=-1;
			this.lectura = "Esperando";
			protagonista.saltar(protagonista,true);
		}
		
		contador2++;
		if(contador2==6 && caida == true) {
			caida = false;
			protagonista.saltar(protagonista,false);
		}

		for(int i=0; i<frutas.length; i++) {
			if(frutas[i] != null && protagonista.posicionX == frutas[i].posicionX && protagonista.posicionY == frutas[i].posicionY) {
				protagonista.cogerFruta(protagonista,frutas[i]);
				frutasCogidas[contador3] = (Fruta) frutas[i];
				contador3++;
			}	
		}
		
	}
	
//Método para controlar el contador de desenfoque
	public void check_desenfoque(Personaje protagonista) {
		protagonista.contador_aux++;
		if(protagonista.invisible==true && protagonista.contador_aux==25) {
			protagonista.invisible=false;
			protagonista.simbolo = 'O';
		}
	}

//Método mostrar datos al final de la partida
	public void finPartida() {
		escenario.getProtagonista().mostrarFrutas(frutasCogidas,escenario.getProtagonista());
		Elemento elementos[]=escenario.getElementos();
		for(int i=0; i<elementos.length; i++) {
			if(elementos[i]!=null) {
				elementos[i].mostrarDatos();	
			}
		}
	}
		
//Método getter para el escenario
	public Escenario getEscenario() {
		return escenario;
		
	}
//Método Setter de lectura
	public void setLectura(String lectura) {
		this.lectura = lectura;
	}
	
//Método getter para las frutas cogidas
	public Fruta[] getFrutasCogidas() {
		return frutasCogidas;
	}

}


/*Comentario #1:El cometido de la clase Ventana es el de dibujar una ventana con un ancho
 * y alto para futuras interfaces gráficas y al mismo tipo dibujar el escenario de un tamaño
 * determinado y rellenarlo con los elementos programados.*/

/*Comentario #2: La idea es crear una matriz de caracteres de dimensionalidad el tamaño del 
 * escenario. Tras esto, la rellenamos con "#" (hastags) para el suelo y " " (vacios) para
 * el resto del escenario.
 * Una vez hecho esto, cogemos el vector de objetos tipo Elemento y recorremos todos los 
 * objetos de este vector de elementos (ya sean personajes o frutas), y sustituimos los 
 * " "(vacios) añadidos anterioremente por el símbolo asociado a cada objeto del vector 
 * Elemento, especificando la posición X e Y de cada uno.
 * A este método lo llamaremos muy seguramente desde el Main, puesto que Elemento es una clase 
 * abstracta, y es Escenario la que guarda sus vectores de objetos.
 * Lo que no entiendo es la parte de los pintlf del final*/

/*Comentario #3: La idea es que el escenario almacene los elementos y la ventana el escenario, de forma que utilizando
 * únicamente la ventana, pueda acceder a todos los */
