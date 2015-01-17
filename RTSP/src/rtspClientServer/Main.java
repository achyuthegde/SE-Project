package rtspClientServer;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.*;

import rtsp.Receive;
public class Main 
{
	public static void main(String args[]) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException
	{
		Thread t=new RTSPServer();
		t.start();
		RTSPClient c=new RTSPClient();
		c.showImage();
	}
}