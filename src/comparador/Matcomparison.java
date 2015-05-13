package comparador;


import java.util.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.opencv.core.Mat;
import org.opencv.core.MatOfDMatch;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.features2d.DMatch;
import org.opencv.features2d.DescriptorExtractor;
import org.opencv.features2d.DescriptorMatcher;
import org.opencv.features2d.FeatureDetector;
import org.opencv.highgui.Highgui;

public class Matcomparison {

	static final File ruta = new File ("C:/Users/CARLOS/Desktop/imagenes");
	
	// This class will allow to implement a method that can compare an input images with
	//a folder full of images and determine which image is the most similar one
	 
	FeatureDetector detector;
	int detection_method = FeatureDetector.ORB;
	
    //Here we will test the different feature extraction methods in terms of time consumption and
	//Accuracy 
	
	DescriptorExtractor extractor;
	int extraction_method = DescriptorExtractor.ORB;
		
	//Here we have also the possibility of implementing different matching methods
	
	DescriptorMatcher matcher;
	int matching_method = DescriptorMatcher.BRUTEFORCE_HAMMING;
	
	
	public Matcomparison()
	{
		this.detector = FeatureDetector.create(detection_method);
		this.extractor = DescriptorExtractor.create(extraction_method);
		this.matcher = DescriptorMatcher.create(matching_method);
	}
	
	//The argument is the path to the image we set as the input (the image data Base is already known (ruta)
	
	//Think about returning a product instead of a mat then with the producto.path we can recover
	//the product and display it to see if the match is ok.
	public Producto obtainbestmatch(String imagepath)
	{
		System.out.println("Analizando in_image");
		
		int similaridad = -1;
		Producto topmatcher = new Producto();
		Mat in_image = Highgui.imread(imagepath);
		MatOfKeyPoint in_keypoints = new MatOfKeyPoint();
		Mat in_descriptors = new Mat();
		detector.detect(in_image, in_keypoints);
		extractor.compute(in_image, in_keypoints, in_descriptors);
		
		//Just to obtain the name of the file currently being used
		File toname = new File(imagepath);
		
		System.out.println("in_image Analizada:   "+ toname.getName() + "\n");
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		//
		ArrayList<String> imagepaths;
		try {
			imagepaths = Imagesfromfolder.getAllImages();
			
			for(int i=0; i< imagepaths.size();i++){
				Producto temp = new Producto();
				temp.path = imagepaths.get(i);
				temp.setDescriptors(temp.path);
				temp.setName(temp.path);
				productos.add(temp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(Producto prod : productos){
			System.out.print("Analizando imagen" + prod.productname);
			MatOfDMatch matches = new MatOfDMatch();
			matcher.match(in_descriptors, prod.getDescriptors(),matches);
			
						
			List<DMatch> listofmatches = matches.toList();
			int numberofcoincidences = 0;
			for(DMatch dm: listofmatches){
				if(dm.distance < 40){
					numberofcoincidences++;
				}
			}
			System.out.print("\t Number of matches: " + numberofcoincidences + "\n");
			
			if(numberofcoincidences > similaridad){
				similaridad = numberofcoincidences;
				topmatcher = prod;
				System.out.println("new top matcher: " + topmatcher.path);
			}
			
		}
		
		//If there is no match with any product in the data base
		if(similaridad == 0){
			System.out.println(" NO MATCHES HAVE BEEN FOUND");
		}else{
			System.out.println(" The product is : " + topmatcher.getName());
		}
		
		
		return topmatcher;
		
	}
	
	
	
	
}
