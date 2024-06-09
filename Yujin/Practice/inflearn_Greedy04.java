package inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Lecture implements Comparable<Lecture>{
    public int day, money;

    Lecture(int money, int day){
        this.money = money;
        this.day = day;
    }

    @Override
    public int compareTo(Lecture o){
        return o.day-this.day; //날짜 기준 내림차순 정렬
    }
}

public class inflearn_09_04 {
    static int n, max=Integer.MIN_VALUE;
    public int solution(ArrayList<Lecture> arr){
        int answer=0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());//제일 큰 값 꺼내기
        Collections.sort(arr);
        int j=0;
        for(int i=max;i>=1;i--){
            for(;j<n;j++){
                if(arr.get(j).day < i) break;
                pQ.offer(arr.get(j).money);
            }
            if(!pQ.isEmpty()) answer+=pQ.poll();
        }
        return answer;
    }

    public static void main(String[] args) {
        inflearn_09_04 T = new inflearn_09_04();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        ArrayList<Lecture> arr = new ArrayList<>();

        for(int i=0;i<n;i++){
            int m = sc.nextInt();
            int d = sc.nextInt();
            arr.add(new Lecture(m, d));
            if(d>max) max = d; //제일큰 날짜
        }

        System.out.println(T.solution(arr));
    }
}
