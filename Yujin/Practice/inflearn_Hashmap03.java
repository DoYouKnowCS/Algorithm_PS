package inflearn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class inflearn_04_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N;i++){
            arr[i]=sc.nextInt();
        }
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<K-1;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1 );
        }
        int lt=0;
        for(int rt=K-1;rt<N;rt++){
            map.put(arr[rt],map.getOrDefault(arr[rt],0)+1);
            answer.add(map.size());
            map.put(arr[lt],map.get(arr[lt])-1);
            if(map.get(arr[lt])==0)map.remove(arr[lt]);
            lt++;
        }

        for(int i:answer){
            System.out.print(i+" ");
        }

    }


  /*public static void main(String[] args) { //런타임오류
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int num = N-K+1;
        int[] arr = new int[N];
        for(int i=0; i<N;i++){
            arr[i]=sc.nextInt();
        }
        int[] answer = new int[num];

        for(int i=0;i<num;i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j=i;j<K+i;j++){
                map.put(arr[j],map.getOrDefault(arr[j],0)+1 );
            }
            answer[i] = map.size();
        }

        for(int i:answer){
            System.out.print(i+" ");
        }

    }*/
}
