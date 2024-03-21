package inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class inflearn_04_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        String T = sc.next();
        int answer=0;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(char x: T.toCharArray()){
            map2.put(x, map2.getOrDefault(x,0)+1);
        }
        for(int i=0;i<T.length()-1;i++){
            map1.put(S.charAt(i), map1.getOrDefault(S.charAt(i),0)+1);
        }
        int lt=0;
        for(int rt=T.length()-1; rt<S.length();rt++){
            map1.put(S.charAt(rt), map1.getOrDefault(S.charAt(rt),0)+1);
            if(map1.equals(map2)) answer++;
            map1.put(S.charAt(lt), map1.get(S.charAt(lt))-1);
            if(map1.get(S.charAt(lt))==0)map1.remove(S.charAt(lt));
            lt++;
        }

        System.out.println(answer);
    }
}
