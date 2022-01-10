import java.util.Scanner;

public class BJ1167_트리의지름 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        try{
            int V = sc.nextInt();
            int tree[][] = new int[V+1][V+1];
            for(int i=0;i<=V;i++){
                for(int j=0;j<=V;j++){
                    if(i!=j){
                        tree[i][j] = 10001;
                    }
                }
            }
            sc.nextLine();
            for(int i=0;i<V;i++){
                String[] input = sc.nextLine().split(" ");
                int j = 0;
                int u = Integer.valueOf(input[j]);
                int v, e;
                for(j=1;!input[j].equals("-1");j+=2){
                    v = Integer.valueOf(input[j]);
                    e = Integer.valueOf(input[j+1]);
                    tree[u][v] = e;
                }
            }
            for (int k=1;k<=V;k++){
                for(int i=1;i<=V;i++){
                    for(int j=1;j<=V;j++){
                        tree[i][j] = Math.min(tree[i][j], tree[i][k] + tree[k][j]);
                    }
                }
            }
            int answer = 0;
            for(int i=1;i<=V;i++){
                for(int j=1;j<=V;j++){
                    if(i!=j){
                        if(tree[i][j]>answer){
                            answer=tree[i][j];
                        }
                    }
                }
            }
            System.out.println(answer);
        }
        finally{
            sc.close();
        }
    }
}
