package inflearn;

import java.util.Scanner;

public class inflearn_07_01 {
    public void DFS(int n){
        if(n==0) return;
        else{
            //위에 줄에 넣으면 3 2 1
            DFS(n-1);
            System.out.print(n + " "); //밑에 줄에 넣으면 1 2 3
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        inflearn_07_01 T = new inflearn_07_01();
        T.DFS(n);
    }
}
