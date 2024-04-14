package inflearn;

import java.util.Scanner;

public class inflearn_07_04 {
    static int[] fibo;
    public int DFS(int n){
        if(fibo[n]>0) return fibo[n]; //(활용)뒤까지 검사하지 않고 바로
        if(n==1) return fibo[n]=1;
        else if (n==2) return fibo[n]=1;
        else{
            return fibo[n]=DFS(n-2)+DFS(n-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        inflearn_07_04 T = new inflearn_07_04();
        fibo = new int[n+1];
        T.DFS(n);
        for(int i=1;i<=n;i++){
            System.out.print(fibo[i]+" ");
        }
    }
}
