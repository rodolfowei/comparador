package comparador;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import org.opencv.core.Mat;

//Change to test gitHub
//Second change

//change

public class Aplicacion {

	public static void main(String[] args) {
		
		ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
		images = Imagesfromfolder.getimages();
		
		ArrayList<Mat> imagesOcv = new ArrayList<Mat>();
		imagesOcv = Imagesfromfolder.getimagesMat();

		for(BufferedImage bufim : images)
		{
			System.out.println(bufim.getWidth());
			System.out.println(bufim.getHeight());
		}
		
		for (Mat matim : imagesOcv)
		{
			System.out.print(matim.cols());
			System.out.println(matim.rows());
		}
	}

}
