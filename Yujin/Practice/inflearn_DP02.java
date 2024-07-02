package inflearn;

import java.util.Scanner;

public class inflearn_10_02 {
    static int[] dy;

    public int solution(int n){
        dy[1]=1;
        dy[2]=2;
        for(int i=3;i<=n+1;i++){ //n+1까지
            dy[i]=dy[i-2]+dy[i-1];
        }
        return dy[n+1]; //n+1까지
    }
    public static void main(String[] args) {
        inflearn_10_02 T = new inflearn_10_02();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n+2]; //n+2개 돌다리 건너서 끝까지
        System.out.print(T.solution(n));

    }
}
