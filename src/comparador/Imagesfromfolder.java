package comparador;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.Highgui;




/*This class implements a method to build an array of images
 * from a folder containing jpg images
 */

public class Imagesfromfolder {
	
	static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
	
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
				
				System.out.println("Image:  " + file.getName());
				System.out.println("Width:  " + temp.getWidth());
				System.out.println("Height: " + temp.getHeight());
				System.out.println("Size:  " + file.length());
				
				bufimages.add(temp);
				
			} catch (Exception e) {
				System.out.println("Error loading the image");
			}
			
			
		}
		
		return bufimages;
		
	}
	
	public static ArrayList<Mat> getimagesMat()
	{
		if(!ruta.isDirectory())
			System.out.println("Not a directory");
		if(!ruta.exists())
			System.out.println("File doesn't exist");
		
		File[] f = ruta.listFiles();
		ArrayList<Mat> Matimages = new ArrayList<Mat>();
		
		for (File file : f)
		{
			Mat temp = null;
			
			try{
				String path = file.toString();
				temp = Highgui.imread(path, Highgui.CV_LOAD_IMAGE_GRAYSCALE);
				Matimages.add(temp);
				
			}catch (Exception e){
				System.out.println("Error loading the image");
			}
		}
		
		return Matimages;
		
		
	}
	

}
