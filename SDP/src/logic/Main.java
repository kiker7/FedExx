package logic;

import dijkstra.*;

public class Main {

	public static void main(String[] args){
	
		Map theMap = new Map();
		
		theMap.addCity("Warszawa");
		theMap.addCity("Radom");
		theMap.addCity("Tarnobrzeg");
		theMap.addCity("Krakow");
		theMap.addCity("Lublin");
		
		theMap.addEdge(0, 1, 50);
		theMap.addEdge(0, 3, 80);
		theMap.addEdge(1, 2, 60);
		theMap.addEdge(1, 3, 90);
		theMap.addEdge(2, 4, 40);
		theMap.addEdge(3, 2, 20);
		theMap.addEdge(3, 4, 70);
		theMap.addEdge(4, 1, 50);
		
		System.out.println("Najkrotsze �cie�ki:");
		theMap.path();
		System.out.println("");
	}
}
