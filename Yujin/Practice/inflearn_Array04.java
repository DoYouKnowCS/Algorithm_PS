package inflearn;

import java.util.Scanner;

public class inflearn_02_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] answer = new int[num];
        int start = 1;
        answer[0] = start;
        answer[1] = start;

        for(int i=1; i< num-1;i++){
            answer[i+1] = answer[i] + answer[i-1];
        }

        for(int x: answer){
            System.out.print(x + " ");
        }
    }
}
