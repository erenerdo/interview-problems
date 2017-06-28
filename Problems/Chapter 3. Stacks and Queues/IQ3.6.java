import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Chapter 3
        // IQ 3.5 Sort Stacks
        /*

        Question:

        An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first
        out" basis. People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
        or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of
        that type). They cannot select which specific animal they would like. Create the data structures to
        maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog,
        and dequeueCat. You may use the built-in Linked List data structure.

        Solution:



         */


        AnimalShelter animalShelter = new AnimalShelter();

        animalShelter.enqueue("Cat1", false);
        animalShelter.enqueue("Cat2", false);
        animalShelter.enqueue("Dog1", true);
        animalShelter.enqueue("Cat3", false);
        animalShelter.enqueue("Dog2", true);
        animalShelter.printShelter();


        System.out.println("Removing any animal");
        animalShelter.dequeuAny();
        animalShelter.printShelter();

        System.out.println("Removing a dog");
        animalShelter.dequeuDog();
        animalShelter.printShelter();

        System.out.println("Removing a cat");
        animalShelter.dequeuCat();
        animalShelter.printShelter();

        animalShelter.enqueue("Cat4", false);
        animalShelter.printShelter();

        System.out.println("Removing a dog");
        animalShelter.dequeuDog();
        animalShelter.printShelter();

        System.out.println("Removing a dog");
        animalShelter.dequeuDog();
        animalShelter.printShelter();

    }

    public static class AnimalShelter {

        AnimalNode head;
        AnimalNode last;

        AnimalShelter(){

            this.head = null;
            this.last = null;
        }

        private class AnimalNode{

            // Cat is false, Dog is true
            boolean animal = false;
            String name;
            AnimalNode next;
            AnimalNode prev;

            AnimalNode(String name, boolean animal){
                this.name = name;
                this.next = null;
                this.prev = null;
                this.animal = animal;
            }

        }

        public void enqueue(String name, boolean animal){

            if (head == null){
                AnimalNode animalNode = new AnimalNode(name, animal);

                head = animalNode;
                last = animalNode;
            }
            else{
                AnimalNode animalNode = new AnimalNode(name, animal);
                head.prev = animalNode;
                animalNode.next = head;
                head = animalNode;

            }

        }

        public void dequeuAny(){

            if(last == null) {
                System.out.println("No animals in shelter");

            }

            else if (last == head){
                // Only 1 animal
                String s = last.name;
                System.out.println(s + " removed");
                head = null;
                last = null;
            }
            else {
                String s = last.name;
                System.out.println(s + " removed");

                AnimalNode temp = last;
                temp = temp.prev;
                temp.next = null;
                last = temp;
            }
        }

        public void dequeuCat(){

            AnimalNode ptr = last;

            // True until we see a cat
            while (ptr.animal){

                ptr = ptr.prev;

                if (ptr == null) {
                    System.out.println("No dog in shelter!");
                    return;
                }
            }

            String name = ptr.name;

            System.out.println(name + " removed");

            removeNode(ptr);

        }

        public void dequeuDog(){


            if(last == null)
                return;

            AnimalNode ptr = last;

            // True until we see a dog
            while (!ptr.animal){

                ptr = ptr.prev;

                if (ptr == null) {
                    System.out.println("No dog in shelter!");
                    return;
                }
            }


            String name = ptr.name;

            System.out.println(name + " removed");

            removeNode(ptr);


        }

        private void removeNode(AnimalNode ptr){

            if (ptr == last){
                last = last.prev;
                last.next = null;

            }
            else if (ptr == head){
                head = head.next;
                head.prev = null;
            }
            else{
                (ptr.next).prev = ptr.prev;
                (ptr.prev).next = ptr.next;

                // So no object reference to the node and Java will delete
                ptr = ptr.next;

            }

        }

        public void printShelter(){
            AnimalNode temp = head;

            while (temp != null){
                System.out.print(temp.name + " ");
                temp = temp.next;
            }

            System.out.println();
        }








    }



}