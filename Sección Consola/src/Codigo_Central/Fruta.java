package Codigo_Central;

public class Fruta extends Elemento{

	//ATRIBUTOS
	public String nombre;
	public int puntos;
	
	//MÉTODOS
	
//Método constructor
	public Fruta(int posicionX,int posicionY,int ancho,int alto,float imagen,char simbolo,String nombre,int puntos) {
		super(posicionX,posicionY,ancho,alto,imagen,simbolo);
		this.nombre = nombre;
		this.puntos = puntos;
	}
	
//Método mostrar datos
	@Override
	public void mostrarDatos() {
		System.out.println("Datos de la fruta "+nombre+":\n"
				+ "Posición X: "+posicionX+"\nPosición Y: "+posicionY+"\nAnchura: "+ancho+"\nAltura: "+alto+"\nImagen: "+imagen+"\n"
						+ "Símbolo: "+simbolo+"\nNombre: "+nombre+"\nPuntos: "+puntos+"\n");
	}
}