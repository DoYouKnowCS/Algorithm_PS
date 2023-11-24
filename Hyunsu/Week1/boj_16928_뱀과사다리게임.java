import java.io.*;
import java.util.*;

public class boj_16928_뱀과사다리게임 {

    static int N, M; //사다리, 뱀
    static boolean[] visited; //중복 방문 체크
    static int[] ladderAndSnake;

    static void solve() {
        visited = new boolean[101];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0}); //[현재 칸, 던진 횟수]
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            //처음으로 100번째 칸에 도달했을 때가 가장 최소로 주사위를 굴린 것.
            if (cur[0] == 100) {
                System.out.println(cur[1]);
                break;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int nxt = cur[0] + dice; //주사위 굴린 다음 칸

                if (nxt > 100 || visited[nxt]) {
                    continue;
                }

                //사다리나 뱀이 존재하는 곳은 바로 그 쪽으로 넘어가진다.
                //그렇기 때문에 nxt를 큐에 담으면 안된다. (큐에 담게 되면 거기서 주사위를 굴릴 수 있기 때문)
                if (ladderAndSnake[nxt] != 0) {
                    if (!visited[ladderAndSnake[nxt]]) {
                        visited[ladderAndSnake[nxt]] = true;
                        q.offer(new int[]{ladderAndSnake[nxt], cur[1] + 1});
                    }
                } else {
                    visited[nxt] = true;
                    q.offer(new int[]{nxt, cur[1] + 1});
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ladderAndSnake = new int[101];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ladderAndSnake[x] = y;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ladderAndSnake[x] = y;
        }

        solve();
    }
}
