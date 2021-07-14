import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ10866_덱 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<Integer>();
		for(int i=0;i<N;i++) {
			String line=br.readLine();
			if(line.substring(0,4).equals("push")) {
				int e = Integer.parseInt(line.split(" ")[1]);
				if (line.substring(5,9).equals("back")) {
					dq.addLast(e);
					continue;
				}
				else {
					dq.addFirst(e);
					continue;
				}
			}
			else if (line.substring(0,3).equals("pop")) {
				try {
					if (line.substring(4,8).equals("back")) {
						
						bw.write(Integer.toString(dq.removeLast()));
						bw.flush();
					}
					else {
						bw.write(Integer.toString(dq.removeFirst()));
						bw.flush();
					}
				}
				catch(NoSuchElementException e1) {
					bw.write("-1");
					bw.flush();
				}
			}
			else if (line.equals("size")) {
				bw.write(Integer.toString(dq.size()));
				bw.flush();
			}
			else if (line.equals("empty")) {
				bw.write((dq.isEmpty())? "1" : "0");
				bw.flush();
			}
			else {
				try {
					if (line.equals("front")) {
						
						if(dq.peekFirst()==null) {
							throw new Exception();
						}
						bw.write(Integer.toString(dq.peekFirst()));
						bw.flush();
					}
					else {
						if(dq.peekLast()==null) {
							throw new Exception();
						}
						bw.write(Integer.toString(dq.peekLast()));
						bw.flush();
					}
				}
				catch(Exception e) {
					bw.write("-1");
					bw.flush();
				}
				
			}
			bw.write("\n");
			bw.flush();
		}
		bw.close();
	}

}
