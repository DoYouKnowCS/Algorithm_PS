import java.io.*;
import java.util.*;

public class boj_1806_부분합 {

    static int N, S, ans = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = 0, sum = 0;
        while (s < N) {
            //합이 S를 넘는지 확인 -> 넘었으면 s를 한 칸 옮겨서 빼줌.
            if (sum >= S) {
                sum -= arr[s++];
            } else if (e == N) {
                //합이 S를 넘지 못하는데 e가 이미 N에 가있음 -> 더 이상 탐색 불가
                break;
            } else {
                sum += arr[e++];
            }

            //합을 확인하고 답 갱신
            if (sum >= S) {
                ans = Math.min(ans, e - s);
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }

}
