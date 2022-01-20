import java.io.*;
public class BJ9202_Boggle {
    static final int[] DY = {-1, -1, 0, 1, 1, 1, 0, -1}; 
    static final int[] DX = {0, 1, 1, 1, 0, -1, -1, -1};
    static final int[] score = {0,0,0,1,1,2,3,5,11};

    static char[][] board;
    static Trie trie;
    static boolean[][] visited = new boolean[4][4];
    static int found = 0;
    static int maxLen = 0;
    static String longestString="";
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(br.readLine());
        trie = new Trie();
        for (int i = 0; i < w; i++) {
            trie.insertWord(br.readLine());
        }
        br.readLine();
        int b = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < b; i++) {
            board = new char[4][4];
            for(int j = 0; j < 4; j++){
                board[j] = br.readLine().toCharArray();
            }
            for(int j=0;j<4;j++){
                for(int k=0;k<4;k++){
                    if(trie.root.child[board[j][k]-'A']!=null){
                        DFS(j, k, trie.root);
                        visited = new boolean[4][4];
                    }
                }
            }
            trie.setIsHit(trie.root);
            System.out.println(maxLen + " " + longestString + " " + found);
            maxLen = 0;
            longestString = "";
            found = 0;    
            if(i!=b-1){
                br.readLine();
            }
        }
    }
    public static void DFS(int y, int x, Node node){
        //1. 체크인
        visited[y][x] = true;
        sb.append(board[y][x]);
        //2. 목적지인가?
        if(node.isEnd && node.isHit==false){
            node.isHit = true;
            //정답찾음
            found += score[sb.length()];
            if(sb.length() > maxLen){
                maxLen = sb.length();
                longestString = sb.toString();
            } 
            else if(sb.length() == maxLen){
                if(sb.toString().compareTo(longestString)<0){
                    longestString = sb.toString();
                }
            }
            maxLen = Math.max(maxLen, sb.length());
            
        }
        //3. 연결된 곳
        for(int i=0;i<8;i++){
            int ty = y + DY[i];
            int tx = x + DX[i];
            //4. 갈 수 있는가?
            if(0 <= ty && ty < 4 && 0 <= tx && tx < 4) {
                if(visited[ty][tx] == false && node.child[board[ty][tx] - 'A']!=null){
                    //5. 간다.
                    DFS(ty, tx, node.child[board[ty][tx] - 'A']);
                }
            }
        }   
        //6. 체크아웃
        visited[y][x] = false;
        sb.deleteCharAt(sb.length()-1);
    }

    public static class Trie{
        Node root;
        public Trie(){
            root = new Node(' ', false);
        }
        public void insertWord(String word){
            Node currentNode = root; 
            for(char c:word.toCharArray()){
                if(currentNode.child[c-'A']!=null){
                    currentNode = currentNode.child[c-'A'];
                }
                else{
                    currentNode.child[c-'A'] = new Node(c, false);
                }
            }
            currentNode.isEnd = true;
        }
        public void setIsHit(Node currentNode){
            currentNode.isHit = false;
            for(Node n:currentNode.child){
                if(n!=null){
                    setIsHit(n);
                }
            }
        }
    }
    public static class Node{
        char data;
        boolean isEnd;
        boolean isHit;
        Node child[];
        public Node(char data, boolean isEnd){
            this.data = data;
            this.isEnd = isEnd;
            this.child = new Node[26];
        }
    } 
}