package inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class inflearn_06_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i]=sc.nextInt();
        }
        int[] tmp = new int[num]; //int[] tmp = arr.clone() 으로 깊은 복사해도 됨
        for(int i=0;i<num;i++){
            tmp[i]=arr[i];
        }
        Arrays.sort(tmp);
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0;i<num;i++){
            if(arr[i]!=tmp[i]){
                answer.add(i+1);
            }
        }
        for(int x: answer){
            System.out.print(x + " ");
        }
    }
}
