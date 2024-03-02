package inflearn;

import java.util.Scanner;

public class inflearn_01_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt(); //몇개인지
        String str = sc.next(); //문자열
        String answer = "";

        for(int i=0;i<count;i++){
            String tmp = str.substring(0,7).replace('#','1').replace('*','0'); //일곱개씩 뽑아내기
            int num = Integer.parseInt(tmp,2); //정수형ㅇ로 바꾸기
            answer += (char)num; //num을 문자로
            str = str.substring(7);
        }

        System.out.println(answer);
    }
}
