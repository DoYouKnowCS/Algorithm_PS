import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int sum=0;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> nodeList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        nodeList = new ArrayList<>();
        for(int i=0;i<=N;i++) {
            nodeList.add(new ArrayList<>());
        }
        StringTokenizer st;

        for(int i=0;i<N-1;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodeList.get(a).add(b);
            nodeList.get(b).add(a);
        }
        visited[1] = true;
        dfs(1,0);
        System.out.println(sum%2==0?"No":"Yes");
    }

    private static void dfs(int node, int depth) {

        for(int i=0;i<nodeList.get(node).size();i++) {
            int nextNode = nodeList.get(node).get(i);
            if(!visited[nextNode]) {
                visited[nextNode] = true;
                dfs(nextNode,depth+1);
                visited[nextNode] = false;
            }
        }
        if(nodeList.get(node).size() == 1 && node != 1) {
            sum+=depth;
        }
    }
}
