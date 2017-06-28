import java.io.IOException;
import java.util.ArrayList;

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

        System.out.println("Is BST checker returned: " + t.isBST());

        t.root.left.data = 15;

        System.out.println("Is BST checker returned: " + t.isBST());

        

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


        public boolean isBST(){

            ArrayList<Integer> arrayList = new ArrayList<>();

            inOrderTraversal(root,arrayList);

            for (int i = 0; i < arrayList.size() - 1; i++){

                if (arrayList.get(i) > arrayList.get(i+1))
                    return false;
            }

            return true;
        }


        public void inOrderTraversal(BST_Node node, ArrayList<Integer> arrayList){


            if (node != null) {
                inOrderTraversal(node.left, arrayList);
                arrayList.add(node.data);
                inOrderTraversal(node.right, arrayList);

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