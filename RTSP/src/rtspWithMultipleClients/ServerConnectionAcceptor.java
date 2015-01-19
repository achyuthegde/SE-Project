package rtspWithMultipleClients;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerConnectionAcceptor {
	ServerSocket server;

	public ServerConnectionAcceptor()  {
		try {
			this.server = new ServerSocket(1234);
			System.out.println("server started");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void acceptConnections() {
		ServerThread startAccepting = new ServerThread(this.server);
		startAccepting.start();
//		ObjectOutputStream obStream = new ObjectOutputStream(
//				clientSocket.getOutputStream());
//		obStream.writeObject(new ImageIcon(image));
	}
}
