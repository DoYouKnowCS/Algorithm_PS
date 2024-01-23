package algorithm;

import java.util.Scanner;

public class boj_9095 { //DP
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        int[] dp = new int[11];
        dp[1] = 1; //1
        dp[2] = 2; //1+1, 2
        dp[3] = 4; //1+1+1, 1+2, 2+1, 3
        // 4 = 1+(4가지경우), 2+(2가지경우), 3+(1가지경우) // 7

        for(int i=4;i<11;i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        for(int i=0; i<T;i++){ //T번
            int num = scan.nextInt(); //숫자
            System.out.println(dp[num]);
        }
    }
}
