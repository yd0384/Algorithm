import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class BJ4153_직각삼각형{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			String[] s = new String[3];
			s = br.readLine().split(" ");
			
			int[] nums = new int[3];
			for(int i=0;i<3;i++) {
				nums[i]=Integer.parseInt(s[i]);
			}
			if((nums[0]|nums[1]|nums[2])==0) {
				break;
			}
			if(Math.abs((Math.pow(nums[0], 2)+Math.pow(nums[1], 2)+Math.pow(nums[2], 2))/2 - Math.pow(Math.max(nums[0],Math.max(nums[1], nums[2])),2))<0.5) {
				bw.write("right\n");
				bw.flush();
				
			}
			else {
					bw.write("wrong\n");
					bw.flush();
			}
			
		}
		bw.close();
	}

}
