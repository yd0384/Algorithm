import java.util.*;
import java.io.*;

public class BJ2606_바이러스 {
    static int[] root;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int edgeCount = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        root = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            root[i] = i;
        }
        for (int i = 0; i < edgeCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (u < v) {
                union(u, v);
            } else {
                union(v, u);
            }
        }
        int root1 = find(1);
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (find(i) == root1) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            root[rootU] = rootV;
        }
    }

    static int find(int x) {
        if (root[x] == x) {
            return x;
        } else {
            return root[x] = find(root[x]);
        }
    }
}
