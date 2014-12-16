package logic2;

import java.util.ArrayList;

public class Message {

	private ArrayList<Trip> tripList;
	
	public void setNewTrip(Trip e){
		tripList.add(e);
	}
	
	public void setNewMessageInTrip(String message){
		tripList.get(tripList.size() - 1).addNewMessage(message);
	}
	
	
}
