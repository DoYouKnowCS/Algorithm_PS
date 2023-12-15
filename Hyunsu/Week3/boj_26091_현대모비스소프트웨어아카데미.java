import java.io.*;
import java.util.*;

public class boj_26091_현대모비스소프트웨어아카데미 {

    static int N, M, ans = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) {
            System.out.println(0);
        } else {
            Arrays.sort(arr);
            int s = 0, e = N - 1;
            while (s < e) {
                if (arr[s] + arr[e] >= M) {
                    ans++;
                    s++;
                    e--;
                } else {
                    s++;
                }
            }

            System.out.println(ans);
        }
    }
}
