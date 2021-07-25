import java.math.BigInteger;
import java.util.Scanner;

public class BJ15829_Hashing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int L = Integer.parseInt(sc.nextLine());
		BigInteger h = new BigInteger("0");
		BigInteger ri =new BigInteger("1");
		BigInteger M =new BigInteger("1234567891");
		BigInteger r =new BigInteger("31");
		char[] ca = sc.nextLine().toCharArray();
		for(int j=0;j<L;j++) {
			h = h.add(new BigInteger(Integer.toString((int)ca[j]-(int)'a'+1)).multiply(ri)).mod(M);
			ri=ri.multiply(r);
		}
		System.out.println(h);
		sc.close();
	}

}
