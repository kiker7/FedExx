package data_structure;

public interface Queue<V extends Comparable<V>> {

	void push(V value);

	V pop();
}