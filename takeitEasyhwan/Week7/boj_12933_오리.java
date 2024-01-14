import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int quackArr[] = new int[5];
        boolean errorFlag = false;
        String line = br.readLine();
        ArrayList<Character> arrayList = new ArrayList<>();
        for(int i=0;i<line.length();i++) {
            if(arrayList.isEmpty()) {
                if(line.charAt(i)=='q')
                    arrayList.add('q');
                else
                    errorFlag = true;
            }
            else if(line.charAt(i)=='q') {
                boolean checkEndQuack = false;
                for(int j=0;j<arrayList.size();j++) {
                    if(arrayList.get(j)=='k') {
                        arrayList.set(j,'q');
                        checkEndQuack=true;
                        break;
                    }
                }
                if(!checkEndQuack) {
                    arrayList.add('q');
                }
            }
            else if(line.charAt(i)=='u') {
                boolean checkEndQuack = false;
                for(int j=0;j<arrayList.size();j++) {
                    if(arrayList.get(j)=='q') {
                        arrayList.set(j,'u');
                        checkEndQuack=true;
                        break;
                    }
                }
                if(!checkEndQuack) {
                    errorFlag=true;
                    break;
                }
            }
            else if(line.charAt(i)=='a') {
                boolean checkEndQuack = false;
                for(int j=0;j<arrayList.size();j++) {
                    if(arrayList.get(j)=='u') {
                        arrayList.set(j,'a');
                        checkEndQuack=true;
                        break;
                    }
                }
                if(!checkEndQuack) {
                    errorFlag=true;
                    break;
                }
            }
            else if(line.charAt(i)=='c') {
                boolean checkEndQuack = false;
                for(int j=0;j<arrayList.size();j++) {
                    if(arrayList.get(j)=='a') {
                        arrayList.set(j,'c');
                        checkEndQuack=true;
                        break;
                    }
                }
                if(!checkEndQuack) {
                    errorFlag=true;
                    break;
                }
            }
            else if(line.charAt(i)=='k') {
                boolean checkEndQuack = false;
                for(int j=0;j<arrayList.size();j++) {
                    if(arrayList.get(j)=='c') {
                        arrayList.set(j,'k');
                        checkEndQuack=true;
                        break;
                    }
                }
                if(!checkEndQuack) {
                    errorFlag=true;
                    break;
                }
            }
        }
        if(errorFlag || arrayList.contains('q') || arrayList.contains('u') || arrayList.contains('a') || arrayList.contains('c'))
            System.out.println(-1);
        else
            System.out.println(arrayList.size());
    }
}
