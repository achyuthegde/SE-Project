/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rtsp;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author arvind
 */
public class Receive {
	Socket server;
	ObjectInputStream inStream;

	public Receive() {
		try {
			this.server = new Socket("localhost", 5556);
			inStream = new ObjectInputStream(server.getInputStream());
		} catch (UnknownHostException ex) {
			Logger.getLogger(Receive.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (IOException ex) {
			Logger.getLogger(Receive.class.getName()).log(Level.SEVERE, null,
					ex);
		}

		
	}

	public void getImage() {

		try {
			ImageIcon img = (ImageIcon) (inStream.readObject());

			/*
			 * Image img = image.getImage();
			 * 
			 * BufferedImage bi = new BufferedImage(img.getWidth(null),
			 * img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			 * 
			 * Graphics2D g2 = bi.createGraphics(); g2.drawImage(img, 0, 0,
			 * null); g2.dispose(); ImageIO.write(bi, "jpg", new
			 * File("../../image1.jpg"));
			 */
			
			  JFrame frame = new JFrame();
			  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			  Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
			  frame.setSize(dm); 
			  JLabel image = new JLabel(img);
			  frame.add(image);
			  frame.setVisible(true);
			 

		} catch (IOException ex) {
			Logger.getLogger(Receive.class.getName()).log(Level.SEVERE, null,
					ex);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(Receive.class.getName()).log(Level.SEVERE, null,
					ex);
		}
	}

}
