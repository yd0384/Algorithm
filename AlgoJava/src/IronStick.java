

import java.util.Scanner;
import java.util.Stack;


public class IronStick {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Stack<Integer> st = new Stack<Integer>();
		int rs = 0;
		char preC=' ';
		char[] carr=str.toCharArray();
		for(char c : carr)
		{
			switch(c)
			{
			case '(':
				st.push(0);
				break;
			case ')':
				if(preC==')')
				{
					if(!st.isEmpty())
					{
						rs++;
						st.pop();
					}
				}
				else
				{
					if(!st.isEmpty())
					{
						st.pop();
						rs += st.size();
					}
				}
			break;	
			}
			preC=c;
		}
		System.out.println(rs);
	}

}
