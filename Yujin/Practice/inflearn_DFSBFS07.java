package inflearn;

import java.util.Scanner;

public class inflearn_08_07 {
    int[][] dy = new int[35][35]; //n이 33까지니까
    public int DFS(int n, int r){
        if(dy[n][r]>0) return dy[n][r];
        if(n==r || r==0) return 1;
        else return dy[n][r]=DFS(n-1, r-1)+DFS(n-1,r);

    }
    public static void main(String[] args) {
        inflearn_08_07 T = new inflearn_08_07();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(T.DFS(n,r));

    }
}
