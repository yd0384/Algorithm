import java.util.*;
import java.io.*;
public class BJ5639_이진검색트리 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Node Root = new Node(Integer.parseInt(br.readLine()));
        Node Current = Root;
        while((line=br.readLine())!=null){
            int v = Integer.parseInt(line);
            if(Current.v < v){
                
            }
        }
    }
    private static class Node{
        int v;
        Node left, right;
        public Node(int v){
            this.v = v;
        }
        public Node(int v, Node left){
            this.v = v;
            this.left = left;
        }
        public Node(int v, Node left, Node right){
            this.v = v;
            this.left = left;
            this.right = right;
        }
    }
}
