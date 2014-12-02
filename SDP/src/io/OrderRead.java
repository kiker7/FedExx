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
	
	public Queue orderRead(File filename) throws IOException{
		Queue priorityQueue = new Heap();
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(filename));
			String buffer;
			buffer = input.readLine();
			baseCity = Integer.parseInt(buffer);
			while ((buffer = input.readLine()) != null) {
				String parts[] = buffer.split("\\s+");
				priorityQueue.push(new Order(intParser(parts[0]), intParser(parts[1]), intParser(parts[2]),nameRead(parts), intParser(parts[parts.length-1])));
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			if (input != null)
				input.close();
		}
		return priorityQueue;
	}
	
	private int intParser(String value){
		int result = Integer.parseInt(value);
		return result;
	}
	
	private String nameRead(String [] p){
		String result = "";
		for(int i = 3; i <= p.length - 2; i++)
			result += p[i];
		return result;
	}
}
