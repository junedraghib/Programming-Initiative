package Test;

import java.util.Scanner;
import java.util.Stack;

public class CheckDuplicateParenthesis {

	public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        String str = s.next();
        System.out.println(checkduplicate(str));
    }
    
    public static boolean checkduplicate(String str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch != ')'){
                stack.push(ch);
            } else if( ch == ')'){
                int counter = 0;
                while(stack.pop() != getcomp(ch)){
                    counter++;
                }
                
                if(counter <= 1){
                    return true;
                }
            }
        }
        return false;
    }
    
    public static char getcomp(char ch){
        if(ch == ')'){
            return '(';
        } else if(ch == '}'){
            return '{';
        } else {
            return '[';
        }
    }
}