package PractiseQuestions;

import javax.swing.tree.TreeNode;

class NodeBST{
    int key;
    NodeBST right;
    NodeBST left;

    public NodeBST(int key){
        this.key = key;
        right = left = null;
    }
}

public class BinarySearchTreePractise {

    NodeBST root;
    public static void main(String[] args) {
        BinarySearchTreePractise tree = new BinarySearchTreePractise();
        tree.insertRecursive(50);
        tree.insertRecursive(30);
        tree.insertRecursive(70);
        tree.insertRecursive(20);
        tree.insertRecursive(40);
        tree.insertRecursive(60);
        tree.insertRecursive(80);

//                  50
//                /    \
//              30      70
//             /  \    /  \
//            20  40  60   80

//        tree.inorder();
//        print(tree.search(700));
//        print(tree.findCeil(73));
//        print(tree.findFloor(73));
        tree.insertIterative(90);
        tree.insertIterative(75);
        tree.insertIterative(55);
//        tree.inorder();
//
//        tree.deleteANode(50);
//        print("\n");
//        int[] kthSmall = new int[1];
//        int[] count = new int[1];
//        tree.kthSmallest(3, count, kthSmall, tree.root);
//        print(kthSmall[0] + "\n");
//        tree.validateBST();
//        tree.inorder();
        print(tree.findLCA(tree.root, 20, 40).key);
    }

    public NodeBST findLCA(NodeBST node, int k1, int k2){
        if (node == null) {
            return null;
        }
        int cur = node.key;
        if(cur > k1 && cur > k2){
            return findLCA(node.left, k1, k2);
        }
        if(cur < k1 && cur < k2){
            return findLCA(node.right, k1, k2);
        }
        return node;
    }

    public void validateBST(){
        print(validate(root, Long.MIN_VALUE, Long.MAX_VALUE));
    }

    public boolean validate(NodeBST node, long minVal, long maxVal){
        if(node == null){
            return true;
        }
        if(node.key >= maxVal || node.key <= minVal){
            return false;
        }
        return validate(node.left, minVal, node.key)
                && validate(node.right, node.key, maxVal);
    }

    public void kthSmallest(int k, int[] c, int[] kthSmall, NodeBST node){
        if(node == null){
            return;
        }
        kthSmallest(k, c, kthSmall, node.left);
        c[0]++;
        if(k == c[0]){
            kthSmall[0] = node.key;
            return ;
        }
        kthSmallest(k, c, kthSmall, node.right);
    }

    public NodeBST deleteANode(int key){
         if(root == null){
             return null;
         }
         if(root.key == key){
             root = helper(root);
             return root;
         }
         NodeBST temp = root;
         while(temp!=null){
             if(temp.key > key){
                 if(temp.left != null && temp.left.key == key){
                     temp.left = helper(temp.left);
                     break;
                 }
                 else{
                     temp = temp.left;
                 }
             }
             else{
                 if(temp.right != null && temp.right.key == key){
                     temp.right = helper(temp.right);
                     break;
                 }
                 else {
                     temp = temp.right;
                 }
             }
         }
         return root;
    }

    public NodeBST helper(NodeBST toDelete) {

        if (toDelete.left == null)
            return toDelete.right;
        if (toDelete.right == null)
            return toDelete.left;
        NodeBST rightChild = toDelete.right;
        NodeBST lastRight = findLastRight(toDelete.left);
        lastRight.right = rightChild;
        return toDelete.left;
    }

    public NodeBST findLastRight(NodeBST findLR){
        if(findLR.right == null){
            return findLR;
        }
        return findLastRight(findLR.right);
    }

    public NodeBST insertIterative(int key){
        if(root == null){
            return new NodeBST(key);
        }
        NodeBST temp = root;
        while (true){
            if(temp.key <= key){
                if(temp.right != null){
                    temp = temp.right;
                }
                else{
                    temp.right = new NodeBST(key);
                    break;
                }
            }
            else{
                if(temp.left != null){
                    temp = temp.left;
                }
                else{
                    temp.left = new NodeBST(key);
                    break;
                }
            }
        }
        return root;
    }

    public int findFloor(int key){
        int floor = -1;
        NodeBST temp = root;
        while(temp!=null){
            if(temp.key == key){
                floor = temp.key;
                return floor;
            }
            if(key > temp.key){
                floor = temp.key;
                temp = temp.right;
            }
            else{
                temp = temp.right;
            }
        }
        return floor;
    }

    public int findCeil(int key){
        int ceil = -1;
        NodeBST temp = root;
        while(temp != null){
            if(root.key == key){
                ceil = temp.key;
                return ceil;
            }
            if(temp.key < key){
                temp = temp.right;
            }
            else{
                ceil = temp.key;
                temp = temp.left;
            }
        }
        return ceil;
    }

    public NodeBST search(int key){
        NodeBST node = root;
        while(node != null && node.key != key){
            node = key < node.key ? node.left : node.right;
        }
        return node;
    }

    public void inorder(){
        inorderRec(root);
    }

    public void inorderRec(NodeBST root){
        if(root == null){
            return;
        }
        inorderRec(root.left);
        print(root.key);
        inorderRec(root.right);
    }

    public void insertRecursive(int key){
        root = insertRec(root, key);
    }

    public NodeBST insertRec(NodeBST root, int key){
        if(root == null){
            root = new NodeBST(key);
            return root;
        }
        if(key < root.key){
            root.left = insertRec(root.left, key);
        }
        else if(key > root.key){
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    public static void print(Object obj){
        System.out.print(obj + " ");
    }

}
