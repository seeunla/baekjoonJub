import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = String.valueOf(st.nextToken());
        String m = String.valueOf(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i =n.length()-1; i>=0; i--) {
            sb.append(n.charAt(i));
        }
        int first = Integer.parseInt(sb.toString());
        sb = new StringBuilder();
        for (int i =m.length()-1; i>=0; i--) {
            sb.append(m.charAt(i));
        }
        int second = Integer.parseInt(sb.toString());

        System.out.println(Math.max(first, second));

    }
}