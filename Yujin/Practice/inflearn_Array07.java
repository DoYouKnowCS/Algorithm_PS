package inflearn;

import java.util.Scanner;

public class inflearn_02_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] res = new int[num];
        for(int i=0;i<num;i++){
            res[i] = sc.nextInt();
        }
        int count = 1;
        int sum = 0;
        for(int i=0;i<num;i++){
            if(res[i]==0){
                count=1;
            }else{
                if(count==1){
                    sum += 1;
                }else{
                    sum += count;
                }
                count++;
            }
        }

        System.out.println(sum);
    }
}
