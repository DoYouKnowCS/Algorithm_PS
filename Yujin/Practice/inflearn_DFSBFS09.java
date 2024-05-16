package inflearn;

import java.util.Scanner;

public class inflearn_08_09 {
    static int n, m;
    static int[] combi;
  
    public void DFS(int L, int s){
        if(L==m){ //조합 완성
            for(int x: combi) System.out.print(x+" ");
            System.out.println();
        }
        else{
            for(int i=s; i<=n; i++){ //s부터 n까지 돌면서
                combi[L]= i;
                DFS(L+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        inflearn_08_09 T = new inflearn_08_09();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[m]; //조합 수
        T.DFS(0,1);

    }
}
