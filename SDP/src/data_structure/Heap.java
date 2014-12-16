package data_structure;

// TODO: Auto-generated Javadoc
/**
 * The Class Heap.
 *
 * @param <T> the generic type
 */
public class Heap<T extends Comparable<T>> implements Queue<T> {

	/** The heap. */
	private Comparable[] heap;
	
	/** The n. */
	private int n;

	/**
	 * Instantiates a new heap.
	 */
	public Heap() {
		n = 0;
		heap = new Comparable[30];
	}

	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty() {
		return n == 0;
	}
	
	

	/* (non-Javadoc)
	 * @see data_structure.Queue#push(java.lang.Comparable)
	 */
	@Override
	public void push(T value) {
		heap[n] = value;
		heapUp();
		n++;
	}

	/* (non-Javadoc)
	 * @see data_structure.Queue#pop()
	 */
	@Override
	public synchronized T pop() {
		T tmp = null;	
			if (!isEmpty()) {
				tmp = get(0);
				heap[0] = get(--n);
				heapDown();
			}
		return tmp;
	}

	/**
	 * Heap up.
	 */
	private void heapUp() {
		int i = n;
		int p = (n - 1) / 2;
		while (i > 0 && get(p).compareTo(get(i)) < 0) {
			swap(p, i);
			i = p;
			p = (i - 1) / 2;
		}
	}

	/**
	 * Swap.
	 *
	 * @param p the p
	 * @param i the i
	 */
	private void swap(int p, int i) {
		T tmp;
		tmp = get(p);
		heap[p] = get(i);
		heap[i] = tmp;
	}

	/**
	 * Heap down.
	 */
	private void heapDown() {
		int i = 0;
		int c = 2 * i + 1;
		while (c < n) {
			if (c + 1 < n && get(c + 1).compareTo(get(c)) > 0) {
				c++;
			}
			if (get(c).compareTo(get(i)) <= 0) {
				return;
			}
			swap(i, c);
			i = c;
			c = 2 * i + 1;
		}
	}

	/**
	 * Gets the.
	 *
	 * @param i the i
	 * @return the t
	 */
	private T get(int i) {
		@SuppressWarnings("unchecked")
		T t = (T) heap[i];
		return t;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = new String();
		for (int i = 0; i < n; i++) {
			result += get(i).toString() + '\n';
		}
		return result;
	}
}