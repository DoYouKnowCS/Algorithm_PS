package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
    int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class inflearn_08_14 {
    static int n, answer=0;
    static int[] dx = {-1,-1,0,1,1,1,0,-1}; //시계방향으로 돌기
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    Queue<Point> queue = new LinkedList<>();

    public void BFS(int x, int y, int[][] board){
        queue.add( new Point3(x,y));
        while(!queue.isEmpty()){
            Point pos = queue.poll();
            for(int i=0;i<8;i++){
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<n&&board[nx][ny]==1){
                    board[nx][ny]=0;
                    queue.add(new Point(nx,ny));
                }
            }
        }
    }

    public void solution(int[][] board){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    answer++;
                    board[i][j]=0;
                    BFS(i,j,board);
                }
            }
        }
    }

    public static void main(String[] args) {
        inflearn_08_14 T = new inflearn_08_14();
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        T.solution(arr);
        System.out.println(answer);
    }

}
