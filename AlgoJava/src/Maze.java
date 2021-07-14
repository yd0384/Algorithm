
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze {
	static int n;
	static int m;
	static int[][] maze;
	static class Pos
	{
		int x,y,d=0;
		boolean visited=false;
		Pos(int x,int y)
		{
			this.x=x;
			this.y=y;
		}
		boolean isAdj(Pos p)
		{
			if(maze[p.x][p.y]==1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		m=sc.nextInt();
		String[] strs= new String[n];
		maze = new int[n][m];
		for(int i=0;i<n;i++)
		{
			strs[i]=sc.next();
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				maze[i][j]=Integer.valueOf(strs[i].charAt(j))-48;
			}
		}
		Queue<Pos> q= new LinkedList<Pos>();
		Pos[][] Parr = new Pos[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				Parr[i][j]=new Pos(i,j);
			}
		}
		q.offer(Parr[0][0]);
		Parr[0][0].d=1;
		while(!Parr[n-1][m-1].visited)
		{
			Pos c = q.poll();
			if(!c.visited)
			{
				c.visited=true;
				if(c.x>0)
				{
					if(!Parr[c.x-1][c.y].visited&&c.isAdj(Parr[c.x-1][c.y]))
					{
						q.offer(Parr[c.x-1][c.y]);
						Parr[c.x-1][c.y].d=c.d+1;
					}
				}
				if(c.x<n-1)
				{
					if(!Parr[c.x+1][c.y].visited&&c.isAdj(Parr[c.x+1][c.y]))
					{
						q.offer(Parr[c.x+1][c.y]);
						Parr[c.x+1][c.y].d=c.d+1;
					}
				}
				if(c.y>0)
				{
					if(!Parr[c.x][c.y-1].visited&&c.isAdj(Parr[c.x][c.y-1]))
					{
						q.offer(Parr[c.x][c.y-1]);
						Parr[c.x][c.y-1].d=c.d+1;
					}
				}
				if(c.y<m-1)
				{
					if(!Parr[c.x][c.y+1].visited&&c.isAdj(Parr[c.x][c.y+1]))
					{
						q.offer(Parr[c.x][c.y+1]);
						Parr[c.x][c.y+1].d=c.d+1;
					}
				}
			
			}
		}
		System.out.println(Parr[n-1][m-1].d);
		
		
	}

}
