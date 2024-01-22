import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int dp[] = new int[100_001];
        dp[0] = 1;
        dp[1] = 3;
        for(int i=2;i<100_001;i++) {
            dp[i] = (dp[i-1]*2 + dp[i-2]) % 9_901;
        }
        System.out.println(dp[N]);
    }
}
