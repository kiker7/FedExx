package logic2;

import io.MapRead;
import io.OrderRead;

import java.io.File;
import java.io.IOException;



import data_structure.Heap;
import dijsktra.Map;
import edu.uci.ics.jung.graph.Graph;

public class Parser {

	private Map map;
	private Heap<Order> priorityList;
	private int nCars, nPackInCar;
	private MapRead mReader;
	private OrderRead oReader;
	private int baseCity;
	private Graph<String, String> g;
	private String [] orderNames;

	/**
	 * Parser.
	 * 
	 * @param args
	 *            the args
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	
	public Parser(){
		mReader = new MapRead();
		oReader = new OrderRead();
		
	}
	
	public String[] getOrderNames(){
		return orderNames;
	}

	public Graph<String,String> getGraph(){
		return g;
	}
	
	public int getBaseCity(){
		return baseCity;
	}
	
	public Heap<Order> getHeap() {
		return priorityList;
	}

	public Map getMap() {
		return map;
	}

	public int getNCars() {
		return nCars;
	}

	public int getNPackInCar() {
		return nPackInCar;
	}
	
	public Order[] getOrdersList(){
		return oReader.getOrderList();
	}

	public int getOrderAmount(){
		return oReader.getOrderCount();
	}
	
	public void parser(String[] args) throws IOException {
		for (int i = 0; i < args.length; i++) {
			switch (i) {
			case 0:
				map = mReader.mapRead(new File(args[0]));
				g = mReader.getGraph();
				break;
			case 1:
				priorityList = oReader.orderRead(new File(args[1]));
				baseCity = oReader.getBaseCity();
				orderNames = oReader.getorderNames();
				break;
			case 2:
				nCars = Integer.parseInt(args[2]);
				break;
			case 3:
				nPackInCar = Integer.parseInt(args[3]);
				break;
			default:
				System.err
						.println("Niewłaściwie podane argumenty lini poleceń");
				break;
			}
		}
	}
}