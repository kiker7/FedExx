package logic2;

import java.util.ArrayList;

public class Message {

	private ArrayList<Trip> tripList;
	private ArrayList<Comunicate> comunicateList; // ZAWIERA WSZYSKIE KOMUNIKATY GOTOWE DO WYSWIETLENIA W ODPOWIEDNIEJ KOLEJNOSCI
	
	
	public Message(){ 
		tripList = new ArrayList<Trip>();
		comunicateList = new ArrayList<Comunicate>();
	}
	
	public ArrayList<Comunicate> getFinalComunicateList(){
		return comunicateList;
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
			comunicateList.addAll(n.getCommunicateList());
		}
	}
	
	public void displayLogTrips(){
		for(Trip n: tripList){
			n.createLogList();
			//System.out.println(n.getLogList());
			//System.out.println(n.getComunicateList());
			comunicateList.addAll(n.getCommunicateList());
		}
		System.out.println(comunicateList);
	}
	
}
