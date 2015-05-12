package comparador;

import java.awt.image.BufferedImage;
import java.util.ArrayList;


import org.opencv.core.Core;
import org.opencv.core.Mat;

//Change to test gitHub
//Second change

//change

public class Aplicacion {
	
	static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

	public static void main(String[] args) {
		
		
		
		ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
		images = Imagesfromfolder.getimages();
		
		ArrayList<Mat> imagesOcv = new ArrayList<Mat>();
		imagesOcv = Imagesfromfolder.getimagesMat();
		
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
	}

}
