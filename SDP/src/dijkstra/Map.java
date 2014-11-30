package dijkstra;

public class Map {

	private final int MAX_CITIES = 20;
	private final int INFINITY = 100000;
	private City cityList[];
	private int adjMat[][];
	private int nCity;
	private int nTree;
	private DistanceParent shortestPath[];
	private int currentCity;
	private int startToCurrent;

	public Map() {
		cityList = new City[MAX_CITIES];
		adjMat = new int[MAX_CITIES][MAX_CITIES];
		nCity = 0;
		nTree = 0;
		for (int i = 0; i < MAX_CITIES; i++) {
			for (int j = 0; j < MAX_CITIES; j++) {
				adjMat[i][j] = INFINITY;
			}
		}
		shortestPath = new DistanceParent[MAX_CITIES];
	}

	public void addCity(String name) {
		cityList[nCity++] = new City(name);
	}

	public void addEdge(int start, int end, int weight) {
		adjMat[start][end] = weight;
	}

	public void path() {
		int startTree = 0;
		cityList[startTree].isInTree = true;
		nTree = 1;

		for (int i = 0; i < nCity; i++) {
			shortestPath[i] = new DistanceParent(startTree,
					adjMat[startTree][i]);
		}

		while (nTree < nCity) {
			int indexMin = getMin();
			int minDistance = shortestPath[indexMin].distance;

			if (minDistance == INFINITY) {
				break;
			} else {
				currentCity = indexMin;
				startToCurrent = shortestPath[indexMin].distance;
			}
			cityList[currentCity].isInTree = true;
			nTree++;
			adjustShortestPath();
		}

		displayPaths();

		nTree = 0;
		for (int k = 0; k < nCity; k++)
			cityList[k].isInTree = false;
	}

	public int getMin() {
		int minDistance = INFINITY;
		int indexMin = 0;
		for (int j = 1; j < nCity; j++) {
			if (!cityList[j].isInTree && shortestPath[j].distance < minDistance) {
				minDistance = shortestPath[j].distance;
				indexMin = j;
			}
		}
		return indexMin;
	}

	public void adjustShortestPath() {
		int column = 1;

		while (column < nCity) {
			if (cityList[column].isInTree) {
				column++;
				continue;
			}
			int currentToFringe = adjMat[currentCity][column];
			int startToFringe = startToCurrent + currentToFringe;
			int sPathDist = shortestPath[column].distance;

			if (startToFringe < sPathDist) {
				shortestPath[column].parentCity = currentCity;
				shortestPath[column].distance = startToFringe;
			}
			column++;
		}
	}

	// -------------------------------------------------------------------------------//
	// POMOCNICZA FUNKCJA DO WYSWIETLANIA

	public void displayPaths() {
		for (int j = 0; j < nCity; j++) {
			System.out.print(cityList[j].cityName + "=");
			if (shortestPath[j].distance == INFINITY)
				System.out.print("inf");
			else
				System.out.print(shortestPath[j].distance);
			String parent = cityList[shortestPath[j].parentCity].cityName;
			System.out.print("(" + parent + ") ");
		}
		System.out.println("");
	}
}