package logic2;

import java.util.ArrayList;


public class Comunicate {

	private String log;
	private int distance;
	private ArrayList<String> orderListLog;
	private String orderView;

	private String destinationCity; // do kolorowania wierzcho³ka
	private int to; // do dijkstry miasto docelowe
	private String[] cityNames = null;
	private ArrayList<String> edgeStringList;
	private ArrayList<String> edgeToChangeList;

	//w konstruktorze dodac liste odwiedzonych krawedzi
	public Comunicate(String l, int d, ArrayList<String>  oL, String dc, int toCity, String [] cn,ArrayList<String> edgeList){
		log = l;
		distance = d;
		orderListLog = oL;
		orderView = "";
		destinationCity = dc;
		to = toCity;
		cityNames = cn;
		edgeStringList = edgeList;
		edgeToChangeList = new ArrayList<String>();
	}
	
	public ArrayList<String> getEdgesToChange(){
		int sum = 0;
		for(String x : edgeStringList){
			sum += Integer.parseInt(x);
			edgeToChangeList.add(x);
			if(sum == distance)
				return edgeToChangeList;
		}
		return null;
			
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
