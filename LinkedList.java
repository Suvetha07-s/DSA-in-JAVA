import java.util.Iterator;

/*
 * Linked List
 * 
 * Insert at Beginning
 * insertAtEnd 
 * insertAtPos
 * Display
 * Delete at any pos
 * deleteAtEnd
 * updatAtPos
 * reverse ll

 */


public class LinkedList{
	Node head;
	
	class Node{
		int data;
		Node next;	
		Node(int val){
			data = val;
			next = null;
		}
	}
	
	public void insertAtEnd(int data){
    	Node newNode = new Node(data);
    	if(head==null){
    	    head=newNode;
    	    return;
    	}
    	Node temp=head;
    	while(temp.next!=null){
    	    temp=temp.next;
    	}
    	temp.next=newNode;
	}
	
	public void insertAtBeginning(int val){
		Node newNode = new Node(val);
		//when list empty
		if(head==null)
			head = newNode;
		else { //list is not empty
			newNode.next = head;	
			head = newNode;
		}	
		
	}
	
	public void insertAtPos(int pos,int val) {
		if(pos==1)
		{
			insertAtBeginning(val);
			return;
		}
		
		Node newNode = new Node(val);
		Node temp = head;
		for(int i=1;i<pos-1;i++) { //jump to prev node
			temp = temp.next;
			if(temp==null) 
				throw new IndexOutOfBoundsException("Invalid Pos " + pos);
		}
		
		//reassign pointers
		newNode.next = temp.next;
		temp.next = newNode;
			
	}
	
	public void display() {
		Node temp = head; //start from head
		while(temp != null) { //null implies end of list
			System.out.print( temp.data+"->" );
			temp = temp.next; //jump
		}
		System.out.println("null");
		
	}
	public void deleteAtEnd(){
	    Node temp=head;
	    if(head==null){
	        System.out.print("List is empty");
	        return;
	    }
	    if(head.next==null){
	        head=null;
	        return;
	    }
	    while(temp.next.next!=null){
	        temp=temp.next;
	    }
	    temp.next=null;
	}
	
	public void deleteAtPos(int pos) {
		
		if(head==null) 
			throw new IndexOutOfBoundsException("Deletion attempted on empty list ");
	
		if(pos==1) {
			head = head.next;
			return;
		}
		
		Node temp = head;
		Node prev = null;
		
		//jump till node to be deleted
		for(int i=1;i<pos;i++) { // 1 based index // for 0 base write <=pos
			prev = temp; //keep track of prev node
			temp = temp.next; //jump to next node
		}
		
		prev.next = temp.next; //reassign pointers
	}
	
	public void deleteAtBeginning() {
		
		if(head==null) 
			throw new IndexOutOfBoundsException("Deletion attempted on empty list ");
	
		head = head.next;
	}
	public void updatAtPos(int pos,int newval){
	    Node temp=head;
	    if(head==null){
	        System.out.print("List is empty");
	        return;
	    }
	    for(int i=1;i<pos;i++){
	        if(temp==null){
	            System.out.print("invalid pos");
	            return;
	        }
	        temp=temp.next;
	    }
	    if(temp==null){
            System.out.print("invalid pos");
            return;
	    }
	    temp.data=newval;
	}
	
	public void reverse() {
		Node prev=null;
		Node current=head;
		Node next=head.next;
		while(current!=null){
		    next=current.next;
		    current.next=prev;
		    prev=current;
		    current=next;
		}
		head=prev;
	}
	public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        System.out.println("Linked List after inserting elements at end:");
        list.display();
        list.reverse();
        System.out.println("After reverse");
        list.display();
    }
	
	
}

/*try the following methods
 * 
 * get(pos) - get(2)
 * update(pos,val)
 * deleteAtEnd
 * insertAtEnd(val)
 * search(val) - return index, -1
 * contains(val) - return true or false
 * length
 
*/
