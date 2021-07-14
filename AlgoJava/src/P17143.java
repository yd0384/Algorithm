
import java.util.ArrayList;
import java.util.Scanner;

public class P17143 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int R=sc.nextInt(),C=sc.nextInt(),M=sc.nextInt();
		Sea sea=new Sea(R,C);
		for(int m=0;m<M;m++){
			Fish shark=new Fish(sc.nextInt()-1,sc.nextInt()-1,sc.nextInt(),sc.nextInt(),sc.nextInt());
			sea.board[shark.r][shark.c]=shark;
			sea.sharks.add(shark);
		}
		int res=0;
		for(int c=0;c<C;c++){
			res+=sea.Catch(c);
			sea.move();
		}
		System.out.println(res);
	}

}
class Sea{
	Fish[][] board;
	ArrayList<Fish> sharks=new ArrayList<Fish>();
	int R=0,C=0;
	public Sea(int R,int C){
		this.R=R;
		this.C=C;
		board=new Fish[R][C];
	}
	int Catch(int c){
		for(int i=0;i<R;i++){
			if(board[i][c]!=null){
				int z=board[i][c].z;
				sharks.remove(board[i][c]);
				board[i][c]=null;
				return z;
			}
		}
		return 0;
	}
	void move(){
		int s;
		this.clearboard();
		for(int i=0;i<sharks.size();i++){
			Fish ish=sharks.get(i);
			switch(ish.d){
			case 1:
			case 2:
				s=ish.s;
				while(s!=0){
					if(ish.d==1){
						if(ish.r<s){
							s-=ish.r;
							ish.r=0;
							ish.d=2;
						}else{
							ish.r=ish.r-s;
							s=0;
						}
					}
					if(ish.d==2){
						if(R-ish.r-1<s){
							s-=R-ish.r-1;
							ish.r=R-1;
							ish.d=1;
						}else{
							ish.r=ish.r+s;
							s=0;
						}
					}
				}
				
				break;
			case 3:
			case 4:
				s=ish.s;
				while(s!=0){
					if(ish.d==4){
						if(ish.c<s){
							s-=ish.c;
							ish.c=0;
							ish.d=3;
						}else{
							ish.c=ish.c-s;
							s=0;
						}
					}
					if(ish.d==3){
						if(C-ish.c-1<s){
							s-=C-ish.c-1;
							ish.c=C-1;
							ish.d=4;
						}else{
							ish.c=ish.c+s;
							s=0;
						}
					}
				}
				break;
			}
			if(board[ish.r][ish.c]!=null){
				Compare(ish.r,ish.c,ish);
				i--;
			}
			else{
				board[ish.r][ish.c]=ish;
			}
		}
	}
	void clearboard(){
		for(int i=0;i<R;i++)
			for(int j=0;j<C;j++)
				board[i][j]=null;
	}
	void Compare(int r,int c,Fish shark){
		if(board[r][c].z<shark.z){
			sharks.remove(board[r][c]);
			board[r][c]=shark;
		}
		else{
			sharks.remove(shark);
		}
	}
}
class Fish{
	int r,c,s,d,z;
	public Fish(int r,int c,int s,int d,int z){
		this.r=r;
		this.c=c;
		this.s=s;
		this.d=d;
		this.z=z;
	}
	
}