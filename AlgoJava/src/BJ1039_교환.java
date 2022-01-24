import java.io.*;
import java.util.*;
public class BJ1039_교환 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = String.valueOf(N).length();
        Queue<NK> queue = new LinkedList<>();
        queue.offer(new NK(N, 0));
        int maxV = 0;
        while(!queue.isEmpty()){
            // 1. 큐에서 꺼내옴
            NK nk = queue.poll();
            int k = nk.k;
            String number = String.valueOf(nk.n);
            // 2. 목적지인가?
            if(k==K){
                maxV = nk.n;
                break;
            }
            // 3. 연결된 곳을 순회
            for(int i=0;i<M-1;i++){
                for(int j=i+1; j<M;j++){
                    String newN = swap(i, j, number);
                    // 4. 갈 수 있는가?
                    if(newN.charAt(0)!='0'){
                        // 6. 큐에 넣음
                        queue.offer(new NK(Integer.parseInt(newN), k+1));
                    }
                }
            }
        }
        if(queue.isEmpty()){
            System.out.println(-1);
        }
        else{
            while(!queue.isEmpty()){
                maxV = Math.max(queue.poll().n, maxV);
            }
            System.out.println(maxV);
        }
        sc.close();
    }
    public static String swap(int i, int j, String number){
        String ret = "";
        for (int k = 0; k < number.length(); k++) {
            if(i==k){
                ret+=number.charAt(j);
            }
            else if(j==k){
                ret+=number.charAt(i);
            }
            else{
                ret+=number.charAt(k);
            }
        }
        return ret;
    }
}
class NK{
    int n;
    int k;
    public NK(int n, int k){
        this.n=n;
        this.k=k;
    }
}
