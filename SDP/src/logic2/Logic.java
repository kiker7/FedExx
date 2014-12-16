package logic2;

import java.util.ArrayList;

import data_structure.Heap;

public class Logic {

	private Car[] carList;
	private Parser parser;
	private ArrayList<Order> orderList;
	private Heap<Order> priorityList;
	private Message messenger;

	public Logic(Parser p) {
		;
		parser = p;
		carList = new Car[parser.getNCars()];
		priorityList = p.getHeap();
		orderList = new ArrayList<Order>();
		messenger = new Message();
		for (int i = 0; i < parser.getNCars(); i++) {
			carList[i] = new Car();
		}

		while (!priorityList.isEmpty()) {
			orderList.add(priorityList.pop());
		}
	}

	public Order findAvailableOrder(int oc) {
		for (Order x : orderList) {
			if (x.getOrderCity() == oc)
				return x;
		}
		return null;
	}

	public void allocation() {
		System.out.println("start");
		int c = 0;
		while (!orderList.isEmpty()) {
			for (int i = 0; i < parser.getNCars(); i++) {
				System.out.println("wyruszl samochod nr " + c);
				if (!orderList.isEmpty()) {
					Order tmp;
					Order order = orderList.remove(0);
					System.out.println("sciagnieto zlecenie nr "
							+ order.getId());
					// messenger.setNewTrip(new Trip());
					// twprzenie komunikatu
					int distance = parser.getMap().getShortestPath(
							order.getBaseCity(), order.getOrderCity());
					int[] vc = parser.getMap().getVisitedCities(); // sciezka
																	// odwiedzonych
																	// miast
				
							
					for (int j = parser.getMap().getVCAL() - 2, k = 0; j > 1; j--) {
						tmp = this.findAvailableOrder(vc[j]);
						if (tmp != null && k != parser.getNPackInCar()) {
							System.out.println("samochod nr " + i
									+ " dowizl paczke" + tmp.getId());
							System.out.println("samochod nr " + i
									+ " dowizl paczke" + order.getId());
							orderList.remove(tmp);
							System.out.println("sciagnieto paczke nr "
									+ tmp.getId());
							// wypisz komunikat
						} else
							break;
						k++;
					}

				} else {
					break;
				}
				System.out.println(orderList);
				c++;
			}
			System.out.println("stop");

		}
	}

}
