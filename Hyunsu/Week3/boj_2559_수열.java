import java.io.*;
import java.util.*;

public class boj_2559_수열 {

    static int N, K, ans = 0;
    static int[] temperature;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        temperature = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temperature[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = K - 1, max = 0;
        for (int i = s; i <= e; i++) {
            max += temperature[i];
        }
        ans = max;

        while (e < N - 1) {
            max -= temperature[s++];
            max += temperature[++e];
            ans = Math.max(ans, max);
        }

        System.out.println(ans);
    }
}
