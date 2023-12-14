import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        Integer[] brokeArr = new Integer[N];
        for(int i=0;i<N;i++) {
            brokeArr[i] = 1;
        }
        for(int i=0;i<B;i++) {
            brokeArr[Integer.parseInt(br.readLine())-1] = 0;
        }
        int f = 0, b = K-1;
        int brokeCnt = 0;
        for(int i=0;i<=K-1;i++) {
            if(brokeArr[i] == 0) brokeCnt++;
        }
        int minCnt = brokeCnt;
        while(b<N-1) {
            if(brokeArr[f]==0)
                brokeCnt--;
            f++;
            if(brokeArr[++b]==0)
                brokeCnt++;
            minCnt = Math.min(minCnt,brokeCnt);
        }
        System.out.println(minCnt);
        //0 0 1 1 0 1 1 1 0 0
        // 1 2 5 9 10
        //0 0 2 3 0 0
    }

}
