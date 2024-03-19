package inflearn;

import java.util.Scanner;

public class inflearn_03_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0, sum=0;
        int num = n/2 + 1;

        int[] arr = new int[num];
        for(int i=0; i<num ; i++){
            arr[i] = i+1;
        }
        int lt=0;

        for(int rt=0; rt<num; rt++){
            sum +=arr[rt];
            if(sum==n) answer++;
            while(sum>=n){
                sum-=arr[lt++];
                if(sum==n) answer++;
            }
        }

        System.out.println(answer);

    }
}


/////////2포인터 대신 수학으로 풀기
