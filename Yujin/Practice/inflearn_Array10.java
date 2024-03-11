package inflearn;

import java.util.Scanner;

public class inflearn_02_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); //격자판 수
        int[][] arr = new int[num+2][num+2];
        for(int i=1; i<num+1;i++){
            for(int j=1; j<num+1;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int center, answer=0;
        for(int i=1; i<num+1;i++){
            for(int j=1; j<num+1;j++) {
                center=arr[i][j];
                if(arr[i][j]>arr[i][j-1] && arr[i][j]>arr[i-1][j]
                && arr[i][j]>arr[i][j+1] && arr[i][j]>arr[i+1][j]){
                    answer++;
                }
            }
        }

        System.out.print(answer);
    }
}
