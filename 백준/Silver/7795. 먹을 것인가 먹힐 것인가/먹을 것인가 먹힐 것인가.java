import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int index = 0;
        while (index != t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] lives1 = new int[n];
            int[] lives2 = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < lives1.length; i++) {
                lives1[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < lives2.length; i++) {
                lives2[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(lives1);
            Arrays.sort(lives2);
            int answer = 0;
            for (int value : lives1) {
                for (int integer : lives2) {
                    if (value > integer) {
                        answer++;
                    } else break;
                }
            }
            System.out.println(answer);
            index++;
        }
        br.close();
    }
}
