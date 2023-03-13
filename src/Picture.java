package src;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments 
	 */
	public Picture ()
	{
		/* not needed but use it to show students the implicit call to super()
		 * child constructors always call a parent constructor 
		 */
		super();  
	}

	/**
	 * Constructor that takes a file name and creates the picture 
	 * @param fileName the name of the file to create the picture from
	 */
	public Picture(String fileName)
	{
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * @param height the height of the desired picture
	 * @param width the width of the desired picture
	 */
	public Picture(int height, int width)
	{
		// let the parent class handle this width and height
		super(width,height);
	}

	/**
	 * Constructor that takes a picture and creates a 
	 * copy of that picture
	 * @param copyPicture the picture to copy
	 */
	public Picture(Picture copyPicture)
	{
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * @param image the buffered image to use
	 */
	public Picture(BufferedImage image)
	{
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * @return a string with information about the picture such as fileName,
	 * height and width.
	 */
	public String toString()
	{
		String output = "Picture, filename " + getFileName() + 
				" height " + getHeight() 
				+ " width " + getWidth();
		return output;

	}

	/** Turns a Picture into its negative
	flip all the colors:  if color had red = 30, green = 100, blue = 200
	negated color red = 225, green= 155, blue = 55  */
	public void negate() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel pixel;
		for (Pixel[] value : pixels) {
			for (int col = 0; col < pixels[0].length; col++) {
				pixel = value[col];
				pixel.setRed(255 - pixel.getRed());
				pixel.setGreen(255 - pixel.getGreen());
				pixel.setBlue(255 - pixel.getBlue());
			}
		}
		
		
	}
	
	/** converts a color image into grayscale.  There are many algorithms 
	   for this.  The most common is to find the mean of the red, green 
	   and blue components and set each component to that average
	*/
	public void grayScale() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] pixel : pixels) {
			for (int j = 0; j < pixel.length; j++) {
				int avg = (pixel[j].getBlue() + pixel[j].getRed() + pixel[j].getGreen()) / 3;
				pixel[j].setBlue(avg);
				pixel[j].setGreen(avg);
				pixel[j].setRed(avg);
			}

		}


	}

  /** pixelates an image
  */

  public void pixelate() {
    
  }

  public void keepOnlyBlue()   
	{     
		// Picture beach = new Picture("beach.jpg");
    // beach.explore();// shows the picture in a window
		 Pixel[][] pixels = this.getPixels2D();

		// Pixel[][] pixels = this.getPixels2D();     
		Pixel pixel = null;     
		for (int row = 0; row < pixels.length; row++)     
		{       for (int col = 0; col < pixels[0].length; col++)       
			{        
								pixel = pixels[row][col];         
		 						pixel.setRed(0);         
		 						pixel.setGreen(0);       
			}     
		}  
    
	}
  public void keepOnlyGreen()   
	{     
		// Picture beach = new Picture("beach.jpg");
    // beach.explore();// shows the picture in a window
		 Pixel[][] pixels = this.getPixels2D();

		// Pixel[][] pixels = this.getPixels2D();     
		Pixel pixel = null;     
		for (int row = 0; row < pixels.length; row++)     
		{       for (int col = 0; col < pixels[0].length; col++)       
			{        
								pixel = pixels[row][col];         
		 						pixel.setRed(0);         
		 						pixel.setBlue(0);       
			}     
		}  
    
		}
  public void keepOnlyRed()   
	{     
		// Picture beach = new Picture("beach.jpg");
    // beach.explore();// shows the picture in a window
		 Pixel[][] pixels = this.getPixels2D();

		// Pixel[][] pixels = this.getPixels2D();     
		Pixel pixel = null;     
		for (int row = 0; row < pixels.length; row++)     
		{       for (int col = 0; col < pixels[0].length; col++)       
			{        
								pixel = pixels[row][col];         
		 						pixel.setBlue(0);         
		 						pixel.setGreen(0);       
			}   
    }
  }
	
	
	/** Method that mirrors the picture around horizontal line that passes
	 * through the center of the picture from left to right */
	public void mirrorVertical()
	{
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;

	}




	/** copy from the passed fromPic to the
	 * specified startRow and startCol in the
	 * current picture
	 * @param fromPic the picture to copy from
	 * @param startRow the start row to copy to
	 * @param startCol the start col to copy to
	 */
	public void copy(Picture fromPic, 
			int startRow, int startCol)
	{
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; 
				fromRow < fromPixels.length && toRow < toPixels.length; 
				fromRow++, toRow++)
		{
			for (int fromCol = 0, toCol = startCol; 
					fromCol < fromPixels[0].length &&
					toCol < toPixels[0].length;  
					fromCol++, toCol++)
			{
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}   
	}

	/** Method to create a collage of several pictures */
	public void createCollage()
	{
		Picture flower1 = new Picture("flower1.jpg");
		Picture flower2 = new Picture("flower2.jpg");
		this.copy(flower1,0,0);
		this.copy(flower2,100,0);
		this.copy(flower1,200,0);
		Picture flowerNoBlue = new Picture(flower2);

		this.copy(flowerNoBlue,300,0);
		this.copy(flower1,400,0);
		this.copy(flower2,500,0);
		this.mirrorVertical();
		this.write("collage.jpg");
	}


	/** Method to show large changes in color 
	 * This method traverses this picture and changes to pixels to 
	 * black and white, depending on the color to each pixel's right.
	 * If the color change is large, then the pixel on the left is set to 
	 * black, otherwise, if the color is close, then the pixel is set to 
	 * white. The result is an image with black pixels where it detected 
	 * a significant change in color.
	 * 
	 * @param edgeDist the distance for finding edges
	 */
	public void edgeDetection(int edgeDist)
	{

		// used as a reference for comparing with leftPixel

		Pixel[][] pixels = this.getPixels2D();// gets the 2D array of Pixel
		// Big hint, the Pixel class has a method called colorDistance(Color) which
		// returns the distance the input Color is from this Pixel's Color

		Pixel leftPixel;// this pixel will always be the one to
		Pixel rightPixel;// this Pixel doesn't change value, it is just
		// the left of rightPixel.  If this Pixel
		// is far enough away (based on edgeDist), then
		// leftPixel is set to Color black, else, white
		for (int p = 0; p < pixels.length-1; p++) {
			for (int i = 1; i < pixels[p].length-1; i++) {
				leftPixel = pixels[p][i];
				rightPixel = pixels[p][i+1];
				if ((leftPixel.getRed() - rightPixel.getRed() <= edgeDist ||
					 leftPixel.getRed() + rightPixel.getRed() <= edgeDist) &&
					(leftPixel.getGreen() - rightPixel.getGreen() <= edgeDist ||
					 leftPixel.getGreen() + rightPixel.getGreen() <= edgeDist) &&
					(leftPixel.getBlue() + rightPixel.getBlue() <= edgeDist ||
					 leftPixel.getBlue() - rightPixel.getBlue() <= edgeDist)){
					leftPixel.setRed(255);
					leftPixel.setGreen(255);
					leftPixel.setBlue(255);
				}else {
					leftPixel.setBlue(0);
					leftPixel.setRed(0);
					leftPixel.setGreen(0);
				}
			}


		}

	}


	/* Main method for testing - each class in Java can have a main 
	 * method 
	 */
	public static void main(String[] args) 
	{
		PictureTester.main(args);
	}

	
	

} // this } is the end of class Picture, put all new methods before this
