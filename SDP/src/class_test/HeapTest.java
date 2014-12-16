package class_test;

import data_structure.Heap;

public class HeapTest {

	public static void main(String[] args) {
		
		Heap<Integer> h = new Heap<>();
		for (int i = 0; i < 10; i++) {
			h.push(i);
		}
		System.out.println(h);
		System.out.println("nowa");
		while (!h.isEmpty())	{
			System.out.println(h.pop());
		}
	}

}
