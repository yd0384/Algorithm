import java.util.*;
import java.io.*;
public class BJ3176_도로네트워크 {
    static int N, K;
    static List<List<Edge>> map;
    static int[][] parent;
    static int[][] Max;
    static int[][] Min;
    static int[] depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int maxDepth = 1;
        K=0;
        while(maxDepth < N-1){
            maxDepth *= 2;
            K++;
        }
        depth = new int [N+1];
        parent = new int[N+1][K];
        Max = new int[N+1][K];
        Min = new int[N+1][K];
        StringTokenizer st;
        map = new ArrayList<>();
        for(int i=0; i<=N; i++){
            map.add(new ArrayList<>());
        }

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            map.get(A).add(new Edge(B, C));
            map.get(B).add(new Edge(A, C));
        }
        bfs(1);
        parent[1][0] = 0;
        MakeSparseTable();
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            LCA(D, E);
            // min max 구해서 출력
        }
    }
    private static void bfs(int V){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        //양방향이라 루트의 부모가 생기는 것 방지
        parent[V][0] = -1;
        while(!queue.isEmpty()){
            V = queue.poll();
            for(Edge e: map.get(V)){
                if(parent[e.v][0]==0){ //not visited
                    depth[e.v] = depth[V] + 1;
                    parent[e.v][0] = V;
                    Min[e.v][0] = e.w;
                    Max[e.v][0] = e.w;
                    queue.add(e.v);
                }
            }
        }
    }
    private static void MakeSparseTable(){
        for(int i=1; i<K; i++){
            for(int j=1; j<=N; j++){
                parent[j][i] = parent[parent[j][i-1]][i-1]; 
                Min[j][i] = Math.min(Min[j][i-1], Min[parent[j][i-1]][i-1]);
                Max[j][i] = Math.max(Max[j][i-1], Max[parent[j][i-1]][i-1]);
            }
        }
    }
    private static class Edge{
        int v, w;
        public Edge(int v, int w){
            this.v = v;
            this.w = w;
        }
    }
    private static int LCA(int D, int E){
        if(D < E){
            return LCA(E, D);
        }
        //TODO
        return 0;
    }
}
