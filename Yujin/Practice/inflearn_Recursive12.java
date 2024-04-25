package inflearn;

import java.util.Scanner;

public class inflearn_07_12 {
    static int n, m, answer=0;
    static int[][] graph;
    static int[] ch;
  
    public void DFS(int v){
        if(v==n) answer++;
        else{
            for(int i=1;i<=n;i++){
                if(graph[v][i]==1 && ch[i]==0){
                    ch[i]=1;
                    DFS(i);
                    ch[i]=0; //호출 취소
                }
            }
        }
    }

    public static void main(String[] args) {
        inflearn_07_12 T = new inflearn_07_12();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //정점 수
        m = sc.nextInt(); //간선 수
        graph = new int[n+1][n+1];
        ch = new int[n+1];
        for(int i=0; i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] =1;
        }
        ch[1]=1;
        T.DFS(1);
        System.out.println(answer);
    }
}
