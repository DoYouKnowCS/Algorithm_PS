package inflearn;

import java.util.Scanner;

public class inflearn_01_05 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        String answer;
        char[] s = str.toCharArray(); //문자배열로만들기
        int lt=0, rt=str.length()-1;

        while (lt<rt){
            if(!Character.isAlphabetic(s[lt])) lt++;
            else if (!Character.isAlphabetic(s[rt])) rt--;
            else{
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(s);

        System.out.println(answer);
    }
}
