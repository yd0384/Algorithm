import java.util.*;

public class BJ1991_트리순회 {
    static char[] tree;
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        N = Integer.parseInt(sc.nextLine());
        int treeSize = 1;
        sb = new StringBuilder();
        
        tree = new char[treeSize+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(sc.nextLine());
            char node = st.nextToken().toCharArray()[0];
            char left = st.nextToken().toCharArray()[0];
            char right = st.nextToken().toCharArray()[0];
            if(i==1){
                tree[1]=node;
                tree[2]=left;
                tree[3]=right;
            }
            else{
                int nodeIndex=1;
                for(int j=2;j<=N;j++){
                    if(node==tree[j]){
                        nodeIndex=j;
                        break;
                    }
                }
                if(left != '.'){
                    tree[nodeIndex*2]=left;
                }
                if(right != '.'){
                    tree[nodeIndex*2+1]=right;
                }
            }
        }
        //탐색
        sc.close();
    }
    public static void preOrderVisit(int index){
        sb.append(tree[index]);
        
    }
    public static class Node{
        char data;
        Node leftChild;
        Node RightChild;

        
    }
}

