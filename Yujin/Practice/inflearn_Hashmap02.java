package inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class inflearn_04_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        String answer = "YES";
        HashMap<Character, Integer> map = new HashMap<>();

        for(char x: str1.toCharArray()){
            map.put(x, map.getOrDefault(x,0)+1);

        }
        for(char x: str2.toCharArray()){
            if(!map.containsKey(x) || map.get(x)==0) answer="NO";
            map.put(x, map.getOrDefault(x,0)-1);
        }

        System.out.println(answer);
    }
}
