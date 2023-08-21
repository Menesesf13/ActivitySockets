package co.edu.unbosque.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import co.edu.unbosque.model.ChatBot;
import co.edu.unbosque.view.Input;
import co.edu.unbosque.view.Ouput;

public class Server {
	
	private final int PORT= 8000; 
	
	private ServerSocket ss;
	private Socket cs;
	private Input in;
	private Ouput out;
	private ChatBot bot;
	
	public Server() {
		try {
			bot = new ChatBot();
			ss = new ServerSocket(PORT);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initServer() {
		try {
			Ouput.showInformation("Servidor en linea. Esperando conexion...");
			cs = ss.accept();
			in = new Input(cs.getInputStream());
			out = new Ouput(cs.getOutputStream());
			String message, response;
			while((message = in.readString())!=null) {
				response = bot.generateResponse(message);
				out.printWithJump("Mensaje del cliente: "+ message);
				out.printWithJump("Respuesta del bot: " +response);
				out.sendPrint(response);
				if(message.equalsIgnoreCase("Salir")) {
					break;
				}
			}
			in.getIn().close();
			out.getWriter().close();
			cs.close();
			ss.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
