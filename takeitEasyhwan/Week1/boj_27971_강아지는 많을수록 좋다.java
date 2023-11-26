import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        if(A>B) {
            int swap = A;
            A=B;
            B=swap;
        }
        int[] dp = new int[N+1];
        dp[0]=0;
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for(int j=s;j<=e;j++) {
                dp[j] = -1;
            }
        }
        for(int i=1;i<=N;i++) {
            if(dp[i]==-1)
                continue;

            if(i<A) {
                dp[i] = -1;
            }
            else if(i<B) {
                if(dp[i-A]==-1)
                    dp[i] = -1;
                else
                    dp[i] = dp[i-A]+1;
            }
            else if(dp[i-A]==-1 && dp[i-B]==-1)
                dp[i] = -1;
            else if(dp[i-A]==-1)
                dp[i] = dp[i-B]+1;
            else if(dp[i-B]==-1)
                dp[i] = dp[i-A]+1;
            else
                dp[i] = Math.min(dp[i-A],dp[i-B])+1;
        }
        System.out.println(dp[N]);
    }
}
