package inflearn;

import java.util.Scanner;

public class inflearn_02_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        int[] answer = new int[num];
        for(int i=0;i<num;i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0;i<num;i++){
            int cnt = 1;
            for(int j=0;j<num;j++){
                if(arr[j]>arr[i]){
                    cnt++;
                }
            }
            answer[i] = cnt;
        }

        for(int x : answer){
            System.out.print(x+" ");
        }
    }
}
