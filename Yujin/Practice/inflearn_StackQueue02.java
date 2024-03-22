package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class inflearn_05_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Stack<Character> stack = new Stack<>();
        for(char x: str.toCharArray()){
            if(x==')') {
                while(stack.pop()!='(');
            }
            else stack.push(x);
        }

        for(char x: stack){
            System.out.print(x);
        }
    }
}
