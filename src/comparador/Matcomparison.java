package comparador;

import java.io.File;

import org.opencv.core.Mat;
import org.opencv.core.MatOfDMatch;
import org.opencv.core.MatOfKeyPoint;
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
	
	//The argument is the path to the image we set as the input
	public Mat obtainbestmatch(String imagepath)
	{
		System.out.println("Analizando in_image");
		
		Mat topmatcher = null;
		Mat in_image = Highgui.imread(imagepath);
		MatOfKeyPoint in_keypoints = new MatOfKeyPoint();
		Mat in_descriptors = new Mat();
		detector.detect(in_image, in_keypoints);
		extractor.compute(in_image, in_keypoints, in_descriptors);
		
		System.out.println("in_image Analizada");
		
		MatOfDMatch matches = new MatOfDMatch();
		
		
		
		
		
		
		
		return null;
		
	}
	
	
	
	
}
