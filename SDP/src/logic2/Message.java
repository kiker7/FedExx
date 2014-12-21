package logic2;

import java.util.ArrayList;

public class Message {

	private ArrayList<Trip> tripList;
	
	
	public Message(){ 
		tripList = new ArrayList<Trip>();
	}
	
	public ArrayList<Trip> getTripList(){
		return tripList;
	}
	
	public void setNewTrip(Trip e){
		tripList.add(e);
	}
	
	public void createLogListForTrips(){
		for(Trip n: tripList){
			n.createLogList();
		}
	}
	
	public void displayLogTrips(){
		for(Trip n: tripList){
			n.createLogList();
			//System.out.println(n.getLogList());
			System.out.println(n.getComunicateList());			
		}
		
	}
	
}
