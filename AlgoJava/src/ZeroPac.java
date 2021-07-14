

import java.util.Scanner;

public class ZeroPac 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int tmp,numTwo=0,numFive=0,numZero=0;
		for(int i=n;i>0;i--)
		{
			tmp=i;
			while(tmp%2==0||tmp%5==0)
			{
				if(tmp%2==0)
				{
					numTwo++;
					tmp/=2;
				}
				if(tmp%5==0)
				{
					numFive++;
					tmp/=5;
				}
			}
			
		}
		for(;numFive>0&&numTwo>0;)
		{
			numZero++;
			numFive--;
			numTwo--;
		}
		System.out.println(numZero);
	}

}
