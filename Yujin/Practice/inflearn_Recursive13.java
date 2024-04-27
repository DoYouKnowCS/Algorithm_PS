package inflearn;

import java.util.*;

public class inflearn_07_13 {
    static int n, m, answer=0;
    static ArrayList<ArrayList<Integer>> graph;//ArrayList를 갖는 ArrayList
    static int[] ch;

    public void DFS(int v){
        if(v==n) answer++;
        else{
            for(int nv : graph.get(v)){ //정수를 저장하는 v번째 ArrayList
                if(ch[nv]==0){
                    ch[nv]=1;
                    DFS(nv);
                    ch[nv]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        inflearn_07_13 T = new inflearn_07_13();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //정점 수
        m = sc.nextInt(); //간선 수
        graph = new ArrayList<ArrayList<Integer>>(); //인접리스트
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n+1];
        for(int i=0; i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1]=1;
        T.DFS(1);
        System.out.println(answer); //6 출력
    }
}
