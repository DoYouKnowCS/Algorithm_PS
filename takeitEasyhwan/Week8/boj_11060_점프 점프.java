import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int dp[] = new int[N];
        dp[0] = 0;
        for(int i=1;i<N;i++) {
            dp[i]=-1;
        }
        for(int i=0;i<N;i++) {
            int num = Integer.parseInt(st.nextToken());
            if(dp[i]==-1)
                continue;
            for(int j=i+1;j<Integer.min(N,i+num+1);j++) {
                if(dp[j]==-1)
                    dp[j] = dp[i]+1;
                else
                    dp[j] = Integer.min(dp[i]+1,dp[j]);
            }
        }
        System.out.println(dp[N-1]);
    }
}
