package inflearn;

import java.util.Scanner;

public class inflearn_02_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[M][N];
        int answer=0;

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                int cnt=0;
                for(int k=0;k<M;k++){
                    int pi=0,pj=0;
                    for(int l=0;l<N;l++){
                        if(arr[k][l]==i) pi=l;
                        if(arr[k][l]==j) pj=l;
                    }
                    if(pi<pj) cnt++;
                }
                if(cnt==M) answer++;
            }
        }

        System.out.println(answer);

    }
}
