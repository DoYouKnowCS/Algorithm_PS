import java.io.*;
import java.util.*;

public class boj_15565_귀여운라이언 {

    static int N, K, ans = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = 0, lion = 0;
        while (s < N) {
            //라이언의 개수가 K보다 많거나 작다 -> s를 한 칸 움직여 크기를 늘리고 라이언 확인.
            if (lion >= K) {
                if (arr[s++] == 1) {
                    lion--;
                }
            } else if (e == N) {
                //라이언의 개수가 K보다 적은데 e가 이미 N에 가있다 -> 더 크기를 늘릴 수 없음 -> 탈출
                break;
            } else {
                //라이언의 개수가 K보다 작다 -> e를 한 칸 움직여 크기를 늘린다.
                if (arr[e++] == 1) {
                    lion++;
                }
            }

            //라이언의 개수를 확인하고 집합의 크기 갱신
            if (lion >= K) {
                ans = Math.min(ans, e - s);
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? "-1" : ans);
    }

}
