package joon;

import java.util.Scanner;
import java.util.Stack;

public class RemoveB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str=sc.next();
		char[] strC=str.toCharArray();
		Stack<Character> st=new Stack<Character>();
		int depth=0;
		for(char a:strC){
			if(depth<0){
				System.out.println(0);
				System.exit(0);
			}
			if(a=='('||a=='['){
				st.push(a);
				depth++;
			}
			else if(a==')'){
				st.pop();
				depth--;
			}
			else if(a==']'){
				st.pop();
				depth--;
			}
		}
	}

}
