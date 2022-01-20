import java.io.*;
import java.util.*;

public class BJ1655_가운데를말해요 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int current = Integer.parseInt(br.readLine());
            if(i%2==1){
                if(maxQueue.peek()==null){
                    maxQueue.offer(current);    
                }
                else{
                    minQueue.offer(current);
                    maxQueue.offer(minQueue.poll());
                }     
            }
            else{
                if(minQueue.peek()==null){
                    maxQueue.offer(current);
                    minQueue.offer(maxQueue.poll());
                }
                else{
                    maxQueue.offer(current);
                    minQueue.offer(maxQueue.poll());
                }
            }
            sb.append(maxQueue.peek()+"\n");
        }
        System.out.println(sb);
    }
}
//StringBuilder안써서 시간초과났었다
//대량의 출력에서는 StringBuilder 사용하기