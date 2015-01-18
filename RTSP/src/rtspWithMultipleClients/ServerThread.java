package rtspWithMultipleClients;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {
	ServerSocket server;

	public ServerThread(ServerSocket server) {
		this.server = server;
	}

	public void run() {
		Socket client = null;
		try {
			client = this.server.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MultipleClientHandler runnable = new MultipleClientHandler(client);
		Thread serverHandle = new Thread(runnable);
		serverHandle.start();
		ServerThread restartAccepting = new ServerThread(this.server);
		restartAccepting.start();
	}
}