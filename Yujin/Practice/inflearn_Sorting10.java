package inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class inflearn_06_10 {
    public static int count(int[] arr, int dist){
        int cnt = 1, ep=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-ep>=dist){
                cnt++;
                ep=arr[i];
            }
        }
        return  cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int lt=1, rt=arr[n-1];
        int answer=0;
        Arrays.sort(arr);
        while(lt<=rt){
            int mid = (lt+rt)/2;
            if(count(arr,mid)>=c){
                answer=mid;
                lt=mid+1;
            }
            else{
                rt=mid-1;
            }
        }
        System.out.println(answer);
    }
}
