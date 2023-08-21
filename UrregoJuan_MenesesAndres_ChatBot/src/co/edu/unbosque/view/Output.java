package co.edu.unbosque.view;

import java.io.OutputStream;
import java.io.PrintWriter;

public class Output {
	
private PrintWriter writer;
	
	public Output(OutputStream writer) {
		this.writer=new PrintWriter(writer,true);
	}
	
	public void printWithJump(String message) {
		System.out.println(message);
	}
	
	public void printWithoutJump(String message) {
		System.out.print(message);
	}
	
	public static void showInformation(String message) {
		System.out.println(message);
	}
	
	public void sendPrint(String message) {
		writer.println(message);
	}

	public PrintWriter getWriter() {
		return writer;
	}

	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}

}
