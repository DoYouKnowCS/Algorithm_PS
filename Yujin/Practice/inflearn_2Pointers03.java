package inflearn;

import java.util.Scanner;

public class inflearn_03_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int answer = 0, sum=0;

        int[] arr = new int[n];
        for(int i=0; i<n ; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<k ; i++){
            sum +=arr[i];
        }

        answer=sum;
        for(int i=k; i<n ; i++){
            sum +=(arr[i]-arr[i-k]);
            answer=Math.max(answer, sum);
        }

        System.out.println(answer);

    }
}
