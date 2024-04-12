package inflearn;

import java.util.Scanner;

public class inflearn_07_03 {
    public int DFS(int n){ //int
        if(n==1) return 1;
        else{
            return n*DFS(n-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        inflearn_07_03 T = new inflearn_07_03();
        System.out.println(T.DFS(n));
    }
}
