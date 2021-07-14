
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DfsBfs {
	static boolean[] visit;
	static String Dfs="";
	static String Bfs="";
	static  ArrayList<ArrayList<Integer>> trunks = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int v=sc.nextInt();
		visit = new boolean[n+1];
		for(int i=0;i<=n+1;i++)
		{
			trunks.add(new <Integer>ArrayList());
		}
		for(int i=0;i<m;i++)
		{
			int t1=sc.nextInt(),t2=sc.nextInt();
			trunks.get(t1).add(t2);
			trunks.get(t2).add(t1);
		}
		dfs(v);
		Dfs=Dfs.trim();
		System.out.println(Dfs);
		for(int i=0;i<=n;i++)
		{
			visit[i]=false;
		}
		bfs(v);
		Bfs=Bfs.trim();
		System.out.println(Bfs);
	}
	
	static void Sort(ArrayList<Integer> arr)
	{
	   for(int index = 1 ; index < arr.size() ; index++){

	      int temp = arr.get(index);
	      int aux = index - 1;

	      while( (aux >= 0) && ( arr.get(aux) > temp ) ) {

	         arr.set(aux+1,arr.get(aux));
	         aux--;
	      }
	      arr.set(aux + 1, temp);
	   }
	}
	static void dfs(int i)
	{
		
		if(!visit[i])
		{
		visit[i]=true;
		Dfs+=i+" ";
		}
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		for(int j:trunks.get(i))
		{
			if(!visit[j])
			{
				tmp.add(j);
			}
		}
		Sort(tmp);
		for(int j:tmp)
		{
			dfs(j);
		}
	}
	static void bfs(int i){
	        Queue <Integer> q = new LinkedList<Integer>();
	        
	        if(!visit[i])
	        {
	        	q.offer(i);
		        visit[i] = true;
	        }
	        	
	         while(!q.isEmpty()){
	            int temp = q.poll();
	            Bfs+=temp+" ";
	            ArrayList<Integer> tmp =new ArrayList<Integer>();
	            for(int j:trunks.get(temp))
	            {
	            	if(!visit[j])
	            	{
	            		tmp.add(j);
	            		visit[j]=true;
	            	}
	            	
	            }
	            Sort(tmp);
	            for(int j:tmp)
	            {
	            	q.offer(j);
	            }
	            }    
	    }

}
