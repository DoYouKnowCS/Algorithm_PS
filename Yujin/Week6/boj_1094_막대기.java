import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);

       int X = sc.nextInt();
       int a = 64;
       int count = 0;
       
       while(X>0){
           if (a > X){
               a/=2;
           }else{
               X -= a;
               count++;
           }
       }
        System.out.println(count);
    }
}
