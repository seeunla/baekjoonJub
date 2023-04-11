import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] arr = s.split("");
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r",
        "s","t","u","v","w","x","y","z"};

        int[] result = new int[26];
        for (int i=0; i< result.length; i++) {
            result[i] = -1;
        }

        for (int i =0; i<arr.length; i++) {
            String a = arr[i];
            for (int j=0; j<alphabet.length; j++) {
                if (a.equals(alphabet[j])&& result[j] == -1) {
                    result[j] = i;
                }
            }
        }
       for (int i : result) {
            System.out.print(i + " ");
        }
    }
}