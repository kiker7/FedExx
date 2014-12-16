package logic2;


import java.util.ArrayList;

public class Trip {

	private ArrayList<MessageControl> messageList;
	private ArrayList<String> logList;
	private String[] cityNames = null;
	private int baseCity;
	
	public Trip(String [] n, int b){
		messageList = new ArrayList<MessageControl>();
		logList = new ArrayList<String>();
		cityNames = n;
		baseCity = b;
	}
	
	public String getCityNameByItsNumber(int number){
		for(int i = 0; i < cityNames.length ; i++)
			if(number == i)
				return cityNames[i];
		return null;
	}
	
	public void addMessageControl(MessageControl mes){
		messageList.add(mes);
	}
	
	public void createLogList(){
		ArrayList<Integer> idList = new ArrayList<Integer>();

	
		
		for(MessageControl x : messageList)
			idList.add(x.getOrderNumberInPath());
	
		
		for(MessageControl n : messageList){
			logList.add(n.getOrderTime()+ " dostarczono przesy�ke " + n.getOrderNumberInPath() + " do miasta " + this.getCityNameByItsNumber(n.getCityNumberInPath()));
		}
		
		logList.add("0 pobrano przesy�ki " + idList + " z miasta " + this.getCityNameByItsNumber(this.baseCity));
		
		
	}

	public ArrayList<String> getLogList(){
		return logList;
	}
	
}
