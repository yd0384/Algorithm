package joon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P1037 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ns = sc.nextInt();
		ArrayList<Integer> n = new ArrayList<Integer>();
		for(int i=0;i<ns;i++){
			n.add(sc.nextInt());
		}
		Collections.sort(n);
		if(n.size()%2==0){
			System.out.println(n.get(0)*n.get(n.size()-1));
		}
		else{
			System.out.println(n.get(n.size()/2)*n.get(n.size()/2));
		}
	}

}
