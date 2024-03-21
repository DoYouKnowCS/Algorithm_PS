package inflearn;

import java.util.*;

public class inflearn_04_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder()); //내림차순 자동정렬
        int answer=-1;

        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                for(int k=j+1;k<N;k++){
                    Tset.add(arr[i]+arr[j]+arr[k]);
                }
            }
        }
        int cnt=0;
        for(int x:Tset){
            cnt++;
            if(cnt==K) answer=x;
            //System.out.println(x);
        }
        System.out.println(answer);
    }
}
