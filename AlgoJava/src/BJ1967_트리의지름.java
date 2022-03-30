import java.util.*;
import java.io.*;


public class BJ1967_트리의지름 {
    static int[] distance;
    static boolean[] visited;
    static List<Node> tree;   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new Node(i));
        }
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            tree.get(parent).addChild(tree.get(child), cost);
            tree.get(child).setBefore(tree.get(parent));
        }
        distance = new int[n+1];
        visited = new boolean[n+1];
        DFS(1, 0);
        int maxIndex = 0;
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            if(maxDistance < distance[i]) {
                maxIndex = i;
                maxDistance = distance[i];
            }
        }
        distance = new int[n+1];
        visited = new boolean[n+1];
        DFS(maxIndex, 0);
        for (int i = 1; i <= n; i++) {
            if(maxDistance < distance[i]) {
                maxIndex = i;
                maxDistance = distance[i];
            }
        }
        System.out.println(maxDistance);
    }
    static void DFS(int current, int dist) {
        visited[current] = true;
        for(Map.Entry<Node, Integer> entry : tree.get(current).getChilds().entrySet()) {
            int child = entry.getKey().getIndex();
            int d = entry.getValue();
            if(!visited[child]) {
                distance[child] = d + dist;
                DFS(child, d + dist);
            }
        }
        Node parentNode = tree.get(current).getBefore();
        if(parentNode!=null && distance[current] == 0) {
            int parent = parentNode.getIndex();
            int d = tree.get(parent).getChilds().get(tree.get(current));
            distance[current] = d + dist;
            DFS(parent, d+dist);
        }
    }
    private static class Node {
        private Node before;
        private int index;
        private Map<Node, Integer> childs = new HashMap<>();
    
        public Node(int index) {
            this.index = index;
        }
        public void setBefore(Node before) {
            this.before = before;
        }
        public void addChild(Node childNode, int cost) {
            this.childs.put(childNode, cost);
        }
        public Map<Node, Integer> getChilds() {
            return childs;
        }
        public Node getBefore() {
            return before;
        }
        public int getIndex() {
            return index;
        }
    }
}
/* 
거리를 어디서부터 구할 지 기준점을 구하는게 어려웠는데
한 노드(ex: 루트)에서 제일 먼 노드를 구하고
그 노드에서 제일 먼 노드까지의 거리를 구하면
거리를 2번만 구하면 된다. (DFS 2번)
 */