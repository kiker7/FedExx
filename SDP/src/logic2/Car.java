package logic2;

public class Car {

	private int[] visitedCities;
	private int numberOfPackInside;
	private boolean isFull;
	private int numberOfAvailablePacksInside;

	public Car(int x){
		numberOfPackInside = 0;
		numberOfAvailablePacksInside = x;
	}
	
	public boolean isFull(){
		return isFull;
	}
	
	public int getNumberOfAvailablePacksInside(){
		return numberOfAvailablePacksInside;
	}
	
	public void addNumberOfPackInside(){
		numberOfPackInside++;
	}
	
	public void setVisitedCitiesArray(int [] arr){
		visitedCities = arr;
	}
}
