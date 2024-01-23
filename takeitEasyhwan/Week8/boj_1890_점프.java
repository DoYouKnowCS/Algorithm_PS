import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long dp[][] = new long[N][N];
        dp[0][0]=1;
        for(int i=0;i<N;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++) {
                int num=Integer.parseInt(st.nextToken());
                if(num==0)
                    continue;
                if(i+num<N)
                    dp[i+num][j] += dp[i][j];
                if(j+num<N)
                    dp[i][j+num] += dp[i][j];
            }
        }
        System.out.println(dp[N-1][N-1]);
    }
}
