import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String Alpha = br.readLine();
        int routine = N;
        for(int i=1;i<N;i++) {
            boolean check = false;
            for(int j=i;j<N;j++) {
                if(Alpha.charAt(j-i)!=Alpha.charAt(j)) {
                    check = true;
                    break;
                }
            }
            if(!check) {
                routine = i;
                break;
            }
        }
        System.out.println((N-1)/routine+1);
    }
}
