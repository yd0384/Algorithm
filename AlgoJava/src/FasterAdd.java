
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FasterAdd {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(st.nextToken());
		for(int i=0;i<T;i++)
		{
			st = new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int b=Integer.parseInt(st.nextToken());
			bw.write(Integer.valueOf(a+b));
			bw.flush();
			bw.close();
		}
		
		br.close();
	}

}
