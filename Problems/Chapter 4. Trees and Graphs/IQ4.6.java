import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 4: Tree and Graphs
        // IQ 4.6 Successor

        /*

        Question:

        Write an algorithm to find the "next" node (i .e., in-order successor) of a given node in a
        binary search tree. You may assume that each node has a link to its parent.

         */

        Tree t = new Tree();

        t.add(5);
        t.add(3);
        t.add(1);
        t.add(4);
        t.add(8);
        t.add(6);
        t.add(10);


        BST_Node node = t.root.left.right;

        System.out.println(node.data);

        if (t.getNextInOrder(node) != null)
            System.out.println(t.getNextInOrder(node).data);
        else
            System.out.println(t.getNextInOrder(node));

    }

    public BST_Node getNextInOrder(BST_Node node){

        if (node == null)
            return null;

        if (node.right != null){
            node = node.right;
            while (node.left != null){
                node = node.left;
            }
            return node;
        }

        BST_Node temp = node;
        int data = node.data;

        while (node.data <= data){
           node = node.parent;

           if (node == null)
               return null;
        }

        if (temp == node) // if node is last node in tree
            return null;
        else
            return node;

    }

}