/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MakeVideo;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author arvind
 */
public class CreateImages 
{
    Robot robo;
    
    private BufferedImage capture(int name)
    {
        BufferedImage image = null;
        try
        {
            robo = new Robot();
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle scrnRect = new Rectangle(dim);
            image = robo.createScreenCapture(scrnRect);
            
            //File img = new File("images/"+name+".jpg");
            //ImageIO.write(image, "jpg", img);
        }
        catch(AWTException e)
        {
            e.printStackTrace();
        } 
        /*catch (IOException ex) 
        {
            Logger.getLogger(CreateVideo.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        return image;
    }
    protected ArrayList<BufferedImage> captureMultiple(int start,int number) throws InterruptedException
    {
        ArrayList<BufferedImage> imagesList = new ArrayList<>();
        for(int i=start;i<number;i++)
        {
            BufferedImage image = this.capture(i);
            imagesList.add(image);
            Thread.sleep(180);
        }
        return imagesList;
    }
    
}