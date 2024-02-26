package inflearn;

import java.util.Scanner;

public class inflearn_01_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        //ASCII 넘버로 풀기
        /*int answer = 0;
        for(char x : str.toCharArray()){
            if(x>=48 && x<=57) answer = (answer*10 + (x-48));
        }

        System.out.println(answer);*/

        //Character.isDigit사용
        String answer = "";
        for(char x : str.toCharArray()){
            if(Character.isDigit(x)) answer+=x; //숫자면
        }
        System.out.println(Integer.parseInt(answer)); //0208을 int형 정수 208로
    }
}
