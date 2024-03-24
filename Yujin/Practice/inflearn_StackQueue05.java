package inflearn;

import java.util.*;

public class inflearn_05_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> stack = new Stack<>();
        int answer=0, stick=0;
        boolean flag = true;

        for(char x: str.toCharArray()){
            if(x==')') {
                if(stack.peek()=='(' && flag){//레이저
                    stick--;
                    answer+=stick;
                    flag=false;
                }
                else if(stack.peek()=='(' && !flag){//레이저
                    answer+=1;
                    stick--;
                }
                stack.pop();
            }
            else if (x=='(') {
                flag = true;
                stick++;
                stack.push(x);
            }
        }

        System.out.println(answer);
    }
}
