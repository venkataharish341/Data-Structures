package ds.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graphs {

	private int v;
	private LinkedList<Integer>[] arr;

	public Graphs(int v){
		this.v = v;
		this.arr = new LinkedList[this.v];

		for(int i= 0; i< v; i++) {
			arr[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int u, int v) {
		arr[u].add(v);
		arr[v].add(u);
	}

	/**
	 * Using BFS.
	 * @param src
	 */
	public void bfs(int src) {

		boolean[] visited = new boolean[v];
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(src);
		visited[src] = true;

		while(!queue.isEmpty()) {
			int x = queue.poll();
			System.out.println(x);
			Iterator<Integer> it = arr[x].iterator(); 

			while(it.hasNext()) {
				int y = it.next();
				if(!visited[y]) {
					queue.add(y);
					visited[y] = true;
				}
			}
		}
	}
	
	/**
	 * Use Stack. Just like BFS.
	 * @param src
	 */
	public void dfsIterative(int src) {
		Stack <Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[v];
		
		stack.push(src);
		visited[src] = true;
		
		while(!stack.isEmpty()) {
			
			int x = stack.pop();
			System.out.println(x);
			
			Iterator<Integer> it = arr[x].iterator();
			
			while(it.hasNext()) {
				int y = it.next();
				if(!visited[y]) {
					stack.push(y);
					visited[y] = true;
				}
			}
		}
	}
	
	/**
	 * Cycle Detection in Undirected Graph can be done in many ways.
	 * 1. Using BFS
	 * 2. Using DFS
	 * 3. Using Disjoint Sets
	 * 4. Topological Sorting
	 * 
	 * This same method can be applied using BFS. Just use Queue.
	 *  
	 * Unvisited = -1
	 * Added to Queue = 0
	 * Popped from Queue/Processed = 1
	 * @param src
	 * @return
	 */
	public boolean cycleDetectUsingDFSUndirectedGraph(int src) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] visited = new int[v];
		
		for(int i=0; i<v; i++) {
			visited[i] = -1;
		}
		
		stack.push(src);
		visited[src] = 0;
		
		while(!stack.isEmpty()) {
			int x = stack.pop();
			visited[x] = 1;
			
			Iterator<Integer> it = arr[x].iterator();
			
			while(it.hasNext()) {
				int y = it.next();
				
				if(visited[y] == 0) {
					return true;
				}else if(visited[y] == -1) {
					stack.push(y);
					visited[y] = 0;
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) {

		Graphs g = new Graphs(5);
		g.addEdge(0,1);
		g.addEdge(1,4);
		g.addEdge(4,3);
		g.addEdge(3,2);
		//g.addEdge(0,2);
		g.addEdge(3,0);
		//g.addEdge(1,3);

		System.out.println(g.cycleDetectUsingDFSUndirectedGraph(0));

	}

}
