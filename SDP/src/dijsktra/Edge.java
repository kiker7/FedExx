package dijsktra;

public class Edge {
	private int value;
	private boolean visited;

	public Edge(int value) {
		this.value = value;
		this.visited = false;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public boolean isVisited(){
		return this.visited;
	}
	
	public void visit(){
		this.visited = true;
	}
	
	public void unvisit(){
		this.visited = false;
	}
}