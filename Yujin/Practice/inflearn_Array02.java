package inflearn;

import java.util.Scanner;

public class inflearn_02_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); //몇명
        int[] height = new int[num];

        for(int i=0;i<num;i++){
            height[i]=sc.nextInt();
        }
        int max = height[0];
        int answer = 1;
        for(int i=1;i<num;i++){
            if(height[i]>max) {
                max = height[i];
                answer++;
            }
        }
        System.out.println(answer);
    }
}
