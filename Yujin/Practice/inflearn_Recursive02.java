package inflearn;

import java.util.Scanner;

public class inflearn_07_02 {
    public void DFS(int n){
        if(n==0) return;
        else{
            DFS(n/2);
            System.out.print(n%2 + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        inflearn_07_02 T = new inflearn_07_02();
        T.DFS(n);
    }
}
