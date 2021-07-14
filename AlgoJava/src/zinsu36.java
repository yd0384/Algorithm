
import java.util.Scanner;

public class zinsu36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println(to36(12));
		int N=sc.nextInt();
		int[] nums=new int[N];
		for(int i=0;i<N;i++){
			nums[i]=toDex(sc.next());
		}
		int k=sc.nextInt();
		int temp;
		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){
				if(nums[i]>nums[j]){
					temp=nums[i];
					nums[i]=nums[j];		
					nums[j]=temp;
				}
			}
		}
		
		int ans=0;
		for(int i=0;i<N;i++){
			ans+=nums[i];
		}
		
	}
	static int toDex(String S){
		char[] str=S.toCharArray();
		int num=0;
		for(int i=0;i<str.length;i++){
			if(str[i]<=58){
				str[i]-=48;
			}
			else{
				str[i]-=55;
			}
		}
		for(int i=str.length-1;i>=0;i--){
			num+=str[i]*Math.pow(36.0, str.length-i-1);
		}
		
		return num;
	}
	static String to36(int n){
		String s="";
		int temp=0;
		char tmp=' ';
		for(int i=0;n!=0;i++){
			temp=n%36;
			if(temp<10){
				tmp=(char)(temp+48);
			}
			else{
				tmp=(char)(temp+55);
			}
			s+=tmp;
			n%=36;
		}
		return s;
	}
	

}
