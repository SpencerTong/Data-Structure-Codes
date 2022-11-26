public class RecitationLL {
  public class Node {
    int data;
    Node next;
  }

  public static void removeAfter(Node first, int target){
    Node curr = head; //want to create a temp variable so can keep head and access rest o list
    while (curr.next != null){
      if (curr.data==target){
          curr.next=curr.next.next;
      }
      curr = curr.next;
    }

     /*for (Node curr = head; curr.next !=null; curr=curr.next{
      if (curr.data==target) {
        curr.next = curr.next.next;
      }
    }*/

  }



}
//if wanted to reverse linkedlist, create dummy variable that is new node, have .next = head 