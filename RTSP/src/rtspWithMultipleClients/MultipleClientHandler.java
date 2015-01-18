package rtspWithMultipleClients;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;

import MakeVideo.CreateImages;

public class MultipleClientHandler implements Runnable {
	Socket client;
	int count = 0;

	public MultipleClientHandler(Socket client) {
		this.client = client;
	}

	public void run() {
		ObjectOutputStream clientStream = null;
		try {
			clientStream = new ObjectOutputStream(this.client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// change true to a condition variable
		try {
			while (true) {
				ImageIcon icon = CreateImages.getScreenShot();
				clientStream.writeObject(icon);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				clientStream.close();
				this.client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}