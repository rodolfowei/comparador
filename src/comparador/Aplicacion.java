package comparador;

import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;









import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import org.opencv.core.Core;
import org.opencv.core.Mat;

//Change to test gitHub
//Second change

//change

public class Aplicacion {
	
	static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

	public static void main(String[] args) {
		
		
		// Previous code probably unnecessary, was just to check if the methods to 
		//charge images where working fine.
		/*
		ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
		images = Imagesfromfolder.getBufferedimages();
		
		ArrayList<Mat> imagesOcv = new ArrayList<Mat>();
		imagesOcv = Imagesfromfolder.getMatimages();
		
		System.out.println("Imprimiendo nombres y tamaño de las imagenes");

		for(BufferedImage bufim : images)
		{
			System.out.println(bufim.getWidth());
			System.out.println(bufim.getHeight());
		}
		
		System.out.println("Imprimiendo nombres y tamaño de las imagenes");
		
		for (Mat matim : imagesOcv)
		{
			System.out.print("COLS:   " + matim.cols() + "  ");
			System.out.println("ROWS:   " + matim.rows());
		}
		*/
		
		BufferedImage in_image;
		BufferedImage match_image;
		String in_imagePath = args[1];
		Matcomparison comparador = new Matcomparison();
		Producto encontrado = comparador.obtainbestmatch(in_imagePath);
		
		File in_file = new File(in_imagePath);
		try {
			in_image = ImageIO.read(in_file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		match_image = encontrado.obtainBuffimage();
		
		//Now we have to print both of the images to see if the match is correct
		
		
		
		 
		
		
		
	}
	
	public void displaymatch(BufferedImage inimage, BufferedImage topmatcher){
		
		JFrame displayingframe = new JFrame("Product matched");
		displayingframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		BufferedImage imagein = inimage;
		BufferedImage imageout = topmatcher;
		
		ImageIcon imageinicon = new ImageIcon(imagein);
		ImageIcon imageouticon = new ImageIcon(imageout);
		
		JLabel labelimagen = new JLabel();
		labelimagen.setIcon(imageinicon);
		labelimagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		
		
	}

}
