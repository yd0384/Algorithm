import java.util.*;
import java.io.*;
public class BJ12015_가장긴증가하는부분수열2 {
    static int[] IndexedTree;
    static List<Integer> A;
    static int S;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        A = new ArrayList<Integer>();

        for(int i=0; i<N; i++){
            int x = Integer.parseInt(st.nextToken());
            if(!set.contains(x)){
                set.add(x);
                A.add(x);
            }
        }
        int[] insertOrder = new int[A.size()];
        for(int i=0; i<A.size(); i++){
            insertOrder[i] = A.get(i);
        }
        A.sort(Comparator.comparingInt(o->o));
        
        S = 1;
        while(S < A.size()){
            S*=2;
        }
        IndexedTree = new int[S*2];
        int Answer = 0;
        for(int i=0; i<A.size(); i++){
            int position = A.indexOf(insertOrder[i]);
            updateTo1(position);
            Answer = Math.max(Answer, query(0, position));
        }
        System.out.println(Answer);
    }
    static private void updateTo1(int target){
        target += S;
        IndexedTree[target]=1;
        while(target>1){
            target/=2;
            IndexedTree[target]+=1;
        }
    }
    static private int query(int left, int right){
        left = left+S;
        right = right+S;
        int ret = 0;
        while(right >= left){
            if(left%2==1){
                ret += IndexedTree[left];
                left++;
            }
            if(right%2==0){
                ret += IndexedTree[right];
                right--;
            }
            left/=2;
            right/=2;
        }
        return ret;
    }
}
