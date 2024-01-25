package inflearn;

import java.util.Scanner;

public class inflearn_01_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        char c = scan.next().charAt(0); //하나 받아오기
        int answer = 0;

        str = str.toUpperCase(); //모두 대문자로 만들기
        c = Character.toUpperCase(c); //받는 문자도 대문자로

        for(int i=0; i<str.length();i++){
            if(str.charAt(i)==c){
                answer++;
            }
        }
        /*
        for(char x : str.toCharArray()){ //문자열을 문자배열로 만들기
        if(x==c){
            answer++;
            }
        }
        */
        System.out.println(answer);

    }
}
