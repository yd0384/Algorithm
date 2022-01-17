import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Comparator;
public class BJ1167_트리의지름 {
    static class Graph{
        private int V;
        ArrayList<HashMap<Integer, Integer>> tree = new ArrayList<HashMap<Integer, Integer>>();
        Graph(int v){
            V = v;
            for(int i=0;i<=V;i++){
                tree.add(new HashMap<Integer, Integer>());
            }
        }

        void addEdge(int u, int v, int w){
            tree.get(u).put(v, w);
        }
        int DFS(){
            boolean visited[] = new boolean[V+1];
            visited[1]=true;
            ArrayList<Integer> dist = new ArrayList<>();
            for(int v:tree.get(1).keySet()){
                dist.add(visit(v, visited, tree.get(1).get(v)));
            }
            if(dist.size()==1){
                return dist.get(0);
            }
            else{
                dist.sort(Comparator.reverseOrder());
                return dist.get(0)+dist.get(1);
            }
        }
        int visit(int u, boolean[] visited, int r){
            visited[u]=true;
            int visitable = 0;
            int dist2 = 0;
            for(int v:tree.get(u).keySet()){
                if(!visited[v]){
                    visitable++;
                }
            }
            if(visitable==0){
                return r;
            }
            for(int v:tree.get(u).keySet()){
                if(!visited[v]){
                    dist2 = Math.max(dist2, visit(v, visited, r+tree.get(u).get(v)));
                }
            }
            return dist2;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        try{
            int V = sc.nextInt();
            Graph graph = new Graph(V);
            
            sc.nextLine();
            for(int i=0;i<V;i++){
                String[] input = sc.nextLine().split(" ");
                int j = 0;
                int u = Integer.valueOf(input[j]);
                int v, w;
                for(j=1;!input[j].equals("-1");j+=2){
                    v = Integer.valueOf(input[j]);
                    w = Integer.valueOf(input[j+1]);
                    graph.addEdge(u, v, w);
                }
            }
            System.out.println(graph.DFS());
        }
        finally{
            sc.close();
        }
    }
}
