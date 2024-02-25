package inflearn;

import java.util.Scanner;

public class inflearn_01_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //알파벳 대문자가 아니면 모두 제거
        String str = sc.nextLine().toUpperCase().replaceAll("[^A-Z]", "");
        String answer = "NO";

        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)) answer="YES";

        System.out.println(answer);

    }
}
