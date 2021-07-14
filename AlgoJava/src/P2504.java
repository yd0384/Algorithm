

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class P2504 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Stack<Character> s = new Stack<Character>();
		boolean check=true;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='('||str.charAt(i)=='['){
				s.push(str.charAt(i));
			}
			else{
				if(s.isEmpty()){
					check=false;
					break;
				}
				if(str.charAt(i)==')'){
					if(s.peek()=='('){
						s.pop();
					}
					else{
						check=false;
						break;
					}
				}
				else{
					if(s.peek()=='['){
						s.pop();
					}
					else{
						check=false;
						break;
					}
				}
			}	
		}
		if(!s.isEmpty()){
			check=false;
		}
		if(!check){
			System.out.println(0);
		}
		else{
			ArrayList<Character> strings = new ArrayList<Character>(); 
			ArrayList<Integer> nums = new ArrayList<Integer>();
			for(char c:str.toCharArray()){
				strings.add(c);
			}
			for(int i=0;i<strings.size();i++){
				if(strings.get(i)==')'){
					if(strings.get(i-1)=='('){
						strings.remove(i-1);
						strings.remove(i-1);
						strings.add(i-1,'n');
						nums.add(2);
						i-=1;
					}
				}
				if(strings.get(i)==']'){
					if(strings.get(i-1)=='['){
						strings.remove(i-1);
						strings.remove(i-1);
						strings.add(i-1,'n');
						nums.add(3);
						i-=1;
					}
				}
			}
			
			while(strings.size()>1){
				int nc=0;
				for(int i=0;i<strings.size();i++){
					if(strings.get(i)=='n'){
						
						if(i>0&&strings.get(i-1)=='n'){
							int tmp=nums.get(nc)+nums.get(nc-1);
							nums.set(nc-1, tmp);
							nums.remove(nc);
							strings.remove(i);
							i--;
						}
						else{
						nc++;
						}
					}
					else if(strings.get(i)==')'){
						if(strings.get(i-2)=='('||strings.get(i-1)=='n'){
							strings.remove(i-2);
							strings.remove(i-1);
							nums.set(nc-1, nums.get(nc-1)*2);
							i=i-1;
						}
					}
					else if(strings.get(i)==']'){
						if(strings.get(i-2)=='['||strings.get(i-1)=='n'){
							strings.remove(i-2);
							strings.remove(i-1);
							nums.set(nc-1, nums.get(nc-1)*3);
							i=i-1;
						}
					}
				}
			}
			for(int i:nums){
				System.out.println(i);
			}
		}
	}
}
