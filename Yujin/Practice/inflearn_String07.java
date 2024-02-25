package inflearn;

import java.util.Scanner;

public class inflearn_01_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase();
        String answer = "YES";

        for(int i=0; i<(str.length()/2);i++){
            if(str.charAt(i) != str.charAt(str.length()-i-1)) {
                answer = "NO";
                break;
            }
        }
        System.out.println(answer);

        //StringBuilder사용
        //String tmp = new StringBuilder(str).reverse().toString();
        //if(str.equalsIgnoreCase(tmp)) System.out.println(answer);
    }
}
