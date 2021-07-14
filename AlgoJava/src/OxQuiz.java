

import java.util.Scanner;
import java.util.Stack;
public class OxQuiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t=sc.nextInt();
		String[] strs=new String[t];
		int[] nums=new int[t];
		for(int i=0;i<t;i++){
			strs[i]=sc.next();
		}
		for(int i=0;i<t;i++){
			Stack<Integer> st=new Stack<Integer>();
			nums[i]=0;
			for(int j=0;j<strs[i].length();j++){
				if(j==0){
					if(strs[i].charAt(j)=='O')st.push(1);
					else{
						st.push(0);
					}
					continue;
				}
				if(strs[i].charAt(j)=='O'){
					st.push(st.peek()+1);
				}
				else{
					st.push(0);
				}
			}
			for(int j=0;j<strs[i].length();j++){
				nums[i]+=st.pop();
			}
		}
		for(int i=0;i<t;i++){
			System.out.println(nums[i]);
		}
	}

}
