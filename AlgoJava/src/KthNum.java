
import java.util.Scanner;

public class KthNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,k;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		int min=0x7FFFFFFF;
		int tmp=0;
		int x=0;
		int[] nums = new int[n];
		for(int i=0;i<n;i++)
		{
			nums[i]=sc.nextInt();
		}
		for(int i=0;i<k;i++)
		{
			min=0x7FFFFFFF;
			for(int j=i;j<n;j++)
			{
				if(min>nums[j])
				{
					min = nums[j];
					x=j;
				}
			}
			nums[x]=nums[i];
			nums[i]=min;
		}
		System.out.println(min);
	}

}
