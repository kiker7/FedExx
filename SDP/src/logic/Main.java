package logic;

import io.MapRead;

import java.io.File;
import java.io.IOException;

import dijkstra.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		//File filename = new File(args[0]);
		MapRead reader = new MapRead();
		Map theMap = reader.mapRead( new File(args[0]));
		System.out.println("Najkrotsze �cie�ki:");
		theMap.path(2);
		System.out.println(" okok");
	}
}
