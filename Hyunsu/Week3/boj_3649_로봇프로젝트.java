import java.io.*;
import java.util.Arrays;

public class boj_3649_로봇프로젝트 {

    static int x, n, ans = 0;
    static int[] lego;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tc = null;
        while ((tc = br.readLine()) != null) {
            ans = 0;
            x = Integer.parseInt(tc); //구멍의 너비
            n = Integer.parseInt(br.readLine()); //레고 조각의 수

            lego = new int[n];
            for (int i = 0; i < n; i++) {
                lego[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(lego);

            int s = 0, e = n - 1;
            while (s < e) {
                int sum = lego[s] + lego[e];
                if (sum == x * 10000000) {
                    ans = Math.max(ans, Math.abs(lego[s] - lego[e]));
                    System.out.println("yes " + lego[s] + " " + lego[e]);
                    break;
                } else if (sum < x * 10000000) {
                    s++;
                } else {
                    e--;
                }
            }

            if (ans == 0) {
                System.out.println("danger");
            }
        }
    }

}
