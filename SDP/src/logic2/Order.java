package logic2;



public class Order implements Comparable<Order> {

	private int id;
	private int baseCity;
	private int orderCity;
	private String name;
	private int priority;
	private boolean isTaken;

	/**
	 * Instantiates a new order.
	 *
	 * @param iD the i d
	 * @param base the base
	 * @param ocity the ocity
	 * @param nm the nm
	 * @param pr the pr
	 */
	public Order(int iD, int base, int ocity, String nm, int pr) {
		id = iD;
		baseCity = base;
		orderCity = ocity;
		name = nm;
		priority = pr;
	}

	public boolean getTaken(){
		return isTaken;
	}
	
	public void setTaken(){
		isTaken = true;
	}
	
	@Override
	public String toString() {
		String result = id + " " + baseCity + " " + orderCity + " " + name
				+ " " + priority;
		return result;
	}

	@Override
	public int compareTo(Order o) {
		return priority - o.getPriority();
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int pr) {
		priority = pr;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBaseCity() {
		return baseCity;
	}

	public void setBaseCity(int baseCity) {
		this.baseCity = baseCity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOrderCity() {
		return orderCity;
	}

	public void setOrderCity(int orderCity) {
		this.orderCity = orderCity;
	}

}
