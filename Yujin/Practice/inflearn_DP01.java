package inflearn;

import java.util.Scanner;

public class inflearn_10_01 {
    static int[] dy;

    public int solution(int n){
        dy[1]=1;
        dy[2]=2;
        for(int i=3;i<=n;i++){
            dy[i]=dy[i-2]+dy[i-1];
        }
        return dy[n];
    }
    public static void main(String[] args) {
        inflearn_10_01 T = new inflearn_10_01();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n+1];
        System.out.print(T.solution(n));

    }
}
