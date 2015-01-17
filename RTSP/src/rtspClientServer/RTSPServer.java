package rtspClientServer;

import MakeVideo.*;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.*;

import javax.swing.ImageIcon;

import MakeVideo.CreateImages;
import rtsp.Receive;
public class RTSPServer extends Thread 
{
	static ArrayList<ImageIcon> imageList;
	int port=8006;
	ServerSocket server;
	Socket socket;
	public void run()
	{
		while(true)
		{
		try{
			server=new ServerSocket(port);
			socket=server.accept();
			System.out.println("Connection established.");
			try{
				sendImage();
			}
			catch(InterruptedException e)
			{}
		}
		
			catch(Exception e)
			{}
		
		}
	}
	
	
	public void sendImage() throws InterruptedException,IOException 
	{		
		CreateImages img=new CreateImages();        
        imageList=img.captureMultiple(0,200);
        ObjectOutputStream obStream = new ObjectOutputStream(socket.getOutputStream());
		
        for(int i=1;i<imageList.size();i++)
        {
            Thread.sleep(140);
    		System.out.println("Sending image.");
            obStream.writeObject(imageList.get(i));
        }
       
		
	}
}	