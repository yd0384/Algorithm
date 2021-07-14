
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountingSort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int[] ori=new int[10001];
		for(int i=1;i<=n;i++)
		{
			int x=Integer.parseInt(br.readLine());
			ori[x]++;
		}
		for(int i=1;i<10001;i++)
		{
			if(ori[i]>0)
			{
				for(int j=0;j<ori[i];j++)
				{
					sb.append(""+i+"\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

}
