import java.io.*;
import java.util.*;

public class boj_18290_NM과K1 {

    static int N, M, K, ans = Integer.MIN_VALUE;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int[][] grid;
    static boolean[][] visited;

    static boolean checkVisit(int r, int c) {
        for (int dir = 0; dir < 4; dir++) {
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                if (visited[nr][nc]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void solve(int len, int sum, int r, int c) {
        if (len == K) {
            ans = Math.max(ans, sum);
            return;
        }

        //매 번 (0,0)부터 돌리는 것은 연산을 너무 잡아먹는다.
        //현재 위치에서 인접해있는 칸을 이미 방문했으면 건너뛰고, 그렇지 않으면 sum에 더한다.
        for (int i = r; i < N; i++) {
            for (int j = c; j < M; j++) {
                if (!visited[i][j] && checkVisit(i, j)) {
                    visited[i][j] = true;
                    solve(len + 1, sum + grid[i][j], r, c);
                    visited[i][j] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];
        solve(0, 0, 0, 0);

        System.out.println(ans);
    }
}
