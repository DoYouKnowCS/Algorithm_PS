import java.io.*;
import java.util.*;

public class boj_16198_에너지모으기 {

    static int N, ans = 0;
    static int[] W;
    static boolean[] used;

    //구슬을 모으는 순서에 따라 결과가 달라짐 -> 순열
    static void solve(int len, int sum) {
        if (len <= 2) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            if (!used[i]) {
                used[i] = true;
                int left = 0, right = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (!used[j]) {
                        left = W[j];
                        break;
                    }
                }
                for (int j = i + 1; j < N; j++) {
                    if (!used[j]) {
                        right = W[j];
                        break;
                    }
                }
                solve(len - 1, sum + (left * right));
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        W = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            W[i] = Integer.parseInt(st.nextToken());
        }

        used = new boolean[N];
        solve(N, 0);

        System.out.println(ans);
    }
}
