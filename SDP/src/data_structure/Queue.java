package data_structure;

/**
 * The Interface Queue.
 *
 * @param <V> the value type
 */
public interface Queue<V extends Comparable<V>> {

	/**
	 * Push.
	 *
	 * @param value the value
	 */
	void push(V value);

	/**
	 * Pop.
	 *
	 * @return the v
	 */
	V pop();
}