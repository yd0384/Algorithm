package joon;

import java.util.Scanner;
import java.util.Stack;
public class Pivo3 {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s=sc.nextLine();
		int[] pivo=new int[1500001];
		pivo[0]=0;
		pivo[1]=1;
		for(int i=2;i<1500001;i++){
			pivo[i]=(pivo[i-1]+pivo[i-2])%1000000;
		}
		if(s.length()>=7){
		BigI a=new BigI(s);
		Stack<Integer> b=a.getS();
		Stack<Integer> c=new Stack<Integer>();
		while(!b.isEmpty()){
			c.push(b.pop());
		}
		while(c.size()>7){
			c.pop();
		}
		int x=c.pop();
		int y=c.pop();
		if(y<=5){
			c.push(y);
		}
		else{
			c.push(y-5);
		}
		if(x<=1){
			c.push(x);
		}
		while(!c.isEmpty()){
			b.push(c.pop());
		}
		a.setS(b);
		
		System.out.println(pivo[Integer.parseInt(a.toString())]);
		}
		else{
			System.out.println(pivo[Integer.parseInt(s)]);
		}
		
	}

}
 class BigI {
	   
	   private Stack<Integer> s=new Stack<Integer>(); //실제 값을 담을 
	   
	   public BigI(String str){	//숫자 스트링을받는 생성자
	      if(str.charAt(0) == '─'){
	         
	         for(int i = 1; i < str.length(); i++)
	            s.push((int)str.charAt(i)-48);
	      }
	      else{
	         
	         for(int i = 0; i < str.length(); i++)
	            s.push((int)str.charAt(i)-48);
	         
	      }
	   }
	   
	   public BigI(){ //디폴트 생성자
	      this("0");
	   }

	   
	   public Stack<Integer> getS() {	//스택 값 반환. 원래 스택은 보존함.
	      return (Stack<Integer>) this.s.clone();
	   }

	   public void setS(Stack<Integer> s) {	//스택 값 설정. 스택 복사해서 가져감. 
	      this.s = (Stack<Integer>)s.clone();
	   }
	   
	   public void pushS(int i){	//스택에 임의로 값 푸시.
	      this.s.push(i);
	   }

	   public int popS(){		//스택에서 값 임의로 팝.
	      return this.s.pop();
	   }
	   
	   public String toString(){	//숫자를 읽을 수 있게 스트링으로 적음.
	      String res = "";
	      	      
	      Stack<Integer> s1 = new Stack<Integer>();
	      Stack<Integer> s2 = new Stack<Integer>();
	      
	      s1 = this.getS();
	      int x = s1.size();
	      
	      for(int i = 0; i < x; i++)
	         s2.push(s1.pop());
	      
	      for(int i = 0; i < x; i++)
	         res += s2.pop();
	      
	      return res;
	   }
	   
	   public Stack<Integer> getInversStack(){	//스택을 뒤집음. 가장 높은자리가 탑에 있게.
	      
	      Stack<Integer> s1 = new Stack<Integer>();
	      Stack<Integer> s2 = new Stack<Integer>();
	      s1 = this.getS();
	      
	      while(!s1.isEmpty())
	         s2.push(s1.pop());
	      
	      return s2;
	   }
	   
	   public boolean hassBiggerStackThan(BigI b){	//스택 값을 비교함. 같아도 false임. 커야 true.
	      
	      if(this.getS().size() > b.getS().size())
	         return true;
	      
	      else if(this.getS().size() < b.getS().size())
	         return false;
	      
	      else{
	         
	         Stack<Integer> s1 = new Stack<Integer>();
	         Stack<Integer> s2 = new Stack<Integer>();
	         
	         s1 = this.getInversStack();
	         s2 = b.getInversStack();
	         int x = s1.size();
	         
	         for(int i = 0; i < x; i++){
	            if(s1.peek().compareTo(s2.peek()) == 0){
	               s1.pop();
	               s2.pop();
	               continue;
	               }
	            else if(s1.pop().compareTo(s2.pop()) > 0)
	               return true;
	            else
	               return false;
	         }
	         return true;
	      }
	   }
	   
	  
	   
	 
	   }
