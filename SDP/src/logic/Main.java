package logic;

import io.MapRead;

import java.io.File;
import java.io.IOException;

import dijsktra.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		MapRead reader = new MapRead();
		Map theMap = reader.mapRead( new File(args[0]));
		System.out.println("Najkrotsze �cie�ki:");
		System.out.println(theMap.getShortestPath(2, 1));
	}
}
