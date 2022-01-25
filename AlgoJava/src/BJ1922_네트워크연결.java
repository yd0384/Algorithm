import java.util.*;
import java.io.*;
public class BJ1922_네트워크연결 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getW));
        List<List<Edge>> adj = new ArrayList<>();
        for(int i=0;i<=N; i++){
            adj.add(new ArrayList<Edge>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj.get(u).add(new Edge(u, v, w));
            adj.get(v).add(new Edge(v, u, w));
        }
        final int MAXEDGE = N-1;
        int currentU = 1;
        int edges = 0;
        int cost = 0;
        boolean[] visited = new boolean[N+1];
        while (edges < MAXEDGE) {
            visited[currentU]=true;
            for(Edge e:adj.get(currentU)){
                if(!visited[e.v]){
                    pq.add(e);
                }
            }
            Edge currentEdge;
            while(true){
                currentEdge = pq.poll();
                if(!visited[currentEdge.v]){
                    break;
                }
            }
            currentU = currentEdge.v;
            cost += currentEdge.w;
            edges+=1;
        }
        System.out.println(cost);
    }
    static class Edge{
        int u, v, w;
        public Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
        public int getU() {
            return u;
        }
        public int getV() {
            return v;
        }
        public int getW() {
            return w;
        }
    }
}

