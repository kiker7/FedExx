package dijsktra;

public class Map {
	private final int INFINITY = 1000000000;
	private String[] cityNames = null;
	private Edge[][] neighborhoodMatrix = null;
	private int limit, visitedCityArrLength;
	private int[] visitedCities = null;

	public Map(int n) {
		limit = n;
		cityNames = new String[limit];
		visitedCities = new int[limit];
		for (int i = 0; i < limit; i++) {
			cityNames[i] = " ";
		}

		neighborhoodMatrix = new Edge[limit][limit];
		for (int i = 0; i < limit; i++) {
			for (int j = 0; j < limit; j++)
				if (i == j)
					neighborhoodMatrix[i][j] = new Edge(0);
				else
					neighborhoodMatrix[i][j] = new Edge(INFINITY);
		}
	}

	public String [] getCityNames(){
		return cityNames;
	}
	
	public int getVCAL(){
		return visitedCityArrLength;
	}
	
	public void addCity(int n, String name) {
		cityNames[n] = name;
	}

	public void addEdge(int from, int to, int cost) {
		neighborhoodMatrix[from][to].setValue(cost);
		neighborhoodMatrix[to][from].setValue(cost);
	}

	public void print() {
		for (int i = 0; i < limit; i++) {
			System.out.print(cityNames[i]);
			System.out.print(" Po³¹czenia z:");
			for (int j = 0; j < limit; j++) {
				int val = neighborhoodMatrix[i][j].getValue();
				if (val != INFINITY && val != 0)
					System.out.print(" " + cityNames[j] + "/" + val);
			}
			System.out.println();
		}
	}

	public int getShortestPath(int from, int to) {
		int path = 0;
		int count = 0;
		visitedCities[count++] = from;
		int nextNode = from;
		for (int i = from; i != to;) {
			int shortest = INFINITY;
			for (int j = 0; j < limit; j++) {
				int val = neighborhoodMatrix[i][j].getValue();
				if (val != INFINITY && val != 0 && shortest > val
						&& neighborhoodMatrix[i][j].isVisited() == false) {
					shortest = val;
					nextNode = j;
				}
			}
			if (nextNode == i) {
				System.out.println("Nie mo¿na znaleŸæ œcie¿ki");
				clearVisit();
				return -1;
			}
			neighborhoodMatrix[i][nextNode].visit();
			neighborhoodMatrix[nextNode][i].visit();
			visitedCities[count++] = nextNode;
			path += shortest;
			i = nextNode;
		}
		visitedCityArrLength = count;
		clearVisit();
		return path;
	}

	public int[] getVisitedCities() {
		return visitedCities;
	}

	private void clearVisit() {
		for (int i = 0; i < limit; i++)
			for (int j = 0; j < limit; j++)
				neighborhoodMatrix[i][j].unvisit();
	}
}