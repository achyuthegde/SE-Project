package CaptureImages;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class CaptureImages
{
	Robot robo;
	public static ArrayList<ImageIcon> imagesList;
	private Dimension dim;
	private Rectangle scrnRect;

	public CaptureImages()
	{
		try
		{
			robo = new Robot();
		}
		catch (AWTException e)
		{
			e.printStackTrace();
		}
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		scrnRect = new Rectangle(dim);
	}

	private BufferedImage capture()
	{
		BufferedImage image = null;
		image = robo.createScreenCapture(scrnRect);
		return image;
	}

	public ImageIcon captureWithInterval(int interval)
	{
		ImageIcon image = new ImageIcon(this.capture());
		System.out.println("Capturing image.");
		try
		{
			Thread.sleep(interval);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		return image;
	}

}
