package class_test;

import io.OrderRead;

import java.io.File;
import java.io.IOException;

import logic.Order;
import data_structure.Heap;

public class OrderReadTest {

	public static void main(String[] args) throws IOException{
		OrderRead rd = new OrderRead();
		File file = new File(args[0]);
		Heap<Order> list = rd.orderRead(file);
		while(!list.isEmpty()) {
			System.out.println(list.pop());
			
		}
	}
}
