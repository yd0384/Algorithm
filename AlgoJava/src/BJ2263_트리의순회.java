import java.util.*;
import java.io.*;
public class BJ2263_트리의순회 {
    static int[] inOrder;
    static int[] postOrder;
    static int[] preOrder;
    static int preIndex = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        inOrder = new int[n];
        postOrder = new int[n];
        preOrder = new int[n];
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }
        divide(0, n-1, 0, n-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(preOrder[i] + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
    static void divide(int startIn, int endIn, int startPost, int endPost) {
        int root = postOrder[endPost];
        preOrder[preIndex++] = root;
        int rootIn = 0;
        for(int i = startIn; i <= endIn; i++) {
            if(inOrder[i] == root) {
                rootIn = i;
                break;
            }
        }
        int leftEndIn = rootIn-1;
        int rightStartIn = rootIn+1;
        if(leftEndIn - startIn >= 0) {
            //left 존재
            if(endIn - rightStartIn < 0) {
                //right 존재 X
                //root만 빼고 left 탐색
                divide(startIn, endIn-1, startPost, endPost-1);
            }
            else {
                //left right 둘다 존재
                //post의 start, end 인덱스 찾아서 left, right 탐색

                int rightStartNum = inOrder[rightStartIn];
                int rightStartPost = 0;
                for(int i = startPost; i <= endPost; i++) {
                    if(postOrder[i] == rightStartNum) {
                        rightStartPost = i;
                        break;
                    }
                }
                divide(startIn, leftEndIn, startPost, rightStartPost-1);
                divide(rightStartIn, endIn, rightStartPost, endPost-1);
            }
        }
        else{
            //left가 없을 때
            if(startIn + 1 <= endIn && startPost <= endPost-1) {
                divide(startIn+1, endIn, startPost, endPost-1);
            }
        }
        
    }
}
