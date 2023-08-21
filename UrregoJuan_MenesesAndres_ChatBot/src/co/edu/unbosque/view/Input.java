package co.edu.unbosque.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Input {
	
	private BufferedReader in;
	
	public Input(InputStream in) {
		this.in = new BufferedReader(new InputStreamReader(in));	
		
	}
	
	public String readString() throws IOException {
		return in.readLine();
	}
	
	public BufferedReader getIn() {
		return in;
	}
	
	public void getIn(BufferedReader in) {
		this.in = in;
	}
	
}
