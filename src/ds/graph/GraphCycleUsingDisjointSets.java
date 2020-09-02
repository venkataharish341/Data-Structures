package ds.graph;

class Edge {
	int src;
	int dest;

	public Edge() {

	}

	public Edge(int src, int dest){
		this.src = src;
		this.dest = dest;
	}
}


public class GraphCycleUsingDisjointSets {

	private int V;
	private int E;
	Edge[] edges;
	private int[] parent;

	public GraphCycleUsingDisjointSets(int nV, int nE){
		this.V = nV;
		this.E = nE;
		edges = new Edge[E];
		parent = new int[V];

		for(int i=0; i< E; i++) {
			edges[i] = new Edge();
		}

		for(int i=0; i< V; i++) {
			// Minus indicates that it is parent of its subset.
			// Initially each node is a disjoint set.
			parent[i] = -1;
		}
	}

	public int find(int data) {

		if(parent[data] < 0) {
			return data;
		} 
		return find(parent[data]);
	}

	public void union(int x, int y) {

		int xRoot = find(x);
		int yRoot = find(y);

		if(parent[xRoot] == parent[yRoot]) {
			parent[yRoot] = parent[xRoot] + parent[yRoot];
			parent[xRoot] = yRoot;
		}else if(parent[xRoot] < parent[yRoot]) {
			parent[xRoot] = parent[xRoot] + parent[yRoot];
			parent[yRoot] = xRoot;
		}else {
			parent[yRoot] = parent[xRoot] + parent[yRoot];
			parent[xRoot] = yRoot;
		}
	}

	public int isCyclePresent() {

		for(int i=0; i< E; i++) {
			int srcRoot = find(edges[i].src);
			int destRoot = find(edges[i].dest);

			if(srcRoot == destRoot) {
				return 1;
			}
			union(edges[i].src, edges[i].dest);
		}
		return 0;
		
	}

	public static void main(String[] args) {

		GraphCycleUsingDisjointSets gd = new GraphCycleUsingDisjointSets(5,5);

		Edge e1 = new Edge(0,1);
		Edge e2 = new Edge(0,2);
		Edge e3 = new Edge(2,3);
		Edge e4 = new Edge(3,4);
		Edge e5 = new Edge(1,4);

		gd.edges[0] = e1;
		gd.edges[1] = e2;
		gd.edges[2] = e3;
		gd.edges[3] = e4;
		gd.edges[4] = e5;

		System.out.println(gd.isCyclePresent());


	}

}
