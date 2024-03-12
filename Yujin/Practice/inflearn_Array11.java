package inflearn;

import java.util.Scanner;

public class inflearn_02_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][]arr = new int[n][5];
        for(int i=0;i<n;i++){
            for(int j=0;j<5;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int answer=0, max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                for(int k=0;k<5;k++){
                    if(arr[i][k]==arr[j][k]){
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt>max){
                max=cnt;
                answer=i+1;
            }
        }
        System.out.println(answer);

    }
}
