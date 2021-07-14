
import java.util.Scanner;

public class FindAlpha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int[] alpha=new int[26];
		for(int i=0;i<26;i++){
			alpha[i]=-1;
		}
		String str=sc.next();
		for(int i=0;i<str.length();i++){
			if(alpha[(int)(str.charAt(i))-97]==-1){
				alpha[(int)(str.charAt(i))-97]=i;
			}
		}
		for(int i=0;i<26;i++){
			System.out.print(alpha[i]+" ");
		}
	}

}
