package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class inflearn_02_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i]=sc.nextInt();
        }
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for(int i=1;i<num;i++){
            if(arr[i]>arr[i-1]) answer.add(arr[i]);
        }
        for (int x: answer){
            System.out.print(x + " ");
        }
    }
}
