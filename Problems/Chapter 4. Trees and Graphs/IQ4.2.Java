import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 4: Tree
        // IQ 4.2 Minimal Tree:

        /*

        Question:

        Given a sorted (increasing order) array with unique integer elements, write an algorithm
        to create a binary search tree with minimal height.

        EXAMPLE

        Input: {1, 2, 3, 4, 5, 6};


        Solution:


        */


        int [] A = {1, 2, 3, 4, 5, 6};

        TreeNode root = buildMinBST(A);

        inOrderTraversal(root);

    }


    public static TreeNode buildMinBST(int [] A ){

        int lo = 0;
        int hi = A.length-1;

        TreeNode root = buildMinBST(A, lo, hi);

        return root;


    }

    public static TreeNode buildMinBST (int [] A, int lo, int hi){

        if( lo == hi){
            TreeNode leaf = new TreeNode(A[lo]);
            return leaf;
        }

        if(lo < 0 || hi >= A.length || lo > hi)
            return null;

        int mid = (hi-lo)/2 + lo;
        TreeNode root = new TreeNode(A[mid]);
        root.left = buildMinBST(A, lo, mid - 1);
        root.right = buildMinBST(A, mid + 1, hi);

        return root;
    }


    public static class TreeNode{

        TreeNode left;
        TreeNode right;
        int data;

        TreeNode(int data){

         this.data = data;
         this.left = null;
         this.right = null;

        }


    }

    public static void inOrderTraversal(TreeNode node){

        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);

        }
    }


}
