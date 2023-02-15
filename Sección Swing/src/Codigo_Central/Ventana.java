package Codigo_Central;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Ventana extends JPanel{

	//ATRIBUTOS
	JTabbedPane tabbed;												//Almaceno la referencia del JTabbedPanel							
	JPanel panel_botones;											//JPanel asociado a los botones del programa
	Timer cronometro;												//Timer para controlar el flujo temporal del programa(no es igual que el de la anterior parte)
	private final int ancho = 1100;									//Ancho del escenario (Comentario #1)
	private final int alto = 600;									//Alto del escenario 
	private final int retardo_Timer = 15;							//Periodo de tiempo entre ocurrencias del Timer

	Escenario escenario;											//Variable de la clase que almacena la referencia en memoria del escenario. 						

	int contador = 0 , contador2 = 50, contador3 = 0;				//Contadores auxiliares
	Fruta frutasCogidas[] = new Fruta[10];							//Almacenaje de frutas cogidas
	boolean caida = false;											//Variable para determinar la caida del personaje
	boolean pintar_elementos = false;								//Indica si es posible comenzar a pintar elementos

	//Botones
	private JButton escenario1,escenario2,escenario3,escenario4;		//Defino los botones asociados a cada escenario
	
	//Imagenes
	private Image presentacion;											//Imagen de presentación del escenario

	//MÉTODOS

//Construtor
	public Ventana(JTabbedPane tabbed) {
		panel_botones = new JPanel();													//Creo el JPanel que contiene los botones
		panel_botones.setPreferredSize(new Dimension(ancho,40));						//Establezco su tamaño
		panel_botones.setOpaque(false); 												//Hacemos el panel transparente
		
		this.tabbed = tabbed;															//Guardamos el JTabbed por si necesitaramos alterarlo posteriormente
		setPreferredSize(new Dimension(ancho,alto));									//Fijo el tamaño de la imagen, que me interesa que sea el mismo que el del escenario
		escenario = new Escenario(ancho,alto);											//Escenario de trabajo
		presentacion = new ImageIcon("Imagenes/Presentacion.png").getImage();			//Escojo la imagen de presentación del juego
		addKeyListener(new DirectionListener());										//Creo el Listener asociado a el salto del personaje
		
		//Sección de botones
		
		ButtonListener gestor_botones = new ButtonListener();			//Creamos el escuchador de los botones (observadores)
		
		escenario1 = new JButton("Escenario 1");						//Creo los botones y les asocio un listener
		escenario1.addActionListener(gestor_botones);
		escenario2 = new JButton("Escenario 2");
		escenario2.addActionListener(gestor_botones);
		escenario3 = new JButton("Escenario 3");
		escenario3.addActionListener(gestor_botones);
		escenario4 = new JButton("Escenario 4");
		escenario4.addActionListener(gestor_botones);
	
		panel_botones.add(escenario1);									//Los introduzco en el JPanel de los botones
		panel_botones.add(escenario2);	
		panel_botones.add(escenario3);
		panel_botones.add(escenario4);
		add(panel_botones);												//Introduzco el panel de los botones en el principal
		
		cronometro = new Timer(retardo_Timer,new ReboundListener());	//Comentario #2
		setFocusable(true);
	}
	
//#######################################################################################################	CLASES PRIVADAS	
	
//Clase privada Listener para recibir estímulos de los botones
private class ButtonListener implements ActionListener {			//El constructor no hace falta, ya está implementado en ActionListener
	//Método de gestión de estímulos	
	@Override							
	public void actionPerformed(ActionEvent e) {					//Cambiamos la imagen de presentación por la del escenario, escogemos el escenario y escondemos botones
		if(e.getSource() == escenario1) {
			presentacion = new ImageIcon("Imagenes/Escenario1.png").getImage();
			escenario.seleccionEscenario(1);}
		
		else if(e.getSource() == escenario2) {
			presentacion = new ImageIcon("Imagenes/Escenario2.png").getImage();
			escenario.seleccionEscenario(2);}
		
		else if(e.getSource() == escenario3) {
			presentacion = new ImageIcon("Imagenes/Escenario3.png").getImage();
			escenario.seleccionEscenario(3);}
		
		else if(e.getSource() == escenario4){
			presentacion = new ImageIcon("Imagenes/Escenario4.png").getImage();
			escenario.seleccionEscenario(4);}
		
		panel_botones.setVisible(false); 							//Escondemos los botones una vez 
		pintar_elementos = true;									//Permitimos que se pinten elementos
		cronometro.start(); 										//Importante para que el Timer comience a actuar
		repaint();													//Volvemos a pintar para actualizar los cambios
	}
		
}

//Clase privada Listener para recibir estímulos del Timer
private class ReboundListener implements ActionListener {			//El constructor no hace falta, ya está implementado en ActionListener
	//Método de gestión de estímulos	
	@Override						
	public void actionPerformed(ActionEvent evento) {
		if(seguirJugando()==false) {
			((Timer)evento.getSource()).stop();						//Si ya no se cumple la condición de seguir jugando, detengo el Timer asociado al Listener
			escenario.limpiarEscenario();	}						//Llamo al método para limpiar el escenario
		
		check();													//Cada interacción con el Timer, llamo al método check para gestionar la evolución de los elementos del programa
		repaint();													//Y vuelvo a pintar todos los elementos
	}
}

//Clase privada Listener para gestionar el salto del personaje
private class DirectionListener implements KeyListener{				//Este Listener sigue el patron observador, como los demás Listener, pero tiene asociadas teclas del teclado
	@Override
	public void keyPressed(KeyEvent pulsacion) {
		switch(pulsacion.getKeyCode()) {
		case KeyEvent.VK_W:											//Si se pulsa la tecla "w", el personaje salta
			if(contador2 > 49) {									//Si ya he saltado, no quiero saltar otra vez hasta que caiga
				caida = true;	
				contador2=-1;										//Inicializo el contador de tiempo en el aire
				escenario.getProtagonista().saltar(true);			//Salto
			}
		}
	}
	
	public void keyTyped(KeyEvent pulsacion) {}						//Métodos de obligada implementación por su abstracción					
	public void keyReleased(KeyEvent pulsacion) {}

}

//#######################################################################################################

//Método Paint heredado de JPanel para dibujar dentro de este contenedor intermedio
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);												//Llamamos a la clase delegada siguiendo un patrón de delegación
		g.drawImage(presentacion, 0, 0, null);									//Dibujamos la imagen del escenario en el JPanel
		
	if(pintar_elementos == true) {
		for(Elemento barrido: escenario.getElementos()) {
			
			try{barrido.getImagen().paintIcon(this, g, barrido.getPosicionX(), barrido.getPosicionY());}   			//Intentamos repintar de nuevo el elemento
		
			catch(java.lang.NullPointerException excepcionFin) {													//En caso de que no se pueda porque la imagen es nula (cuando llega al final,limpiamos todas las imagenes,terminamos el programa)
				String finPartida = escenario.getProtagonista().mostrarFrutas(frutasCogidas);							
				JOptionPane.showMessageDialog(null, finPartida);													//Saco por pantalla el cuadro final con todos los datos de la partida
				System.exit(0);																						//Para evitar que repita el mensaje el mismo número de veces que elementos hay, simplemente termino el programa
			}		
		}
	}	
	
	requestFocus();
}
		
//Método seguir jugando
	public boolean seguirJugando() {												//Si el protagonista no ha llegado al final del escenario, no termino la partida
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

//Hacer invisible
		check_desenfoque(protagonista);									
		
//Avanzar el personaje
		protagonista.avanzar(protagonista);
		
//Chocar con una fruta
		for(int i=0; i<frutas.length; i++) {											//Llamo al método coger fruta y guardo la fruta que he cogido
			if(frutas[i] != null && check_choque(protagonista,frutas[i]) == true) {
				protagonista.cogerFruta(protagonista,frutas[i]);
				frutasCogidas[contador3] = (Fruta) frutas[i];
				contador3++;
			}
		}
		
//Saltar el personaje
		check_salto(protagonista);
		
	}
	
//Método para controlar el contador de desenfoque
	public void check_desenfoque(Personaje protagonista) {						//Comprobamos si ha pasado el tiempo suficiente y si el prota ya se encontraba en estado de invisibilidad
		protagonista.contador_aux++;
		if(protagonista.invisible==true && protagonista.contador_aux==334) {
			protagonista.invisible=false;										//Desinvisibilizamos al protagonista
			protagonista.imagen = new ImageIcon("Imagenes/Protagonista.png");	//Y le devolvemos su imagen
		}
	}
		
//Método para controlar el choque de personajes y frutas
	public boolean check_choque(Personaje protagonista,Elemento fruta) {			//Comentario #3
		if(escenario.getCajaColision(protagonista).getBounds2D().intersects(escenario.getCajaColision(fruta).getBounds2D())) {	
			return true;		
		}

		else {return false;}
	}

//Método para controlar el tiempo de salto del personaje
	public void check_salto(Personaje protagonista) {
		contador2++;
		if(contador2==50 && caida == true) {				//Si ha pasado el tiempo de salto y se me permite caer
			caida = false;
			protagonista.saltar(false);						//Caigo
		}
	}
	
//Método getter para el escenario
	public Escenario getEscenario() {
		return escenario;
		
	}
	
//Método getter para las frutas cogidas
	public Fruta[] getFrutasCogidas() {
		return frutasCogidas;
	}

	}



/*Comentario #1: En este caso, no tendremos ancho y alto de escenario y ventana respectivamente. Simplemente tendremos magnitudes de 
 * escenario y será la ventana la que se ajuste a estas.*/

/*Comentario #2: IMPORTANTE->Este Timer que estamos empleando no es el mismo que el de la primera parte del proyecto. 
 *En la primera parte, tenías un Timer y una clase que heredaba de TimerTask, donde hacías la tarea en su método "Run".
 *En este caso, el nuevo Timer tiene como argumentos en constructor el tiempo que tiene que pasar entre aviso y aviso, nombrado como 
 *"retardo_Timer", y la clase a la que tiene que avisar, en este caso será "ReboundListener", una clase que hereda de Action Listener y 
 *tiene la misma función que la clase ButtonListener (ambas siguen patrón observador), es decir, recibir un estímulo (en el primer caso
 *de los botones, en este caso del Timer) y hacer una acción en su método "actionPerformed", por lo que este método es totalmente 
 *sustitutorio de la clase TimerTask, y por lo tanto, de TimerControl.*/

/*Comentario #3: Para saber si dos elementos chocan, empleo la idea de caja de colisión, de forma que, dado que la fruta no tiene una
 * posición exacta si tenemos en cuenta su ancho y alto, el método a emplear se complica y debemos de trabajar con áreas. La clase Rectangle
 * me permite crear este rectángulo, indicando el centro, ancho y alto. De esta forma, nos aseguramos de que la colisión ocurre sin recurrir
 * a comparaciones caseras.*/
 