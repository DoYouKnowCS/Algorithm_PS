package inflearn;

import java.util.Scanner;

public class inflearn_06_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=1;i<num;i++){ //삽입정렬은 i=1부터
            int tmp = arr[i], j; //j 여기서 선언
            for(j=i-1;j>=0;j--){
                if(arr[j]>tmp) arr[j+1]=arr[j];
                else break;
            }
            arr[j+1]=tmp; //j 사용
        }

        for(int x: arr){
            System.out.print(x +" ");
        }

    }
}
