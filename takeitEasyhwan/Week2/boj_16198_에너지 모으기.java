import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int maxSum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> linkedList = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) {
            linkedList.add(Integer.parseInt(st.nextToken()));
        }
        req(0,linkedList);
        System.out.println(maxSum);
    }
    private static void req(int tempSum, LinkedList<Integer> linkedList) {
        if(linkedList.size()==2) {
            maxSum = Math.max(maxSum,tempSum);
            return;
        }
        for(int i=1;i<linkedList.size()-1;i++) {
            int exceptNum = linkedList.get(i);
            linkedList.remove(i);
            req(linkedList.get(i-1) * linkedList.get(i) + tempSum,linkedList);
            linkedList.add(i,exceptNum);
        }
    }
}
