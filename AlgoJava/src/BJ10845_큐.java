import java.io.*;
import java.util.*;
public class BJ10845_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("push")){
                int x = Integer.parseInt(st.nextToken());
                queue.add(x);
            }
            else if(op.equals("pop")){
                if(queue.isEmpty()){
                    sb.append(-1+"\n");
                }
                else{
                    int pop = queue.remove(0);
                    sb.append(pop+"\n");
                }
            }
            else if(op.equals("size")){
                sb.append(queue.size()+"\n");
            }
            else if(op.equals("empty")){
                if(queue.size()==0){
                    sb.append(1+"\n");
                }
                else{
                    sb.append(0+"\n");
                }
            }
            else if(op.equals("front")){
                if(queue.isEmpty()){
                    sb.append(-1+"\n");
                }
                else{
                    sb.append(queue.get(0)+"\n");
                }
            }
            else if(op.equals("back")){
                if(queue.isEmpty()){
                    sb.append(-1+"\n");
                }
                else{
                    sb.append(queue.get(queue.size()-1)+"\n");
                }
            }
        }
        System.out.println(sb);
    }
}
