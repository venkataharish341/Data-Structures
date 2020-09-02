package ds.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class DirectedGraph {

	private int v;
	private LinkedList<Integer>[] arr;

	public DirectedGraph(int v){
		this.v = v;
		this.arr = new LinkedList[this.v];

		for(int i= 0; i< v; i++) {
			arr[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int u, int v) {
		arr[u].add(v);
	}
	
	public void detectCycleDirectedGraphDFS(int src) {
		
		int[] visited = new int[v];
		for(int i=0; i<v; i++) {
			visited[i] = -1;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		
		while(true) {
			
			stack.push(src);
			visited[src] = 0;
			map.put(src, null);
			
			
			
			
			
		}
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		
		
		
		
	}

}
