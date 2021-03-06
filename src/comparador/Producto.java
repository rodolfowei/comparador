package comparador;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.features2d.DescriptorExtractor;
import org.opencv.features2d.FeatureDetector;
import org.opencv.highgui.Highgui;

public class Producto implements Comparable<Producto> {

	BufferedImage prodimage;
	String path;
	String productname;
	Mat product_descriptors;
	FeatureDetector detector;
	DescriptorExtractor extractor;
	
	//Variable to count the number of matches.
	private int similaridad;

	static int detecting_method = FeatureDetector.ORB;
	static int extracting_method = DescriptorExtractor.ORB;
	
		
	public Producto() {
		this.detector = FeatureDetector.create(detecting_method);
		this.extractor = DescriptorExtractor.create(extracting_method);
	}
	
	
	
	public void SetPath(String path_prod){
		path = path_prod;
	}
	
	public void setDescriptors(String path_prod){
		
		Mat img = Highgui.imread(path_prod);
		Mat descriptors = new Mat();
		MatOfKeyPoint keypoints = new MatOfKeyPoint();
		detector.detect(img, keypoints);
		extractor.compute(img, keypoints, descriptors);
		product_descriptors = descriptors;
		
	}
	
	public Mat getDescriptors()
	{
		return product_descriptors;
	}
	
	public void setBufimage(String path_prod){
		File bufim = new File(path_prod);
		try {
			prodimage = ImageIO.read(bufim);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public BufferedImage obtainBuffimage(){
		return prodimage;
		
	}
	
	public String getPath(){
		return path;
		
	}
	
	public void setName(String path_prod){
		File f = new File(path);
		productname = f.getName();
	}
	
	public String getName(){
		return productname;
	}



	int getSimilaridad() {
		return similaridad;
	}



	void setSimilaridad(int similaridad) {
		this.similaridad = similaridad;
	}



	@Override
	public int compareTo(Producto prod) {
		if(similaridad < prod.similaridad){
			return -1;
		}
		if(similaridad > prod.similaridad){
			return 1;
		}
		return 0;
	}
	
	
	
}
