package logic2;

import java.io.IOException;

import logic2.Logic;
import logic2.Parser;

public class Test {

	
	public static void main(String[] args) throws IOException{
		
		Parser p = new Parser();
		p.parser(args);
		Logic l = new Logic(p);
		l.allocation();
		
	}
}