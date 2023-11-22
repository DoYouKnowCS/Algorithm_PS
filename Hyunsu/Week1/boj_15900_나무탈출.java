import java.io.*;
import java.util.*;

/**
 * 루트 노드에서 각 리프 노드까지의 거리의 총합이 홀수 -> 이김, 짝수 -> 짐
 */
public class boj_15900_나무탈출 {

    static int N, ans = 0;
    static List<ArrayList<Integer>> tree = new ArrayList<>();

    static void dfs(int parent, int node, int depth) {
        if (tree.get(node).size() == 1 && tree.get(node).get(0) == parent) {
            ans += depth;
            return;
        }

        for (int child : tree.get(node)) {
            if (child == parent) {
                continue;
            }
            dfs(node, child, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dfs(-1, 1, 0); //1번 노드가 root이므로 1번 노드부터 시작. 1번 노드는 부모가 없음(-1)

        System.out.println((ans % 2 == 0) ? "No" : "Yes");
    }
}
