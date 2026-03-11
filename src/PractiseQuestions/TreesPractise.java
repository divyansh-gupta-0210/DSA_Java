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
        Node root = new Node(3);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(1);
//        root.left.right = new Node(5);
//        root.right.left = new Node(6);
//        root.right.right = new Node(7);
//        root.left.left.left = new Node(8);
//        root.left.right.right = new Node(9);
//        root.right.right.right = new Node(10);

        int[] maxi = new int[1];
        ArrayList<Integer> ans = new ArrayList<>();
//        Node root1 = new Node(1);
//        root1.left = new Node(2);
//        root1.right = new Node(3);
//        root1.left.left = new Node(4);
//        root1.left.right = new Node(5);
//        root1.right.left = new Node(6);
//        root1.right.right = new Node(7);
//        root1.left.left.left = new Node(8);
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
//        leftSideVide(root, 0, ans);
//        isSymmetricTree(root);
//        rootToNodePath(root, 9, ans);
//        lowestCommonAncestor(root, 6, 10);
//        widthOfABinaryTree(root);
//                   33
//                /       \
//              17         16
//             /  \       /   \
//            8    9     6     10
//           /      \             \
//          8        9            10
//        childrenSumProperty(root);
//        nodesAtADistanceK(root, 2, ans, 5);
//        print(timeTakenToBurnABTFromANode(root, 9));
//        print(countNumberOfNodesInACompleteBT(root));

//        ArrayList<Integer> inorder = new ArrayList<>();
//        inorder.add(9);inorder.add(3);inorder.add(15);inorder.add(20);inorder.add(7);
//        ArrayList<Integer> preorder = new ArrayList<>();
//        preorder.add(3);preorder.add(9);preorder.add(20);preorder.add(15);preorder.add(7);
//        buildATreeFromPreAndInorder(inorder, preorder);

//        ArrayList<Integer> inorder = new ArrayList<>();
//        inorder.add(9);inorder.add(3);inorder.add(15);inorder.add(20);inorder.add(7);
//        ArrayList<Integer> postOrder = new ArrayList<>();
//        postOrder.add(3);postOrder.add(9);postOrder.add(20);postOrder.add(15);postOrder.add(7);
//        buildATreeFromPostAndInorder(inorder, postOrder);

//        String s = serialize(root);
//        print(s);
//        Node deserialized = deserialize(s);
//        levelOrderTraversal(deserialized);
//        morisTraversalInorder(root, ans);
//        morisTraversalPreorder(root, ans);
//        printLinkedList(flattenBinaryTreeRecursive(root));
//        flattenBinaryTreeIterative(root);
//        print(ans);

        print(longestConsecutive(root, maxi));
    }

    public static int longestConsecutive(Node root, int[] ans){
        dfsLC(root, ans);
        return ans[0];
    }

    public static int[] dfsLC(Node node, int[] ans){
        if(node == null){
            return new int[]{0,0};
        }
        int inc = 1;
        int dec = 1;
        if(node.left != null){
            int[] left = dfsLC(node.left, ans);
            if(node.val == node.left.val + 1){
                dec = Math.max(dec, left[1] + 1);
            }
            if(node.val == node.left.val - 1){
                inc = Math.max(inc, left[0] + 1);
            }
        }
        if(node.right != null){
            int[] right = dfsLC(node.right, ans);
            if(node.val == node.right.val + 1){
                dec = Math.max(dec, right[1] + 1);
            }
            if(node.val == node.right.val - 1){
                inc = Math.max(inc, right[0] + 1);
            }
        }
        ans[0] = Math.max(ans[0], inc + dec - 1);
        return new int[]{inc, dec};
    }

    public static void printLinkedList(Node node){
        while(node!=null){
            print(node.val);
            node = node.right;
        }
        print("\n");
    }

    public static void flattenBinaryTreeIterative(Node root){
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            Node cur = st.peek();
            st.pop();
            if(cur.right != null){
                st.add(cur.right);
            }
            if(cur.left!= null){
                st.add(cur.left);
            }
            if(!st.isEmpty()){
                cur.right = st.peek();
            }
            cur.left = null;
        }
        printLinkedList(root);
    }

    public static Node flattenBinaryTreeRecursive(Node root){
        if(root == null){
            return null;
        }
        Node right = flattenBinaryTreeRecursive(root.right);
        Node left = flattenBinaryTreeRecursive(root.left);
        root.right = right;
        root.left = null;
        Node temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        temp.right = left;
        return root;
    }

    public static void morisTraversalPreorder(Node node, ArrayList<Integer> ans){
        Node cur = node;
        while(cur!= null){
            if(cur.left == null){
                ans.add(cur.val);
                cur = cur.right;
            }
            else{
                Node prev = cur.left;
                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = cur;
                    ans.add(cur.val);
                    cur = cur.left;
                }
                else{
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }
    }

    public static void morisTraversalInorder(Node node, ArrayList<Integer> ans){
        Node cur = node;
        while(cur!= null){
            if(cur.left == null){
                ans.add(cur.val);
                cur = cur.right;
            }
            else{
                Node prev = cur.left;
                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = cur;
                    cur = cur.left;
                }
                else{
                    prev.right = null;
                    ans.add(cur.val);
                    cur = cur.right;
                }
            }
        }
    }

    public static Node deserialize(String s){
        if(s.isEmpty()){
            return null;
        }
        String[] values = s.split(" ");
        Queue<Node> queue = new LinkedList<>();
        Node ans = new Node(Integer.parseInt(values[0]));
        queue.add(ans);
        for(int i = 1; i < values.length; i++){
            Node parent = queue.poll();
            if(!values[i].equals("n")){
                Node left = new Node(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            if(!values[++i].equals("n")){
                Node right = new Node(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return ans;
    }

    public static String serialize(Node root){
        StringBuilder ans = new StringBuilder();
        if(root == null) {
            return "";
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(cur == null){
                ans.append("n ");
                continue;
            }
            ans.append(cur.val).append(" ");
            queue.add(cur.left);
            queue.add(cur.right);
        }

        return ans.toString();
    }

    public static void buildATreeFromPostAndInorder(ArrayList<Integer> inorder, ArrayList<Integer> postOrder){
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.size(); i++){
            inMap.put(inorder.get(i), i);
        }
        Node root = buildATreePostIn(postOrder, 0, postOrder.size()-1, inorder, 0, inorder.size()-1, inMap);
        inOrderRecursive(root);
    }

    public static Node buildATreePostIn(
            ArrayList<Integer> post, int postStart, int postEnd, ArrayList<Integer> in,
            int inStart, int inEnd, HashMap<Integer, Integer> inMap){
        if(postStart > postEnd || inStart > inEnd){
            return null;
        }
        Node root = new Node(post.get(postEnd));
        int inRoot = inMap.get(post.get(postEnd));
        int numsLeft = inRoot - inStart;
        root.left =
                buildATreePostIn(post, postStart, postStart + numsLeft - 1, in, inStart, inRoot - 1, inMap);
        root.right =
                buildATreePostIn(post, postStart+numsLeft, postEnd - 1, in, inRoot + 1, inEnd, inMap);
        return root;
    }

    public static void buildATreeFromPreAndInorder(ArrayList<Integer> inorder, ArrayList<Integer> preorder){
        HashMap<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.size(); i++){
            inMap.put(inorder.get(i), i);
        }
        Node root = buildATreePreIn(preorder, 0, preorder.size()-1, inorder, 0, inorder.size(), inMap);
        inOrderRecursive(root);
    }

    public static Node buildATreePreIn(
            ArrayList<Integer> pre, int preStart, int preEnd, ArrayList<Integer> in,
            int inStart, int inEnd, HashMap<Integer, Integer> inMap){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        Node root = new Node(pre.get(preStart));
        int inRoot = inMap.get(root.val);
        int numsLeft = inRoot - inStart;
        root.left =
                buildATreePreIn(pre, preStart + 1, preStart + numsLeft, in, inStart, inRoot-1, inMap);
        root.right =
                buildATreePreIn(pre, preStart + numsLeft + 1, preEnd, in, inRoot + 1, inEnd, inMap);
        return root;
    }

    public static int countNumberOfNodesInACompleteBT(Node root){
        if(root == null){
            return 0;
        }
        int lh = countLeftHeight(root);
        int rh = countRightHeight(root);
        if(lh == rh){
            return ((2<<lh) - 1);
        }
        return 1 + countNumberOfNodesInACompleteBT(root.left) + countNumberOfNodesInACompleteBT(root.right);
    }

    public static int countRightHeight(Node node){
        int c = 0;
        while(node.right!= null){
            c++;
            node = node.right;
        }
        return c;
    }

    public static int countLeftHeight(Node node){
        int c = 0;
        while(node.left!=null){
            node = node.left;
            c++;
        }
        return c;
    }

    public static int timeTakenToBurnABTFromANode(Node node, int target){
        if(node == null){
            return 0;
        }
        int time = -1;
        HashMap<Node, Node> map_parents = new HashMap<>();
        mark_parents_Burn(map_parents, node);
        Node toBurnFrom = findNodeToBurnFrom(node, target);

        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        queue.offer(toBurnFrom);
        visited.add(toBurnFrom);
        while (!queue.isEmpty()){
            int size = queue.size();
            time++;
            for(int i = 0; i < size; i++){
                Node cur = queue.poll();
                if(cur.left!=null && !visited.contains(cur.left)){
                    queue.offer(cur.left);
                    visited.add(cur.left);
                }
                if(cur.right!=null && !visited.contains(cur.right)){
                    queue.offer(cur.right);
                    visited.add(cur.right);
                }
                Node parent = map_parents.get(cur);
                if(parent != null && !visited.contains(parent)){
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
        }
        return time;
    }

    public static Node findNodeToBurnFrom(Node node, int target){
        if(node == null || node.val == target){
            return node;
        }
        Node left = findNodeToBurnFrom(node.left, target);
        if(left!=null){
            return left;
        }
        return findNodeToBurnFrom(node.right, target);
    }

    public static void mark_parents_Burn(HashMap<Node, Node> map_parents, Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current.left != null){
                map_parents.put(current.left, current);
                queue.offer(current.left);
            }
            if(current.right != null){
                map_parents.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

    public static void nodesAtADistanceK(Node node, int k, ArrayList<Integer> ans, int target) {
        HashMap<Node, Node> parent_map = new HashMap<>();
        mark_parents(node, parent_map);

        Map<Node, Boolean> visited = new HashMap<>();
        Node targetNode = findNode(node, target);

        if (targetNode == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(targetNode);
        visited.put(targetNode, true);

        int cur_level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (cur_level == k) break;
            cur_level++;

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                if (current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }

                if (current.right != null && visited.get(current.right) == null) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }

                if (parent_map.get(current) != null && visited.get(parent_map.get(current)) == null) {
                    queue.offer(parent_map.get(current));
                    visited.put(parent_map.get(current), true);
                }
            }
        }

        while (!queue.isEmpty()) {
            ans.add(queue.poll().val);
        }
    }

    public static Node findNode(Node root, int k){
        if(root == null || root.val == k) {
            return root;
        }
        Node left = findNode(root.left, k);
        if(left != null){
            return left;
        }
        return findNode(root.right, k);
    }

    public static void mark_parents(Node node, HashMap<Node, Node> parent_map){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current.left != null){
                parent_map.put(current.left, current);
                queue.offer(current.left);
            }
            if(current.right != null){
                parent_map.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

    public static void childrenSumProperty(Node root){
        // node - left + right -> increase the value by +1 any times
        if(root == null){
            return;
        }
        int child = 0;
        if(root.left != null){
            child+=root.left.val;
        }
        if(root.right != null){
            child+=root.right.val;
        }
        if(child >= root.val){
            root.val = child;
        }
        else{
            if(root.left != null){
                root.left.val = root.val;
            }
            else if(root.right != null){
                root.right.val = root.val;
            }
        }
        childrenSumProperty(root.left);
        childrenSumProperty(root.right);
        int tot = 0;
        if(root.left != null) tot+= root.left.val;
        if(root.right != null) tot += root.right.val;
        if(root.left != null || root.right != null) root.val = tot;
    }

    public static void widthOfABinaryTree(Node root){
        int ans = 0;
        if(root == null){
            print(ans);
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while(!queue.isEmpty()){
            int size = queue.size();
            int min = queue.peek().ht;
            int first = 0, last = 0;
            for(int i = 0; i < size; i++){
                // we subtract min in order to get the same id for the nodes to start from 0
                int cur_id = queue.peek().ht - min;
                Node node = queue.peek().node;
                queue.poll();
                if(i == 0){
                    first = cur_id;
                }
                if(i == size-1){
                    last = cur_id;
                }

                if(node.left != null){
                    queue.offer(new Pair(node.left, cur_id * 2 + 1));
                }
                if(node.right != null){
                    queue.offer(new Pair(node.right, cur_id * 2 + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        print(ans);
    }

    public static void lowestCommonAncestor(Node node, int n1, int n2){

        // Optimal
        Node ans = lowestCommonAncestorOptimal(node, n1, n2);
        print(ans.val);

        // Brute
//        ArrayList<Integer> p1 = new ArrayList<>();
//        ArrayList<Integer> p2 = new ArrayList<>();
//        rootToNodePathBrute(node, n1, p1);
//        rootToNodePathBrute(node, n2, p2);
//        int ans = 0;
//        for(int i = 0; i < Math.min(p1.size(), p2.size()); i++){
//            if(p1.get(i) == p2.get(i)){
//                ans = p1.get(i);
//            }
//            else{
//                break;
//            }
//        }
//        print(ans);
    }

    public static Node lowestCommonAncestorOptimal(Node node, int n1, int n2){
        if(node == null){
            return null;
        }
        if(node.val == n1 || node.val == n2){
            return node;
        }
        Node left = lowestCommonAncestorOptimal(node.left, n1, n2);
        Node right= lowestCommonAncestorOptimal(node.right, n1, n2);
        if(left == null){
            return right;
        }
        else if(right == null){
            return left;
        }
        else{
            return node;
        }
    }

    public static boolean rootToNodePathBrute(Node node, int val, ArrayList<Integer> path){
        if(node == null){
            return false;
        }
        path.add(node.val);
        if(node.val == val){
            return true;
        }
        if(rootToNodePathBrute(node.left, val, path) || rootToNodePathBrute(node.right, val, path)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    public static boolean rootToNodePath(Node node, int val, ArrayList<Integer> ans){
        if(node == null){
            return false;
        }
        ans.add(node.val);
        if(node.val == val){
            return true;
        }
        if(rootToNodePath(node.left, val, ans) || rootToNodePath(node.right, val, ans)){
            return true;
        }
        ans.remove(ans.size()-1);
        return false;
    }

    public static void isSymmetricTree(Node node){
        print(checkSymmetric(node.left, node.right));
    }

    public static boolean checkSymmetric(Node node1, Node node2){
        if(node1 == null || node2 == null){
            return node1 == node2;
        }
        if(node1.val != node2.val){
            return false;
        }
        return checkSymmetric(node1.left, node2.right) && checkSymmetric(node1.right, node2.left);
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
