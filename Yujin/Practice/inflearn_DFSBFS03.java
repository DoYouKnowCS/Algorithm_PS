package inflearn;

import java.util.Scanner;

public class inflearn_08_03 {
    static int answer = Integer.MIN_VALUE, m, n;
    public void DFS(int L, int sum, int time, int[] ps, int[] pt){ //부분집합 만들기
        if(time>m) return;
        if(L==n){
            answer=Math.max(answer,sum);
        }else{
            DFS(L+1, sum+ps[L], time+pt[L], ps, pt); //포함
            DFS(L+1, sum, time, ps, pt); //포함x
        }
    }
    public static void main(String[] args) {
        inflearn_08_03 T = new inflearn_08_03();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //문제 개수
        m = sc.nextInt(); //제한 시간
        int[] ps = new int[n]; //점수 저장
        int[] pt = new int[n]; //시간 저장
        for(int i=0;i<n;i++){
            ps[i] = sc.nextInt();
            pt[i] = sc.nextInt();
        }
        T.DFS(0,0,0, ps, pt);
        System.out.println(answer);
    }
}
