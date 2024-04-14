package inflearn;

import java.util.Scanner;

public class inflearn_07_04 {
    public int DFS(int n){
        if(n==1) return 1;
        else if (n==2) return 1;
        else{
            return DFS(n-2)+DFS(n-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        inflearn_07_04 T = new inflearn_07_04();
        for(int i=1;i<=n;i++){
            System.out.print(T.DFS(i)+" ");
        }
    }
}
