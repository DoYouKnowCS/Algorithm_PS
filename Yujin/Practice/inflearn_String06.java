package inflearn;

import java.util.Scanner;

public class inflearn_01_06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        String answer="";

        for(int i=0;i<str.length();i++){
            //System.out.println(str.charAt(i) + " "+i+" "+str.indexOf(str.charAt(i)));
            //indexOf()는 해당 문자가 제일 처음 발견된 위치
            if (str.indexOf(str.charAt(i))==i)
                answer +=str.charAt(i); //위치 같을 때만 answer에 추가
        }

        System.out.println(answer);

    }
}
