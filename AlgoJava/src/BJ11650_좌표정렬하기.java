import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BJ11650_좌표정렬하기 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> axis = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<200001;i++) {
			axis.add(new ArrayList<Integer>());
		}
		for(int n=0;n<N;n++) {
			String[] point = br.readLine().split(" ");
			int x=Integer.parseInt(point[0]);
			int y=Integer.parseInt(point[1]);
			int l = axis.get(x+100000).size();
			if(l==0)
				axis.get(x+100000).add(y);
			else {
				boolean flag=false;
				for(int i=0;i<l;i++) {
					if(axis.get(x+100000).get(i)>y) {
						axis.get(x+100000).add(i,y);
						flag=true;
						break;						
					}
				}
				if(!flag)
					axis.get(x+100000).add(l,y);
			}
		}
		for(int i=0;i<200001;i++) {
			for(int y:axis.get(i)) {
				bw.write(Integer.toString(i-100000)+" "+Integer.toString(y)+"\n");
				bw.flush();
			}
		}
		bw.close();
	}

}
