package inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Time implements Comparable<Time>{
    public int start, end;

    Time(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Time o){
        if(this.end == o.end) return this.start-o.start; //끝시간 같으면 시작시간 기준 오름차순 정렬
        return this.end-o.end;//끝시간 기준 오름차순 정렬
    }
}

public class inflearn_09_02 {
    public int solution(ArrayList<Time> arr, int n){
        int cnt=0;
        Collections.sort(arr); //오버라이드 기준 정렬
        int et=0;
        for(Time ob : arr) {
            if (ob.start >= et) {
                cnt++;
                et = ob.end;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        inflearn_09_02 T = new inflearn_09_02();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> arr = new ArrayList<>();

        for(int i=0;i<n;i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr.add(new Time(s, e));
        }
        System.out.println(T.solution(arr, n));

    }
}
