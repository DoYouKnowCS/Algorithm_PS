package inflearn;

import java.util.Scanner;

public class inflearn_01_04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] str = new String[n];
        for(int i=0; i<n; i++){
            str[i]=scan.next();
        }
        for(int i=0; i<n; i++) {
            String tmp = new StringBuilder(str[i]).reverse().toString();
            System.out.println(tmp);
        }
    }
}
            
