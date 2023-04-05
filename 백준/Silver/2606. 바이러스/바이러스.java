import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] dist = new int[n][n];

        for( int i = 0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dist[v-1][w-1] = 1;
            dist[w-1][v-1] = 1;
        }

        for (int k=0; k<n; k++) {
            for (int i =0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if(i==j) continue;
                    if (dist[i][k] == 1 && dist[k][j] ==1 ){
                        dist[i][j] = 1;
                    }
                }
            }
        }

        int cnt =0;
        for (int i=1; i<n; i++) {
            if (dist[0][i] ==1 ) cnt++;
        }

        System.out.println(cnt);
    }
}
