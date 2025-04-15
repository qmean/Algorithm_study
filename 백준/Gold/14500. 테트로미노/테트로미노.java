import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		new Solution().solve();
	}

	private static class Solution {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] sq32x = {{0, 2}, {0, 2}, {0, 2}, {0, 2}, {0, 1}, {0, 1}, {1, 2}, {1, 2}};
		int[][] sq32y = {{0, 0}, {1, 1}, {0, 1}, {1, 0}, {0, 0}, {1, 1}, {0, 0}, {1, 1}};
		int[][] sq23x = {{0, 0}, {0, 0}, {0, 0}, {1, 1}, {1, 1}, {1, 1}, {0, 1}, {0, 1}};
		int[][] sq23y = {{0, 1}, {1, 2}, {0, 2}, {0, 1}, {1, 2}, {0, 2}, {0, 2}, {2, 0}};
		int[] squareX = {3, 2, 1, 1, 0}; // 사각형의 종류 x 좌표 index=1 -> 32 index=3 -> 23
		int[] squareY = {0, 1, 1, 2, 3}; // 사각형의 종류 y 좌표 index=1 -> 32 index=3 -> 23
		int n,m;
		int max = 0;
		int[][] map;

		void init() throws Exception{
			String[] s = br.readLine().split(" ");
			n = Integer.parseInt(s[0]);
			m = Integer.parseInt(s[1]);
			map = new int[m][n];
			for (int i = 0; i <n ; i++) {
				s = br.readLine().split(" ");
				for (int j = 0; j <m ; j++) {
					map[j][i] = Integer.parseInt(s[j]);
				}
			}
		}

		void solve() throws Exception{
			init();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					for (int k = 0; k < 5; k++) {
						int xStart = j;
						int xEnd = j + squareX[k];
						int yStart = i;
						int yEnd = i + squareY[k];
						if (xEnd < m && yEnd < n) {
							int sum = 0;
							for (int l = yStart; l <= yEnd; l++) {
								for (int o = xStart; o <= xEnd; o++) {
									sum += map[o][l];
								}
							}
							if (k == 1) {
								int min = Integer.MAX_VALUE;
								for (int l = 0; l < 8; l++) {
									int tmp = 0;
									tmp += map[xStart + sq32x[l][0]][yStart + sq32y[l][0]];
									tmp += map[xStart + sq32x[l][1]][yStart + sq32y[l][1]];
									min = Math.min(min, tmp);
								}
								sum -= min;
							} else if (k == 3) {
								int min = Integer.MAX_VALUE;
								for (int l = 0; l < 8; l++) {
									int tmp = 0;
									tmp += map[xStart + sq23x[l][0]][yStart + sq23y[l][0]];
									tmp += map[xStart + sq23x[l][1]][yStart + sq23y[l][1]];
									min = Math.min(min, tmp);
								}
								sum -= min;
							}
							max = Math.max(sum, max);
						}
					}
				}
			}
			System.out.println(max);
		}
	}
}
