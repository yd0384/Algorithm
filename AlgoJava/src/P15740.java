
import java.util.Scanner;
import java.util.Stack;

public class P15740 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a=sc.next(),b=sc.next();
		if(a.equals("0")||a.equals("-0")){
			System.out.println((b.equals("-0"))?b.substring(1):b);
			System.exit(0);
		}
		else if(b.equals("0")||b.equals("0")){
			System.out.println((a.equals("-0"))?a.substring(1):a);
			System.exit(0);
		}
		Stack<Character> stA = new Stack<Character>();
		Stack<Character> stB = new Stack<Character>();
		Stack<Character> stC = new Stack<Character>();
		int up=0;
		int num;
		if(a.charAt(0)=='-'&&b.charAt(0)=='-'){
			a=a.substring(1, a.length());
			b=b.substring(1, b.length());
		if(a.length()>=b.length()){
		for(char c:a.toCharArray()){
			stA.push(c);
		}
		for(char c:b.toCharArray()){
			stB.push(c);
		}
		}
		else{
			for(char c:b.toCharArray()){
				stA.push(c);
			}
			for(char c:a.toCharArray()){
				stB.push(c);
			}
		}
		while(true){
			if(stA.isEmpty()&&stB.isEmpty()){
				if(up>0){
					stC.push('1');
				}
				break;
			}
			else{
				if(stB.isEmpty()){
					num=(int)(stA.pop()-48)+up;
					up=num/10;
					num=num%10;
					stC.push((char)(num+48));
				}
				else{
					num=(int)(stA.pop())-48+(int)(stB.pop())-48+up;
					up=num/10;
					num=num%10;
					stC.push((char)(num+48));
				}
			}
		}
		String st="-";
		while(!stC.isEmpty()){
			st+=stC.pop();
		}
		
		System.out.println(st);
	}
	else if(a.charAt(0)!='-'&&b.charAt(0)!='-'){
		if(a.length()>=b.length()){
			for(char c:a.toCharArray()){
				stA.push(c);
			}
			for(char c:b.toCharArray()){
				stB.push(c);
			}
			}
			else{
				for(char c:b.toCharArray()){
					stA.push(c);
				}
				for(char c:a.toCharArray()){
					stB.push(c);
				}
			}
			while(true){
				if(stA.isEmpty()&&stB.isEmpty()){
					if(up>0){
						stC.push('1');
					}
					break;
				}
				else{
					if(stB.isEmpty()){
						num=(int)(stA.pop()-48)+up;
						up=num/10;
						num=num%10;
						stC.push((char)(num+48));
					}
					else{
						num=(int)(stA.pop())-48+(int)(stB.pop())-48+up;
						up=num/10;
						num=num%10;
						stC.push((char)(num+48));
					}
				}
			}
			String st="";
			while(!stC.isEmpty()){
				st+=stC.pop();
			}
			
			System.out.println(st);
		}
	else{
		boolean bf=false;
		if(a.charAt(0)=='-'){
			a=a.substring(1, a.length());
			bf=false;
		}
		else{
			b=b.substring(1,b.length());
			bf=true;
		}
		if(a==b){
			System.out.println(0);
		}
		else{
			boolean bigger=true;
			if(a.length()>b.length()){
				bigger=true;
			}
			else if(a.length()==b.length()){
				for(int i=0;i<a.length();i++){
					if(a.charAt(i)==b.charAt(i)){
						continue;
					}
					bigger=(a.charAt(i)>b.charAt(i))?true:false;
					break;
				}
			}
			else{
				bigger=false;
			}
			for(char c:a.toCharArray()){
				stA.push(c);
			}
			for(char c:b.toCharArray()){
				stB.push(c);
			}
			if(bigger){
				while(true){
					if(stA.isEmpty()&&stB.isEmpty()){
						break;
					}
					else if(stB.isEmpty()){
						num=(int)(stA.pop())-48-up;
						if(num>=0){
							stC.push((char)(num+48));
							up=0;
						}
						else{
							stC.push((char)(10+num+48));
							up=1;
						}
					}
					else{
						num=(int)(stA.pop())-48-(int)(stB.pop())+48-up;
						if(num>=0){
							stC.push((char)(num+48));
							up=0;
						}
						else{
							stC.push((char)(10+num+48));
							up=1;
						}
					}
				}
				String st =(!bf)?"-":"";
				boolean zerof=true;
				while(!stC.isEmpty()){
					if(stC.peek()=='0'&&zerof){
						stC.pop();
					}
					else{
					st+=stC.pop();
					zerof=false;
					}
				}
				System.out.println(st);
			}
			else{
				while(true){
					if(stA.isEmpty()&&stB.isEmpty()){
						break;
					}
					else if(stA.isEmpty()){
						num=(int)(stB.pop())-48-up;
						if(num>=0){
							stC.push((char)(num+48));
							up=0;
						}
						else{
							stC.push((char)(10+num+48));
							up=1;
						}
					}
					else{
						num=-(int)(stA.pop())-48+(int)(stB.pop())+48-up;
						if(num>=0){
							stC.push((char)(num+48));
							up=0;
						}
						else{
							stC.push((char)(10+num+48));
							up=1;
						}
					}
				}
				String st =(!bf)?"":"-";
				boolean zerof=true;
				while(!stC.isEmpty()){
					if(stC.peek()=='0'&&zerof){
						stC.pop();
					}
					else{
					st+=stC.pop();
					zerof=false;
					}
				}
				System.out.println(st);
			}
		}
		
	}
	}

}
