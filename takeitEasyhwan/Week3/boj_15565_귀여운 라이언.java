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
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int f = 0, b = 0, cnt = 0;
        int min=Integer.MAX_VALUE;
        if(arr[0]==1) {
            cnt=1;
        }
        while(b!=N) {
            if(cnt==K)
                min = Math.min(min, b-f+1);
            if(b==f || cnt<K) {
                b++;
                if(b==N)
                    break;
                else if(arr[b]==1)
                    cnt++;
            }
            else {
                if(arr[f]==1)
                    cnt--;
                f++;
            }
        }
        System.out.println(min==Integer.MAX_VALUE?-1:min);
    }
}
