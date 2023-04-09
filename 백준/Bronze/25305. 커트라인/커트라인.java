import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int[] students = new int[A];
        for (int i=0; i<A; i++) {
            students[i] = sc.nextInt();
        }
        Arrays.sort(students);

        System.out.println(students[students.length - B]);
    }
}
