import java.io.*;
import java.util.*;

public class boj_13565_침투 {

    static int M, N;
    static boolean flag = false;
    static int[] dr = {1,0,0,-1};
    static int[] dc = {0, -1, 1, 0};
    static int[][] grid;
    static boolean[][] visited;

    static void dfs(int r, int c) {
        if (r == M - 1) {
            flag = true;
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr >= 0 && nr < M && nc >= 0 && nc < N) {
                if (grid[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    dfs(nr, nc);
                }
            }
        }
    }

    static boolean solve() {
        visited = new boolean[M][N];

        for (int i = 0; i < N; i++) {
            if (grid[0][i] == 0 && !visited[0][i]) {
                visited[0][i] = true;
                dfs(0, i);
                if (flag) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        grid = new int[M][N];
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        System.out.println(solve() ? "YES" : "NO");
    }
}
