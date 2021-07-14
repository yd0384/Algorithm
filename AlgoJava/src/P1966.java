package joon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P1966 {
	
	static class doc{
		boolean isM = false;
		int imp;
		doc(int imp){
			this.imp=imp;
		}
		void Mth(){
			this.isM=true;
		}
		boolean isMth(){
			if(this.isM){
				return true;
			}
			else{
				return false;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++){
			int n=sc.nextInt();
			int m=sc.nextInt();
			doc[] docs = new doc[n];
			for(int j=0;j<n;j++){
				int tmp=sc.nextInt();
				docs[j]=new doc(tmp);
				if(j==m){
					docs[j].Mth();
				}
			}
			Queue<doc> q = new LinkedList<doc>();
			for(doc j:docs){
				q.add(j);
			}
			int seq=1;
			while(true){
				doc p=q.poll();
				int max=p.imp;
				for(doc k:q){
					if(k.imp>max){
						max=k.imp;
					}
				}
				if(max==p.imp){
					if(p.isMth()){
						System.out.println(seq);
						break;
					}
					seq++;
				}
				else{
					q.add(p);
				}
			}
		}
			
	}

}
