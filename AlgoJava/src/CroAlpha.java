
import java.util.Scanner;

public class CroAlpha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		String[] alpha={"c=","c-","dz=","d-","lj","nj","s=","z="};
		for(int i=0;i<alpha.length;i++){
			str=str.replaceAll(alpha[i], "*");	
		}
		System.out.println(str.length());
	}

}
