/**
 * Inverse colors for all selected images.
 * 
 * @author Xiaozhe Li 
 */

import edu.duke.*;
import java.io.*;

public class BatchInversions {
	//I started with the image I wanted (inImage)
	public static ImageResource makeInversion(ImageResource inImage) {
		//I made a blank image of the same size
		ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
		//for each pixel in outImage
		for (Pixel pixel: outImage.pixels()) {
			//look at the corresponding pixel in inImage
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			//inverse red
			pixel.setRed(255 - inPixel.getRed());
			//inverse green
			pixel.setGreen(255 - inPixel.getGreen());
			//inverse blue
			pixel.setBlue(255 - inPixel.getBlue());
		}
		//outImage is your answer
		return outImage;
	}
	
	public static void selectAndConvert(){
		DirectoryResource dr= new DirectoryResource();
		for(File f: dr.selectedFiles()){
			ImageResource inImage = new ImageResource(f);
			ImageResource inver = makeInversion(inImage);
			String newName = "inverted-"+ inImage.getFileName();
			inver.setFileName("./images/" + newName);
			inver.draw();
			inver.save();		
		}
	}

	public void testInversion(){
	   ImageResource ir = new ImageResource();
	   ImageResource inver = makeInversion(ir);
	   inver.draw();
	   }
}
