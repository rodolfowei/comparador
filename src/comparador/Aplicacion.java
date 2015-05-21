package comparador;

//import java.awt.Window;
import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;



//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.WindowConstants;

import org.opencv.core.Core;
//import org.opencv.core.Mat;

//Change to test gitHub
//Second change

//change

public class Aplicacion {
	
	static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

	public static void main(String[] args) {
		
		
	
		
		BufferedImage in_image = null;
		BufferedImage match_image;
		String in_imagePath = "C:/Users/CARLOS/Desktop/ref_image/cocacola_2.jpg";
		Matcomparison comparador = new Matcomparison();
		Producto encontrado = comparador.obtainbestmatch(in_imagePath);
		
	
	}
		
	
}
