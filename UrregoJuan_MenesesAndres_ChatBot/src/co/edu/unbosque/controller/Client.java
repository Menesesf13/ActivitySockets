package co.edu.unbosque.controller;

import java.io.IOException;
import java.net.Socket;

import co.edu.unbosque.view.Input;
import co.edu.unbosque.view.Ouput;

public class Client {
	
	private final int PORT=8000;
	private final String HOST="127.0.0.1";
	
	private Socket cs;
	private Input inServer,inClient;
	private Ouput out;
	
	public Client() {
		try {
			cs = new Socket(HOST, PORT);
		}catch (IOException e) {
			e.printStackTrace();
			
		}
		
	}
	
	public void initClient() {
		try {
			inServer = new Input(cs.getInputStream());
			out = new Ouput(cs.getOutputStream());
			inClient = new Input(System.in);
			String message, reponse;
			do {
				out.printWithoutJump("Mensaje a enviar al servidor: ");
				message = inClient.readString();
				out.sendPrint(message);
				reponse = inServer.readString();
				out.printWithoutJump("Respuesta del servidor: "+ reponse);
				
			}while(!message.equalsIgnoreCase("Salir"));
			inServer.getIn().close();
			out.getWriter().close();
			inClient.getIn().close();
			cs.close();
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}
