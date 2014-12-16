package logic;

import java.io.IOException;


public class Main {

	private static Parser p;
	private static Logic l;
	
	public static void main(String[] args) throws IOException{
		
		p = new Parser();
		p.parser(args);
		l = new Logic(p);
		l.supply();
		
	}
}
