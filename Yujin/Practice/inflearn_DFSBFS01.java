package inflearn;

import java.util.*;

public class inflearn_08_01 {
    static string answer="NO";
    static int n, total=0;
    boolean flag=false;

    public void DFS(int L, int sum, int[] arr){
        if(flag) return;
        if(sum>total/2) return; //합이 반보다 크면 밑에 확인할 필요 없음
        if(L==n){ //부분집합 완성되면
            if((total-sum)==sum){
                answer="YES";
                flag=true;
            }
        }else{ //부분집합 포함시키기
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }

    public static void main(String[] args) {
        inflearn_08_01 T = new inflearn_08_01();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n;i++){
            arr[i]=sc.nextInt();
            total+=arr[i];
        }
        T.DFS(0,0,arr);
        System.out.println(answer);
    }
}
