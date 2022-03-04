import java.util.*;
public class BJ1918_후위표기식 {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();
        Scanner sc = new Scanner(System.in);
        String inOrder = sc.next();
        String postOrder = "";
        for(char c : inOrder.toCharArray()){
            if(!isOp(c)){
                postOrder += c;
            }
            else{
                if(c != '(' && c != ')'){
                    while(!stack.isEmpty() && priority(c) <= priority(stack.peek())){
                        postOrder += stack.pop();
                    }
                    stack.push(c);
                }
                else{
                    if(c == '('){
                        stack.push(c);
                    }
                    else{
                        char top = stack.pop();
                        while(top != '('){
                            postOrder += top;
                            top = stack.pop();
                        }
                    }
                }
            }
        }
        while(!stack.isEmpty()){
            postOrder += stack.pop();
        }
        System.out.println(postOrder);
        sc.close();
    }
    private static int priority(char op){
        if(op == '(' || op == ')'){
            return 0;
        }
        else if(op == '+' || op == '-'){
            return 1;
        }
        else{
            return 2;
        }
    }
    private static boolean isOp(char c){
        if(c == '*' || c == '/' || c == '+' || c == '-' || c == '(' || c==')'){
            return true;
        }
        return false;
    }
}
