import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int JOIN_NUM = -10_001;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;
        int[][] arr = new int[N+2][M+2];
        for(int i=0;i<N+2;i++) {
            if(i==0 || i==N+1) {
                for(int j=0;j<M+2;j++) {
                    arr[i][j] = JOIN_NUM;
                }
            }
            else {
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<M+2;j++) {
                    arr[i][j] = (j==0||j==M+1)?JOIN_NUM:Integer.parseInt(st.nextToken());
                }
            }
        }
        for(int i=1;i<N+1;i++) {
            for(int j=1;j<M+1;j++) {
                req(i,j,arr,0, K,0, N, M);
            }
        }
        System.out.println(max);
    }

    private static void req(int lastI, int lastJ, int[][] arr, int depth, int K, int sum, int N, int M) {
        if(depth == K) {
            max = Math.max(max, sum);
            return;
        }
        for(int i=lastI;i<N+1;i++) {
            for(int j=(i==lastI)?lastJ:1; j<M+1; j++) {
                if(arr[i][j]!=JOIN_NUM) {
                    int temp = arr[i][j];
                    int temp1 = arr[i+1][j];
                    int temp2 = arr[i-1][j];
                    int temp3 = arr[i][j+1];
                    int temp4 = arr[i][j-1];

                    arr[i][j] = JOIN_NUM;
                    arr[i+1][j] = JOIN_NUM;
                    arr[i-1][j] = JOIN_NUM;
                    arr[i][j+1] = JOIN_NUM;
                    arr[i][j-1] = JOIN_NUM;

                    req(i,j,arr,depth+1,K,sum+temp,N,M);

                    arr[i][j] = temp;
                    arr[i+1][j] = temp1;
                    arr[i-1][j] = temp2;
                    arr[i][j+1] = temp3;
                    arr[i][j-1] = temp4;
                }
            }
        }
    }
}
