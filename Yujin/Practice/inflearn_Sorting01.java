package inflearn;

import java.util.Scanner;

public class inflearn_06_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0;i<num-1;i++){
            int idx=i;//인덱스 설정
            for(int j=i+1;j<num;j++){
                if(arr[j]<arr[idx]) idx=j;
            }
            int tmp=arr[i]; //정렬
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }

        for(int x:arr){
            System.out.print(x + " ");
        }
    }
}
