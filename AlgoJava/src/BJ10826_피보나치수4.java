import java.math.BigInteger;
import java.util.*;
public class BJ10826_피보나치수4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<BigInteger> dp = new ArrayList<>();
        dp.add(new BigInteger("0"));
        dp.add(new BigInteger("1"));
        for(int i=2; i<=n; i++){
            dp.add(dp.get(i-2).add(dp.get(i-1)));
        }
        System.out.println(dp.get(n));
        sc.close();
    }
}
