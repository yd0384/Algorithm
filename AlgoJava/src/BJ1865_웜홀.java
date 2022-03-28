import java.util.*;
import java.io.*;
public class BJ1865_웜홀 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                if(map.get(S) == null) {
                    Map<Integer, Integer> tmpMap = new HashMap<>();
                    tmpMap.put(E, T);
                    map.put(S, tmpMap);
                }
                else if(map.get(S).get(E) == null) {
                    map.get(S).put(E, T);
                }
                else if (map.get(S).get(E) > T) {
                    map.get(S).put(E, T);
                }
                if(map.get(E) == null) {
                    Map<Integer, Integer> tmpMap = new HashMap<>();
                    tmpMap.put(S, T);
                    map.put(E, tmpMap);
                }
                else if(map.get(E).get(S) == null) {
                    map.get(E).put(S, T);
                }
                else if (map.get(E).get(S) > T) {
                    map.get(E).put(S, T);
                }
            }
            for (int w = 0; w < W; w++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                T = -T;
                if(map.get(S) == null) {
                    Map<Integer, Integer> tmpMap = new HashMap<>();
                    tmpMap.put(E, T);
                    map.put(S, tmpMap);
                }
                else if(map.get(S).get(E) == null) {
                    map.get(S).put(E, T);
                }
                else if (map.get(S).get(E) > T) {
                    map.get(S).put(E, T);
                }
            }
            int[] D = new int[N+1];
            for (int i = 0; i < N-1; i++) {
                for(Map.Entry<Integer, Map<Integer, Integer>> entry : map.entrySet()) {
                    int start = entry.getKey();
                    for(Map.Entry<Integer, Integer> innerEntry : entry.getValue().entrySet()) {
                        int end = innerEntry.getKey();
                        int weight = innerEntry.getValue();
                        if(D[end] > D[start] + weight) {
                            D[end] = D[start] + weight;
                        }
                    }
                }
            }
            boolean changed = false;
            for(Map.Entry<Integer, Map<Integer, Integer>> entry : map.entrySet()) {
                int start = entry.getKey();
                for(Map.Entry<Integer, Integer> innerEntry : entry.getValue().entrySet()) {
                    int end = innerEntry.getKey();
                    int weight = innerEntry.getValue();
                    if(D[end] > D[start] + weight) {
                        changed = true;
                        break;
                    }
                }
                if(changed) {
                    break;
                }
            }
            if(changed) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
