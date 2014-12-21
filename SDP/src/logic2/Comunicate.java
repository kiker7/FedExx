package logic2;

import java.util.ArrayList;

public class Comunicate {

	private String log;
	private int distance;
	private ArrayList<String> orderListLog;
	private String orderView;

	public Comunicate(String l, int d, ArrayList<String>  oL){
		log = l;
		distance = d;
		orderListLog = oL;
		orderView = "";
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
