package inflearn;

import java.util.Scanner;

public class inflearn_06_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int num = sc.nextInt();
        int[] arr = new int[num];
        for(int i=0; i<num;i++){
            arr[i] = sc.nextInt();
        }
        int[] cache = new int[s];

        for(int x: arr){
            int pos=-1;
            for(int i=0; i<s;i++){
                if(x==cache[i]) pos = i;
            }
            if(pos==-1){ //hit 아닐때
                for(int i=s-1;i>=1;i--){
                    cache[i]=cache[i-1];
                }
            }
            else{ //hit 일때
                for(int i=pos;i>=1;i--){
                    cache[i]=cache[i-1];
                }
            }
            cache[0]=x;
        }

        for(int x: cache){
            System.out.print(x + " ");
        }
    }
}
