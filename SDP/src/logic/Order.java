package logic;

public class Order implements Comparable<Order> {

	private int id;
	private int baseCity;
	private int orderCity;
	private String name;
	private int priority;
	

	@Override
	public int compareTo(Order o) {	
		return priority - o.priority;
	}

	public int getPriority(){
		return priority;
	}
	
	public void setPriority(int pr){
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


