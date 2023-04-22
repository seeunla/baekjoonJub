import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = String.valueOf(br.readLine());
        String[] arr = s.split(" ");
        int ans = 0;
        for (int i =0; i<arr.length; i++) {
            if (arr[i].length() <1) {
                continue;
            } else ans++;
        }
        System.out.println(ans);
    }
}
