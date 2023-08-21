package co.edu.unbosque.controller;

import java.io.IOException;
import java.net.Socket;

import co.edu.unbosque.view.Input;
import co.edu.unbosque.view.Output;
import co.edu.unbosque.view.Output;

public class Client {
	
	private final int PORT=8000;
	private final String HOST="127.0.0.1";
	
	private Socket cs;
	private Input inServer,inClient;
	private Output out;
	
	public Client() {
		try {
			cs = new Socket(HOST, PORT);
		}catch (IOException e) {
			System.err.println("Error");
			
		}
		
	}
	
	public void initClient() {
		try {
			inServer = new Input(cs.getInputStream());
			out = new Output(cs.getOutputStream());
			inClient = new Input(System.in);
			String message, response;
			Output.showInformation("***BOTINFO***\nBienvenido a BotInfo un programa que responde preguntas y resuelve operaciones simples:\n"
		               +"Para que el programa calcule solo escriba la operación ejemplo: 2+2/(2*5) de otra manera no lo respondera.\n"
		               +"Para terminar el programa ingrese salir.\n");
			do {
				out.printWithoutJump("Mensaje a enviar al servidor: ");
				message = inClient.readString();
				out.sendPrint(message);
				response = inServer.readString();
				out.printWithoutJump("Respuesta del servidor: "+ response);
				
			}while(!response.equalsIgnoreCase("Gracias por utilizar el programa :D"));
			inServer.getIn().close();
			out.getWriter().close();
			inClient.getIn().close();
			cs.close();
		
		}catch(IOException e) {
			System.err.println("Error");
		}
	}
	
}
