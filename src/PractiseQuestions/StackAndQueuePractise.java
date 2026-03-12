package PractiseQuestions;

import java.util.*;

class PairStack{
    int num;
    int min;
    public PairStack(int num, int min){
        this.num = num;
        this.min = min;
    }
}

class PairStackStock{
    int val;
    int ind;
    public PairStackStock(int val, int ind){
        this.val = val;
        this.ind = ind;
    }
}

class NodeDLL{
    int val; int key;
    NodeDLL prev; NodeDLL next;
    public NodeDLL(int key, int val){
        this.key = key;
        this.val = val;
    }
}
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

//        MinStackImplementation minStack = new MinStackImplementation();
//        minStack.push(5);
//        minStack.push(10);
//        System.out.println(minStack.getMin());
//        minStack.push(1);
//        System.out.println(minStack.getMin());

//        MinStackImplementationUsingMinVal minStack = new MinStackImplementationUsingMinVal();
//        minStack.push(5);
//        minStack.push(10);
//        System.out.println(minStack.getMin());
//        minStack.push(1);
//        System.out.println(minStack.getMin());

//        int[] arr = new int[]{4,12,5,3,1,2,5,3,1,2,4,6};
//        nextGreaterElement(arr);
//
//        int[] arr2 = new int[]{2,10,12,1,11};
//        nextGreaterElementII(arr2);

//        int[] arr = new int[]{5,7,9,6,9,4,5,1,3,7};
//        nearestSmallerElement(arr);

//        int[] arr = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
//        trappingRainwater(arr);

//        int[] arr = new int[]{3,1,2,4};
//        sumOfSubarrayMin(arr);

//        int[] arr = new int[]{1,4,3,2};
//        sumOfSubarrayRanges(arr);
//        int[] arr = new int[]{4,7,1,1,2,-3,-7,17,15,-16,-18,-19};
//        asteroidCollision(arr);
//        int[] arr = new int[]{2,1,5,6,2,3};
//        largestRectangleInAHistogram(arr);

//        int[][] arr = new int[][]{{1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,1,1}, {1,0,0,0,1}};
//        maximumRectangleInHistogram(arr);

//        String s = "1432219";
//        removeKDigits(s, 3);
//        int[] arr = new int[]{7,2,1,3,3,5,8};
//        stockSpanner(arr);

//        int[] arr = new int[]{1,3,-1,-3,5,3,2,1,6};
//        slidingWindowMaximum(arr, 3);

//        int[][] arr = new int[][]{{0,1,1,0},{0,0,0,0},{0,1,0,0},{1,1,0,0}};
//        celebrityProblem(arr);

        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));   // returns 1
        cache.put(3,3); // removes key 2
        System.out.println(cache.get(2));   // returns -1
    }

    public static void celebrityProblem(int[][] arr){

//        Optimal
        int top = 0; int down = arr.length - 1;
        while(top < down){
            if(arr[top][down] == 1){
                top = top + 1;
            }
            else{
                down--;
            }
        }
        int candidate = top;
        for(int i = 0; i < arr.length; i++){
            if(i != candidate){
                if(arr[candidate][i] == 1 || arr[i][candidate] == 0){
                    System.out.println("No Celebrity");
                    break;
                }
            }
        }
        System.out.println(top);

//        Brute
//        int n = arr.length;
//        int[] knowMe = new int[n];
//        int[] iKnow = new int[n];
//        for(int i = 0; i < arr.length; i++){
//            for(int j = 0; j < arr[0].length; j++){
//                if(arr[i][j] == 1){
//                    knowMe[j]++;
//                    iKnow[i]++;
//                }
//            }
//        }
//        for(int i = 0; i < n-1; i++){
//            if(knowMe[i] == n-1 && iKnow[i] == 0){
//                System.out.println(i);
//            }
//        }
    }

    public static void slidingWindowMaximum(int[] arr, int k){

//        Optimal
        Deque<Integer> deque = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            if(!deque.isEmpty() && deque.peekFirst() <= i-k){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && arr[deque.peekLast()] < arr[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            if(i>=k-1){
                ans.add(arr[deque.peekFirst()]);
            }
        }
        System.out.println(ans);

//        Brute
//        ArrayList<Integer> ans = new ArrayList<>();
//        for(int i = 0; i <= arr.length - k; i++){
//            int maxi = arr[i];
//            for(int j = i; j < i + k; j++){
//                maxi = Math.max(maxi, arr[j]);
//            }
//            ans.add(maxi);
//        }
//        System.out.println(ans);
    }

    public static void stockSpanner(int[] arr){

//        Optimal
         Stack<PairStackStock> stack = new Stack<>();
         int[] span = new int[arr.length];
         for(int i = 0; i < arr.length; i++){
             while(!stack.isEmpty() && stack.peek().val <= arr[i]){
                 stack.pop();
             }
             if(stack.isEmpty()){
                 span[i] = i + 1;
             }
             else{
                 span[i] = i - stack.peek().ind;
             }
             stack.add(new PairStackStock(arr[i], i));
         }
        System.out.println(Arrays.toString(span));

//        Better
//        int[] pge = findPGE(arr);
//        int maxCnt = 0;
//        for(int i = 0; i < arr.length; i++){
//            maxCnt = Math.max(maxCnt, i - pge[i]);
//        }
//        System.out.println(maxCnt);

//        Brute
//        ArrayList<Integer> ans = new ArrayList<>();
//        int maxCnt = 0;
//        for(int i = 0; i < arr.length; i++){
//            int cnt = 1;
//            for(int j = i-1; j >= 0; j--){
//                if(arr[j] <= arr[i]){
//                    cnt++;
//                }
//                else{
//                    break;
//                }
//            }
//            maxCnt = Math.max(cnt, maxCnt);
//        }
//        System.out.println(maxCnt);
    }

    public static void removeKDigits(String s, int k){
        char[] ch = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < ch.length; i++){
            while(!stack.isEmpty() && stack.peek()-'0' > ch[i]-'0' && k > 0){
                stack.pop();
                k--;
            }
            stack.push(ch[i]);
        }
        if(k!=0){
            while(k>0){
                stack.pop();
                k--;
            }
        }
        if(stack.isEmpty()){
            System.out.println(0);
        }
        String res = "";
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        String ans = new StringBuilder(res).reverse().toString();
        int i = 0;
        while(i < ans.length() && ans.charAt(i) == '0'){
            i++;
        }
        ans = ans.substring(i);
        if(ans.length() == 0){
            System.out.println(0);
        } else {
            System.out.println(ans);
        }
    }

    public static void maximumRectangleInHistogram(int[][] arr){
        int n = arr.length; int m = arr[0].length; int maxArea = 0; int[][] prefixSum = new int[n][m];

        for(int j = 0; j < m; j++){
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += arr[i][j];
                if(arr[i][j] == 0){
                    sum = 0;
                }
                prefixSum[i][j] = sum;
            }
        }

        for(int i = 0; i < n; i++){
            maxArea = Math.max(maxArea, largestRectangleInAHistogram(prefixSum[i]));
        }
        System.out.println(maxArea);
    }

    public static int largestRectangleInAHistogram(int[] arr){

//        Optimal
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                int element = stack.peek();
                stack.pop();
                int nse = i;
                int pse = stack.isEmpty()?-1:stack.peek();
                maxArea = Math.max(maxArea, arr[element] * (nse - pse - 1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int nse = arr.length;
            int ele = stack.peek();
            stack.pop();
            int pse = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, arr[ele] * (nse - pse - 1));
        }
//        System.out.println(maxArea);
        return maxArea;
//        Brute
//        int[] pse = findPSE(arr);
//        int[] nse = findNSE(arr);
//        int maxi = 0;
//        for(int i = 0; i < arr.length; i++){
//            int area = arr[i] * (nse[i] - pse[i] - 1);
//            maxi = Math.max(maxi, area);
//        }
//        System.out.println(maxi);
    }

    public static void asteroidCollision(int[] arr){
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++){

            if(arr[i] > 0){
                stack.push(arr[i]);
            }
            else{
                while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(arr[i])){
                    stack.pop();
                }
                if(!stack.isEmpty() && stack.peek() == Math.abs(arr[i])){
                    stack.pop();
                }
                else if(stack.isEmpty() || stack.peek() < 0){
                    stack.push(arr[i]);
                }
            }

//            boolean isDestroyed = false;
//            int a = arr[i];
//            while(!stack.isEmpty() && a < 0 && stack.peek() > 0){
//                if(stack.peek() < -a){
//                    stack.pop();
//                    continue;
//                }
//                else if(stack.peek() == -a){
//                    stack.pop();
//                }
//                isDestroyed = true;
//                break;
//            }
//            if(!isDestroyed){
//                stack.push(a);
//            }
        }
        System.out.println(stack);
    }

    public static void sumOfSubarrayRanges(int[] arr){

//      Optimal
        int largest = sumOfSubarrayMax(arr);
        int smallest = sumOfSubarrayMin(arr);
        System.out.println(largest - smallest);

//        Brute
//        int sum = 0;
//        for(int i = 0; i < arr.length; i++){
//            int max = arr[i], min = arr[i];
//            for(int j = i+1; j < arr.length; j++){
//                max = Math.max(max, arr[j]);
//                min = Math.min(min, arr[j]);
//                sum += (max - min);
//            }
//        }
//        System.out.println(sum);
    }

    public static int sumOfSubarrayMax(int[] arr){
        int total = 0;
        int[] pge = findPGE(arr);
        int[] nge = findNGE(arr);

        for(int i = 0; i < arr.length; i++){
            int left = i - pge[i];
            int right = nge[i] - i;
            total += (right * left * arr[i]);
        }
        return total;
    }

    public static int[] findPGE(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] pge = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                stack.pop();
            }
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pge;
    }

    public static int[] findNGE(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] pge = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            pge[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return pge;
    }

    public static int sumOfSubarrayMin(int[] arr){

//        Optimal

        int total = 0;
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);
        for(int i = 0; i < arr.length; i++){
            int left = i - pse[i];
            int right = nse[i] - i;
            total = (total + (right * left * arr[i]));
        }
//        System.out.println(total);
        return total;
//        Brute
//        int sum = 0;
//        for(int i = 0; i < arr.length; i++){
//            int mini = arr[i];
//            for(int j = i; j < arr.length; j++){
//                mini = Math.min(mini, arr[j]);
//                sum = sum + mini;
//            }
//        }
//        System.out.println(sum);
    }

    public static int[] findPSE(int[] arr){
        int[] pse = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            pse[i]= stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return pse;
    }

    public static int[] findNSE(int[] arr){
        int[] nse = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length - 1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return nse;
    }

    public static void trappingRainwater(int[] arr){

//        Optimal
         int leftMax = 0, rightMax = 0, total = 0, l = 0, r = arr.length - 1;
         while(l < r){
             if(arr[l] <= arr[r]){
                 if(leftMax > arr[l]){
                     total += leftMax - arr[l];
                 }
                 else{
                     leftMax = arr[l];
                 }
                 l = l + 1;
             }
             else{
                 if(rightMax > arr[r]){
                     total += rightMax - arr[r];
                 }
                 else{
                     rightMax = arr[r];
                 }
                 r = r - 1;
             }
         }
         System.out.println(total);

//        Brute
//        int total = 0;
//        int[] prefixMax = prefixMax(arr);
//        int[] suffixMax = suffixMax(arr);
//        for(int i = 0; i < arr.length; i++){
//            int leftMax = prefixMax[i];
//            int rightMax = suffixMax[i];
//            if(arr[i] < leftMax && arr[i] < rightMax){
//                total += Math.min(leftMax, rightMax) - arr[i];
//            }
//        }
//        System.out.println(total);
    }

    public static int[] suffixMax(int[] arr){
        int[] suffix = new int[arr.length];
        suffix[arr.length - 1] = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; i--){
            suffix[i] = Math.max(suffix[i+1], arr[i]);
        }
        return suffix;
    }

    public static int[] prefixMax(int[] arr){
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            prefix[i] = Math.max(prefix[i-1], arr[i]);
        }
        return prefix;
    }

    public static void nearestSmallerElement(int[] arr){

//        Optimal
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }
            int num = stack.isEmpty() ? -1 : stack.peek();
            ans.add(num);
            stack.push(arr[i]);
        }
        System.out.println(ans);
//        Brute
//        ArrayList<Integer> ans = new ArrayList<>();
//        for(int i = 0; i < arr.length; i++){
//            boolean changed = false;
//            for(int j = i-1; j >= 0; j--){
//                if(arr[j] < arr[i]){
//                    ans.add(arr[j]);
//                    changed = true;
//                    break;
//                }
//            }
//            if(!changed){
//                ans.add(-1);
//            }
//        }
//        System.out.println(ans);
    }

    public static void nextGreaterElementII(int[] arr){
//        See it as a circular array
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 2 * n - 1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i%n]){
                stack.pop();
            }
            if(i < n){
                int num = stack.isEmpty() ? -1 : stack.peek();
                ans.add(0, num);
            }
            stack.push(arr[i%n]);
        }
        System.out.println(ans);
//        Better (take it as a circular array)
//        ArrayList<Integer> ans = new ArrayList<>();
//        for(int i = 0; i < arr.length; i++){
//            boolean added = false;
//            for(int j = i + 1; j < i + arr.length -1; j++){
//                int ind = j % arr.length;
//                if(arr[ind] > arr[i]){
//                    ans.add(arr[ind]);
//                    added = true;
//                    break;
//                }
//            }
//            if(!added){
//               ans.add(-1);
//            }
//        }
//        System.out.println(ans);

//        Brute
//        For brute force solution, we need to run the for loop of i ->
//        from i+1 to arr.length if found -> return true
//        else if not found -> 0 to i to find if an element exists
    }

    public static void nextGreaterElement(int[] arr){

//        Optimal
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = arr.length -1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            int num = stack.isEmpty() ? -1 : stack.peek();
            ans.add(0, num);
            stack.push(arr[i]);
        }
        System.out.println(ans);

//        Brute
//        Stack<Integer> ans = new Stack<>();
//        for(int i = 0; i < arr.length; i++){
//            boolean added = false;
//            for(int j = i + 1; j < arr.length; j++){
//                if(arr[j] > arr[i]){
//                    ans.add(arr[j]);
//                    added = true;
//                    break;
//                }
//            }
//            if(!added){
//               ans.push(-1);
//            }
//        }
//        System.out.println(ans);
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

class LRUCache{
    int capacity;
    HashMap<Integer, NodeDLL> map;

    NodeDLL head;
    NodeDLL tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        map = new HashMap<>();
        head = new NodeDLL(0,0);
        tail = new NodeDLL(0,0);
        head.next = tail;
        tail.prev = head;
    }

    private void remove(NodeDLL node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(NodeDLL node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        NodeDLL node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        NodeDLL node = new NodeDLL(key,value);
        insert(node);
        map.put(key,node);
        if(map.size() > capacity){
            NodeDLL lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }
}


class MinStackImplementationUsingMinVal{
    Stack<Integer> minStack;
    int mini;
    public MinStackImplementationUsingMinVal(){
        minStack = new Stack<>();
        mini = Integer.MAX_VALUE;
    }

    public void push(int val){
        if(minStack.isEmpty()){
            mini = val;
            minStack.push(val);
        }
        else{
            if(val > mini){
                minStack.push(val);
            }
            else{
                minStack.push(2 * val - mini);
                mini = val;
            }
        }
    }

    public void pop(){
        if(minStack.isEmpty()){
            return;
        }
        int n = minStack.peek();
        minStack.pop();
        if(n < mini){
            mini = 2 * mini - n;
        }
    }

    public int top(){
        if(minStack.isEmpty()){
            return 0;
        }
        int x = minStack.peek();
        if(mini < x){
            return x;
        }
        return mini;
    }

    public int getMin(){
        return mini;
    }

}

class MinStackImplementation{
    Stack<PairStack> minStack;
    public MinStackImplementation(){
        minStack = new Stack<>();
    }
    public void push(int val){
        if(minStack.isEmpty()){
            minStack.push(new PairStack(val, val));
        }
        else{
            minStack.push(new PairStack(val, Math.min(val, minStack.peek().min)));
        }
    }

    public int getMin(){
        return minStack.peek().min;
    }

    public int top(){
        return minStack.peek().num;
    }
    public void pop(){
        if(!minStack.isEmpty()){
            minStack.pop();
        }
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
