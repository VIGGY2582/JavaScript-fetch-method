import java.util.*;

class Solution {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] value = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
            left[i] = sc.nextInt();
            right[i] = sc.nextInt();
        }
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(value[i]);
        }
        for (int i = 0; i < n; i++) {
            if (left[i] != -1) {
                nodes[i].left = nodes[left[i]];
            }
            if (right[i] != -1) {
                nodes[i].right = nodes[right[i]];
            }
        }

        Node root = nodes[0];
        int result = largestBSTSubtree(root);

        System.out.println(result);
    }

    public static int largestBSTSubtree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftMax = largestBSTSubtree(root.left);
        int rightMax = largestBSTSubtree(root.right);
        int current = isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) ? count(root) : 0;
        return Math.max(current, Math.max(leftMax, rightMax));
    }

    static boolean isBST(Node root , int min , int max){
        if(root == null){
            return true;
        }
        if(root.val>max || root.val<min){
            return false;
        }
        boolean left = isBST(root.left, min, root.val);
        boolean ryt = isBST(root.right, root.val, max);
        return left && ryt;
    }


    static int count(Node root){
        if(root==null){
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

}