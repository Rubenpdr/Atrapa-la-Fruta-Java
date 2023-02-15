package Codigo_Central;

import javax.swing.ImageIcon;

public class Fruta extends Elemento{

	//ATRIBUTOS
	public String nombre_fruta;						//Nombre de la fruta
	public int puntos;								//Puntos otorgados por la fruta
	
	//M�TODOS
	
//M�todo constructor
	public Fruta(int posicionX,int posicionY,int ancho,int alto,ImageIcon imagen,char simbolo,String nombre,int puntos) {
		super(posicionX,posicionY,ancho,alto,imagen,simbolo);
		this.nombre_fruta = nombre;
		this.puntos = puntos;
	}

//M�todo mostrar datos
	@Override
	public void mostrarDatos() {
		System.out.println("Datos de la fruta "+nombre_fruta+":\n"
				+ "Posici�n X: "+posicionX+"\nPosici�n Y: "+posicionY+"\nAnchura: "+ancho+"\nAltura: "+alto+"\nImagen: "+imagen+"\n"
						+ "S�mbolo: "+simbolo+"\nNombre: "+nombre_fruta+"\nPuntos: "+puntos+"\n");
	}
}