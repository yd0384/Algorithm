import java.util.*;
import java.io.*;
public class BJ1753_최단경로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(br.readLine());
        int[] D = new int[V+1];
        final int MAXDIST = 3000001;
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(u).add(new Edge(u, v, w));
        }
        for (int i = 1; i < D.length; i++) {
            if(i!=S){
                D[i]=MAXDIST;
            }
        }
        PriorityQueue<DistFromStart> pq = new PriorityQueue<>(Comparator.comparingInt(DistFromStart::getDist));
        pq.add(new DistFromStart(S, 0));
        while(!pq.isEmpty()){
            DistFromStart minDist = pq.poll();
            if(minDist.dist > D[minDist.V]){
                continue;
            }
            for(Edge e:adj.get(minDist.V)){
                if(D[e.v] > D[e.u] + e.w){
                    D[e.v] = D[e.u] + e.w;
                    pq.add(new DistFromStart(e.v, D[e.v]));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for(int d: D){
            if(first){
                first=false;
                continue;
            }
            if(d==MAXDIST){
                sb.append("INF\n");
            }
            else{
                sb.append(d+"\n");
            }
        }
        System.out.print(sb);
    }
    static class Edge{
        int u, v, w;
        public Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    static class DistFromStart{
        int V, dist;
        public DistFromStart(int V, int dist){
            this.V = V;
            this.dist = dist;
        }
        public int getV() {
            return V;
        }
        public int getDist() {
            return dist;
        }
    }
}
