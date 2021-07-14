

import java.util.Scanner;

public class P2902 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String txt = sc.next();
		String s = "";
		for(int c:txt.toCharArray()){
			if(c>=65&&c<=90){
				s+=(char)c;
			}
		}
		System.out.println(s);
	}

}
