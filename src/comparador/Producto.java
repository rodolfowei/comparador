package comparador;

import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.features2d.DescriptorExtractor;
import org.opencv.features2d.FeatureDetector;
import org.opencv.highgui.Highgui;

public class Producto {

	String path;
	Mat roduct_descriptors;
	FeatureDetector detector;
	DescriptorExtractor extractor;
	static int detecting_method = FeatureDetector.ORB;
	static int extracting_method = DescriptorExtractor.ORB;
	
	public Producto() {
		this.detector = FeatureDetector.create(detecting_method);
		this.extractor = DescriptorExtractor.create(extracting_method);
	}
	
	
	
	public void SetPath(String path_prod){
		path = path_prod;
	}
	
	public Mat getDescriptors(String path_prod){
		
		Mat img = Highgui.imread(path_prod);
		Mat descriptors = new Mat();
		MatOfKeyPoint keypoints = new MatOfKeyPoint();
		detector.detect(img, keypoints);
		extractor.compute(img, keypoints, descriptors);
		return descriptors;
		
	}
	
	public String getPath(){
		return path;
		
	}
}
