package logic;

import io.MapRead;
import io.OrderRead;

import java.io.File;
import java.io.IOException;

import javax.sound.midi.SysexMessage;

import data_structure.Heap;
import dijsktra.Map;

public class Parser {

	private Map mapa;
	private Heap<Order> priorityList;
	private int nCars, nPackInCar;
	private MapRead mReader;
	private OrderRead oReader;

	/**
	 * Parser.
	 *
	 * @param args the args
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void parser(String[] args) throws IOException {
		for (int i = 0; i < args.length; i++) {
			switch (i) {
			case 0:
				mapa = mReader.mapRead(new File(args[0]));
				break;
			case 1:
				priorityList = oReader.orderRead(new File(args[1]));
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
