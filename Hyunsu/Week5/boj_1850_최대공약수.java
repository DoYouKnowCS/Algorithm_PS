import java.io.*;
import java.util.*;

public class boj_1850_최대공약수 {
    
    static long A, B;
    
    static long findGCD(long n1, long n2) {
        return n2 == 0 ? n1 : findGCD(n2, n1 % n2);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        
        StringBuilder answer = new StringBuilder();
        long gcd = findGCD(A, B);
        for (int i = 0; i < gcd; i++) {
            answer.append("1");
        }
        
        System.out.println(answer.toString());
    }
}
