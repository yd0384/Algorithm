import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;
public class BJ4949_균형잡힌세상 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> results = new ArrayList<String>();
		for(String line = sc.nextLine(); !line.equals(".");line = sc.nextLine()) {
			Stack<Character> stack = new Stack<Character>();
			try {
				for(char c:line.toCharArray()) {
					if(c=='.') {
						if(!stack.isEmpty())
							throw new EmptyStackException();
					}
					else if(c=='(') {
						stack.push(c);
					}
					else if(c=='[') {
						stack.push(c);
					}
					else if(c==']') {
						if(stack.pop()!='[') {
							throw new EmptyStackException();
						}
					}
					else if(c==')') {
						if(stack.pop()!='(') {
							throw new EmptyStackException();
						}
					}
				}
				results.add("yes");
				continue;
			}catch(EmptyStackException e) {
				results.add("no");
			}
			
		}
		for(String r:results) {
			System.out.println(r);
		}
		sc.close();
	}

}
