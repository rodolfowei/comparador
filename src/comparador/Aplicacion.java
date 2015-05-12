package comparador;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

//Change to test gitHub
//Second change

//change

public class Aplicacion {

	public static void main(String[] args) {
		
		ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
		images = Imagesfromfolder.getimages();

		for(BufferedImage bufim : images)
		{
			System.out.print(bufim.getWidth()+ "  ");
			System.out.println(bufim.getHeight());
		}
	}

}
