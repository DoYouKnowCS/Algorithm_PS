package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class inflearn_05_04 {
    public  static int solution(String str){
        int answer=0;
        Stack<Integer> stack = new Stack<>();
        for(char x: str.toCharArray()){
            if(Character.isDigit(x)) stack.push(x-48); //문자형에서는 아스키넘버빼주기
            else{
                int rt = stack.pop();
                int lt = stack.pop();
                if(x=='+') stack.push(lt+rt);
                else if(x=='-') stack.push(lt-rt);
                else if(x=='*') stack.push(lt*rt);
                else if(x=='/') stack.push(lt/rt);
            }
        }
        answer=stack.get(0);

        return answer;
    }

    public static void main(String[] args){
        inflearn_05_04 T = new inflearn_05_04();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
