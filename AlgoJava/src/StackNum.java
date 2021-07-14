

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
public class StackNum {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.valueOf(br.readLine());
		int[] num= new int[n];
		for(int i=0;i<n;i++){
			num[i]=Integer.valueOf(br.readLine());
		}
		Stack<Integer> st= new Stack<Integer>();
		String store = "";
		int x=1;
		for(int i=0;i<n;i++){
			while(true){
			if(num[i]==x){
				st.push(x);
				store+="+\n";
				st.pop();
				store+="-\n";
				x++;
				break;
			}
			else if(num[i]>x){
				st.push(x);
				store+="+\n";
				x++;
			}
			else if(st.peek()==num[i]){
				st.pop();
				store+="-\n";
				break;
			}
			else{
				System.out.println("NO");
				System.exit(0);
			}
			}
		}
		System.out.println(store);
	}

}
