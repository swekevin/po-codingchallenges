/*
JAVA CODING PROBLEM:
Write a code to convert a sorted array to a balanced binary search tree.


LOGICAL REASONING:
A watch, which loses time uniformly, was observed to be 5 minutes fast at 8.00 p.m. on Thursday.
It was noticed to be 7 minutes slow at 8.00 a.m. on the subsequent Monday.
When did the watch show the correct time ? Explanation needed.

a) 7 a.m. Saturday b) 7 a.m. on Friday
c) 10a.m. on Sunday d) 11 a.m. on Friday

 */

import java.util.*;

public class August302021 {
    public static void main(String[] args) {
        Integer[] test1 = {1, 2, 3, 4, 5, 6, 7};
        TreeNode tree1 = sortedArrayToNode(test1);
        preOrder(tree1);
    }

    public static TreeNode sortedArrayToNode(Integer[] array){
        int mid = array.length / 2;
        TreeNode root = buildTree(array, 0, array.length - 1);

        return root;
    }


    public static TreeNode buildTree(Integer[] array, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end)/2;
        TreeNode result = new TreeNode(array[mid]);

        result.left = buildTree(array, start, mid -1);
        result.right = buildTree(array, mid +1, end);

        return result;
    }

    public static void preOrder(TreeNode node){
        if(node == null){
            return;
        }
        System.out.println(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static int getHeight(TreeNode node){
        int leftHeight = 0;
        int rightHeight = 0;
        if(node.left == null && node.right == null){ return 0; }
        if(node.left != null){ leftHeight += 1 + getHeight(node.left); }

        if(node.right != null){ rightHeight += 1 + getHeight(node.right); }

        if(leftHeight > rightHeight){ return leftHeight; }
        else{ return rightHeight; }

    }

    static class TreeNode{

        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(){ }

        public TreeNode(int val){
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public String toString(){
            return ""+ this.val;
        }
    }
}
