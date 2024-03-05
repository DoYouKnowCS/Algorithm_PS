package inflearn;

import java.util.Scanner;

public class inflearn_02_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] a_info = new int[num];
        for(int i=0; i<num;i++){
            a_info[i]=sc.nextInt();
        }
        int[] b_info = new int[num];
        for(int i=0; i<num;i++){
            b_info[i]=sc.nextInt();
        }
        String answer = "";
        for(int i=0; i<num; i++)
        {
            if (a_info[i] == b_info[i]) answer += "D\n";
            else if(a_info[i] == 1 && b_info[i] == 3) answer += "A\n";
            else if(a_info[i] == 2 && b_info[i] == 1) answer += "A\n";
            else if(a_info[i] == 3 && b_info[i] == 2) answer += "A\n";
            else answer += "B\n";
        }

        System.out.println(answer);
    }
}
