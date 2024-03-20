package inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class inflearn_04_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        char answer=' ';
        HashMap<Character, Integer> map = new HashMap<>();

        for(char x: str.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        // System.out.println(map.containsKey('A')); //A키 있는지
        // System.out.println(map.size()); //전체크기
        // System.out.println(map.remove('A')); //A키 삭제

        int max = Integer.MIN_VALUE;
        for(char key: map.keySet()){ //존재하는 키 모두 돌기
            //System.out.println(key + " " + map.get(key)); // x랑 value출력
            if(map.get(key)>max){
                max = map.get(key);
                answer=key;
            }
        }

        System.out.println(answer);
    }
}
