package ds.graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	private int v;
	private LinkedList<Integer>[] adj;

	public Graph(int v) {
		this.v = v;
		adj = new LinkedList[v];

		for(int i=0; i<v; ++i) {
			adj[i] = new LinkedList<Integer>();
		}
	}
	
	// Since Undirected Graph, edge should be bidirectional.
	public void addEdge(int v, int a) {
		adj[v].add(a);
		adj[a].add(v);
		
	}

	public void bfs(int s) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		boolean[] visited = new boolean[v];
		
		queue.add(s);
		visited[s] = true;
		
		while(!queue.isEmpty()) {
			
			int x = queue.poll();
			System.out.println(x);
			
			Iterator<Integer> it = adj[x].iterator();
			
			while(it.hasNext()) {
				int y = it.next();
				
				if(!visited[y]) {
					queue.add(y);
					visited[y] = true;
				}
				
			}
		}
	}
	
	public void dfsIteration(int s){
		Stack<Integer> stk = new Stack<Integer>();
		boolean[] visited = new boolean[v];
		
		stk.add(s);
		visited[s]  = true;
		
		while(!stk.isEmpty()) {

			int x = stk.pop();
			System.out.println(x);
			
			Iterator<Integer> it = adj[x].iterator();
			
			while(it.hasNext()) {
				int y = it.next();
				
				if(!visited[y]) {
					stk.push(y);
					visited[y] = true;
				}
			}
		}
	}
	
	public void dfsRecursion(int s) {
		boolean[] visited = new boolean[v];
		dfsUtil(s, visited);
	}

	private void dfsUtil(int s, boolean[] visited) {
		visited[s] = true;
		System.out.println(s);
		
		Iterator<Integer> it = adj[s].iterator();
		
		while(it.hasNext()) {
			int x = it.next();
			if(!visited[x])
				dfsUtil(x, visited);
		}
	}
	
	public static void main(String[] args) {

		Graph g = new Graph(5);
		g.addEdge(1, 0);  
        g.addEdge(2, 3);  
        g.addEdge(3, 4);
        g.addEdge(3, 1);
        g.addEdge(2, 0);
        g.addEdge(1, 4);
        
		g.dfsIteration(0);
		
		
	}
	
	public void DfsUtils(int s, boolean[] visited, ArrayList<Integer> str) {
		visited[s] = true;
		str.add(s);
		
		Iterator<Integer> it = adj[s].iterator();
		
		while(it.hasNext()) {
			int x = it.next();
			
			if(!visited[x]) {
				DfsUtils(x, visited, str);
			}
		}
	}
	
	public void findConnectedComponents(int s) {
		
		boolean[] visited = new boolean[v];
		ArrayList<Integer> str = new ArrayList<Integer>();
		
		for(int i=0; i< v; i++) {
			if(!visited[i]) {
				this.DfsUtils(i, visited, str);
				str.stream().forEach(d-> System.out.print(d));
				str = new ArrayList<Integer>();
				System.out.println("");
			}
		}
		
	}
	
}
