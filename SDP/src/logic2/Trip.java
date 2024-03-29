package logic2;

import java.util.ArrayList;
import java.util.Collections;

public class Trip {

	private ArrayList<MessageControl> messageList;
	private ArrayList<String> logList;
	private String[] cityNames = null;
	private int baseCity;
	private ArrayList<Comunicate> comunicateList;
	private ArrayList<String> orderNames;
	private ArrayList<String> edgeList;

	public Trip(String[] n, int b, ArrayList<String> o, ArrayList<String> eList) {
		messageList = new ArrayList<MessageControl>();
		logList = new ArrayList<String>();
		comunicateList = new ArrayList<Comunicate>();
		edgeList = eList;
		orderNames = o;
		cityNames = n;
		baseCity = b;
	}

	public Comunicate getLastComunicate() {
		return comunicateList.remove(comunicateList.size() - 1);
	}

	public int getLogListSize() {
		return logList.size();
	}

	public String getCityNameByItsNumber(int number) {
		for (int i = 0; i < cityNames.length; i++)
			if (number == i)
				return cityNames[i];
		return null;
	}

	public ArrayList<Comunicate> getCommunicateList() {
		return comunicateList;
	}

	public void addMessageControl(MessageControl mes) {
		messageList.add(mes);
	}

	public void createLogList() {
		ArrayList<Integer> idList = new ArrayList<Integer>();
		ArrayList<String> currentOrderNames = new ArrayList<String>();

		for (MessageControl x : messageList)
			idList.add(x.getOrderNumberInPath());

		// tutaj na podstawie idlist zrobic orderNames zgodne z id

		for (String x : orderNames)
			for (int n : idList)
				if (n == orderNames.indexOf(x) + 1)
					currentOrderNames.add(x);

		for (MessageControl n : messageList) {
			logList.add(n.getOrderTime() + " dostarczono przesy�ke "
					+ n.getOrderNumberInPath() + " do miasta "
					+ this.getCityNameByItsNumber(n.getCityNumberInPath()));
			comunicateList.add(new Comunicate(logList.get(logList.size() - 1),
					n.getOrderTime(), currentOrderNames, this
							.getCityNameByItsNumber(n.getCityNumberInPath()), n
							.getCityNumberInPath(), cityNames, edgeList));
		}

		logList.add("0 pobrano przesy�ki " + idList + " z miasta "
				+ this.getCityNameByItsNumber(this.baseCity));
		comunicateList.add(new Comunicate(logList.get(logList.size() - 1), 0,
				currentOrderNames, this.getCityNameByItsNumber(this.baseCity),
				0, cityNames, edgeList));

		Collections.reverse(comunicateList);
	}

	public ArrayList<String> getOrderNamesList() {
		return orderNames;
	}

	public ArrayList<String> getLogList() {
		return logList;
	}

	// funkcja testowa przy wypisywaniu komunikatu
	public ArrayList<Comunicate> getComunicateList() {
		return comunicateList;
	}

}
