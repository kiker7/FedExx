package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import logic.Order;
import data_structure.Heap;
import data_structure.Queue;

/**
 * The Class OrderRead.
 */
public class OrderRead {

	/** The base city. */
	private int baseCity;

	/**
	 * Order read.
	 *
	 * @param filename the filename
	 * @return the heap
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Heap<Order> orderRead(File filename) throws IOException {
		Heap<Order> priorityQueue = new Heap<Order>();
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(filename));
			String buffer;
			int id, bc, oc, pr;
			String cname;
			buffer = input.readLine();
			baseCity = Integer.parseInt(buffer);
			while ((buffer = input.readLine()) != null) {
				String parts[] = buffer.split("\\s+");
				id = intParser(parts[0]);
				bc = intParser(parts[1]);
				oc = intParser(parts[2]);
				cname = nameRead(parts);
				pr = intParser(parts[parts.length - 1]);
				priorityQueue.push(new Order(id, bc, oc, cname, pr));
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (input != null)
				input.close();
		}
		return priorityQueue;
	}

	/**
	 * Int parser.
	 *
	 * @param value the value
	 * @return the int
	 */
	private int intParser(String value) {
		int result = Integer.parseInt(value);
		return result;
	}

	/**
	 * Name read.
	 *
	 * @param p the p
	 * @return the string
	 */
	private String nameRead(String[] p) {
		String result = "";
		for (int i = 3; i <= p.length - 2; i++)
			result += (p[i] + " ");
		return result;
	}
}
