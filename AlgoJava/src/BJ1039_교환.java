import java.io.*;
import java.util.*;
public class BJ1039_교환 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue<String> queue = new LinkedList<String>();
        String before = Integer.toString(N);
        int M = before.length();
        queue.add(before);
        int kthSwap = 0;
        int kcnt = 0;
        boolean disable = false;
        Set<String> visited = new HashSet<>();
        while(true){
            if(queue.isEmpty()){
                disable=true;
                break;
            }
            if(kthSwap == queue.size()){
                kcnt++;
                kthSwap=0;
                visited = new HashSet<>();
            }
            if(kcnt==K){
                break;
            }
            before = queue.poll();
            for (int i = 0; i < M-1; i++) {
                for (int j = i+1; j < M; j++) {
                    String after = "";
                    for(int k=0; k<M; k++){
                        if(k==i){
                            after += before.charAt(j);
                        }
                        else if(k==j){
                            after += before.charAt(i);
                        }
                        else{
                            after += before.charAt(k);
                        }
                    }
                    if(after.charAt(0)!='0' && !visited.contains(after)){
                        queue.add(after);
                        visited.add(after);
                        kthSwap++;
                    }
                }
            }
        }
        if(disable){
            System.out.println(-1);
        }
        else{
            int maxNum = 0;
            while(!queue.isEmpty()){
                maxNum = Math.max(maxNum, Integer.parseInt(queue.poll()));
            }
            System.out.println(maxNum);
        }
        sc.close();
    }
}

