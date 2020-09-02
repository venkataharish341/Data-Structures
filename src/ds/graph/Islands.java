package ds.graph;

public class Islands {
	
	private static int ROW = 5;
	private static int COL = 5;

	private int countIslands(int[][] mat) {
		boolean[][] visited = new boolean[5][5];
		int count = 0;
		
		for(int i =0; i< ROW; i++) {
			for(int j=0; j< COL; j++) {
				
				if(!visited[i][j] && mat[i][j] == 1) {
					dfsUtil(mat, i,j,visited);
					count++;
				}
				
			}
		}
		return count;
	}

	public void dfsUtil(int[][] mat, int row, int col, boolean[][] visited) {

		//TO get to its Neighbours.
		int[] adjRow = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] adjCol = new int[] {0,-1, 1, -1, 1, -1, 0, 1 };

		//System.out.println(mat[row][col]);
		visited[row][col] = true;

		for(int i=0; i < 8; i++) {
			int adjRowNum = row+adjRow[i];
			int adjColNum = col+adjCol[i];

			if(adjColNum >= 0 && adjRowNum >= 0 && adjRowNum <= ROW-1 && adjColNum <= COL-1) {
				int x = mat[adjRowNum][adjColNum];

				if(x== 1 && !visited[adjRowNum][adjColNum]) {
					dfsUtil(mat, adjRowNum, adjColNum, visited);
				}
			}
		}
	}



	public static void main(String[] args) {

		int[][] mat = new int[][] {
			{1,1,0,0,0},
			{0,1,0,0,1},
			{1,0,0,1,1},
			{0,0,0,0,0},
			{1,0,1,0,1}
		};

		//new Islands().countIslands(mat);
		System.out.println(new Islands().countIslands(mat));

	}

}
