package inflearn;

import java.util.Scanner;

public class inflearn_08_06 {
    static int[] pm, ch, arr;
    static int m, n;

    public void DFS(int L){
        if(L==m){
            for(int x : pm) System.out.print(x+" ");
            System.out.println();

        }else{
            for(int i=0; i<n;i++){ //DFS가 n번 뻗어나가기
                if(ch[i]==0){
                    ch[i]=1;
                    pm[L]=arr[i];
                    DFS(L+1);
                    ch[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        inflearn_08_06 T = new inflearn_08_06();
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt(); //n개중
        m=sc.nextInt(); //m개뽑기
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        ch = new int[n]; //체크
        pm = new int[m];
        T.DFS(0);
    }
}
