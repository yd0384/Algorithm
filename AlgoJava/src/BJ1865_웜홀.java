import java.util.*;
import java.io.*;
public class BJ1865_웜홀 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N, M, W;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            List<Map<Integer, Integer>> map = new ArrayList<>();
            for(int i = 0; i <= N; i++){
                map.add(new HashMap<>());
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u, v, w;
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());
                if(map.get(u).get(v)==null){
                    map.get(u).put(v, w);
                }
                else if(map.get(u).get(v) > w){
                    map.get(u).put(v, w);
                }
            }
            for (int i = M; i < M+W; i++) {
                st = new StringTokenizer(br.readLine());
                int u, v, w;
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());
                if(map.get(u).get(v)==null){
                    map.get(u).put(v, -w);
                }
                else if(map.get(u).get(v) > -w){
                    map.get(u).put(v, -w);
                }
            }
            final int INF = 987654321;
            int[] D = new int[N+1];
            for(int i=1; i<=N; i++){
                D[i] = INF;
                map.get(0).put(i, 0);
            }
            for(int i=0; i<N-1; i++){
                for (int j = 0; j <= N; j++) {
                    for(int key : map.get(j).keySet()){
                        if(D[key] > D[j] + map.get(j).get(key)){
                            D[key] = D[j] + map.get(j).get(key);
                        }
                    }    
                }
            }
            boolean changed = false;
            for (int j = 0; j <= N; j++) {
                for(int key : map.get(j).keySet()){
                    if(D[key] > D[j] + map.get(j).get(key)){
                        D[key] = D[j] + map.get(j).get(key);
                        changed = true;
                        break;
                    }
                }    
            }
            System.out.println(changed?"YES":"NO");
        }
    }
}
