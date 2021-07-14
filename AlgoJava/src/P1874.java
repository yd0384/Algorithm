package joon;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class P1874 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean x=true;
		Stack<Integer> s = new Stack<Integer>();
		int n = sc.nextInt();
		int[] arr = new int[n];
		ArrayList<Character> st=new ArrayList<Character>();
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		int i=0;
		int j=1;
		while(i<n){
			if(arr[i]>j){
				s.push(j);
				st.add('+');
				j++;
			}
			else if(arr[i]==j){
				s.push(j);
				st.add('+');
				j++;
				s.pop();
				st.add('-');
				i++;
			}
			else{
				if(s.peek()!=arr[i]){
					x=false;
					break;
				}
				else{
				s.pop();
				st.add('-');
				i++;
				}
			}
		}
		if(!x){
			System.out.println("NO");
		}
		else{
			for(char c:st){
				System.out.println(c);
			}
		}
	}
}
