package ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Zombies_vs_Humans {

	public int findHoursToInfect(int rows, int cols, List<List<Integer>> mat) {

		boolean[][] visited = new boolean[rows][cols];
		int count = 0;

		for(int i=0; i< rows; i++) {
			for(int j=0; j< cols; j++) {
				if(mat.get(i).get(j) == 1 && !visited[i][j]) {
					int[] adjRows = new int[] {-1, 1, 0, 0};
					int[] adjCols = new int[] {0, 0,-1, 1};

					Queue<Integer> queue = new LinkedList<Integer>();
					queue.add(mat.get(i).get(j));
					visited[i][j] = true;

					while(!queue.isEmpty()) {

						int x = queue.poll();

						for(int k=0; i<4; i++) {
							int rowAdj = i + adjRows[k];
							int colAdj = j + adjCols[k];

							if(rowAdj >=0 && rowAdj < rows-1 && colAdj >= 0 && colAdj < cols-1) {

								int adj = mat.get(rowAdj).get(colAdj);

								if(!visited[rowAdj][colAdj] && adj == 1) {
									queue.add(adj);
									visited[rowAdj][colAdj] = true;
								}else if(adj == 0 && !visited[rowAdj][colAdj]) {
									mat.get(rowAdj).set(colAdj, 1);
									visited[rowAdj][colAdj] = true;
								}else {

								}

							}
						}
					}
					count++;
				}
			}
		}
		return count;
	}	


	public static void main(String[] args) {

		List<List<Integer>> mat = new ArrayList<List<Integer>>();
		mat.add(Arrays.asList(0, 1, 1, 0, 1));
		mat.add(Arrays.asList(0, 1, 0, 1, 0));
		mat.add(Arrays.asList(0, 0, 0, 0, 1));
		mat.add(Arrays.asList(0, 1, 0, 0, 0));


		System.out.println(new Zombies_vs_Humans().findHoursToInfect(5,4,mat));

	}

}
