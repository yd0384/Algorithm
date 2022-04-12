import java.util.*;
import java.io.*;
import java.math.*;

public class BJ2407_조합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BigInteger answer = new BigInteger("1");
        for (int i = n; i > n - m; i--) {
            answer = answer.multiply(new BigInteger(Integer.toString(i)));
        }   
        for (int i = m; i > 1; i--) {
            answer = answer.divide(new BigInteger(Integer.toString(i)));
        }
        System.out.println(answer);
    }
}
