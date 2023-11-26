import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] arr;
    static boolean check = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        arr = new boolean[M][N];
        for(int i =0;i<M;i++) {
            String line = br.readLine();
            for(int j=0; j<N; j++) {
                arr[i][j] = line.charAt(j)=='1'?true:false;
            }
        }
        for(int i=0;i<N;i++) {
            if(arr[0][i]==false) {
                req(0,i);
            }
        }
        System.out.println(check?"YES":"NO");
    }

    private static void req(int iIndex, int jIndex) {
        if(iIndex<0 || iIndex>arr.length-1 || jIndex<0 || jIndex>arr[0].length-1)
            return;
        if(arr[iIndex][jIndex])
            return;
        if(iIndex==arr.length-1) {
            check=true;
            return;
        }
        arr[iIndex][jIndex]=true;
        req(iIndex+1,jIndex);
        req(iIndex-1,jIndex);
        req(iIndex,jIndex-1);
        req(iIndex,jIndex+1);
    }
}
