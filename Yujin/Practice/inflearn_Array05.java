package inflearn;

import java.util.Scanner;

public class inflearn_02_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] sosu = new int[num+1];
        int answer = 0;

        for(int i=2;i<num+1;i++){
            if(sosu[i]==0){
                answer++;
                for(int j=i;j<num+1;j=j+i) sosu[j]=1;
            }
        }
        System.out.println(answer);
    }
}
