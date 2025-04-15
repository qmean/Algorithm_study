import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n;
		boolean[][] map;
		boolean[][] visited;
		final boolean BLUE = true;
		final boolean WHITE = false;
		int white = 0;
		int blue = 0;
		int[] dx = {1, 0};
		int[] dy = {0, 1};

		void init() throws Exception{
			n = Integer.parseInt(br.readLine());
			map = new boolean[n+1][n+1];
			visited = new boolean[n+1][n+1];
			for (int i = 1; i <= n; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 1; j <= n; j++) {
					map[i][j] = s[j-1].equals("1");
				}
				Arrays.fill(visited[i], false);
			}
		}

		void solve() throws Exception {
			init();
			int idx = n;
			while (idx != 0) {
				// if idx = 128 start = 1 end 128
				// idx = 64 start = 1 end 64 start = 65 end 128\
				int k = n / idx;
				int start = 1;
				int end = idx;
				for (int i = 0; i < k; i++) {
					int xStart = start + idx * i;
					int xEnd = end + idx * i;
					for (int j = 0; j < k; j++) {
						int yStart = start + idx * j;
						int yEnd = end + idx * j;
						boolean stop = false;
						for (int l = xStart; l <= xEnd; l++) {
							for (int m = yStart; m <= yEnd; m++) {
								if (visited[l][m]) {
									stop = true;
									break;
								}
							}
							if (stop)
								break;
						}
						if (stop)
							continue;

						boolean whiteFlag = true;
						for (int l = xStart; l <= xEnd; l++) {
							for (int m = yStart; m <= yEnd; m++) {
								if (map[l][m] == BLUE) {
									whiteFlag = false;
									break;
								}
							}
							if (!whiteFlag) {
								break;
							}
						}

						boolean blueFlag = true;
						for (int l = xStart; l <= xEnd; l++) {
							for (int m = yStart; m <= yEnd; m++) {
								if (map[l][m] == WHITE) {
									blueFlag = false;
									break;
								}
							}
							if (!blueFlag) {
								break;
							}
						}

						if (whiteFlag) {
							for (int l = xStart; l <= xEnd; l++) {
								for (int m = yStart; m <= yEnd; m++) {
									visited[l][m] = true;
								}
							}
							white++;
						} else if (blueFlag) {
							blue++;
							for (int l = xStart; l <= xEnd; l++) {
								for (int m = yStart; m <= yEnd; m++) {
									visited[l][m] = true;
								}
							}
						}
					}
				}
				idx = idx / 2;
			}
			bw.write(white + "\n" + blue + "\n");
			bw.flush();
		}
	}
}
