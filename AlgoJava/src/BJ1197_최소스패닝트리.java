import java.util.*;
import java.io.*;
public class BJ1197_최소스패닝트리 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getW));
        parent = new int[V+1];
        int weight = 0;
        for (int i = 1; i < V+1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            if(find(e.u) == find(e.v)) {
                continue;
            }
            else {
                union(e.u, e.v);
                weight += e.w;
            }
        }
        System.out.println(weight);
    }
    static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        parent[aRoot] = bRoot;
    }
    static int find(int a) {
        if(parent[a] == a) {
            return a;
        }
        else {
            return parent[a] = find(parent[a]);
        }
    }
    private static class Edge {
        private int u;
        private int v;
        private int w;
        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        public int getW() {
            return w;
        }
    }
}
