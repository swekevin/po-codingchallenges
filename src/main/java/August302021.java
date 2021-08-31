/*
JAVA CODING PROBLEM:
Write a code to convert a sorted array to a balanced binary search tree.


LOGICAL REASONING:
A watch, which loses time uniformly, was observed to be 5 minutes fast at 8.00 p.m. on Thursday.
It was noticed to be 7 minutes slow at 8.00 a.m. on the subsequent Monday.
When did the watch show the correct time ? Explanation needed.

a) 7 a.m. Saturday b) 7 a.m. on Friday
c) 10a.m. on Sunday d) 11 a.m. on Friday

From 8pm Thursday to 8am Monday follows a linear progression, assuming that 8pm Thursday starts at the origin.
The amount of time that passes between those two time points is (4 * 60) + (3 * 24 * 60) + (8 * 60) = 5040 minutes.
y = x, where x is in minutes, where y is the amount of minutes that has passed and x is the time progression measured
in minutes, thus has a slope of 1.

If we want to then consider that time is progressing at a different rate than how the expected slope, then the two
lines must only intersect once. Thus, we need to find the slope. m = [(5040 -7) - (5)] / 5040 = 0.99761905.

Thus the slope equation is y = 0.99761905x + 5, thus they intersect at x = 0.99761905x + 5
x = 5 / 0.00238095 = 2100 minutes or 35 horus after 8pm on Thursday.

The answer is a) 7 a.m Saturday.

This means that the only time the correct time was shown on the clock



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
