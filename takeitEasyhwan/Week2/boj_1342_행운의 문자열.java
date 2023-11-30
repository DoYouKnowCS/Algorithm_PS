import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int sum = 0;
    static ArrayList<Integer> arrayList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<line.length();i++) {
            if(map.containsKey(line.charAt(i)))
                map.put(line.charAt(i),map.get(line.charAt(i))+1);
            else
                map.put(line.charAt(i),1);
        }
        arrayList = new ArrayList<>(map.values());
        for(int i=0;i<arrayList.size();i++) {
            arrayList.set(i,arrayList.get(i)-1);
            req(i, 1, line.length());
            arrayList.set(i,arrayList.get(i)+1);
        }
        System.out.println(sum);
    }
    private static void req(int lastIndex, int depth, int maxDepth) {
        if(depth == maxDepth) {
            sum++;
            return;
        }
        for(int i=0;i<arrayList.size();i++) {
            if(arrayList.get(i)>0 && lastIndex!=i) {
                arrayList.set(i,arrayList.get(i)-1);
                req(i,depth+1, maxDepth);
                arrayList.set(i,arrayList.get(i)+1);
            }
        }
    }
}
