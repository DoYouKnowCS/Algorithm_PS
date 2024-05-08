package inflearn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class inflearn_08_05 {
    static int answer = Integer.MAX_VALUE, n, m;

    public void DFS(int L, int sum, Integer[] arr){ //동전개수, 동전합, 동전종류
        if(sum>m) return;
        if(L>=answer) return;
        if(sum==m){
            answer=Math.min(answer,L);
        }else{
            for(int i=0; i<n; i++){
                DFS(L+1, sum+arr[i], arr);
            }
        }
    }

    public static void main(String[] args) {
        inflearn_08_05 T = new inflearn_08_05();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Integer[] arr = new Integer[n]; //객체형 Integer 배열
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt(); //동전종류
        }
        m = sc.nextInt(); //거스름돈
        Arrays.sort(arr, Collections.reverseOrder()); //객체형 내림차순
        T.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
