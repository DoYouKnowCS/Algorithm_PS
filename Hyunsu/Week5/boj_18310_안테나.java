import java.io.*;
import java.util.*;

public class boj_18310_안테나 {
    
    static int N;
    static int[] houses;
    
    static int solve() {
        Arrays.sort(houses);
        return houses[(N - 1) / 2];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        
        houses = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(solve());
    }
}
