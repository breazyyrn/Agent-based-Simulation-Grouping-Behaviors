/**
 * LinkedList
 * Bryan Thiam
 * project 5
 * Prof. Max Bender
 * Prof. Hannah Wolfe
 * 3/31/2022
 */
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class LinkedList<T> implements Iterable<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;
    /**
     * I made this sharedArrayList because it's
     * going to be used to shuffle all content
     * derived from the linkedList using Java's
     * Collection Method
     */
    private ArrayList<T> sharedArrayList;
    public LinkedList(){
        head = null;
        tail=null;
        size = 0;
    }

    public void clear(){
        head = null;
        tail=null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public void addFirst(T item){
        Node<T> newNode = new Node<T>(item, head);
        this.head = newNode;
        size++;
    }

    public void addLast(T item){
        // Node<T> newNode = new Node<T>(item, tail);
        // newNode.next = null;
        // this.tail.next = newNode;
        // this.tail = newNode;
        // size++;
        Node<T> newNode = new Node<T>(item, tail);
        Node<T> curNode = head;
        if(curNode == null){
            head = newNode;
            size++;
            return;
        }
        while(curNode.getNext() != null) {
            curNode = curNode.getNext();
        }
        curNode.setNext(newNode);
        size++;
    }

    

    public void add(int pos, T item){
        Node<T> newNode = new Node(item);
        Node<T> temp = this.head;
        if(pos == 0) {
            newNode.setNext(temp);
            head = newNode;
            size++;
            return;
        }
        for(int i = 0; i < pos - 1; i++) {
            temp = temp.getNext();
        }
        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        
        size++;
    }

    public Node<T> remove(int index){
        Node<T> node = head;
        Node<T> prevNode = null;
        int count = 0;

        if(head != null && index == 0){
            return head;
        }

        if(head != null && index==0){
            head = null;
            head = node.next;
        }

        if (index > 0){
            while(count<index){
                prevNode = node.next;
                node = node.next;
                count++;
            }
        }


        prevNode.next = node.next;
        node = null;

        return head;
    }

    public ArrayList<T> toArrayList(){
        ArrayList<T> LinkedListArray = new ArrayList<>();
        
        for (T item : this){
            LinkedListArray.add(item);            
        }

        /**
         * Adds all items from the LinkedListArray
         * which were collected from the LinkedListArray
         * into the SharedArrayList
         */
        // sharedArrayList.addAll(LinkedListArray);
        return LinkedListArray;
    }



    public ArrayList<T> toShuffledList(){
        Random ranNum = new Random();
        ArrayList<T> shuffledArrayList = this.toArrayList();

        for (int i=0;i<shuffledArrayList.size();i++){
            int RandomIndex = ranNum.nextInt(shuffledArrayList.size());
            T pull = shuffledArrayList.remove(RandomIndex);
            shuffledArrayList.add(pull);
        }

        /**
         * Shuffles the sharedArrayList which contains
         * all the items that were added into the array 
         * which colleced its items from the LinkedList
         */
        // Collections.shuffle(sharedArrayList);

        return shuffledArrayList;
    }

    // return a new LLIterator pointing to the head of the list
    public Iterator<T> iterator(){
        return new LLIterator(this.head);
    }



// Where Node Subclass Begins:
    private class Node<T>{
        Node<T> next;
        T data;

        public Node(T item){
            next = null;
            data = item;
        }

        public Node(T val, Node<T> n){
            data = val;
            next = n;
        }

        public T getThing(){
            return data;
        }

        public void setNext(Node n){
            next = n;
        }

        public Node getNext(){
            return next;
        }
    }
// Where Node Subclass Ends.



// Iterator Interface is Implemented
    private class LLIterator implements Iterator<T>{
        Node<T> nextNode;

        public LLIterator(Node head){
            nextNode = head;
        }

        public boolean hasNext(){
            if(nextNode!=null){
                return true;
            } else{
                return false;
            }
        }

        public T next(){
            if (hasNext()) {
                T data = nextNode.getThing();
                nextNode = nextNode.getNext();
                return data;

            } else {
                return null;
            }
        }
    }
}