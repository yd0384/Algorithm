package joon;

import java.util.Scanner;
import java.util.Stack;

public class Script {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Stack<Character> st = new Stack<Character>();
		String str1 = sc.nextLine();
		str1=str1.replaceAll(" ", "");
		str1=str1.replaceAll("\\+", "\\.");
		String[] strs = str1.split("\\."); 
	
		int bef=0;
		String ore="";
		String ret = "";
		for(String s: strs)
		{
			int[] d=new int[s.length()];
			int de=0;
			for(int i=0;i<s.length();i++)
			{
				switch(s.charAt(i))
				{
				case '(':
					st.push('(');
					de++;
					d[i]=de;
					break;
				case ')':
					st.pop();
					de--;
					d[i]=de;
				}
			}
			int max=0;
			for(int i:d)
			{
				if(i>max)
				{
					max=i;
				}
			}
			if(bef!=0)
			{
				if(bef==max)
				{
					ore=ore+s;
				}
				else if(bef>max)
				{
					char[] a = ore.toCharArray();
					a[a.length-1]=' ';
					String x =new String(a).replaceAll(" ", ""); 
					ore = x+s+')';
					max = bef;
				}
				else
				{
					char []a =s.toCharArray();
					a[0]=' ';
					String x = new String(a).replaceAll(" ", "");
					ore = '('+ore+x;
				}
			}
			else
			{
				ore=s;
			}
			bef=max;
		}
		System.out.println(ore);
	}
}
