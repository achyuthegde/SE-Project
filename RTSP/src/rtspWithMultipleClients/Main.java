package rtspWithMultipleClients;

public class Main
{
	public static void main(String[] args) throws InterruptedException
	{
		ServerConnectionAcceptor startServer=new ServerConnectionAcceptor();
		startServer.acceptConnections();
		Thread.sleep(6000);
		Client startClient = new Client();
		Thread.sleep(30000);
		startClient.play();
	}
}
