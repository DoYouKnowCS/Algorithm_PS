import java.util.Scanner;
  
public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    String answer = "";
    int m = 0;
    String[] s = str.split(" ");
    for(String x : s){
      int len = x.length();
      if(len>m){
        m=len;
        answer=x;
      }
    }
    System.out.print(answer);
    
    return ;
  }
}
