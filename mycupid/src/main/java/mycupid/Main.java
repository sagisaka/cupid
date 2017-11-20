package mycupid;

import java.io.IOException;

import javax.script.ScriptException;

import mycupid.delivery.Deliverd;

public class Main {
	public void run(String[] args) throws IOException, ScriptException{
		Deliverd del = new Deliverd();
		del.deliverd(args);
	}
	
	public static void main(String[] args) throws IOException, ScriptException{
		Main main = new Main();
		main.run(args);
	}
}
