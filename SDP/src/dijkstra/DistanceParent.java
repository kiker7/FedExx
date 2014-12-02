package dijkstra;

// TODO: Auto-generated Javadoc
/**
 * The Class DistanceParent.
 */
public class DistanceParent {

	/** The distance. */
	public int distance;
	
	/** The parent city. */
	public int parentCity;

	/**
	 * Instantiates a new distance parent.
	 *
	 * @param pv the pv
	 * @param d the d
	 */
	public DistanceParent(int pv, int d) {
		distance = d;
		parentCity = pv;
	}

}
