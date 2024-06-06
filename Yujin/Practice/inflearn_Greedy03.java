package inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Sequence implements Comparable<Sequence>{
    public int time;
    public char when;

    Sequence(int time, char when){
        this.time = time;
        this.when = when;
    }
    @Override
    public int compareTo(Sequence o){
        if(this.time == o.time) return this.when-o.when; //시간 같으면 when 기준 오름차순 정렬
        return this.time-o.time;//시간 기준 오름차순 정렬
    }

}

public class inflearn_09_03 {
    public int solution(ArrayList<Sequence> arr){
        int answer = Integer.MIN_VALUE;
        Collections.sort(arr); //오버라이드 기준 정렬
        int cnt=0;

        for(Sequence ob : arr) {
            if (ob.when == 's') cnt++;
            else cnt--;
            answer=Math.max(answer,cnt);
        }
        return answer;
    }

    public static void main(String[] args) {
        inflearn_09_03 T = new inflearn_09_03();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList<Sequence> arr = new ArrayList<>();

        for(int i=0;i<num;i++){
            int st = sc.nextInt();
            int et = sc.nextInt();
            arr.add(new Sequence(st,'s'));
            arr.add(new Sequence(et,'e'));
        }
        System.out.println(T.solution(arr));
    }
}
