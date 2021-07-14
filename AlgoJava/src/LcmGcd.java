

import java.util.Scanner;

public class LcmGcd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int m=(a>b)?a:b;
		int n=(a>b)?b:a;
		int r=m%n;
		int gcd;
		if(r==0){
			gcd=n;
		}
		else{
			while(n!=0){
				r=m%n;
				m=n;
				n=r;
			}
			gcd=m;
		}
		int lcm=(a*b)/gcd;
		System.out.println(gcd+" "+lcm);
	}

}
