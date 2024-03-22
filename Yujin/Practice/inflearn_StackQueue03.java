package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class inflearn_05_03 {
    public int solution(int[][] arr, int[] moves){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int pos:moves){
            for(int i=0; i<arr.length; i++){
                if(arr[i][pos-1]!=0){
                    int tmp = arr[i][pos-1];
                    arr[i][pos-1]=0;
                    if(!stack.isEmpty() && tmp==stack.peek()){ //뽑지않고 확인만
                        answer +=2;
                        stack.pop();
                    }
                    else stack.push(tmp);
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        inflearn_05_03 T = new inflearn_05_03();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] arr = new int[num][num];
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                arr[i][j]=sc.nextInt();
            }
        }

        int M = sc.nextInt();
        int[] moves = new int[M];
        for(int i=0;i<M;i++){
            moves[i]=sc.nextInt();
        }
        System.out.println(T.solution(arr, moves));

    }
}
