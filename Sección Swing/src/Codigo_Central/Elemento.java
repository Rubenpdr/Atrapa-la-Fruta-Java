package Codigo_Central;

import javax.swing.ImageIcon;						

public abstract class Elemento {			//Comentario #1
	
	//ATRIBUTOS
	public int posicionX;							//Indica la posici�n en el eje de abcisas del objeto (en t�rminos de p�xeles)
	public int posicionY;							//Indica la posici�n en el eje de ordenadas del objeto (en t�rminos de p�xeles)
	public int ancho;								//Indica el ancho en p�xeles del ImageIcon asociado al objeto
	public int alto;								//Indica el alto en p�xeles del ImageIcon asociado al objeto
	public ImageIcon imagen;						//Imagen asociada al objeto
	public char simbolo;							//Indica el s�mbolo del objeto
	
	//M�TODOS
	
//M�todo Constructor
	public Elemento(int posicionX,int posicionY,int ancho,int alto,ImageIcon imagen,char simbolo) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.ancho = ancho;
		this.alto = alto;
		this.imagen = imagen;
		this.simbolo = simbolo;

	}
	
//M�todo abstracto para mostrar datos
	public abstract void mostrarDatos();			//M�todo que muestran los atributos del objeto que lo invoca
	
//M�todos Getter
	public char getSimbolo() {
		return simbolo;
	}
	
	public ImageIcon getImagen() {
		return imagen;
	}
	
	public int getPosicionX() {
		return posicionX;
	}
	
	public int getPosicionY() {
		return posicionY;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return alto;
	}
	

}

//COMENTARIOS
/*Comentario #1-> Esta clase es una superclase abstracta, de forma que las clases "Personaje" y "Fruta" heredaran de esta. Estas 
 * tambi�n deben de implementar el m�todo abstracto */


