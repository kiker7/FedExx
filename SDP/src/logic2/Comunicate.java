package logic2;

import java.util.ArrayList;

import dijsktra.Map;

public class Comunicate {

	private String log;
	private int distance;
	private ArrayList<String> orderListLog;
	private String orderView;

	private String destinationCity; // do kolorowania wierzchołka
	private int to; // do dijkstry miasto docelowe
	private String[] cityNames = null;

	//w konstruktorze dodac liste odwiedzonych krawedzi
	public Comunicate(String l, int d, ArrayList<String>  oL, String dc, int toCity, String [] cn){
		log = l;
		distance = d;
		orderListLog = oL;
		orderView = "";
		destinationCity = dc;
		to = toCity;
		cityNames = cn;
	}
	
	public int getCityIndexByName(String name){
		for(int i = 0 ; i < cityNames.length - 1; i++)
			if(cityNames[i].equalsIgnoreCase(name))
				return i;
		return 0;
	}
	
	public String getDestinationCity(){
		return destinationCity;
	}
	
	public int getToCity(){
		return to;
	}
	
	public String getOrderView(){
		for(String x : orderListLog)
			orderView += (x + "\n");
		return orderView;
	}
	
	@Override
	public String toString() {
		return "Komunikat: (log): "+ log + " DISTANCE: " + distance + " ORDERSVIEW: " +orderListLog;
	}


	
	public String getLog(){
		return log;
	}
	
	public int getDistance(){
		return distance;
	}
	
	public ArrayList<String> getOrderList(){
		return orderListLog;
	}
	
}
