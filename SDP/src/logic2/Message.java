package logic2;

import java.util.ArrayList;

public class Message {

	private ArrayList<Trip> tripList;
	
	
	public Message(){ 
		tripList = new ArrayList<Trip>();
	}
	
	public void setNewTrip(Trip e){
		tripList.add(e);
	}
	
	public void displayLogTrips(){
		for(Trip n: tripList){
			n.createLogList();
			System.out.println(n.getLogList());
		}
		
	}
	
}
