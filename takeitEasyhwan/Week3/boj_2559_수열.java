import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //전체 인원 명단
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int max=Integer.MIN_VALUE;
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int s = 0;
        int e = K-1;
        int sum =0;
        for(int i=0;i<=e;i++) {
            sum+=arr[i];
            max = sum;
        }
        while(e!=N-1) {
            sum-=arr[s++];
            sum+=arr[++e];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

}
