
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<Integer> arrayList = new ArrayList<>(set);
        Collections.sort(arrayList);
        req(0, M, arrayList);
        System.out.print(sb);
    }

    private static void req(int depth, int m, ArrayList<Integer> arrayList) {
        if(depth==m) {
            for(int i=0;i<m;i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0;i<arrayList.size();i++) {
            arr[depth] = arrayList.get(i);
            req(depth+1,m,arrayList);
        }
    }
}
