package inflearn;

import java.util.Scanner;

public class inflearn_08_04 {
    static int[] pm;
    static int m, n;

    public void DFS(int L){
        if(L==m){
            for(int x : pm) System.out.print(x+" ");
            System.out.println();

        }else{
            for(int i=1; i<=n;i++){ //DFS가 n번 뻗어나가기
                pm[L]=i;
                DFS(L+1);
            }
        }
    }

    public static void main(String[] args) {
        inflearn_08_04 T = new inflearn_08_04();
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        pm = new int[m];
        T.DFS(0);
    }
}
