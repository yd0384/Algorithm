import java.util.*;
import java.io.*;
public class BJ3176_도로네트워크 {
    static int N, K;
    static List<List<Edge>> map;
    static int[][] parent;
    static int[][] Max;
    static int[][] Min;
    static int[] depth;
    static int minW, maxW;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int maxDepth = 1;
        K=0;
        while(maxDepth < N){
            maxDepth *= 2;
            K++;
        }
        depth = new int [N+1];
        parent = new int[N+1][K+1];
        Max = new int[N+1][K+1];
        Min = new int[N+1][K+1];

        StringTokenizer st;
        map = new ArrayList<>();
        for(int i=0; i<=N; i++){
            map.add(new ArrayList<>());
        }

        for(int i=1; i<=N-1; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            map.get(A).add(new Edge(B, C));
            map.get(B).add(new Edge(A, C));
        }
        bfs(1);
        MakeSparseTable();
        int Q = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            minW = Integer.MAX_VALUE;
            maxW = 0;
            LCA(D, E);
            sb.append(minW+" "+maxW+"\n");
            // min max 구해서 출력
        }
        System.out.print(sb);
    }
    private static void bfs(int V){
        depth[V] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        while(!queue.isEmpty()){
            V = queue.poll();
            for(Edge e: map.get(V)){
                if(depth[e.v]==0){ //not visited
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
        for(int i=1; i<=K; i++){
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
        if(depth[D] < depth[E]){
            return LCA(E, D);
        }
        int diff = depth[D] - depth[E];
        for(int k=0; k<=K && diff!=0; k++){
            if((diff&1)==1){
                minW = Math.min(Min[D][k], minW);
                maxW = Math.max(Max[D][k], maxW);
                D = parent[D][k];
            }
            diff>>=1;
        }
        if(D==E) {
            return D;
        }
        for(int k=K; k>=0; k--){
            if(parent[D][k] != parent[E][k]){
                minW = Math.min(minW, Math.min(Min[D][k], Min[E][k]));
                maxW = Math.max(maxW, Math.max(Max[D][k], Max[E][k]));
                D = parent[D][k];
                E = parent[E][k];
            }
        }
        
        minW = Math.min(minW, Math.min(Min[D][0], Min[E][0]));
        maxW = Math.max(maxW, Math.max(Max[D][0], Max[E][0]));

        return parent[D][0];
    }
}
