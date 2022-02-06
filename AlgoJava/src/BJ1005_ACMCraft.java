import java.util.*;
import java.io.*;
public class BJ1005_ACMCraft {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] D = new int[N+1];
            int[] dp = new int[N+1];
            List<List<Integer>> adj = new ArrayList<>();
            int[] indegree = new int[N+1];
            for(int i = 0; i <= K+1; i++){
                adj.add(new ArrayList<>());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++){
                D[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                indegree[v] += 1;
                adj.get(u).add(v);
            }
            int target = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            int current = 0;
            boolean[] visited = new boolean[N+1];
            for (int i = 1; i <= N; i++) {
                if(indegree[i] == 0 && adj.get(i).size() == 0){
                    dp[i] = D[i];
                }
            }
            for (int i = 1; i <= N; i++) {
                if(indegree[i]==0 && adj.get(i).size() != 0){
                    current = i;
                    queue.add(current);
                    dp[current] = D[current];
                }
            }

            while(!queue.isEmpty()){
                current = queue.poll();
                if(visited[current]){
                    continue;
                }
                visited[current] = true;
                for (int next : adj.get(current)) {
                    indegree[next]--;
                    dp[next] = Math.max(D[next] + dp[current], dp[next]);
                }
                for (int i = 1; i <= N; i++) {
                    if(!visited[i]){
                        if(indegree[i] == 0){
                            queue.add(i);
                        }
                    }
                }
            }
            sb.append(dp[target]+"\n");
        }
        System.out.print(sb);
    }
}
