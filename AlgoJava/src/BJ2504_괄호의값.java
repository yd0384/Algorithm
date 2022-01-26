import java.util.*;
public class BJ2504_괄호의값 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int Answer = 0;
        boolean wrong = false;
        Stack<Integer> stack = new Stack<>(); 
        for(int i=0; i<str.length() && !wrong;i++){
            char c = str.charAt(i);
            if(c=='('){
                stack.push(-1);
            }
            else if(c=='['){
                stack.push(-2);
            }
            else if(c==')'){
                int x = 0;
                int pop = 0;
                while(true){
                    if(stack.isEmpty()){
                        wrong = true;
                        break;
                    }
                    pop = stack.pop();
                    if(pop == -1){
                        if(x==0){
                            stack.push(2);
                        }
                        else{
                            stack.push(x*2);
                        }
                        break;
                    }
                    else if(pop==-2){
                        wrong = true;
                        break;
                    }
                    else{
                        x+=pop;
                    }
                }
            }
            else if(c==']'){
                int x = 0;
                int pop = 0;
                while(true){
                    if(stack.isEmpty()){
                        wrong = true;
                        break;
                    }
                    pop = stack.pop();
                    if(pop == -1){
                        wrong = true;
                        break;
                    }
                    else if(pop==-2){
                        if(x==0){
                            stack.push(3);
                        }
                        else{
                            stack.push(x*3);
                        }
                        break;
                    }
                    else{
                        x+=pop;
                    }
                }
            }
        }
        while(!stack.isEmpty()){
            int pop = stack.pop();
            if(pop<0){
                wrong=true;
                break;
            }
            Answer += pop;
            
        }
        if(wrong){
            System.out.println(0);
        }
        else{
            System.out.println(Answer);
        }
        sc.close();
    }
}
