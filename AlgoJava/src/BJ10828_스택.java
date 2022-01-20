import java.io.*;
import java.util.*;
public class BJ10828_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<Integer> stack = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            if(op.equals("push")){
                int x = Integer.parseInt(st.nextToken());
                stack.add(x);
            }
            else if(op.equals("pop")){
                if(stack.isEmpty()){
                    sb.append(-1+"\n");
                }
                else{
                    int pop = stack.remove(stack.size()-1);
                    sb.append(pop+"\n");
                }
            }
            else if(op.equals("size")){
                sb.append(stack.size()+"\n");
            }
            else if(op.equals("empty")){
                if(stack.size()==0){
                    sb.append(1+"\n");
                }
                else{
                    sb.append(0+"\n");
                }
            }
            else if(op.equals("top")){
                if(stack.isEmpty()){
                    sb.append(-1+"\n");
                }
                else{
                    sb.append(stack.get(stack.size()-1)+"\n");
                }
            }
        }
        System.out.println(sb);
    }
}
