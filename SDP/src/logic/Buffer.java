package logic;

public class Buffer {

	private Order[] orderVisitedCity;
	private boolean available;

	public Buffer(Parser p) {
		orderVisitedCity = p.getOrdersList() ;
		available = false;
	}

	public synchronized boolean get(int id) {

		while (available == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		available = false;
		notifyAll();
		return orderVisitedCity[id].getTaken();
	}

	public synchronized void put(int id) {
		while (available == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		orderVisitedCity[id].setTaken();
		available = true;
		notifyAll();
	}
	
	public boolean isAnyOrder(){
		for(Order x: orderVisitedCity){
			if(x.getTaken() == false)
				return true;
		}
		return false;
	}
}
