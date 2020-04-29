import java.util.ArrayList;
import java.util.List;

public class ListTree {
    static class Node {
        int val;
        Node left;
        Node right;
        Node(int x) { val = x ;}
    }

    static Node build() {
        //通过build方法构建一棵树，返回树的根节点
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        E.left = G;
        C.right = F;
        return A;
    }

    public static List<Integer> preorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }

    public static List<Integer> inorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    public static List<Integer> postorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    static Node p() {
        Node num1 = new Node(1);
        Node num2 = new Node(2);
        num1.left = num2;
        return num1;
    }
    static Node q() {
        Node num1 = new Node(1);
        Node num2 = new Node(2);
        num1.right = num2;
        return num1;
    }
    public static boolean isSameTree(Node p, Node q) {
        //给定两个二叉树，编写一个函数来检验它们是否相同.
        //如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的.
        if(p == null && q == null) {
            return true;
        }
        if(p != null && q != null && p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        List<Integer> result1 = new ArrayList<>();
        Node root = build();
        System.out.println(preorderTraversal(root));
        System.out.println(inorderTraversal(root));
        System.out.println(postorderTraversal(root));

        boolean ret = isSameTree(p(), q());
        System.out.println(ret);
    }
}
