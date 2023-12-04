import java.io.*;
import java.util.*;

public class boj_15665_N과M11 {

    static Set<String> set = new LinkedHashSet<>();
    static int N, M;
    static int[] input;
    static int[] output;

    static void solve(int len) {
        if (len == M) {
            StringBuilder sb = new StringBuilder();
            for (int i : output) {
                sb.append(i).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for (int i : input) {
            output[len] = i;
            solve(len + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        output = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);
        solve(0);

        for (String s : set) {
            System.out.println(s);
        }
    }
}
