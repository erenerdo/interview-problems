// Chapter 4: Tree and Graphs
// IQ 4.4 Check Balanced

        /*

        Question:

        Implement a function to check if a binary tree is balanced. For the purposes of
        this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
        node never differ by more than one.

         */
	private int getHeight(BST_Node root){

        if (root == null)
            return -1;

        int leftHeight = getHeight(root.left);
        if (leftHeight == -2)
            return -2;

        int rightHeight = getHeight(root.right);
        if (rightHeight == -2)
            return -2;

        if (Math.abs((rightHeight - leftHeight)) <= 1)
            return (1 + Math.max(rightHeight,leftHeight));

        else
            return -2;

    }

    public boolean isBalanced(){

        return getHeight(root) != -2;
    }