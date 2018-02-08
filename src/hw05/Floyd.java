package hw05;

public class Floyd {
	// Runs Floyd Warshall algorithm. Returns the matrix of
	// shortest paths.
	public static int[][] shortestpath(int[][] adj) {
		int n = adj.length;
		int[][] m = new int[n][n];

		// Initialize m to be graph adjacency matrix
		copy(m, adj);
		// Add in each vertex as intermediate point.
		for (int k = 0; k < n; k++) {
			// Recalculate estimate for distance from vertex i to j.
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++)
					m[i][j] = min(m[i][j], m[i][k] + m[k][j]);
			}
		}
		return m;
	}

	public static void copy(int[][] a, int[][] b) {
		for (int i = 0; i < a.length; i++)
			for (int j = 0; j < a.length; j++)
				a[i][j] = b[i][j];
	}

	public static int min(int a, int b) {
		if (a < b)
			return a;
		else
			return b;
	}

	public static void main(String[] args) {
		// Hard code in example adjacency matrix.
		int[][] m = new int[5][5];
		m[0][0] = 0;
		m[0][1] = 3;
		m[0][2] = 8;
		m[0][3] = 10000;
		m[0][4] = -4;
		m[1][0] = 10000;
		m[1][1] = 0;
		m[1][2] = 10000;
		m[1][3] = 1;
		m[1][4] = 7;
		m[2][0] = 10000;
		m[2][1] = 4;
		m[2][2] = 0;
		m[2][3] = 10000;
		m[2][4] = 10000;
		m[3][0] = 2;
		m[3][1] = 10000;
		m[3][2] = -5;
		m[3][3] = 0;
		m[3][4] = 10000;
		m[4][0] = 10000;
		m[4][1] = 10000;
		m[4][2] = 10000;
		m[4][3] = 6;
		m[4][4] = 0;
		int[][] shortpath;
		shortpath = shortestpath(m);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++)
				System.out.print(shortpath[i][j] + " ");
			System.out.println();
		}
	}
}
