package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import logic.Order;
import data_structure.Heap;
import data_structure.Queue;

public class OrderRead {

	private int baseCity;

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

	private int intParser(String value) {
		int result = Integer.parseInt(value);
		return result;
	}

	private String nameRead(String[] p) {
		String result = "";
		for (int i = 3; i <= p.length - 2; i++)
			result += p[i];
		return result;
	}
}
