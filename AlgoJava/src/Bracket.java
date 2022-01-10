import java.util.Scanner;
import java.util.Stack;

public class Bracket {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		s=s.replace("()", "2");
		s=s.replace("[]", "3");
		Stack<Integer> st = new Stack<Integer>();
		char[] carr = s.toCharArray();
		char cpre;
		int err=-1;
		for(int i=0;i<carr.length;i++)
		{
			if(carr[i]=='(')
			{
				st.push(-1);
			}
			else if(carr[i]=='[')
			{
				st.push(-2);
			}
			else if(carr[i]=='2')
			{
				st.push(2);
				cpre='2';
			}
			else if(carr[i]=='3')
			{
				st.push(3);
				cpre='3';
			}
			else if(carr[i]==')')
			{
				int n=0;
				int next=0;
				while(n!=-1)
				{
					n=st.pop();
					next=st.peek();
					if(next==-2)
					{
						err=0;
						break;
					}
					else if(next!=-1)
					{
						st.push(st.pop()+n);
						st.push(st.pop()*2);
						st.pop();
					}
					else if(next==-1)
					{
						st.pop();
						st.push(n*2);
					}
				}
				
				break;
			}
			
		}
		System.out.println(st.pop());
		sc.close();
	}
	
}
