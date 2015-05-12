package comparador;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;




/*This class implements a method to build an array of images
 * from a folder containing jpg images
 */

public class Imagesfromfolder {
	
	static final File ruta = new File ("C:/Users/CARLOS/Desktop/imagenes");
	
	public static ArrayList<String> getAllImages() throws IOException
	{
		
			
		if(!ruta.isDirectory())
			System.out.println("Not a directory");
		if(!ruta.exists())
			System.out.println("File doesn't exist");
		
		
		ArrayList<String> imageList = new ArrayList<String>(256);
		File[] f = ruta.listFiles();
		
		for (File file : f) 
		{
			if (file != null & file.getName().toLowerCase().endsWith(".jpg"))
			{
				imageList.add(file.getCanonicalPath());
			}
		
		}
		
		if(imageList.size() > 0)
			return imageList;
		else {
			return null;
		}
		
		
		
	}
	
	public static ArrayList<BufferedImage> getimages ()
	{
		
		
		if(!ruta.isDirectory())
			System.out.println("Not a directory");
		if(!ruta.exists())
			System.out.println("File doesn't exist");
		
				
		File[] f = ruta.listFiles();
		ArrayList<BufferedImage> bufimages = new ArrayList<BufferedImage>();
		
		for (File file : f)
		{
			BufferedImage temp = null;
			
			try {
				temp = ImageIO.read(file);
				
				System.out.println("image: " + file.getName());
				System.out.println("width: " + temp.getWidth());
				System.out.println("height: " + temp.getHeight());
				System.out.println("size: " + file.length());
				
				bufimages.add(temp);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}
		
		return bufimages;
		
	}

}
