import java.io.*;
import java.util.*;
public class BJ2252_줄세우기 {
    static int[] indegree;
    static boolean[] included;
    static List<List<Integer>> adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        indegree = new int[N+1];
        included = new boolean[N+1];
        adj = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pre = Integer.parseInt(st.nextToken());
            int post = Integer.parseInt(st.nextToken());
            adj.get(pre).add(post);
            indegree[post]++;
        }
        int cnt = 0;
        while(cnt < N){
            for(int i=1; i<N+1;i++){
                if(!included[i] && indegree[i]==0){
                    for(int j:adj.get(i)){
                        if(!included[j]){
                            indegree[j]--;
                        }
                    }
                    included[i]=true;
                    cnt++;
                    sb.append(i + " ");
                }
            }
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}
// 큐를 만들어서 한 사이클마다 indegree가 0인 노드들을 넣어서 한번에 처리하면 순서가 
// 섞이지 않고 BFS의 순서대로 될 것이다. 하지만 위상정렬의 결과는 유일하지 않기 때문에
// 이렇게 해도 정답으로 인정된다.