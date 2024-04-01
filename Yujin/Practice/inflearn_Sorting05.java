package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class inflearn_06_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i]=sc.nextInt();
        }
        char answer = 'U';
        Arrays.sort(arr); //배열 오름차순 정렬
        for(int i=0;i<num-1;i++){
            if(arr[i]==arr[i+1]) answer = 'D';
        }
        System.out.print(answer);
    }
}
