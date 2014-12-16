package logic2;

public class MessageControl {

	private int cityNumberInPath;
	private int orderNumberInPath;
	private int orderTime;
	
	public MessageControl(int c, int o, int t){
		cityNumberInPath = c;
		orderNumberInPath = o;
		orderTime = t;
	}
	
	public int getCityNumberInPath(){
		return cityNumberInPath;
	}
	
	public int getOrderNumberInPath(){
		return orderNumberInPath;
	}
	
	public int getOrderTime(){
		return orderTime;
	}
	
}
