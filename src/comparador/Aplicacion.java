package comparador;


import java.awt.image.BufferedImage;



import org.opencv.core.Core;




public class Aplicacion {
	
	static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

	public static void main(String[] args) {
		
		
		/*Diferent forms to call the methods*/
		
		//BufferedImage in_image = null;
		//BufferedImage match_image;
		
		//String in_imagePath = "C:/Users/CARLOS/Desktop/ref_image/cocacola_2.jpg";
		//Matcomparison comparador = new Matcomparison();
		//Producto encontrado = comparador.obtainbestmatch(in_imagePath);
		//Producto[] ordenados = comparador.obtain_matches_in_order(in_imagePath);
		
		
		DisplayApp win = new DisplayApp();
		win.setTitle("Guardar y leer imagenes en Mysql");
		win.getFrame().setVisible(true);
		
	}
		
	
}
