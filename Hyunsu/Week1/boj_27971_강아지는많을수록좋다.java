import java.io.*;
import java.util.*;

public class boj_27971_강아지는많을수록좋다 {

    static int N, M, A, B; //원하는 강아지의 수, 닫힌 구간의 수, 강아지 생성하는 방법 1, 2
    static boolean[] visited;
    static int[][] closedRange;

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0}); //현재 마리수, 행동 횟수

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == N) {
                return cur[1];
            }

            int nxtA = cur[0] + A, nxtB = cur[0] + B;
            if (nxtA <= N && !visited[nxtA]) {
                q.offer(new int[]{nxtA, cur[1] + 1});
                visited[nxtA] = true;
            }
            if (nxtB <= N && !visited[nxtB]) {
                q.offer(new int[]{nxtB, cur[1] + 1});
                visited[nxtB] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        closedRange = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            closedRange[i][0] = Integer.parseInt(st.nextToken());
            closedRange[i][1] = Integer.parseInt(st.nextToken());
        }

        visited = new boolean[N + 1];
        for (int[] range : closedRange) {
            for (int j = range[0]; j <= range[1]; j++) {
                visited[j] = true;
            }
        }

        System.out.println(bfs());
    }
}
