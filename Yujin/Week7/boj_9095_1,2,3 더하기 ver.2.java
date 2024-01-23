package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9095 { //DP
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[11];
        dp[1] = 1; //1
        dp[2] = 2; //1+1, 2
        dp[3] = 4; //1+1+1, 1+2, 2+1, 3
        // 4 = 1+(4가지경우), 2+(2가지경우), 3+(1가지경우) // 7

        for(int i=4;i<11;i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        for(int i=0; i<T;i++){ //T번
            int num = Integer.parseInt(br.readLine()); //숫자
            sb.append(dp[num]).append("\n");
        }
        System.out.println(sb);
    }
}
