package inflearn;

import java.util.Scanner;

public class inflearn_07_06 {
    static int n;
    static int[] ch;
    public void DFS(int L){
        if(L==n+1){
            String tmp="";
            for(int i=1;i<=n;i++){
                if(ch[i]==1) tmp+=(i+" ");
            }
            if(tmp.length()>0) System.out.println(tmp); //출력
        }else{ //재귀
            ch[L]=1;
            DFS(L+1); //사용
            ch[L]=0;
            DFS(L+1); //사용X
        }
    }

    public static void main(String[] args) {
        inflearn_07_06 T = new inflearn_07_06();
        Scanner sc = new Scanner(System.in);
        n =sc.nextInt();
        ch=new int[n+1];
        T.DFS(1);
    }
}
