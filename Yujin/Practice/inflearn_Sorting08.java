package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class inflearn_06_08 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr); //오름차순정렬
        int lt=0, rt=num-1;
        int answer = 0;
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(arr[mid]==m){
                answer=mid+1;
                break;
            }
            if(arr[mid]>m){
                rt=mid-1;
            }else{
                lt=mid+1;
            }
        }
        System.out.println(answer);
    }
}
