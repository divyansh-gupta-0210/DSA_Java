package PractiseQuestions;

import java.util.*;

class Pair{
    Node node;
    int ht;

    public Pair(Node node, int ht){
        this.node = node;
        this.ht = ht;
    }
}

class Tuple{
    Node node;
    int row;
    int col;
    public Tuple(Node node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

class Node{
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val = val;
    }
}

public class TreesPractise {

//            1
//          /   \
//         2     3
//        / \   / \
//       4   5 6   7
//      /     \     \
//     8       9    10

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
//        root.left.left.left = new Node(8);
//        root.left.right.right = new Node(9);
//        root.right.right.right = new Node(10);

//        Node root1 = new Node(1);
//        root1.left = new Node(2);
//        root1.right = new Node(3);
//        root1.left.left = new Node(4);
//        root1.left.right = new Node(5);
//        root1.right.left = new Node(6);
//        root1.right.right = new Node(7);
//        root1.left.left.left = new Node(8);

        int[] maxi = new int[1];
        ArrayList<Integer> ans = new ArrayList<>();
//        preorderRecursive(root); // Preorder (Root -> Left -> Right)
//        postorderRecursive(root); // PostOrder (Left -> Right -> Root)
//        inOrderRecursive(root); //Inorder (Left -> Root -> Right)
//        levelOrderTraversal(root);
//        preOrderIterative(root);
//        inOrderIterative(root);
//        postOrderIterative(root);
//        allTraversalInOne(root);
//        print(maximumDepthOfBinaryTree(root));
//        print(checkBalancedBinaryTree(root));
//        diameterOfABinaryTree(root, maxi);
//        maximumPathSum(root, maxi);
//        print(checkIfTwoTreesAreIdenticalOrNot(root, root1));
//        zigzagTraversal(root);
//        boundaryTraversal(root);
//        verticalOrderTraversal(root);
//        topView(root);
//        bottomView(root);
//        rightSideView(root, 0, ans); // Reverse PreOrder (Root -> Right -> Left)
        leftSideVide(root, 0, ans);
        print(ans);
    }

    public static void leftSideVide(Node node, int level, ArrayList<Integer> ans){
        if(node == null){
            return;
        }
        if(ans.size() == level){
            ans.add(node.val);
        }
        leftSideVide(node.left, level+1, ans);
        leftSideVide(node.right, level+1, ans);
    }

    public static void rightSideView(Node node, int level, ArrayList<Integer> ans){
         if(node == null){
             return;
         }
         if(ans.size() == level){
             ans.add(node.val);
         }
        rightSideView(node.right, level+1, ans);
        rightSideView(node.left, level+1, ans);
    }

    public static void bottomView(Node node){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        if(node == null){
            print(ans);
        }
        queue.offer(new Pair(node, 0));
        while(!queue.isEmpty()){
            Pair it = queue.poll();
            int ht = it.ht;
            Node temp = it.node;
            map.put(ht, temp.val);
            if(temp.left != null){
                queue.offer(new Pair(temp.left, ht-1));
            }
            if(temp.right != null){
                queue.offer(new Pair(temp.right, ht+1));
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        print(ans);
    }

    public static void topView(Node node){
        ArrayList<Integer> ans = new ArrayList<>();
        if(node == null) print(ans);
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        queue.offer(new Pair(node, 0));
        while(!queue.isEmpty()){
            Pair it = queue.poll();
            int ht = it.ht;
            Node temp = it.node;
            if(!map.containsKey(ht)){
                map.put(ht, temp.val);
            }
            if(temp.left != null){
                queue.offer(new Pair(temp.left, ht - 1));
            }
            if(temp.right != null){
                queue.offer(new Pair(temp.right, ht + 1));
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        print(ans);
    }

    public static void verticalOrderTraversal(Node node){
        Queue<Tuple> queue = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> ans = new TreeMap<>();
        if(node == null){
            print(ans);
        }
        queue.offer(new Tuple(node, 0, 0));
        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            int x = tuple.row; int y = tuple.col; Node cur = tuple.node;

            ans.putIfAbsent(x, new TreeMap<>());
            ans.get(x).putIfAbsent(y, new PriorityQueue<>());
            ans.get(x).get(y).offer(cur.val);

            if(cur.left != null){
                queue.offer(new Tuple(cur.left, x - 1, y + 1));
            }
            if(cur.right != null){
                queue.offer(new Tuple(cur.right, x + 1, y + 1));
            }
        }
        ArrayList<ArrayList<Integer>> fans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> tmv : ans.values()){
            fans.add(new ArrayList<>());
            for(PriorityQueue<Integer> q : tmv.values()){
                while(!q.isEmpty()){
                    fans.get(fans.size()-1).add(q.poll());
                }
            }
        }
        print(fans);
    }

    public static void boundaryTraversal(Node node){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(node.val);
        addLeftBoundary(node, ans);
        addLeafNodes(node, ans);
        addRightBoundary(node, ans);
        print(ans);
    }


    public static void addLeftBoundary(Node node, ArrayList<Integer> ans){
        Node cur = node.left;
        while(cur!=null){
            if(!isLeaf(cur)){
                ans.add(cur.val);
            }
            if(cur.left!= null){
                cur = cur.left;
            }
            else{
                cur = cur.right;
            }
        }
    }

    public static void addLeafNodes(Node node, ArrayList<Integer> ans){
        if(isLeaf(node)){
            ans.add(node.val);
            return;
        }
        if(node.left != null) {
            addLeafNodes(node.left, ans);
        }
        if(node.right != null) {
            addLeafNodes(node.right, ans);
        }
    }

    public static void addRightBoundary(Node node, ArrayList<Integer> ans){
        Node cur = node.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while(cur!=null){
            if(!isLeaf(cur)){
                temp.add(cur.val);
            }
            if(cur.right != null){
                cur = cur.right;
            }
            else{
                cur = cur.left;
            }
        }
        for(int i = temp.size()-1; i >= 0; i--){
            ans.add(temp.get(i));
        }
    }

    public static boolean isLeaf(Node node){
        if(node.left == null && node.right == null){
            return true;
        }
        return false;
    }

    public static void zigzagTraversal(Node node){
        Queue<Node> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(node == null){
            print(ans);
        }
        queue.offer(node);

        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int level = queue.size();
            ArrayList<Integer> subAns = new ArrayList<>();
            for(int i = 0; i < level; i++){
                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                if(leftToRight){
                    subAns.add(queue.poll().val);
                }
                else{
                    subAns.add(0, queue.poll().val);
                }
            }
            leftToRight = !leftToRight;
            ans.add(subAns);
        }
        print(ans);
    }

    public static boolean checkIfTwoTreesAreIdenticalOrNot(Node node1, Node node2){
        if(node1 == null || node2 == null){
            return node1 == node2;
        }

        return node1.val == node2.val
                && checkIfTwoTreesAreIdenticalOrNot(node1.left, node2.left)
                && checkIfTwoTreesAreIdenticalOrNot(node1.right, node2.right);
    }

    public static int maximumPathSum(Node node, int[] maxi){
        if(node == null){
            return 0;
        }
        int leftSum = maximumPathSum(node.left, maxi);
        int rightSum = maximumPathSum(node.right, maxi);
        maxi[0] = Math.max(maxi[0], leftSum + rightSum + node.val);
        return node.val + Math.max(leftSum, rightSum);
    }

    public static int diameterOfABinaryTree(Node node, int[] maxi){

//        Longest path between any 2 nodes + path can / cannot pass via root
        if(node == null){
            return 0;
        }
        int lh = diameterOfABinaryTree(node.left, maxi);
        int rh = diameterOfABinaryTree(node.right, maxi);
        maxi[0] = Math.max(lh + rh + 1, maxi[0]);
        return 1 + Math.max(lh, rh);
    }

    public static int checkBalancedBinaryTree(Node node){

//    public static boolean checkBalancedBinaryTree(Node node){
//    height of left subtree and right subtree is <= 1

//        Optimal
        if(node == null){
            return 0;
        }
        int lh = checkBalancedBinaryTree(node.left);
        int rh = checkBalancedBinaryTree(node.right);
        if(rh == -1 || lh == -1) return -1;
        if(Math.abs(lh - rh) > 1) return -1;
        return 1 + Math.max(lh, rh);

//        Brute
//        if(node == null){
//             return true;
//        }
//        int leftHeight = maximumDepthOfBinaryTree(node.left);
//        int rightHeight = maximumDepthOfBinaryTree(node.right);
//        if(Math.abs(rightHeight - leftHeight) > 1){
//            return false;
//        }
//        boolean left = checkBalancedBinaryTree(node.left);
//        boolean right = checkBalancedBinaryTree(node.right);
//        return left && right;
    }

    public static int maximumDepthOfBinaryTree(Node node){

//        Optimal
        if(node == null){
            return 0;
        }
        int left = maximumDepthOfBinaryTree(node.left);
        int right = maximumDepthOfBinaryTree(node.right);
        return 1 + Math.max(left, right);

//        Brute
//        Queue<Node> queue = new LinkedList<>();
//        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//        queue.offer(node);
//        while(!queue.isEmpty()){
//            int level = queue.size();
//            ArrayList<Integer> fans = new ArrayList<>();
//            for(int i = 0; i < level; i++){
//                if(queue.peek().left != null){
//                    queue.offer(queue.peek().left);
//                }
//                if(queue.peek().right != null){
//                    queue.offer(queue.peek().right);
//                }
//                fans.add(queue.poll().val);
//            }
//            ans.add(fans);
//        }
//        print(ans.size());
    }

    public static void allTraversalInOne(Node root){
        ArrayList<Integer> preOrder = new ArrayList<>();
        ArrayList<Integer> inOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        if(root == null) {return;}
        stack.add(new Pair(root, 1));

        while(!stack.isEmpty()){
            Pair it = stack.pop();
            if(it.ht == 1){
                preOrder.add(it.node.val);
                it.ht++;
                stack.push(it);
                if(it.node.left != null){
                    stack.push(new Pair(it.node.left, 1));
                }
            }
            else if(it.ht == 2){
                inOrder.add(it.node.val);
                it.ht++;
                stack.push(it);
                if(it.node.right != null){
                    stack.push(new Pair(it.node.right, 1));
                }
            }
            else{
                postOrder.add(it.node.val);
            }
        }
        print(preOrder + "\n");
        print(inOrder + "\n");
        print(postOrder);
    }

    public static void postOrderIterative(Node node){

//        Using 1 stack
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Node current = node;
        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.push(current);
                current = current.left;
            }
            else{
                Node temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    ans.add(temp.val);
                    while(!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        ans.add(temp.val);
                    }
                }
                else{
                    current = temp;
                }
            }
        }
        print(ans);

//        Using 2 stacks
//         Stack<Node> stack1 = new Stack<>();
//         Stack<Node> stack2 = new Stack<>();
//         ArrayList<Integer> ans = new ArrayList<>();
//         stack1.push(node);
//
//         while(!stack1.isEmpty()){
//             Node root = stack1.pop();
//             stack2.push(root);
//             if(root.left != null){
//                 stack1.add(root.left);
//             }
//             if(root.right != null){
//                 stack1.add(root.right);
//             }
//         }
//         while(!stack2.isEmpty()){
//             ans.add(stack2.pop().val);
//         }
//         print(ans);
    }

    public static void inOrderIterative(Node root){
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        while(true){
            if(root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                root = stack.pop();
                ans.add(root.val);
                root = root.right;
            }
        }
        print(ans);

//        Node current = root;
//        while (current != null || !stack.isEmpty()) {
//            while(current != null){
//                stack.push(current);
//                current = current.left;
//            }
//            current = stack.pop();
//            ans.add(current.val);
//            current = current.right;
//        }
//        print(ans);
    }

    public static void preOrderIterative(Node root){
        Stack<Node> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            print(ans);
        }
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            ans.add(root.val);
            if(root.right != null){
                stack.push(root.right);
            }
            if(root.left != null){
                stack.push(root.left);
            }
        }
        print(ans);
    }

    public static void levelOrderTraversal(Node node){
        Queue<Node> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(node == null){
            return;
        }
        queue.offer(node);
        while(!queue.isEmpty()){
            int level = queue.size();
            ArrayList<Integer> subAns = new ArrayList<>();
            for(int i = 0; i < level; i++){
                if(queue.peek().left != null){
                    queue.offer(queue.peek().left);
                }
                if(queue.peek().right != null){
                    queue.offer(queue.peek().right);
                }
                subAns.add(queue.poll().val);
            }
            ans.add(subAns);
        }
        print(ans);
    }

    public static void inOrderRecursive(Node node){
        if(node == null){
            return;
        }
        inOrderRecursive(node.left);
        print(node.val);
        inOrderRecursive(node.right);
    }

    public static void postorderRecursive(Node node){
        if(node == null){
            return;
        }
        postorderRecursive(node.left);
        postorderRecursive(node.right);
        print(node.val);
    }

    public static void preorderRecursive(Node node){
        if(node == null){
            return;
        }
        print(node.val);
        preorderRecursive(node.left);
        preorderRecursive(node.right);
    }

    public static void print(Object object){
        System.out.print(object + " ");
    }
}
