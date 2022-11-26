public class LinkedListsOfIntegers {
  // private inner class only visible within LinkedListsOfIntegers
  private class Node {
      private int  item; // data part of the node
      private Node next; // link to the next node in the LL
      public Node (int itemToInsert, Node linkToNext) {
          item = itemToInsert;
          next = linkToNext;
      }
  }
  // reference to the first node of the linked list
  private Node front;
  private int size; // size of the linked list
  public LinkedListsOfIntegers () {
      front = null;
      size = 0;
  }
  // resets the linked list
  public void clear () {
      front = null;
      size = 0;
  }
  public int getSize() {
      return size;
  }
  // insert at the beggining of the list
  public void addToFront (int itemToInsert) {
      // creates and inserts a new node at the front of the list
      Node n = new Node(itemToInsert, front);
      // update the front;
      front = n;
      size += 1;
  }
  public boolean search ( int target ) {
      // COMPLETE THIS METHOD
      return true;
  }
  public boolean addAfter ( int target, int itemToInsert ) {
      // search for target
      Node p = front;
      while ( p!= null && p.item != target ) {
          p = p.next;
      }
      
      if ( p == null ) {
          // target not found
          return false;
      } else {
          // found target, insert the new node
          Node n = new Node(itemToInsert, p.next);
          p.next = n; // target node points to new node n
          size += 1;
          return true;
      }
  }
  public boolean delete (int target) {
      Node ptr = front;
      Node prev = null;
      // traverse the list looking for target
      while ( ptr != null && ptr.item != target ) {
          prev = ptr;     // move previous into ptr
          ptr = ptr.next; // moves ptr to the next node
      }
      if ( ptr == null ) {
          // target not found OR list is empty
          return false;
      } else if ( ptr == front ) {
          // remove the front
          front = front.next;
      } else {
          prev.next = ptr.next;
      }
      size -= 1;
      return true;
  }
  public void print () {
      Node p = front; // starts at the first node
      while ( p != null ) {
          System.out.print(p.item + " -> ");
          p = p.next; // go to the next node of the linked list
      }
      System.out.println("\\");
  }
  public static void main (String args[]) {
      LinkedListsOfIntegers ll = new LinkedListsOfIntegers();
      ll.addToFront(7);
      ll.addToFront(4);
      ll.addToFront(3);
      ll.addToFront(2);
      ll.addToFront(1);
      ll.print();
      ll.addAfter(4, 5);
      ll.print();
      ll.delete(3);
      ll.print();
      ll.delete(7);
      ll.print();
  }

}