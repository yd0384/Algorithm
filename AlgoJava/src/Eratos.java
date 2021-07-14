package joon;

import java.util.Scanner;

public class Eratos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		boolean[] arr = new boolean[n+1];
		for(int i=2;i<arr.length;i++)
		{
			arr[i]=true;
		}
		int count = 0;
		int rs=0;
		while(count != k)
		{
			for(int i=2;i<arr.length;i++)
			{
				if(arr[i])
				{
					arr[i]=false;
					count++;
					rs=i;
					if(count==k)
					{
						break;
					}
					for(int j=i;j<=n;j+=i)
					{
						if(arr[j])
						{
							arr[j]=false;
							count++;
							rs=j;
							if(count==k)
							{
								break;
							}
						}
					}
					break;
				}
			}
		}
		System.out.println(rs);
	}

}
