import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2805_나무자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N, M;
		N = Long.parseLong(st.nextToken());
		M = Long.parseLong(st.nextToken());
		List<Long> trees = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(long i=0; i<N; i++){
			trees.add(Long.parseLong(st.nextToken()));
		}
		Collections.sort(trees, Collections.reverseOrder());
		long low=0, high = trees.get(0);
		long answer = 0;
		while(true){
			if(low > high){
				break;
			}
			long mid = (low + high) / 2;
			long sum = 0;
			for(long t: trees){
				if(t>mid){
					sum += t - mid;
				}
				else{
					break;
				}
			}
			if(sum>M){
				answer = mid;
				low = mid + 1;
			}
			else if(sum==M){
				answer = mid;
				low = mid + 1;
			}
			else{
				high = mid - 1;
			}
			
		}
		System.out.println(answer);
	}

}
