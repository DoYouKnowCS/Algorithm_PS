package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class inflearn_02_06 {
    public static boolean isPrime(int num){
        if(num==1) return false;
        for(int i=2;i<num;i++){
            if(num%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] num = new int[N];
        String[] reverse = new String[N];
        for(int i=0;i<N;i++){
            num[i] = sc.nextInt();
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<N; i++) {
            int tmp = num[i];
            int res = 0;
            while(tmp>0){
                int t = tmp%10;
                res=res*10 +t;
                tmp=tmp/10;
            }
            if(isPrime(res)) answer.add(res);
        }
        for(int x: answer){
            System.out.print(x+" ");
        }
    }

}
