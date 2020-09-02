package ds.graph;

import java.util.Arrays;

/**
 * Kruskal's Algorithm is for finding edges which form minimum cost spanning tree. It is a Greedy Algorithm.
 * We use disjoint sets with Weighted Union and Find with path compression operations to find the edges which
 * doesn't form cycle and form minimum cost spanning tree.
 * 
 * @author htavva
 *
 */
class WeightedEdge implements Comparable<WeightedEdge> {
	int src;
	int dest;
	int weight;
	
	WeightedEdge(){}
	
	WeightedEdge(int src, int dest, int weight){
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	@Override
	public int compareTo(WeightedEdge e) {
		return weight- e.weight;
	}

}

public class KruskalsAlgoUsingDisjointSets {

	int V;
	int E;
	WeightedEdge[] edges;
	int[] parent;
	
	public KruskalsAlgoUsingDisjointSets(int nV, int nE) {
		
		this.V = nV;
		this.E = nE;
		edges = new WeightedEdge[E];
		parent = new int[V];
		
		for(int i=0; i<V; i++) {
			parent[i] = -1;
		}
		
		for(int i=0; i< E; i++) {
			edges[i] = new WeightedEdge();
		}
	}
	
	/**
	 * Finds the root of subset containing that node.
	 * Also does path compression.
	 * @param data
	 * @return
	 */
	public int find(int data) {
		
		if(parent[data] < 0) {
			return data;
		}
		
		int x = this.find(parent[data]);
		parent[data] = x;
		
		return x;
	}
	
	/**
	 * Find the root for both disjoint sets and add smaller rank one to
	 * bigger rank one. Also update the number of nodes in the parent of bigger rank one.
	 * @param x
	 * @param y
	 */
	public void union(int x, int y) {
		
		int xRoot = find(x);
		int yRoot = find(y);
		
		if(parent[xRoot] == parent[yRoot]) {
			parent[xRoot] = parent[xRoot] + parent[yRoot];
			parent[yRoot] = xRoot;
		}else if(parent[xRoot] < parent[yRoot]) {
			parent[xRoot] = parent[xRoot] + parent[yRoot];
			parent[yRoot] = xRoot;
		}else {
			parent[yRoot] = parent[xRoot] + parent[yRoot];
			parent[xRoot] = yRoot;
		}
	}
	
	public void kruskalsAlgo() {
		
		Arrays.sort(edges); // Sorting to find the minimum cost. Greedy Step.
		WeightedEdge[] mstEdges = new WeightedEdge[V-1];
		int m = 0;
		
		for(int i=0; i< E; i++) {
			int srcRoot = find(edges[i].src);
			int destRoot = find(edges[i].dest);
			
			if(srcRoot == destRoot) {
				continue;
			}else {
				union(edges[i].src, edges[i].dest);
				mstEdges[m++] = edges[i];
			}
		}
		
		for(int i = 0; i<m; i++) {
			System.out.println("Edges : " + mstEdges[i].src + mstEdges[i].dest + mstEdges[i].weight);
		}
		
	} 
	
	public static void main(String[] args) {

		KruskalsAlgoUsingDisjointSets kad = new KruskalsAlgoUsingDisjointSets(5,5);
		
		WeightedEdge e1 = new WeightedEdge(0,1, 2);
		WeightedEdge e2 = new WeightedEdge(0,2, 1);
		WeightedEdge e3 = new WeightedEdge(2,3, 2);
		WeightedEdge e4 = new WeightedEdge(3,4, 3);
		WeightedEdge e5 = new WeightedEdge(1,4, 4);
		WeightedEdge e6 = new WeightedEdge(1,3, 2);

		kad.edges[0] = e1;
		kad.edges[1] = e2;
		kad.edges[2] = e3;
		kad.edges[3] = e4;
		kad.edges[4] = e5;
		kad.edges[4] = e6;
		
		kad.kruskalsAlgo();
		
	}

}
