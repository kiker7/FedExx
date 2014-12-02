package logic;

import java.io.File;
import java.io.IOException;

import dijkstra.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		File filename = new File(args[0]);
		MapRead reader = new MapRead();
		Map theMap = reader.mapRead(filename);
		System.out.println("Najkrotsze œcie¿ki:");
		theMap.path(0);
		System.out.println("");
	}
}
