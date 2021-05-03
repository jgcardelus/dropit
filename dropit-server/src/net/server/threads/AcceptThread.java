package net.server.threads;

import java.io.IOException;
import java.net.Socket;

import debug.DebugTools;
import net.client.Client;
import net.server.Server;

public class AcceptThread extends Thread {
	private Server server;

	public AcceptThread(Server server) {
		this.server = server;
	}

	@Override
	public void run() {
		this.accept();
	}
	
	private void accept() {
		try {
			Socket socket = this.server.getSocket().accept();
			// Handle new socket
			Client newClient = new Client(this.server, socket);
			this.server.addClient(newClient);
			// Start the client
			newClient.start();
			DebugTools.print("New client accepted");

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		// Accept new client
		this.accept();
	}
}

