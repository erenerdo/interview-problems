import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 4: Tree and Graphs
        // IQ 4.3 List Of Depths

        /*
        Question:

       Given a binary tree, design an algorithm which creates a linked list of all the nodes
        at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).

         */

        Tree t = new Tree();

        t.add(3);
        t.add(1);
        t.add(5);
        t.add(0);
        t.add(2);
        t.add(4);
        t.add(6);

        //t.inOrderTraversal();


        ArrayList<LinkedList<Integer>> AL = listOfDepths(t.root);

        for ( LinkedList L : AL){

            for (int i = 0; i < L.size() - 1; i++)
                System.out.print(L.get(i) + " -> ");

            System.out.println(L.getLast());

        }




    }


    public static ArrayList<LinkedList<Integer>> listOfDepths(BST_Node root){

        ArrayList<LinkedList<Integer>> linkedListHeads = new ArrayList<>();

        LinkedList<BST_Node> Queue_A = new LinkedList<>();

        LinkedList<BST_Node> Queue_B = new LinkedList<>();

        Queue_A.add(root);

        while (!Queue_A.isEmpty() || !Queue_B.isEmpty()){

            if (Queue_A.isEmpty())
                break;

            LinkedList<Integer> ll = new LinkedList<>();

            while (!Queue_A.isEmpty()){

                BST_Node temp = Queue_A.removeLast();

                ll.add(temp.data);

                if (temp.left != null)
                    Queue_B.add(temp.left);

                if (temp.right != null)
                    Queue_B.add(temp.right);

            }

            linkedListHeads.add(ll);

            if (Queue_B.isEmpty()){
                break;
            }

            LinkedList<Integer> ll2 = new LinkedList<>();

            while (!Queue_B.isEmpty()){

                BST_Node temp = Queue_B.removeLast();

                ll2.add(temp.data);

                if (temp.left != null)
                    Queue_A.add(temp.left);

                if (temp.right != null)
                    Queue_A.add(temp.right);


            }

            linkedListHeads.add(ll2);

        }

        return linkedListHeads;

    }




    public static class Tree {

        BST_Node root;

        Tree(){
            this.root = null;
        }

        public void add(int data){

            if (root == null) {
                root = new BST_Node(data);
                return;
            }

            BST_Node temp = root;

            while (true) {

                if (data > temp.data) {

                    if (temp.right == null){
                        BST_Node node = new BST_Node(data);
                        temp.right = node;
                        return;
                    }
                    else
                        temp = temp.right;
                }


                else {
                    if (temp.left == null){
                        BST_Node node = new BST_Node(data);
                        temp.left = node;
                        return;
                    }
                    else
                        temp = temp.left;

                }
            }


        }



        public void inOrderTraversal(){

            inOrderTraversal(root);

        }


        public void inOrderTraversal(BST_Node node){

            if (node != null) {
                inOrderTraversal(node.left);
                System.out.println(node.data);
                inOrderTraversal(node.right);

            }
        }
    }

    public static class BST_Node {

        int data;
        BST_Node left;
        BST_Node right;

        BST_Node(int data) {

            this.data = data;
            this.left = null;
            this.right = null;
        }


    }



}