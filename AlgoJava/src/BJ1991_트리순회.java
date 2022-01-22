import java.util.*;

public class BJ1991_트리순회 {
    static int N;
    static StringBuilder sb;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;
        N = Integer.parseInt(sc.nextLine());
        sb = new StringBuilder();
        Node[] tree = new Node[N];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(sc.nextLine());
            char node = st.nextToken().toCharArray()[0];
            char left = st.nextToken().toCharArray()[0];
            char right = st.nextToken().toCharArray()[0];
            Node leftChild = null;
            Node rightChild = null;
            if(left!='.'){
                if(tree[left-'A']==null){
                    leftChild = new Node(left, null, null);
                }
                else{
                    leftChild = tree[left-'A'];
                }
                tree[left-'A']=leftChild;
            }
            if(right!='.'){
                if(tree[right-'A']==null){
                    rightChild = new Node(right, null, null);
                }
                else{
                    rightChild = tree[right-'A'];
                }
                tree[right-'A']=rightChild;
            }
            if(tree[node-'A']==null){
                tree[node-'A']=new Node(node, leftChild, rightChild);
            }
            else{
                tree[node-'A'].leftChild = leftChild;
                tree[node-'A'].rightChild = rightChild;
            }
        }
        Node root = tree[0];
        visited = new boolean[N];
        preOrder(root);
        sb.append("\n");
        visited = new boolean[N];
        inOrder(root);
        sb.append("\n");
        visited = new boolean[N];
        postOrder(root);
        System.out.println(sb);
        sc.close();
    }
    public static void preOrder(Node current){
        //현재 노드 방문
        sb.append(current.data);
        visited[current.data-'A']=true;
        //왼쪽 자식 탐색
        if(current.leftChild!=null && !visited[current.leftChild.data-'A']){
            preOrder(current.leftChild);
        }
        //오른쪽 자식 탐색
        if(current.rightChild!=null && !visited[current.rightChild.data-'A']){
            preOrder(current.rightChild);
        }
    }
    public static void inOrder(Node current){
        //왼쪽 자식 탐색
        if(current.leftChild!=null && !visited[current.leftChild.data-'A']){
            inOrder(current.leftChild);
        }
        //현재 노드 방문
        sb.append(current.data);
        visited[current.data-'A']=true;
        //오른쪽 자식 탐색
        if(current.rightChild!=null && !visited[current.rightChild.data-'A']){
            inOrder(current.rightChild);
        }
    }
    public static void postOrder(Node current){
        //왼쪽 자식 탐색
        if(current.leftChild!=null && !visited[current.leftChild.data-'A']){
            postOrder(current.leftChild);
        }
        //오른쪽 자식 탐색
        if(current.rightChild!=null && !visited[current.rightChild.data-'A']){
            postOrder(current.rightChild);
        }
        //현재 노드 방문
        sb.append(current.data);
        visited[current.data-'A']=true;
    }
    public static class Node{
        char data;
        Node leftChild;
        Node rightChild;
        public Node(char data, Node leftChild, Node rightChild){
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }        
    }
}

