package PractiseQuestions;

import java.util.Stack;

public class StackAndQueuePractise {
    public static void main(String[] args) {

//        StackImplementation st = new StackImplementation();
//        st.push(5);
//        st.push(2);
//        st.push(3);
//        st.display();
//        System.out.println("\n");
//        st.pop();
//        st.display();
//        System.out.println("\n" + st.size());

//        QueueImplementation queueImplementation = new QueueImplementation(4);
//        queueImplementation.push(5);
//        queueImplementation.push(23);
//        queueImplementation.push(8);
//        queueImplementation.display();
//        System.out.print("\n");
//        queueImplementation.pop();
//        System.out.print("\n");
//        queueImplementation.display();
//        System.out.println(queueImplementation.size());

//        InfixPostfixPrefix infixPostfixPrefix = new InfixPostfixPrefix("a+b*(c^d-e");
//        infixPostfixPrefix.infixToPostfix();
//        infixPostfixPrefix.infixToPrefix();
//        String s = "()[{}()";
//        balancedParenthesis(s);
        
    }

    public static void balancedParenthesis(String s){
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        int i = 0;
        while(i < ch.length){
            if(ch[i] == '(' || ch[i] == '{' || ch[i] == '['){
                stack.push(ch[i]);
            }
            if(ch[i] == '}' && stack.peek() == '{'){
                stack.pop();
            }
            else if(ch[i] == ')' && stack.peek() == '('){
                stack.pop();
            }
            else if(ch[i] == ']' && stack.peek() == '['){
                stack.pop();
            }
            i++;
        }
        System.out.println(stack.isEmpty());
    }
}

class InfixPostfixPrefix{
    String s;

    public InfixPostfixPrefix(String s){
        this.s = s;
    }

    public int priority(char op){
        if(op == '+' || op == '-'){
            return 1;
        }
        else if(op == '*' || op == '/'){
            return 2;
        }
        else if(op == '^'){
            return 3;
        }
        return 0;
    }

    public void infixToPostfix(){
        char[] ch = s.toCharArray();
        int i = 0;
        Stack<Character> stack = new Stack<>();
        String ans = "";
        while(i < s.length()){
            if((ch[i] >= 'A' && ch[i] <= 'Z') || (ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= '0' && ch[i] <= '9')){
                ans += ch[i];
            }
            else if(ch[i] == '('){
                stack.push(ch[i]);
            }
            else if(ch[i] == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    ans += stack.pop();
                }
                stack.pop();
            }
            else{
                while(!stack.isEmpty() && priority(ch[i]) <= priority(stack.peek())){
                    ans += stack.peek();
                    stack.pop();
                }
                stack.push(ch[i]);
            }
            i++;
        }
        while(!stack.isEmpty()){
            ans += stack.peek();
            stack.pop();
        }
        System.out.println(ans);
    }

    public void infixToPrefix(){

        String reverse = "";
        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);

            if(c == '(')
                reverse += ')';
            else if(c == ')')
                reverse += '(';
            else
                reverse += c;
        }
        char[] ch = reverse.toCharArray();
        int i = 0;
        Stack<Character> stack = new Stack<>();
        String ans = "";
        while(i < reverse.length()){
            if(Character.isLetterOrDigit(ch[i])){
                ans += ch[i];
            }
            else if(ch[i] == '('){
                stack.push(ch[i]);
            }
            else if(ch[i] == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    ans += stack.pop();
                }
                stack.pop();
            }
            else{
                while(!stack.isEmpty() && priority(ch[i]) <= priority(stack.peek())){
                    ans += stack.pop();
                }
                stack.push(ch[i]);
            }
            i++;
        }
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        String reverse2 = "";
        for(int j = ans.length() - 1; j >= 0; j--){
            reverse2 += ans.charAt(j);
        }

        System.out.println(reverse2);
    }
}

class QueueImplementation {
    int cur_size = 0;
    int start = -1, end = -1;
    int[] queue;
    int size;

    public QueueImplementation(int capacity){
        queue = new int[capacity];
        size = capacity;
    }

    public void push(int x){
        if(cur_size == size){
            throw new RuntimeException("Queue is full");
        }

        if(cur_size == 0){
            start = 0;
            end = 0;
        } else {
            end = (end + 1) % size;
        }

        queue[end] = x;
        cur_size++;
    }

    public int pop(){
        if(cur_size == 0){
            throw new RuntimeException("Queue is empty");
        }

        int element = queue[start];
        cur_size--;

        if(cur_size == 0){
            start = -1;
            end = -1;
        } else {
            start = (start + 1) % size;
        }

        return element;
    }

    public int top(){
        if(cur_size == 0){
            throw new RuntimeException("Queue is empty");
        }
        return queue[start];
    }

    public int size(){
        return cur_size;
    }

    public void display(){
        if(cur_size == 0){
            System.out.println("Queue is empty");
            return;
        }

        int i = start;
        for(int count = 0; count < cur_size; count++){
            System.out.print(queue[i] + " ");
            i = (i + 1) % size;
        }
        System.out.println();
    }
}

class StackImplementation{
    int top = -1;
    int[] st;

    public StackImplementation(){
        st = new int[10];
    }

    public void push(int x){
        if(top >= 10){
            return;
        }
        top = top + 1;
        st[top] = x;
    }

    public int top(){
        if(top == -1){
            return 0;
        }
        return st[top];
    }

    public void pop(){
        if(top == -1){
            return;
        }
        st[top] = 0;
        top = top - 1;
    }

    public int size(){
        return top+1;
    }

    public void display(){
        for(int i : st){
            if(i!=0){
                System.out.print(i + " ");
            }
        }
    }

}
