package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class inflearn_05_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String subject = sc.next();
        String answer = "YES";
        Queue<Character> Q = new LinkedList<>();
        for(char x: str.toCharArray()) Q.offer(x);
        for(char x: subject.toCharArray()){
            if(Q.contains(x)){
                if(x!=Q.poll()){
                    answer = "NO";
                    break;
                }
            }
        }
        if(!Q.isEmpty()) answer = "NO";

        System.out.println(answer);
    }
}
