import java.io.*;
import java.util.*;

public class boj_1342_행운의문자열 {

    static int ans = 0;
    static String S;
    static int[] count;

    /* S.length()만큼 돌면서 순열로 문자열을 배치하는 방식으로 구성하면
    만들어진 문자열에 대한 중복체크, i번째 문자를 사용했는지 여부 체크 등 많은 메모리를 사용해야 해서 MLE가 발생한다.
    따라서 계수정렬을 사용해서 count 배열 하나로 해당 문자를 얼만큼 더 사용할 수 있는지를 판단하여 함수를 구성했다.
     */
    static void solve(int len, int prev) {
        if (len == S.length()) {
            ans++;
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0 && (len == 0 || prev != i)) {
                count[i]--;
                solve(len + 1, i);
                count[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        count = new int[26];

        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i) - 'a']++;
        }

        solve(0, 0);
        System.out.println(ans);
    }
}
