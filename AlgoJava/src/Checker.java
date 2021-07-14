package joon;

import java.util.Scanner;
import java.util.Stack;

public class Checker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int count=n;
		String[] strs=new String[n]; 
		for(int i=0;i<n;i++){
			strs[i]=sc.next();
		}
		for(String a:strs){
			Stack<Character> st=new Stack<Character>();
			boolean[] b=new boolean[26];
			for(int i=0;i<26;i++){
				b[i]=false;
			}
			for(int i=0;i<a.length();i++){
				if(!st.isEmpty()){
					if(st.peek()==a.charAt(i)){
						continue;
					}
					else{
						st.push(a.charAt(i));
					}
				}
				else{
					st.push(a.charAt(i));
				}
			}
			while(!st.isEmpty()){
				if(b[(int)st.peek()-97]){
					count--;
					break;
				}
				else{
					b[(int)st.pop()-97]=true;
				}
			}
		}
		System.out.println(count);
	}

}
