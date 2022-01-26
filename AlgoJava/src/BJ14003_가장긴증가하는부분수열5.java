import java.io.*;
import java.util.*;
public class BJ14003_가장긴증가하는부분수열5 {
    static String[] IndexedTree;
    static int S;
    static List<Node> Arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> DupCheck = new HashSet<>();
        Arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int order = 1;
        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(st.nextToken());
            if(!DupCheck.contains(A)){
                DupCheck.add(A);
                Arr.add(new Node(order++, A));
            }
        }
        S = 1;
        while(S<order-1){
            S*=2;
        }
        IndexedTree = new String[S*2];
        Arr.sort(Comparator.comparingInt(Node::getN));
        for (int i = 0; i < Arr.size(); i++) {
            Arr.get(i).index = i;
        }
        Arr.sort(Comparator.comparingInt(Node::getOrder));
        String LISCandidate;
        String LIS = "";
        int LISlen = 0;
        int spaceCnt;
        for (int i = 0; i < order-1; i++) {
            update(Arr.get(i).index, Arr.get(i).n);
            LISCandidate = "";
            spaceCnt = 1;
            LISCandidate = query(0, Arr.get(i).index);
            for(char c:LISCandidate.toCharArray()){
                if(c==' '){
                    spaceCnt++;
                }
            }
            if(spaceCnt > LISlen){
                LISlen = spaceCnt;
                LIS = LISCandidate;
            }
        }
        System.out.println(LISlen);
        System.out.println(LIS);
    }
    private static void update(int target, int value){
        int index = target + S;
        IndexedTree[index] = Integer.toString(value);
        while(index!=1){
            index/=2;
            IndexedTree[index] = ((IndexedTree[index*2]==null)?"":IndexedTree[index*2]) + ((IndexedTree[index*2+1]==null)?"":" "+IndexedTree[index*2+1]);
        }
    }
    private static String query(int left, int right){
        left += S;
        right += S;
        String leftString = null;
        String rightString = null;
        while(left < right){
            if(left%2==1){
                leftString+= (leftString==null)?(IndexedTree[left]==null)?"":IndexedTree[left]:(IndexedTree[left]==null)?"":" "+IndexedTree[left];
                left++;
            }
            if(right%2==0){
                rightString = (rightString==null)?(IndexedTree[right]==null)?"":IndexedTree[right]:(IndexedTree[right]==null)?"":rightString+" "+IndexedTree[right];
                right--;
            }
            left/=2;
            right/=2;
        }
        if(left%2==1){
            rightString = (rightString==null)?(IndexedTree[right]==null)?"":IndexedTree[right]:(IndexedTree[right]==null)?"":rightString+" "+IndexedTree[right];
        }
        if(right%2==0){
            leftString+= (leftString==null)?(IndexedTree[left]==null)?"":IndexedTree[left]:(IndexedTree[left]==null)?"":" "+IndexedTree[left];
        }
        return (leftString==null)?(rightString==null)?"":rightString:(rightString==null)?leftString:leftString+" "+rightString;
    }
    private static class Node{
        int order, n, index;
        public Node(int order, int n){
            this.order = order;
            this.n = n;
        }
        public int getN() {
            return n;
        }
        public int getOrder() {
            return order;
        }
    }
}
