package Codigo_Central;

public abstract class Elemento {
	
	//ATRIBUTOS
	public int posicionX;
	public int posicionY;
	public int ancho;
	public int alto;
	public float imagen;
	public char simbolo;
	public boolean tipo_elemento;
	
	//MÉTODOS
	
//Método Constructor
	public Elemento(int posicionX,int posicionY,int ancho,int alto,float imagen,char simbolo) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.ancho = ancho;
		this.alto = alto;
		this.imagen = imagen;
		this.simbolo = simbolo;
	}
	
	public abstract void mostrarDatos();

//Métodos Getter
	public char getSimbolo() {
		return simbolo;
	}
	

}

/*Esta clase solo sirve para almacenar características generales de las frutas y los 
 * personajes, así como para inicializar un método abstracto*/
