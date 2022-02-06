import java.util.*;
import java.io.*;
public class BJ1167_트리의지름 {
    private static class Edge{
        int v, w;
        public Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    static boolean[] visited;
    static int[] dp;
    static List<List<Edge>> adj;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        StringTokenizer st;
        adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        visited = new boolean[V+1];
        dp = new int[V+1];
        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while(true){
                int v = Integer.parseInt(st.nextToken());
                if(v==-1){
                    break;
                }
                int w = Integer.parseInt(st.nextToken());
                adj.get(u).add(new Edge(v, w));
            }   
        }
        DFS(1);
        int answer = 0;
        for (int i = 1; i <= V; i++) {
            if(answer < dp[i]){
                answer = dp[i];
            }
        }
        System.out.println(answer);

    }
    private static int DFS(int node){
        visited[node] = true;
        int childCnt = 0;
        for(Edge next : adj.get(node)){
            if(!visited[next.v]){
                childCnt++;
            }
        }
        int maxdp = 0;
        int ret = 0;
        int seconddp = 0;
        switch(childCnt){
            case 0: 
                return 0;
            case 1:
                for(Edge next : adj.get(node)){
                    if(!visited[next.v]){
                        dp[node] = DFS(next.v) + next.w;
                    }
                }
                return dp[node];
            case 2:
                for(Edge next : adj.get(node)){
                    if(!visited[next.v]){
                        ret = DFS(next.v) + next.w;
                        if(ret > maxdp){
                            maxdp = ret;
                        }
                        dp[node] += ret;
                    }
                }
                return maxdp;
            default:
                for(Edge next : adj.get(node)){
                    if(!visited[next.v]){
                        ret =  DFS(next.v) + next.w;
                        if(ret > maxdp){
                            seconddp = maxdp;
                            maxdp = ret;
                        }
                        else if(ret > seconddp){
                            seconddp = ret;
                        }
                    }
                }
                dp[node] = maxdp + seconddp;
                return maxdp;
        }
    }
}
