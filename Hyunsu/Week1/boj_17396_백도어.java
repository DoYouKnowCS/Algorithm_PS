import java.io.*;
import java.util.*;

public class boj_17396_백도어 {

    static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static int[] wards;
    static long[] dist;
    static boolean[] visited;
    static List<ArrayList<Node>> graph = new ArrayList<>();

    static void solve() {
        visited = new boolean[N];
        dist[0] = 0; //0번째 분기점은 현재 위치

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (visited[cur.value]) {
                continue;
            }

            for (int i = 0; i < graph.get(cur.value).size(); i++) {
                //현재 위치(cur)에서 i분기점까지의 길이 있다면
                //그냥 바로 가는거랑 현재 위치를 거쳐서 가는거랑 뭐가 더 빠른지 갱신
                Node nxt = graph.get(cur.value).get(i);
                if (nxt.value != N - 1 && wards[nxt.value] == 1) {
                    continue;
                }

                if (dist[nxt.value] > dist[cur.value] + nxt.time) {
                    dist[nxt.value] = dist[cur.value] + nxt.time;
                    pq.offer(new Node(nxt.value, dist[nxt.value]));
                }
            }

            visited[cur.value] = true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        wards = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < wards.length; i++) {
            wards[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, t));
            graph.get(b).add(new Node(a, t));
        }

        dist = new long[N]; //i번째 분기점까지 걸리는 최소 시간
        Arrays.fill(dist, INF);
        solve();
        System.out.println((dist[N - 1] == INF ? "-1" : dist[N - 1]));
    }

    static class Node implements Comparable<Node> {

        int value;
        long time;

        public Node(int value, long time) {
            this.value = value;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.time, o.time);
        }
    }
}
